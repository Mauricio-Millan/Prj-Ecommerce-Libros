import { Component } from '@angular/core';
import { User } from '../../../../core/models/user';
import { AuthService } from '../../../../core/services/user/auth.service';
import { environment } from '../../../../../environments/environment';

@Component({
  selector: 'app-persona-details',
  imports: [],
  templateUrl: './persona-details.html',
  styleUrl: './persona-details.css'
})
export class PersonaDetails {
  errorMessage: String = '';
  user?: User;
  constructor(private authService: AuthService) {
    this.authService.getUserById(environment.userId).subscribe({
      next: (userData)=>{
        this.user = userData;
      },
      error: (errorData)=>{
        this.errorMessage = errorData;
      },
      complete:() =>{
        console.info('user data ok');
      }
    });
  }
}