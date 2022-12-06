import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Usuario } from '../model/usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private http: HttpClient) { }

  public adicionarUsuario(usuario: Usuario): Observable<Usuario> {
    return this.http.post<Usuario>(`${environment.apiUrl}/usuarios/cliente`, usuario);
  }
}
