import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ResponseReq, Usuario } from 'src/app/componente/home/home.component';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})

export class HeaderComponent implements OnInit 
{
  datos: String[] = new Array();
  datos2: String[] = new Array();
  datos3: String[] = new Array();
  datos4: String[] = new Array();
  i: number = 0;
  j: number = 0;
  seleccionado: String = '';
  usuario: Usuario = new Usuario();
  departamento: Departamento = new Departamento();
  tienda: Tienda = new Tienda();
  opcionSeleccionado: String = "";
  opcionSeleccionado2: String = "";
  opcionSeleccionado3: String = "";
  opcionSeleccionado4: String = "";
  campoCiudad: boolean = false;
  miTienda: boolean = false;
  campoRequeridoNombre: boolean = false;
  campoRequeridoDireccion: boolean = false;
  campoRequeridoRutaLogo: boolean = false;
  campoRequeridoCiudad: boolean = false;
  campoRequeridoDepartamento: boolean = false;
  campoRequeridotelefono: boolean = false;
  confirmacionCampos: boolean = false;
  confirmacionRegistro: boolean = false;
  confirmacionLoading: boolean = false;
  nombre: string = '';
  status: string = '';

  formularioRegistro = new FormGroup
  ({
    registroNombre: new FormControl('', Validators.required),
    registroDireccion: new FormControl('', Validators.required),
    registroRutaLogo: new FormControl('', Validators.required),
    registroDepartamento: new FormControl('', Validators.required),
    registroCiudad: new FormControl('', Validators.required),
    registroTelefono: new FormControl('', Validators.required),
    registroPlan: new FormControl('', Validators.required),
    registroTiempo: new FormControl('', Validators.required),
  });

  constructor(public http: HttpClient) 
  { 
    this.datos3 = ["Con Inventario","Sin Inventario"];
    this.datos4 = ["Un Mes", "Tres Meses", "Seis Meses", "Un Año"];
  }

  onRegistrarTienda()
  {
    this.confirmacionLoading = true;

    this.tienda.nombre = this.formularioRegistro.get('registroNombre')?.value;
    this.tienda.rutaLogo = this.formularioRegistro.get('registroRutaLogo')?.value;
    this.tienda.direccion = this.formularioRegistro.get('registroDireccion')?.value;
    this.tienda.ciudad.nombre = this.opcionSeleccionado2.toString();
    this.tienda.ciudad.departamento.nombre = this.opcionSeleccionado.toString();
    this.tienda.telefono = this.formularioRegistro.get('registroTelefono')?.value;
    this.tienda.planSuscripcion.nombre = this.opcionSeleccionado3.toString();

    if(this.tienda.nombre === '')
    {
      this.campoRequeridoNombre = true;
      this.confirmacionLoading = false;
      this.confirmacionCampos = true;
    }

    if(this.tienda.rutaLogo === '')
    {
      this.campoRequeridoRutaLogo = true;
      this.confirmacionLoading = false;
      this.confirmacionCampos = true;
    }

    if(this.tienda.direccion === '')
    {
      this.campoRequeridoDireccion = true;
      this.confirmacionLoading = false;
      this.confirmacionCampos = true;
    }

    if(this.tienda.planSuscripcion.nombre === 'Con Inventario')
    {
      this.tienda.planSuscripcion.descripcion = 'Se brinda servicios de inventario para gestion y control de los productos de la tienda';
    }
    else if (this.tienda.planSuscripcion.nombre === 'Sin Inventario')
    {
      this.tienda.planSuscripcion.descripcion = 'Se brinda unicamente servicio de gestion de las tiendas';
    }

    if(this.opcionSeleccionado4.toString() === 'Un Mes')
    {
      this.tienda.planSuscripcion.tiempoSuscripcion = 1;
    }
    else if(this.opcionSeleccionado4.toString() === 'Tres Meses')
    {
      this.tienda.planSuscripcion.tiempoSuscripcion = 3;
    }
    else if(this.opcionSeleccionado4.toString() === 'Seis Meses')
    {
      this.tienda.planSuscripcion.tiempoSuscripcion = 6;
    }
    else if(this.opcionSeleccionado4.toString() === 'Un Año')
    {
      this.tienda.planSuscripcion.tiempoSuscripcion = 12;
    }

    this.tienda.planSuscripcion.fechaRegistro = new Date();

    this.crearTienda(this.tienda).subscribe((resp: Tienda) => 
      {
        this.confirmacionRegistro = true;
        console.log(resp);
        this.confirmacionLoading = false;
      })

  }

