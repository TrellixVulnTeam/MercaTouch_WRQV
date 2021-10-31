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
import co.edu.uco.mercatouch.dto.TiendaDTO;
import co.edu.uco.mercatouch.negocio.fachada.TiendaFachada;

@RestController
@RequestMapping("/api/tienda")
@CrossOrigin(origins = "http://localhost:4200")
public class TiendaControlador 
{
	@Autowired
	TiendaFachada tiendaFachada;
	
	@PostMapping
	public ResponseEntity<Respuesta<TiendaDTO>> crear(@RequestBody TiendaDTO tienda)
	{
		ResponseEntity<Respuesta<TiendaDTO>> entidadRespuesta;
		Respuesta<TiendaDTO> respuesta = new Respuesta<>();
			
		try 
		{
			var tiendaDTO = TiendaDTO.crear().setNombre(tienda.getNombre()).setDireccion(tienda.getDireccion()).setCiudad(tienda.getCiudad()).setDepartamento(tienda.getDepartamento()).setTelefono(tienda.getTelefono());
			
			tiendaFachada.registrar(tiendaDTO);
			
			respuesta.adicionarMensaje("La tienda se creo sin problemas");
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
			respuesta.adicionarMensaje("Se ha presentado un problema inesperado tratando de registrar la información de una nueva tienda");
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
			
		return entidadRespuesta;
	}
		
	@PutMapping("/{codigo}")
	public ResponseEntity<Respuesta<TiendaDTO>> modificar(@RequestBody TiendaDTO tienda, @PathVariable int codigo)
	{
		ResponseEntity<Respuesta<TiendaDTO>> entidadRespuesta;
		Respuesta<TiendaDTO> respuesta = new Respuesta<>();
			
		try 
		{
			tiendaFachada.modificar(tienda.setCodigo(codigo));
				
			respuesta.adicionarMensaje("La tienda se Modifico sin problemas");
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
			respuesta.adicionarMensaje("Se ha presentado un problema inesperado tratando de modificar la información de una tienda");
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
			
		return entidadRespuesta;
	}
	   
	@DeleteMapping("/{codigo}")
	public ResponseEntity<Respuesta<TiendaDTO>> eliminar(@PathVariable int codigo)
	{
	    ResponseEntity<Respuesta<TiendaDTO>> entidadRespuesta;
		Respuesta<TiendaDTO> respuesta = new Respuesta<>();
			
		try 
		{
			tiendaFachada.eliminar(TiendaDTO.crear().setCodigo(codigo));
				
			respuesta.adicionarMensaje("La tienda se elimino sin problemas");
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
			respuesta.adicionarMensaje("Se ha presentado un problema inesperado tratando de eliminar la información de una tienda");
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
			
		return entidadRespuesta;
	}
	    
	@GetMapping
	public ResponseEntity<Respuesta<TiendaDTO>> consultar()
	{
		ResponseEntity<Respuesta<TiendaDTO>> entidadRespuesta;
		Respuesta<TiendaDTO> respuesta = new Respuesta<>();
			
		try 
		{
			List<TiendaDTO> tiendas = tiendaFachada.consultar(TiendaDTO.crear());
				
			respuesta.setDatos(tiendas);
			respuesta.adicionarMensaje("Las tiendas se consultaron de forma exitosa.");
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
			respuesta.adicionarMensaje("Se ha presentado un problema inesperado tratando de consultar la información de las tiendas");
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
			
			return entidadRespuesta;
		}
		
	@GetMapping("/{codigo}")
	public ResponseEntity<Respuesta<TiendaDTO>> consultar(@PathVariable int codigo) 
	{
		ResponseEntity<Respuesta<TiendaDTO>> entidadRespuesta;
		Respuesta<TiendaDTO> respuesta = new Respuesta<>();

		try 
		{
			List<TiendaDTO> tiendas = tiendaFachada.consultar(TiendaDTO.crear().setCodigo(codigo));

			respuesta.setDatos(tiendas);
			
			if (respuesta.getDatos().isEmpty()) 
			{
				respuesta.adicionarMensaje("No exite una tienda con codigo " + codigo);
			} 
			else 
			{
				respuesta.adicionarMensaje("La tienda se consulto de forma exitosa.");
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
			respuesta.adicionarMensaje("Se ha presentado un problema inesperado tratando de consultar la información de la tienda " + codigo);
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);

			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);

			excepcion.printStackTrace();
		}

		return entidadRespuesta;
	}
}