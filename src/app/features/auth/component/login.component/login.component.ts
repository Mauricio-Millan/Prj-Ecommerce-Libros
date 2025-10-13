import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../../../../core/services/user/login.service';
import { LoginRequest } from '../../../../core/models/loginRequest';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  @Output() loginSuccess = new EventEmitter<void>();
  
  loginError: string = "";
  isLoading: boolean = false;
  loginForm: any;

  constructor(private formBuilder: FormBuilder, private router: Router, private loginService: LoginService) {
    this.loginForm = this.formBuilder.group({
      email: ['', [Validators.required, Validators.email]],
      clave: ['', [Validators.required, Validators.minLength(6)]]
    });
  }

  ngOnInit(): void {
  }

  get email() {
    return this.loginForm.controls['email'];
  }

  get clave() {
    return this.loginForm.controls['clave'];
  }

  login(): void {
    if (this.loginForm.valid) {
      this.loginError = "";
      this.isLoading = true;

      this.loginService.login(this.loginForm.value as LoginRequest).subscribe({
        next: (userData) => {
          console.log('Login exitoso:', userData);
        },
        error: (error) => {
          console.error('Error en login:', error);
          this.loginError = error.message || 'Error al iniciar sesión. Verifique sus credenciales.';
          this.isLoading = false;
        },
        complete: () => {
          console.info("Login completo");
          this.isLoading = false;
          this.loginSuccess.emit(); // Emit event for modal to close
          this.router.navigateByUrl('/inicio');
          this.loginForm.reset();
        }
      });
    } else {
      this.loginForm.markAllAsTouched();
      this.loginError = "Por favor, complete correctamente todos los campos.";
    }
  }

}