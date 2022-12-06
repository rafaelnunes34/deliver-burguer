import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Checkout } from '../model/checkout';
import { Pedido } from '../model/pedido';

@Injectable({
  providedIn: 'root'
})
export class PedidoService {

  constructor(private http: HttpClient) { }

  public listarFormaPagamento(): Observable<string[]> {
    return this.http.get<string[]>(`${environment.apiUrl}/pedidos/formaPagamento`);
  }

  public enviarPedido(checkout: Checkout): Observable<any> {
    return this.http.post<any>(`${environment.apiUrl}/pedidos`, checkout);
  }

  public listarPedidos(): Observable<Pedido[]> {
    return this.http.get<Pedido[]>(`${environment.apiUrl}/pedidos`);
  }

  public cancelarPedido(pedidoId: number): Observable<Pedido> {
    return this.http.put<Pedido>(`${environment.apiUrl}/pedidos/${pedidoId}/cancelarPedido`,"");
  }
}
