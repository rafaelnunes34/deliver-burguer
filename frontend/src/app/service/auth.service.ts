import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { JwtHelperService } from '@auth0/angular-jwt';
import { catchError, map, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private jwtHelper: JwtHelperService = new JwtHelperService();

  constructor(private http: HttpClient) { }

  public login(email: string, senha: string): Observable<any> {
    const params = new HttpParams()

      .set("username", email)
      .set("password", senha)
      .set("grant_type", "password");

      const headers = {
        'Authorization': 'Basic ' + btoa(`${environment.clienteId}:${environment.clientSecret}`),
        'Content-Type': 'application/x-www-form-urlencoded'
      }

      return this.http.post(`${environment.apiUrl}/oauth/token`, params.toString(), { headers }).pipe(
        map((response) => this.setTokenLocalStorage(response)),
        catchError((err) => {
          console.log(err);
          this.removerTokenLocalStore();
          throw 'Falha ao efetuar login';
        })
      );
  }

  public getUsuarioAutenticado(): string {
    if(this.getToken()) {
      const usuario = this.jwtHelper.decodeToken(this.getToken()).user_name;
      return usuario;
    }
    return null;
  }

  public isAuthenticated(): boolean {
    if(this.getToken()) {
      const expired = this.jwtHelper.isTokenExpired(this.getToken());
      return !expired;
    }
    return false;
  }

  public getToken(): string | null {
    return localStorage.getItem("token");
  }

  public deslogarUsuario(): void {
    this.removerTokenLocalStore();
  }

  private setTokenLocalStorage(response: any): void {
    const {access_token} = response;
    localStorage.setItem("token", access_token);
  }

  private removerTokenLocalStore(): void {
    localStorage.removeItem("token");
  }
}
