import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { CarrinhoProduto } from 'src/app/model/carrinhoProduto';

import { Categoria } from 'src/app/model/categoria';
import { Checkout } from 'src/app/model/checkout';
import { Endereco } from 'src/app/model/endereco';
import { Pedido } from 'src/app/model/pedido';
import { Produto } from 'src/app/model/produto';
import { AuthService } from 'src/app/service/auth.service';
import { CarrinhoService } from 'src/app/service/carrinho.service';
import { CategoriaService } from 'src/app/service/categoria.service';
import { EnderecoService } from 'src/app/service/endereco.service';
import { PedidoService } from 'src/app/service/pedido.service';
import { ProdutoService } from 'src/app/service/produto.service';


@Component({
  selector: 'app-cardapio',
  templateUrl: './cardapio.component.html',
  styleUrls: ['./cardapio.component.css']
})
export class CardapioComponent implements OnInit {

  isProdutoNaoLocalizado: boolean = false;
  produtos: Produto[] = [];
  carrinhoProdutos: CarrinhoProduto[] = [];
  itensCarrinho: CarrinhoProduto[] = [];
  totalValorCarrinho: number = 0;
  totalItensCarrinho: number = 0;

  listaFormaPagamento: string[] = [];
  listaCategorias: Categoria[] = [];
  categoriaId: number = 0;
  endereco: Endereco;
  pedido: Pedido;
  checkout: Checkout;

  constructor(
    public authService: AuthService,
    private produtoService: ProdutoService,
    private carrinhoService: CarrinhoService,
    private pedidoService: PedidoService,
    private categoriaService: CategoriaService,
    private enderecoService: EnderecoService,
    private toast: ToastrService
  ) {
    
  }

  ngOnInit(): void {
    //recuperar os produtos
    this.listarProdutos(0);

    this.atualizaDadosCarrinho();

    //recuperar forma pagamento
    this.retornaFormaPagamento();

    this.categoriaService.listarCategorias().subscribe(
      (res: Categoria[]) => { this.listaCategorias = res }
    );

    //this.endereco = new Endereco();
    this.pedido = new Pedido();
    this.checkout = new Checkout();
  }

  aumentarQuantidade(carrinhoProduto: CarrinhoProduto): void {
    carrinhoProduto.quantidade++;
  }

  diminuirQuantidade(carrinhoProduto: CarrinhoProduto): void {
    if (carrinhoProduto.quantidade > 1) {
      carrinhoProduto.quantidade--;
    }
  }

  adicionarProdutoCarrinho(carrinhoProduto: CarrinhoProduto): void {
    this.carrinhoService.adicionarProdutoCarrinho(carrinhoProduto);
    this.atualizaDadosCarrinho();
  }

  pesquisarProdutosPorCategoria(): void {
    this.carrinhoProdutos = [];
    if (typeof this.categoriaId === "number") {
      //recuperar produtos
      this.listarProdutos(this.categoriaId);
    }
    else {
      this.listarProdutos(0);
    }
  }

  removerProdutoCarrinho(carrinhoProduto: CarrinhoProduto): void {
    this.carrinhoService.removerProdutoCarrinho(carrinhoProduto);
    this.atualizaDadosCarrinho();
  }

  buscarEnderecoPorCep(event: any): void {
    
    //const keycode = (event.keyCode ? event.keyCode : event.which);
    
      this.enderecoService.buscarEndereco(this.checkout.endereco.cep).subscribe({
        next: (res: Endereco) => {
          this.checkout.endereco = res;
        },
        error: (e) => console.error(e)
      });
    

  }

  enviarPedido(): void {
    if(this.authService.isAuthenticated()) {
      this.checkout.itens.push(...this.carrinhoService.retornaItensCarrinho());
      this.pedidoService.enviarPedido(this.checkout).subscribe({
        next: (res: Pedido) => {
          this.pedido = res;
          this.toast.success("Pedido de Nº" + this.pedido.id + " gerado com sucesso!", "Pedido", {timeOut: 3000});
          this.carrinhoService.removerCarrinhoLocalStorage();
          this.atualizaDadosCarrinho();
          setInterval(() => {
            window.location.reload();
          }, 1000);
          
        },
        error: (e) => {
          console.log(console.error(e));
          const {error } = e.error;
          if(error) {this.toast.error("Erro "  + error);}
          
          
        }
      }); 
    }
    else {
      this.toast.warning("Para finalizar o pedido e preciso fazer o Login");
    }
  }

  private listarProdutos(nCategoriaId: number): void {
    this.produtoService.getListarProdutos(nCategoriaId).subscribe(
      (res: Produto[]) => {
        this.isProdutoNaoLocalizado = res.length > 0 ? false : true;
        this.produtos = res;
        this.produtos.forEach(x => this.carrinhoProdutos.push(new CarrinhoProduto(x, 1)));
      }
    );
  }

  private retornaFormaPagamento(): void {
    this.pedidoService.listarFormaPagamento().subscribe(
      (res: string[]) => { this.listaFormaPagamento = res }
    );
  }

  private atualizaDadosCarrinho(): void {
    this.totalValorCarrinho = this.carrinhoService.retornaSubTotal();
    this.totalItensCarrinho = this.carrinhoService.retornaQuantidadeItens();
    this.itensCarrinho = this.carrinhoService.retornaItensCarrinho();
  }

}
