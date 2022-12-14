import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { CardapioComponent } from './components/cardapio/cardapio.component';
import { LoginComponent } from './components/login/login.component';
import { CadastroClienteComponent } from './components/cadastro-cliente/cadastro-cliente.component';
import { AuthGuard } from './security/auth.guard';
import { AuthInterceptor } from './security/auth.interceptor';
import { ListaPedidoComponent } from './components/lista-pedido/lista-pedido.component';
import { FooterComponent } from './components/footer/footer.component';

import { ToastrModule } from 'ngx-toastr';
import { HashLocationStrategy, LocationStrategy } from '@angular/common';
import { IConfig, NgxMaskModule } from 'ngx-mask';

const maskConfigFunction: () => Partial<IConfig> = () => {
  return {
    validation: false,
  };
};

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    CardapioComponent,
    LoginComponent,
    CadastroClienteComponent,
    ListaPedidoComponent,
    FooterComponent
  ],
  exports: [
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    NgxMaskModule.forRoot({
      dropSpecialCharacters: false
    }),
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    AuthGuard,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    },
    { provide: LocationStrategy, useClass: HashLocationStrategy } //acerta o problema de reload em produção
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
