import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from "rxjs";
import { Categoria } from '../model/categoria';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {

  constructor(private http: HttpClient) { }

  public listarCategorias(): Observable<Categoria[]> {
    return this.http.get<Categoria[]>(`${environment.apiUrl}/categorias`);
  }
}
