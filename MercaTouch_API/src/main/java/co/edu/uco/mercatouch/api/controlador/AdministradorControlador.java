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
import co.edu.uco.mercatouch.dto.AdministradorDTO;
import co.edu.uco.mercatouch.dto.TiendaDTO;
import co.edu.uco.mercatouch.negocio.fachada.AdministradorFachada;
import co.edu.uco.mercatouch.negocio.fachada.TiendaFachada;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@RestController
@RequestMapping("/api/administrador")
@CrossOrigin(origins = "http://localhost:4200")
public class AdministradorControlador 
{
	@Autowired
	AdministradorFachada administradorFachada;
	
	@Autowired
	TiendaFachada tiendaFachada;
	
	@PostMapping
	public ResponseEntity<Respuesta<AdministradorDTO>> crear(@RequestBody AdministradorDTO administrador)
	{
		ResponseEntity<Respuesta<AdministradorDTO>> entidadRespuesta;
		Respuesta<AdministradorDTO> respuesta = new Respuesta<>();
			
		try 
		{
			tiendaFachada.registrar(administrador.getTienda());
			
			List<TiendaDTO> lista = tiendaFachada.consultar(TiendaDTO.crear());
			
			var tienda = lista.get(lista.size() - 1);
			
			var administradorDTO = AdministradorDTO.crear().setNombre(administrador.getNombre()).setApellidos(administrador.getApellidos()).setNumeroIdentificacion(administrador.getNumeroIdentificacion()).setCorreo(administrador.getCorreo()).setClave(administrador.getClave()).setTelefono(administrador.getTelefono()).setTienda(tienda);
			
			Argon2 argon = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
			String hash = argon.hash(1, 1024, 1, administradorDTO.getClave());
			administradorDTO.setClave(hash);
			
			administradorFachada.registrar(administradorDTO);
			
			respuesta.adicionarMensaje("El administrador se creo sin problemas");
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
			respuesta.adicionarMensaje("Se ha presentado un problema inesperado tratando de registrar la información de un nuevo administrador");
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
			
		return entidadRespuesta;
	}
		
	@PutMapping("/{codigo}")
	public ResponseEntity<Respuesta<AdministradorDTO>> modificar(@RequestBody AdministradorDTO administrador, @PathVariable int codigo)
	{
		ResponseEntity<Respuesta<AdministradorDTO>> entidadRespuesta;
		Respuesta<AdministradorDTO> respuesta = new Respuesta<>();
			
		try 
		{
			administradorFachada.modificar(administrador.setCodigo(codigo));
				
			respuesta.adicionarMensaje("El administrador se Modifico sin problemas");
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
			respuesta.adicionarMensaje("Se ha presentado un problema inesperado tratando de modificar la información de un administrador");
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
			
		return entidadRespuesta;
	}
	   
	@DeleteMapping("/{codigo}")
	public ResponseEntity<Respuesta<AdministradorDTO>> eliminar(@PathVariable int codigo)
	{
	    ResponseEntity<Respuesta<AdministradorDTO>> entidadRespuesta;
		Respuesta<AdministradorDTO> respuesta = new Respuesta<>();
			
		try 
		{
			administradorFachada.eliminar(AdministradorDTO.crear().setCodigo(codigo));
				
			respuesta.adicionarMensaje("El administrador se elimino sin problemas");
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
			respuesta.adicionarMensaje("Se ha presentado un problema inesperado tratando de eliminar la información de un administrador");
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
			
		return entidadRespuesta;
	}
	    
	@GetMapping
	public ResponseEntity<Respuesta<AdministradorDTO>> consultar()
	{
		ResponseEntity<Respuesta<AdministradorDTO>> entidadRespuesta;
		Respuesta<AdministradorDTO> respuesta = new Respuesta<>();
			
		try 
		{
			List<AdministradorDTO> administradores = administradorFachada.consultar(AdministradorDTO.crear());
				
			respuesta.setDatos(administradores);
			respuesta.adicionarMensaje("Los administradores se consultaron de forma exitosa.");
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
			respuesta.adicionarMensaje("Se ha presentado un problema inesperado tratando de consultar la información de los administradores");
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
			
			return entidadRespuesta;
		}
		
	@GetMapping("/{codigo}")
	public ResponseEntity<Respuesta<AdministradorDTO>> consultar(@PathVariable int codigo) 
	{
		ResponseEntity<Respuesta<AdministradorDTO>> entidadRespuesta;
		Respuesta<AdministradorDTO> respuesta = new Respuesta<>();

		try 
		{
			List<AdministradorDTO> administradores = administradorFachada.consultar(AdministradorDTO.crear().setCodigo(codigo));

			respuesta.setDatos(administradores);
			
			if (respuesta.getDatos().isEmpty()) 
			{
				respuesta.adicionarMensaje("No exite un administrador con codigo " + codigo);
			} 
			else 
			{
				respuesta.adicionarMensaje("El administrador se consulto de forma exitosa.");
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
			respuesta.adicionarMensaje("Se ha presentado un problema inesperado tratando de consultar la información del administrador " + codigo);
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);

			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);

			excepcion.printStackTrace();
		}

		return entidadRespuesta;
	}
}