import { Injectable } from '@angular/core';
import { User } from '../../models/user';
import { catchError, Observable, throwError } from 'rxjs';
import { HttpClient, HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { environment } from '../../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private http: HttpClient) { }

  getUserById(id: number): Observable<User> {
  return this.http.get<User>(environment.urlApi+/usuarios/+id).pipe
  (catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse) {
    if(error.status === 0) {
      console.error('ah ocurrido un error', error.error);
    }else {
      console.error(
        `Backend retorno el codigo de estado ${error.status}, `, error.error);
    }
    return throwError(() => new Error('algo malo ocurrio; por favor intente de nuevo'));
  }
}
