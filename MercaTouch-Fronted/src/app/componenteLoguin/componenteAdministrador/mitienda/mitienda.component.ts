import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ResponseReq } from 'src/app/componente/home/home.component';
import { Administrador, ResponseReqA } from '../../componenteUsuario/headeruser/headeruser.component';

@Component({
  selector: 'app-mitienda',
  templateUrl: './mitienda.component.html',
  styleUrls: ['./mitienda.component.css']
})
export class MitiendaComponent implements OnInit 
{
  tiendaNombre: string = '';
  tiendaDireccion: string = '';
  tiendaCiudad: string = '';
  tiendaDepartamento: string = '';
  tiendaTelefono: number = 0;
  tiendaCalificacion: number = 0;

  administrador: Administrador = new Administrador();
  constructor(public http: HttpClient) { }

  ngOnInit(): void 
  {
    this.http.get<ResponseReqA>("http://localhost:8080/api/administrador/" + localStorage.getItem('abcd'), { responseType: 'json' }).subscribe((resp: ResponseReqA) => 
    {
      this.tiendaNombre = resp.datos[0].tienda.nombre;
      this.tiendaDireccion = resp.datos[0].tienda.direccion;
      this.tiendaCiudad = resp.datos[0].tienda.ciudad;
      this.tiendaDepartamento = resp.datos[0].tienda.departamento;
      this.tiendaTelefono = resp.datos[0].tienda.telefono;
      this.tiendaCalificacion = resp.datos[0].tienda.calificacion;
    });
  }
}
