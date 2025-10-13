import { Routes } from '@angular/router';
import { LoginComponent } from './features/auth/component/login.component/login.component';
import { InicioComponent } from './features/inicio.component/inicio.component';

export const routes: Routes = [
    {path: '', redirectTo: 'inicio', pathMatch: 'full'},
    {path: 'inicio', component: InicioComponent},
    {path: 'login', component: LoginComponent},
    {path: '**', redirectTo: 'inicio'}  
];
