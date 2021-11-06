import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit 
{
  usuario: Usuario = new Usuario();
  usuarioAuth: Usuario = new Usuario();
  confirmarClave: String = '';
  confirmacionLoading: Boolean = false;
  confirmacionCampos: boolean = false;
  confirmacionLogin: boolean = false;
  confirmacionLogout: boolean = false;
  confirmacionRegistro: boolean = false;
  confirmacionUsuario: boolean = false;
  campoRequeridoNombre: boolean = false;
  campoRequeridoApellidos: boolean = false;
  campoRequeridoIdentificacion: boolean = false;
  campoRequeridotelefono: boolean = false;
  campoRequeridoCorreo: boolean = false;
  campoRequeridoClave: boolean = false;

  formularioRegistro = new FormGroup
  ({
    registroNombre: new FormControl('', Validators.required),
    registroApellidos: new FormControl('', Validators.required),
    registroIdentificacion: new FormControl('', Validators.required),
    registroTelefono: new FormControl('', Validators.required),
    registroCorreo: new FormControl('', Validators.required),
    registroClave: new FormControl('', Validators.required),
    registroConfirmarClave: new FormControl('', Validators.required),
  });

  formularioIniciarSesion = new FormGroup
  ({
    inicioCorreo: new FormControl('', Validators.required),
    inicioClave: new FormControl('', Validators.required)
  });

  constructor(public http: HttpClient) { }

  onRegistrarUsuario()
  {
    this.campoRequeridoNombre = false;
    this.campoRequeridoApellidos = false;
    this.campoRequeridoIdentificacion = false;
    this.campoRequeridotelefono = false;
    this.campoRequeridoCorreo = false;
    this.campoRequeridoClave = false;
    this.confirmacionCampos = false;
    this.confirmacionLoading = true;

    this.usuario.nombre = this.formularioRegistro.get('registroNombre')?.value;
    this.usuario.apellidos = this.formularioRegistro.get('registroApellidos')?.value;
    this.usuario.numeroIdentificacion  = this.formularioRegistro.get('registroIdentificacion')?.value;
    this.usuario.telefono = this.formularioRegistro.get('registroTelefono')?.value;
    this.usuario.correo = this.formularioRegistro.get('registroCorreo')?.value;
    this.usuario.clave = this.formularioRegistro.get('registroClave')?.value;
    this.usuario.puntuacion = 0;
    this.usuario.perfil.nombre = 'Usuario';
    this.confirmarClave = this.formularioRegistro.get('registroConfirmarClave')?.value;

    if(this.usuario.nombre === '')
    {
      this.campoRequeridoNombre = true;
      this.confirmacionLoading = false;
      this.confirmacionCampos = true;
    }

    if(this.usuario.apellidos === '')
    {
      this.campoRequeridoApellidos = true;
      this.confirmacionLoading = false;
      this.confirmacionCampos = true;
    }

    if(this.usuario.telefono === 0)
    {
      this.campoRequeridotelefono = true;
      this.confirmacionLoading = false;
      this.confirmacionCampos = true;
    }

    if(this.usuario.numeroIdentificacion === 0)
    {
      this.campoRequeridoIdentificacion = true;
      this.confirmacionLoading = false;
      this.confirmacionCampos = true;
    }

    if(this.usuario.correo === '')
    {
      this.campoRequeridoCorreo = true;
      this.confirmacionLoading = false;
      this.confirmacionCampos = true;
    }

    if(this.usuario.clave === '')
    {
      this.campoRequeridoClave = true;
      this.confirmacionLoading = false;
      this.confirmacionCampos = true;
    }

    if(this.usuario.clave === this.confirmarClave)
    {
      this.confirmacionLogout = false;
      this.confirmacionCampos = false;
      this.crearUsuario(this.usuario).subscribe((resp: Usuario) => 
      {
        this.confirmacionRegistro = true;
        console.log(resp);
        this.confirmacionLoading = false;
      })
    }
    else
    {
      this.confirmacionLogout = true;
      this.confirmacionLoading = false;
    }
  }

  crearUsuario(usuario: Usuario) 
  {
    return this.http.post<Usuario>("http://localhost:8080/api/usuario", usuario);
  }

  onIniciarSesion()
  {
    this.confirmacionLoading = true;
    this.usuarioAuth.nombre = 'Vacio';
    this.usuarioAuth.apellidos = 'Vacio';
    this.usuarioAuth.numeroIdentificacion = 0;
    this.usuarioAuth.telefono = 0;
    this.usuarioAuth.correo = this.formularioIniciarSesion.get('inicioCorreo')?.value;
    this.usuarioAuth.clave = this.formularioIniciarSesion.get('inicioClave')?.value;
    this.usuarioAuth.puntuacion = 0;

    this.verificarCredencialesUsuario(this.usuarioAuth).subscribe((resp: ResponseReq) => 
    {
      if(resp.mensajes[0] === 'OK')
      {
        window.location.href= '/homeuser';
        this.confirmacionLoading = false;
        localStorage.setItem('abcd', this.usuarioAuth.correo);
      }
      else
      {
        this.confirmacionLogin = true;
        this.confirmacionLoading = false;
      }
    })
  }

  verificarCredencialesUsuario(usuarioAuth: Usuario)
  {
    return this.http.post<Usuario>("http://localhost:8080/api/auth", usuarioAuth);
  }

  ngOnInit(): void 
  {

  }
}

export class Usuario implements ResponseReq
{
  nombre: string = '';
  apellidos: string = '';
  numeroIdentificacion: number = 0;
  telefono: number = 0;
  correo: string = '';
  clave: string = '';
  puntuacion: number = 0;
  perfil: Perfil = new Perfil();
  estado!: string;
  mensajes!: string[];
  datos!: Usuario[];
  constructor() 
  {

  }
}

export class Perfil implements ResponseReq
{
  nombre: string = '';
  estado!: string;
  mensajes!: string[];
  datos!: Usuario[];
  constructor() 
  {

  }
}

export interface ResponseReq 
{
  estado: string;
  mensajes: string[];
  datos: Usuario[];
}