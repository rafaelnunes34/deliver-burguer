import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from '../service/auth.service';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(private authService: AuthService) { }

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {

    if(this.authService.isAuthenticated()) {
      const token = this.authService.getToken();
      const authRequest = request.clone({ setHeaders: { Authorization: `Bearer ${token}` } });
      return next.handle(authRequest);
    }

    return next.handle(request);
  }
}
