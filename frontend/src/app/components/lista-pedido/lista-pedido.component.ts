import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { Pedido } from 'src/app/model/pedido';
import { AuthService } from 'src/app/service/auth.service';
import { PedidoService } from 'src/app/service/pedido.service';

@Component({
  selector: 'app-lista-pedido',
  templateUrl: './lista-pedido.component.html',
  styleUrls: ['./lista-pedido.component.css']
})
export class ListaPedidoComponent implements OnInit {

  listaPedidos: Pedido[] = [];

  constructor(
    public authService: AuthService,
    private pedidoService: PedidoService,
    private toast: ToastrService
  ) { }

  ngOnInit(): void {
    this.listarPedidos();
  }

  cancelarPedido(pedido: Pedido): void {
    this.pedidoService.cancelarPedido(pedido.id).subscribe({
      next: (response: Pedido) => {
        this.toast.success("Pedido Nº " + response.id + " cancelado com sucesso.");
        this.listaPedidos = [];
        this.listarPedidos();
      }
    });
  }

  private listarPedidos(): void {
    this.pedidoService.listarPedidos().subscribe({
      next: (response: Pedido[]) => {
        this.listaPedidos = response;
      }
    });
  }

}
