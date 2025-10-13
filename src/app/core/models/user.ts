import { Rol } from "./rol";

export interface User {
    id:number;
    nombre:string;
    apellido:string;
    clave:string;
    email:string;
    direccion:string;
    telefono:string;
    idRol:Rol;
}
