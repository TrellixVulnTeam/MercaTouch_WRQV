import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ResponseReq, Usuario } from 'src/app/componente/home/home.component';

@Component({
  selector: 'app-headeruser',
  templateUrl: './headeruser.component.html',
  styleUrls: ['./headeruser.component.css']
})
export class HeaderuserComponent implements OnInit 
{
  usuario: Usuario = new Usuario();
  administrador: Administrador = new Administrador();
  campoRequeridoNombre: boolean = false;
  campoRequeridoDireccion: boolean = false;
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
    registroCiudad: new FormControl('', Validators.required),
    registroDepartamento: new FormControl('', Validators.required),
    registroTelefono: new FormControl('', Validators.required),
  });

  constructor(public http: HttpClient) { }

  onRegistrarTienda()
  {
    this.confirmacionLoading = true;

    this.administrador.nombre = this.usuario.nombre;
    this.administrador.apellidos = this.usuario.apellidos;
    this.administrador.numeroIdentificacion = this.usuario.numeroIdentificacion;
    this.administrador.telefono = this.usuario.telefono;
    this.administrador.correo = this.usuario.correo;
    this.administrador.clave = this.usuario.clave;
    this.administrador.tienda.nombre = this.formularioRegistro.get('registroNombre')?.value;
    this.administrador.tienda.direccion = this.formularioRegistro.get('registroDireccion')?.value;
    this.administrador.tienda.ciudad = this.formularioRegistro.get('registroCiudad')?.value;
    this.administrador.tienda.departamento = this.formularioRegistro.get('registroDepartamento')?.value;
    this.administrador.tienda.telefono = this.formularioRegistro.get('registroTelefono')?.value;
    this.administrador.tienda.calificacion = 0;

    if(this.administrador.tienda.nombre === '')
    {
      this.campoRequeridoNombre = true;
      this.confirmacionLoading = false;
      this.confirmacionCampos = true;
    }

    if(this.administrador.tienda.direccion === '')
    {
      this.campoRequeridoDireccion = true;
      this.confirmacionLoading = false;
      this.confirmacionCampos = true;
    }

    if(this.administrador.tienda.ciudad === '')
    {
      this.campoRequeridoCiudad = true;
      this.confirmacionLoading = false;
      this.confirmacionCampos = true;
    }

    if(this.administrador.tienda.departamento === '')
    {
      this.campoRequeridoDepartamento = true;
      this.confirmacionLoading = false;
      this.confirmacionCampos = true;
    }

    if(this.administrador.tienda.telefono === 0)
    {
      this.campoRequeridotelefono = true;
      this.confirmacionLoading = false;
      this.confirmacionCampos = true;
    }

    this.confirmacionCampos = false;
    this.crearAdministrador(this.administrador).subscribe((resp: Administrador) => 
    {
      this.confirmacionRegistro = true;
      console.log(resp);
      this.confirmacionLoading = false;
      this.http.delete('http://localhost:8080/api/usuario/' + localStorage.getItem('abcd')).subscribe(() => this.status = 'Delete successful');
      window.location.href= '/homeadmin';
    })
  }

  crearAdministrador(administrador: Administrador) 
  {
    return this.http.post<Administrador>("http://localhost:8080/api/administrador", administrador);
  }

  ngOnInit(): void 
  {
    this.http.get<ResponseReq>("http://localhost:8080/api/usuario/" + localStorage.getItem('abcd'), { responseType: 'json' }).subscribe((resp: ResponseReq) => {
      this.usuario.nombre = resp.datos[0].nombre;
      this.usuario.apellidos = resp.datos[0].apellidos;
      this.usuario.numeroIdentificacion = resp.datos[0].numeroIdentificacion;
      this.usuario.telefono = resp.datos[0].telefono;
      this.usuario.correo = resp.datos[0].correo;
      this.usuario.clave = resp.datos[0].clave;
      this.nombre = resp.datos[0].nombre;
    });
  }
}

export interface ResponseReqA
{
  estado: string;
  mensajes: string[];
  datos: Administrador[];
}

export class Administrador implements ResponseReqA
{
  nombre: string = '';
  apellidos: string = '';
  numeroIdentificacion: number = 0;
  telefono: number = 0;
  correo: string = '';
  clave: string = '';
  tienda: Tienda = new Tienda();
  estado!: string;
  mensajes!: string[];
  datos!: Administrador[];
  constructor() 
  {

  }
}

export class Tienda implements ResponseReqA
{
  nombre: string = '';
  direccion: string = '';
  ciudad: string = '';
  departamento: string = '';
  telefono: number = 0;
  calificacion: number = 0;
  
  constructor()
  {

  }

  estado!: string;
  mensajes!: string[];
  datos!: Administrador[];
}