package co.edu.uco.mercatouch.api.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.mercatouch.api.controlador.respuesta.Respuesta;
import co.edu.uco.mercatouch.api.controlador.respuesta.enumerador.EstadoRespuestaEnum;
import co.edu.uco.mercatouch.dto.AdministradorDTO;
import co.edu.uco.mercatouch.dto.UsuarioDTO;
import co.edu.uco.mercatouch.negocio.dominio.AdministradorDominio;
import co.edu.uco.mercatouch.negocio.dominio.UsuarioDominio;
import co.edu.uco.mercatouch.negocio.ensamblador.implementacion.AdministradorEnsambladorImpl;
import co.edu.uco.mercatouch.negocio.ensamblador.implementacion.UsuarioEnsambladorImpl;
import co.edu.uco.mercatouch.negocio.fachada.AdministradorFachada;
import co.edu.uco.mercatouch.negocio.fachada.UsuarioFachada;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchExcepcion;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthControlador 
{
	@Autowired
	UsuarioFachada usuarioFachada;
	
	@Autowired
	AdministradorFachada administradorFachada;
	
	@PostMapping
	public ResponseEntity<Respuesta<UsuarioDTO>> validarCredenciales(@RequestBody UsuarioDTO usuario)
	{
		ResponseEntity<Respuesta<UsuarioDTO>> entidadRespuesta;
		Respuesta<UsuarioDTO> respuesta = new Respuesta<>();
		
		var administrador = AdministradorDTO.crear().setCorreo(usuario.getCorreo()).setClave(usuario.getClave());
		
		try 
		{
			List<UsuarioDominio> listaU = UsuarioEnsambladorImpl.obtenerUsuarioEnsamblador().ensamblarDominiosDesdeDTO(usuarioFachada.consultar(usuario));
			
			List<UsuarioDominio> listaUsuario = new ArrayList<>();
			
			for(int i = 0; i < listaU.size(); i ++)
			{
				if(usuario.getCorreo().equals(listaU.get(i).getCorreo()))
				{
					listaUsuario.add(listaU.get(i));
				}
			}
			
			List<AdministradorDominio> listaA = AdministradorEnsambladorImpl.obtenerAdministradorEnsamblador().ensamblarDominiosDesdeDTO(administradorFachada.consultar(administrador));
			
			List<AdministradorDominio> listaAdministrador = new ArrayList<>();
			
			for(int i = 0; i < listaA.size(); i ++)
			{
				if(administrador.getCorreo().equals(listaA.get(i).getCorreo()))
				{
					listaAdministrador.add(listaA.get(i));
				}
			}
			
			if(!listaUsuario.isEmpty())
			{
				var usuarioDTO = UsuarioDTO.crear().setCorreo(usuario.getCorreo()).setClave(usuario.getClave());
				
				if(usuarioFachada.verificarCredenciales(usuarioDTO))
				{
					respuesta.adicionarMensaje("OK USER");
				}
				else
				{
					respuesta.adicionarMensaje("FAIL USER");
				}
			}
			
			if(!listaAdministrador.isEmpty())
			{
				var administradorDTO = AdministradorDTO.crear().setCorreo(usuario.getCorreo()).setClave(usuario.getClave());
				
				if(administradorFachada.verificarCredenciales(administradorDTO))
				{
					respuesta.adicionarMensaje("OK ADMIN");
				}
				else
				{
					respuesta.adicionarMensaje("FAIL ADMIN");
				}
			}
			
			respuesta.setEstado(EstadoRespuestaEnum.EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.ACCEPTED);
		} 
		catch (MercaTouchExcepcion excepcion) 
		{
			respuesta.adicionarMensaje(excepcion.getMessage());
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
		catch (Exception excepcion) 
		{
			respuesta.adicionarMensaje("Se ha presentado un problema inesperado tratando de autenticar las credenciales de un usuario " + excepcion.getMessage());
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
			
		return entidadRespuesta;
	}
}