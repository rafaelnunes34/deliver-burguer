import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastroClienteComponent } from './components/cadastro-cliente/cadastro-cliente.component';
import { CardapioComponent } from './components/cardapio/cardapio.component';
import { ListaPedidoComponent } from './components/lista-pedido/lista-pedido.component';
import { LoginComponent } from './components/login/login.component';
import { AuthGuard } from './security/auth.guard';

const routes: Routes = [
  { path: '', component:CardapioComponent},
  { path: 'login', component:LoginComponent},
  { path: 'cadastro', component:CadastroClienteComponent},
  { 
    path: 'pedidos', component:ListaPedidoComponent,
    canActivate: [AuthGuard]
  },
  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
