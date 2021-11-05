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
import co.edu.uco.mercatouch.dto.PlanSuscripcionDTO;
import co.edu.uco.mercatouch.negocio.fachada.PlanSuscripcionFachada;

@RestController
@RequestMapping("/api/plansuscripcion")
@CrossOrigin(origins = "http://localhost:4200")
public class PlanSuscripcionControlador 
{
	@Autowired
	PlanSuscripcionFachada planSuscripcionFachada;
	
	@PostMapping
	public ResponseEntity<Respuesta<PlanSuscripcionDTO>> crear(@RequestBody PlanSuscripcionDTO planSuscripcion)
	{
		ResponseEntity<Respuesta<PlanSuscripcionDTO>> entidadRespuesta;
		Respuesta<PlanSuscripcionDTO> respuesta = new Respuesta<>();
			
		try 
		{
			planSuscripcionFachada.registrar(planSuscripcion);
			
			respuesta.adicionarMensaje("El planSuscripcion se creo sin problemas");
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
			respuesta.adicionarMensaje("Se ha presentado un problema inesperado tratando de registrar la información de un nuevo planSuscripcion");
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
			
		return entidadRespuesta;
	}
		
	@PutMapping("/{codigo}")
	public ResponseEntity<Respuesta<PlanSuscripcionDTO>> modificar(@RequestBody PlanSuscripcionDTO planSuscripcion, @PathVariable int codigo)
	{
		ResponseEntity<Respuesta<PlanSuscripcionDTO>> entidadRespuesta;
		Respuesta<PlanSuscripcionDTO> respuesta = new Respuesta<>();
			
		try 
		{
			planSuscripcionFachada.modificar(planSuscripcion.setCodigo(codigo));
				
			respuesta.adicionarMensaje("El planSuscripcion se Modifico sin problemas");
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
			respuesta.adicionarMensaje("Se ha presentado un problema inesperado tratando de modificar la información de un planSuscripcion");
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
			
		return entidadRespuesta;
	}
	   
	@DeleteMapping("/{codigo}")
	public ResponseEntity<Respuesta<PlanSuscripcionDTO>> eliminar(@PathVariable int codigo)
	{
	    ResponseEntity<Respuesta<PlanSuscripcionDTO>> entidadRespuesta;
		Respuesta<PlanSuscripcionDTO> respuesta = new Respuesta<>();
			
		try 
		{
			planSuscripcionFachada.eliminar(PlanSuscripcionDTO.crear().setCodigo(codigo));
				
			respuesta.adicionarMensaje("El planSuscripcion se elimino sin problemas");
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
			respuesta.adicionarMensaje("Se ha presentado un problema inesperado tratando de eliminar la información de un planSuscripcion");
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
			
		return entidadRespuesta;
	}
	    
	@GetMapping
	public ResponseEntity<Respuesta<PlanSuscripcionDTO>> consultar()
	{
		ResponseEntity<Respuesta<PlanSuscripcionDTO>> entidadRespuesta;
		Respuesta<PlanSuscripcionDTO> respuesta = new Respuesta<>();
			
		try 
		{
			List<PlanSuscripcionDTO> planesSuscripcion = planSuscripcionFachada.consultar(PlanSuscripcionDTO.crear());
				
			respuesta.setDatos(planesSuscripcion);
			respuesta.adicionarMensaje("Los planesSuscripcion se consultaron de forma exitosa.");
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
			respuesta.adicionarMensaje("Se ha presentado un problema inesperado tratando de consultar la información de los planesSuscripcion");
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);
				
			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
				
			excepcion.printStackTrace();
		}
			
			return entidadRespuesta;
		}
		
	@GetMapping("/{codigo}")
	public ResponseEntity<Respuesta<PlanSuscripcionDTO>> consultar(@PathVariable int codigo) 
	{
		ResponseEntity<Respuesta<PlanSuscripcionDTO>> entidadRespuesta;
		Respuesta<PlanSuscripcionDTO> respuesta = new Respuesta<>();

		try 
		{
			List<PlanSuscripcionDTO> planesSuscripcion = planSuscripcionFachada.consultar(PlanSuscripcionDTO.crear().setCodigo(codigo));

			respuesta.setDatos(planesSuscripcion);
			
			if (respuesta.getDatos().isEmpty()) 
			{
				respuesta.adicionarMensaje("No exite un planSuscripcion con codigo " + codigo);
			} 
			else 
			{
				respuesta.adicionarMensaje("El planSucripcion se consulto de forma exitosa.");
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
			respuesta.adicionarMensaje("Se ha presentado un problema inesperado tratando de consultar la información del plan de suscripcion " + codigo);
			respuesta.setEstado(EstadoRespuestaEnum.NO_EXITOSA);

			entidadRespuesta = new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);

			excepcion.printStackTrace();
		}

		return entidadRespuesta;
	}
}