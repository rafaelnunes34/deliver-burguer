import { Component, Input, OnInit } from '@angular/core';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  @Input() authService: AuthService;

  constructor() { }

  ngOnInit(): void {
  }

  get isAuthenticated(): boolean {
    return this.authService.isAuthenticated();
  }

  get usuarioLogado(): string {
    return this.authService.getUsuarioAutenticado();
  }

  public sair(): void {
    this.authService.deslogarUsuario();
    location.reload();
  }

}
