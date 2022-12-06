import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from "rxjs";
import { environment } from 'src/environments/environment';
import { Produto } from '../model/produto';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  constructor(private http: HttpClient) { }

  public getListarProdutos(categoriaId: number): Observable<Produto[]> {
 
    return this.http.get<Produto[]>(`${environment.apiUrl}/produtos?categoriaId=${categoriaId}`);
  }
}
