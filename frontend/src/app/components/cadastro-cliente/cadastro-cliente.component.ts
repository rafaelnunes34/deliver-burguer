import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Usuario } from 'src/app/model/usuario';
import { AuthService } from 'src/app/service/auth.service';
import { UsuarioService } from 'src/app/service/usuario.service';

@Component({
  selector: 'app-cadastro-cliente',
  templateUrl: './cadastro-cliente.component.html',
  styleUrls: ['./cadastro-cliente.component.css']
})
export class CadastroClienteComponent implements OnInit {

  public formCadastro: FormGroup;
  usuario: Usuario;

  constructor(
    private formBuilder: FormBuilder,
    public authService: AuthService,
    private usuarioService: UsuarioService,
    private route: Router,
    private toast: ToastrService) 
    {
      this.formCadastro = this.criarFormCadastro();
     }

  ngOnInit(): void {
    this.usuario = new Usuario();
  }

  public criarFormCadastro(): FormGroup {
    return this.formBuilder.group({
      nome: ["", [Validators.required, Validators.minLength(2)]],
      telefone: ["", [Validators.required, Validators.minLength(11)]],
      email: ["", [Validators.required, Validators.email]],
      senha: ["", [Validators.required, Validators.minLength(6)]]
    });
  }

  public salvarUsuario(): void {
    const {nome, telefone, email, senha} = this.formCadastro.value;
    this.usuario.nome = nome;
    this.usuario.telefone = telefone;
    this.usuario.email = email;
    this.usuario.senha = senha;

    this.usuarioService.adicionarUsuario(this.usuario).subscribe(
      {next: (response: Usuario) => {
        this.usuario = response;
        this.toast.success("Cadastro realizado com sucesso");
        this.route.navigate(["''"]);
      }, error: (err) => console.log(console.error(err))
    });
  }

}
