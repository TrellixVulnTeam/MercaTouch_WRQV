import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ResponseReq } from 'src/app/componente/home/home.component';
import { Administrador } from '../../componenteUsuario/headeruser/headeruser.component';

@Component({
  selector: 'app-headeradmin',
  templateUrl: './headeradmin.component.html',
  styleUrls: ['./headeradmin.component.css']
})
export class HeaderadminComponent implements OnInit 
{
  nombre: string = '';
  administrador: Administrador = new Administrador();
  
  constructor(public http: HttpClient) { }

  ngOnInit(): void 
  {
    this.http.get<ResponseReq>("http://localhost:8080/api/administrador/" + localStorage.getItem('abcd'), { responseType: 'json' }).subscribe((resp: ResponseReq) => {
      this.administrador.nombre = resp.datos[0].nombre;
      this.administrador.apellidos = resp.datos[0].apellidos;
      this.administrador.numeroIdentificacion = resp.datos[0].numeroIdentificacion;
      this.administrador.telefono = resp.datos[0].telefono;
      this.administrador.correo = resp.datos[0].correo;
      this.nombre = resp.datos[0].nombre;
    });
  }
}
