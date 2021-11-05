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
import co.edu.uco.mercatouch.dto.UsuarioTiendaDTO;
import co.edu.uco.mercatouch.negocio.fachada.UsuarioTiendaFachada;

@RestController
@RequestMapping("/api/usuariotienda")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioTiendaControlador 
{
	@Autowired
	UsuarioTiendaFachada usuarioTiendaFachada;
	
	@PostMapping
	public ResponseEntity<Respuesta<UsuarioTiendaDTO>> crear(@RequestBody UsuarioTiendaDTO usuarioTienda)
	{
		ResponseEntity<Respuesta<UsuarioTiendaDTO>> entidadRespuesta;
		Respuesta<UsuarioTiendaDTO> respuesta = new Respuesta<>();
			
		try 
		{
			usuarioTiendaFachada.registrar(usuarioTienda);
			
			respuesta.adicionarMensaje("El UsuarioTienda se creo sin problemas");
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
			respuesta.adicionarMensaje("Se ha presentado un problema inesperado tratando de registrar la información de un nuevo usuarioTienda");
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
			
		return entidadRespuesta;
	}
		
	@PutMapping("/{codigo}")
	public ResponseEntity<Respuesta<UsuarioTiendaDTO>> modificar(@RequestBody UsuarioTiendaDTO usuarioTienda, @PathVariable int codigo)
	{
		ResponseEntity<Respuesta<UsuarioTiendaDTO>> entidadRespuesta;
		Respuesta<UsuarioTiendaDTO> respuesta = new Respuesta<>();
			
		try 
		{
			usuarioTiendaFachada.modificar(usuarioTienda.setCodigo(codigo));
				
			respuesta.adicionarMensaje("El usuarioTienda se Modifico sin problemas");
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
			respuesta.adicionarMensaje("Se ha presentado un problema inesperado tratando de modificar la información de un UsuarioTienda");
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
			
		return entidadRespuesta;
	}
	   
	@DeleteMapping("/{codigo}")
	public ResponseEntity<Respuesta<UsuarioTiendaDTO>> eliminar(@PathVariable int codigo)
	{
	    ResponseEntity<Respuesta<UsuarioTiendaDTO>> entidadRespuesta;
		Respuesta<UsuarioTiendaDTO> respuesta = new Respuesta<>();
			
		try 
		{
			usuarioTiendaFachada.eliminar(UsuarioTiendaDTO.crear().setCodigo(codigo));
				
			respuesta.adicionarMensaje("El usuarioTienda se elimino sin problemas");
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
			respuesta.adicionarMensaje("Se ha presentado un problema inesperado tratando de eliminar la información de un usuarioTienda");
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
			
		return entidadRespuesta;
	}
	    
	@GetMapping
	public ResponseEntity<Respuesta<UsuarioTiendaDTO>> consultar()
	{
		ResponseEntity<Respuesta<UsuarioTiendaDTO>> entidadRespuesta;
		Respuesta<UsuarioTiendaDTO> respuesta = new Respuesta<>();
			
		try 
		{
			List<UsuarioTiendaDTO> usuariosTienda = usuarioTiendaFachada.consultar(UsuarioTiendaDTO.crear());
				
			respuesta.setDatos(usuariosTienda);
			respuesta.adicionarMensaje("Los UsuariosTienda se consultaron de forma exitosa.");
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
			respuesta.adicionarMensaje("Se ha presentado un problema inesperado tratando de consultar la información de los UsuariosTienda");
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
			
			return entidadRespuesta;
		}
		
	@GetMapping("/{codigo}")
	public ResponseEntity<Respuesta<UsuarioTiendaDTO>> consultar(@PathVariable int codigo) 
	{
		ResponseEntity<Respuesta<UsuarioTiendaDTO>> entidadRespuesta;
		Respuesta<UsuarioTiendaDTO> respuesta = new Respuesta<>();

		try 
		{
			List<UsuarioTiendaDTO> usuariosTienda = usuarioTiendaFachada.consultar(UsuarioTiendaDTO.crear().setCodigo(codigo));

			respuesta.setDatos(usuariosTienda);
			
			if (respuesta.getDatos().isEmpty()) 
			{
				respuesta.adicionarMensaje("No exite un UsuarioTienda con codigo " + codigo);
			} 
			else 
			{
				respuesta.adicionarMensaje("El UsuarioTiendaDTO se consulto de forma exitosa.");
			}

			respuesta.setEstado(EstadoRespuestaEnum.EXITOSA);

			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.ACCEPTED);
		} catch (RuntimeException excepcion) 
		{
			respuesta.adicionarMensaje(excepcion.getMessage());
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);

			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);

			excepcion.printStackTrace();
		} catch (Exception excepcion) 
		{
			respuesta.adicionarMensaje("Se ha presentado un problema inesperado tratando de consultar la información del UsuarioTienda " + codigo);
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);

			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);

			excepcion.printStackTrace();
		}

		return entidadRespuesta;
	}
}