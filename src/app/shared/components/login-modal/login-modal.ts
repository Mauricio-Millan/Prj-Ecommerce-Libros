import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from '../../../features/auth/component/login.component/login.component';

@Component({
  selector: 'app-login-modal',
  standalone: true,
  imports: [CommonModule, LoginComponent],
  templateUrl: './login-modal.html',
  styleUrl: './login-modal.css'
})
export class LoginModalComponent {
  @Input() isOpen = false;
  @Output() closeModal = new EventEmitter<void>();

  close(): void {
    this.closeModal.emit();
  }

  onBackdropClick(event: MouseEvent): void {
    if (event.target === event.currentTarget) {
      this.close();
    }
  }
}
