import { Component, inject, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterLinkActive } from '@angular/router';
import { LoginService } from '../../../core/services/user/login.service';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [CommonModule, RouterLink, RouterLinkActive],
  templateUrl: './navbar.html',
  styleUrl: './navbar.css'
})
export class NavbarComponent {
  @Output() openLoginModal = new EventEmitter<void>();
  
  private loginService = inject(LoginService);
  
  isLoggedIn$ = this.loginService.userLoginOn;
  currentUser$ = this.loginService.userData;
  
  cartItemCount = 0; // TODO: Conectar con servicio de carrito
  
  openLogin(): void {
    this.openLoginModal.emit();
  }
  
  logout(): void {
    this.loginService.logout();
  }
}