  crearTienda(tienda: Tienda) 
  {
    return this.http.post<Tienda>("http://localhost:8080/api/tienda/" + localStorage.getItem('abcd'), tienda);
  }

  capturar()
  {
    this.campoCiudad =  true;
  }

  capturarC()
  {

  }

  capturarP()
  {

  }

  capturarT()
  {

  }

  ngOnInit(): void 
  {
    this.http.get<ResponseReq>("http://localhost:8080/api/usuario/" + localStorage.getItem('abcd'), { responseType: 'json' }).subscribe((resp: ResponseReq) => 
    {
      this.usuario.nombre = resp.datos[0].nombre;
      this.usuario.apellidos = resp.datos[0].apellidos;
      this.usuario.numeroIdentificacion = resp.datos[0].numeroIdentificacion;
      this.usuario.telefono = resp.datos[0].telefono;
      this.usuario.correo = resp.datos[0].correo;
      this.usuario.clave = resp.datos[0].clave;
      this.nombre = resp.datos[0].nombre;
      this.usuario.perfil = resp.datos[0].perfil;

      if(this.usuario.perfil.nombre === 'Administrador')
      {
        this.miTienda = true;
      }
    });

    this.http.get<ResponseReqDepartamento>("http://localhost:8080/api/departamento", { responseType: 'json' }).subscribe((resp: ResponseReqDepartamento) => 
    {
      for(let dato of resp.datos)
      {
        this.datos[this.i] = dato.nombre;
        this.i = this.i + 1;
      }
    });

    this.http.get<ResponseReqCiudad>("http://localhost:8080/api/ciudad/"+ this.opcionSeleccionado, { responseType: 'json' }).subscribe((resp: ResponseReqCiudad) => 
    {
      for(let dato of resp.datos)
      {
        this.datos2[this.j] = dato.nombre;
        this.j = this.j + 1;
      }
    });
  }
}

export class Tienda implements ResponseReqTienda
{
  nombre: string = '';
  rutaLogo: string = '';
  direccion: string = '';
  telefono: number = 0;
  ciudad: Ciudad = new Ciudad();
  planSuscripcion = new PlanSuscripcion();

  constructor()
  {

  }

  estado!: string;
  mensajes!: string[];
  datos!: Tienda[];
}

export interface ResponseReqTienda
{
  estado: string;
  mensajes: string[];
  datos: Tienda[];
}

export class PlanSuscripcion implements ResponseReqPlanSuscripcion
{
  nombre: string = '';
  descripcion: string = '';
  precio: string = '';
  tiempoSuscripcion: number = 0;
  fechaRegistro: Date = new Date();
  
  constructor()
  {

  }

  estado!: string;
  mensajes!: string[];
  datos!: PlanSuscripcion[];
}

export interface ResponseReqPlanSuscripcion
{
  estado: string;
  mensajes: string[];
  datos: PlanSuscripcion[];
}

export class Ciudad implements ResponseReqCiudad
{
  nombre: string = '';
  departamento: Departamento = new Departamento();
  
  constructor()
  {

  }

  estado!: string;
  mensajes!: string[];
  datos!: Ciudad[];
}

export interface ResponseReqCiudad
{
  estado: string;
  mensajes: string[];
  datos: Ciudad[];
}

export class Departamento implements ResponseReqDepartamento
{
  nombre: string = '';
  
  constructor()
  {

  }

  estado!: string;
  mensajes!: string[];
  datos!: Departamento[];
}

export interface ResponseReqDepartamento
{
  estado: string;
  mensajes: string[];
  datos: Departamento[];
}