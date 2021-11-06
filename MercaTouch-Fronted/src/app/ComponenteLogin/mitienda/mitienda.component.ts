import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ResponseReqTienda, Tienda } from '../header/header.component';

@Component({
  selector: 'app-mitienda',
  templateUrl: './mitienda.component.html',
  styleUrls: ['./mitienda.component.css']
})
export class MitiendaComponent implements OnInit 
{
  tienda: Tienda = new Tienda();
  tiendaNombre: string = '';
  tiendaDireccion: string = '';
  tiendaCiudad: string = '';
  tiendaDepartamento: string = '';
  tiendaTelefono: number = 0;
  tiendaCalificacion: number = 0;

  constructor(public http: HttpClient) { }

  ngOnInit(): void 
  {
    
  }
}
