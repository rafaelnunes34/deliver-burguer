import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Usuario } from 'src/app/model/usuario';
import { AuthService } from 'src/app/service/auth.service';
import { UsuarioService } from 'src/app/service/usuario.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public formLogin: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    public authService: AuthService,
    private toast: ToastrService,
    private route: Router
  ) {
    this.formLogin = this.criarFormLogin();
   }

  ngOnInit(): void {
  }

  public isFormControlInvalid(controlName: string): boolean {
    return !!(this.formLogin.get(controlName)?.invalid && this.formLogin.get(controlName)?.touched);
  } 

  public criarFormLogin(): FormGroup {
    return this.formBuilder.group({
      email: ["", [Validators.required, Validators.email]],
      senha: ["", [Validators.required, Validators.minLength(6)]]
    });
  }

  public submitForm(): void {
    const {email, senha} = this.formLogin.value;
    
    this.authService.login(email, senha).subscribe(
      {next: (response) => {
        this.toast.success("Login efetuado com sucesso");
        this.route.navigate(['']);
        this.formLogin.reset();
      },
      error: err => {
        console.log(err);
      }
    });
  }

}
