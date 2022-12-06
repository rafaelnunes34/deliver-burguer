import { Injectable } from '@angular/core';
import { CarrinhoProduto } from '../model/carrinhoProduto';

@Injectable({
  providedIn: 'root'
})
export class CarrinhoService {

  private carrinhoProdutos: CarrinhoProduto[] = [];

  constructor() { }

  public retornaItensCarrinho(): CarrinhoProduto[] {
    const itensCarrinho = JSON.parse(localStorage.getItem("carrinho"));
    if(itensCarrinho) {
      return itensCarrinho;
    }
    return this.carrinhoProdutos;
  }

  //ADICIONA O PRODUTO NO CARRINHO
  public adicionarProdutoCarrinho(carrinhoProduto: CarrinhoProduto): void {
    this.carrinhoProdutos = this.retornaItensCarrinho();
    if(this.isExisteProdutoCarrinho(carrinhoProduto)) {
      return this.alteraQuantidadeProduto(carrinhoProduto);
    }
    this.carrinhoProdutos.push(carrinhoProduto);
    this.salvarCarrinhoLocalStorage();
  }

  //RETORNA O VALOR TOTAL DO CARRINHO
  public retornaSubTotal(): number {
    if(this.retornaItensCarrinho().length == 0) {
      return 0;
    }
    return this.retornaItensCarrinho().reduce(function (valor, carrinhoProduto) {
      return valor + carrinhoProduto.quantidade * carrinhoProduto.produto.preco;
    }, 0);
  }

  //RETORNA A QUANTIDADE DE ITENS DO CARRINHO
  public retornaQuantidadeItens(): number {
    if(this.retornaItensCarrinho().length == 0) {
      return 0;
    }
    return this.retornaItensCarrinho().reduce(function (valor, carrinhoProduto) {
      return valor += carrinhoProduto.quantidade;
    }, 0);
  }

  public removerProdutoCarrinho(carrinhoProduto: CarrinhoProduto): void {
    this.carrinhoProdutos = this.retornaItensCarrinho();
    this.carrinhoProdutos.forEach(prod => {
      if(prod.produto.id == carrinhoProduto.produto.id) {
        const index = this.carrinhoProdutos.indexOf(prod);
        this.carrinhoProdutos.splice(index, 1);
      }
    });
    this.salvarCarrinhoLocalStorage();
  }

  //VERIFICA SE EXISTE O PRODUTO NO CARRINHO
  private isExisteProdutoCarrinho(carrinhoProduto: CarrinhoProduto): boolean {
    let isAchou = false;
    this.carrinhoProdutos.forEach(item => {
      if(item.produto.id == carrinhoProduto.produto.id) {
        isAchou = true;
      }
    });
    return isAchou;
  }

  //ALTERA A QUANTIDADE DO PRODUTO NO CARRINHO
  private alteraQuantidadeProduto(carrinhoProduto: CarrinhoProduto): void {
    this.carrinhoProdutos = this.retornaItensCarrinho();
    this.carrinhoProdutos.forEach(item => {
      if(item.produto.id == carrinhoProduto.produto.id) {
        item.quantidade = carrinhoProduto.quantidade;
        this.salvarCarrinhoLocalStorage();
      }
    });
  }

  private salvarCarrinhoLocalStorage(): void {
    localStorage.setItem("carrinho", JSON.stringify(this.carrinhoProdutos));
  }

  public removerCarrinhoLocalStorage(): void {
    localStorage.removeItem("carrinho");
  }
}
