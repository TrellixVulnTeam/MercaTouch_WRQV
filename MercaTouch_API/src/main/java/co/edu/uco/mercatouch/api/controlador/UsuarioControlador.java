package co.edu.uco.mercatouch.api.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.uco.mercatouch.api.controlador.respuesta.Respuesta;
import co.edu.uco.mercatouch.api.controlador.respuesta.enumerador.EstadoRespuestaEnum;
import co.edu.uco.mercatouch.dto.UsuarioDTO;
import co.edu.uco.mercatouch.negocio.fachada.UsuarioFachada;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioControlador 
{
	@Autowired
	UsuarioFachada usuarioFachada;
	
	@PostMapping
	public ResponseEntity<Respuesta<UsuarioDTO>> crear(@RequestBody UsuarioDTO usuario)
	{
		ResponseEntity<Respuesta<UsuarioDTO>> entidadRespuesta;
		Respuesta<UsuarioDTO> respuesta = new Respuesta<>();
			
		try 
		{
			var usuarioDTO = UsuarioDTO.crear().setNombre(usuario.getNombre()).setApellidos(usuario.getApellidos()).setNumeroIdentificacion(usuario.getNumeroIdentificacion()).setCorreo(usuario.getCorreo()).setClave(usuario.getClave()).setTelefono(usuario.getTelefono());
			
			/*Argon2 argon = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
			String hash = argon.hash(1, 1024, 1, usuarioDTO.getClave());
			usuarioDTO.setClave(hash);*/
			
			usuarioFachada.registrar(usuarioDTO);
			
			respuesta.adicionarMensaje("El usuario se creo sin problemas");
			respuesta.setEstado(EstadoRespuestaEnum.EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.ACCEPTED);
		} 
		catch (RuntimeException excepcion) 
		{
			respuesta.adicionarMensaje(excepcion.getMessage());
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
		catch (Exception excepcion) 
		{
			respuesta.adicionarMensaje("Se ha presentado un problema inesperado tratando de registrar la información de un nuevo usuario");
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
			
		return entidadRespuesta;
	}
		
	@PutMapping("/{codigo}")
	public ResponseEntity<Respuesta<UsuarioDTO>> modificar(@RequestBody UsuarioDTO usuario, @PathVariable int codigo)
	{
		ResponseEntity<Respuesta<UsuarioDTO>> entidadRespuesta;
		Respuesta<UsuarioDTO> respuesta = new Respuesta<>();
			
		try 
		{
			usuarioFachada.modificar(usuario.setCodigo(codigo));
				
			respuesta.adicionarMensaje("El usuario se Modifico sin problemas");
			respuesta.setEstado(EstadoRespuestaEnum.EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.ACCEPTED);
		} 
		catch (RuntimeException excepcion) 
		{
			respuesta.adicionarMensaje(excepcion.getMessage());
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
		catch (Exception excepcion) 
		{
			respuesta.adicionarMensaje("Se ha presentado un problema inesperado tratando de modificar la información de un Usuario");
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
			
		return entidadRespuesta;
	}
	   
	@DeleteMapping("/{correo}")
	public ResponseEntity<Respuesta<UsuarioDTO>> eliminar(@PathVariable String correo)
	{
	    ResponseEntity<Respuesta<UsuarioDTO>> entidadRespuesta;
		Respuesta<UsuarioDTO> respuesta = new Respuesta<>();
			
		try 
		{
			List<UsuarioDTO> usuarios = usuarioFachada.consultar(UsuarioDTO.crear().setCorreo(correo));
			
			usuarioFachada.eliminar(UsuarioDTO.crear().setCodigo(usuarios.get(0).getCodigo()));
				
			respuesta.adicionarMensaje("El usuario se elimino sin problemas");
			respuesta.setEstado(EstadoRespuestaEnum.EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.ACCEPTED);
		} 
		catch (RuntimeException excepcion) 
		{
			respuesta.adicionarMensaje(excepcion.getMessage());
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
		catch (Exception excepcion) 
		{
			respuesta.adicionarMensaje("Se ha presentado un problema inesperado tratando de eliminar la información de un usuario");
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
			
		return entidadRespuesta;
	}
	    
	@GetMapping
	public ResponseEntity<Respuesta<UsuarioDTO>> consultar()
	{
		ResponseEntity<Respuesta<UsuarioDTO>> entidadRespuesta;
		Respuesta<UsuarioDTO> respuesta = new Respuesta<>();
			
		try 
		{
			List<UsuarioDTO> usuarios = usuarioFachada.consultar(UsuarioDTO.crear());
				
			respuesta.setDatos(usuarios);
			respuesta.adicionarMensaje("Los usuarios se consultaron de forma exitosa.");
			respuesta.setEstado(EstadoRespuestaEnum.EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.ACCEPTED);
		} 
		catch (RuntimeException excepcion) 
		{
			respuesta.adicionarMensaje(excepcion.getMessage());
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
		catch (Exception excepcion) 
		{
			respuesta.adicionarMensaje("Se ha presentado un problema inesperado tratando de consultar la información de los usuarios");
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
			
			return entidadRespuesta;
	}
	
	@GetMapping("/{correo}")
	public ResponseEntity<Respuesta<UsuarioDTO>> consultar(@PathVariable String correo)
	{
		ResponseEntity<Respuesta<UsuarioDTO>> entidadRespuesta;
		Respuesta<UsuarioDTO> respuesta = new Respuesta<>();
			
		try 
		{
			List<UsuarioDTO> usuarios = usuarioFachada.consultar(UsuarioDTO.crear().setCorreo(correo));
			
			respuesta.setDatos(usuarios);
			respuesta.adicionarMensaje("Los usuarios se consultaron de forma exitosa.");
			respuesta.setEstado(EstadoRespuestaEnum.EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.ACCEPTED);
		} 
		catch (RuntimeException excepcion) 
		{
			respuesta.adicionarMensaje(excepcion.getMessage());
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
		catch (Exception excepcion) 
		{
			respuesta.adicionarMensaje("Se ha presentado un problema inesperado tratando de consultar la información de los usuarios");
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
			
			return entidadRespuesta;
	}
}