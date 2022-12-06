import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Endereco } from '../model/endereco';

@Injectable({
  providedIn: 'root'
})
export class EnderecoService {

  constructor(private http: HttpClient) { }

  public buscarEndereco(cep: string): Observable<Endereco> {
    return this.http.get<Endereco>(`${environment.apiUrl}/enderecos/${cep}`)
  }

}