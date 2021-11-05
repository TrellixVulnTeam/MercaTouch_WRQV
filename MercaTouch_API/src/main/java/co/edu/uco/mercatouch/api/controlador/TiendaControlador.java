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
import co.edu.uco.mercatouch.dto.CiudadDTO;
import co.edu.uco.mercatouch.dto.PlanSuscripcionDTO;
import co.edu.uco.mercatouch.dto.TiendaDTO;
import co.edu.uco.mercatouch.dto.UsuarioDTO;
import co.edu.uco.mercatouch.dto.UsuarioTiendaDTO;
import co.edu.uco.mercatouch.negocio.fachada.CiudadFachada;
import co.edu.uco.mercatouch.negocio.fachada.PlanSuscripcionFachada;
import co.edu.uco.mercatouch.negocio.fachada.TiendaFachada;
import co.edu.uco.mercatouch.negocio.fachada.UsuarioFachada;
import co.edu.uco.mercatouch.negocio.fachada.UsuarioTiendaFachada;

@RestController
@RequestMapping("/api/tienda")
@CrossOrigin(origins = "http://localhost:4200")
public class TiendaControlador 
{
	@Autowired
	UsuarioTiendaFachada usuarioTiendaFachada;
	
	@Autowired
	TiendaFachada tiendaFachada;
	
	@Autowired
	PlanSuscripcionFachada planSuscripcionFachada;
	
	@Autowired
	CiudadFachada ciudadFachada;
	
	@Autowired
	UsuarioFachada usuarioFachada;
	
	@PostMapping("/{correo}")
	public ResponseEntity<Respuesta<TiendaDTO>> crear(@RequestBody TiendaDTO tienda, @PathVariable String correo)
	{
		ResponseEntity<Respuesta<TiendaDTO>> entidadRespuesta;
		Respuesta<TiendaDTO> respuesta = new Respuesta<>();
			
		try 
		{
			var planSuscripcion = PlanSuscripcionDTO.crear().setNombre(tienda.getPlanSuscripcion().getNombre()).setDescripcion(tienda.getPlanSuscripcion().getDescripcion()).setPrecio(tienda.getPlanSuscripcion().getPrecio()).setTiempoSuscripcion(tienda.getPlanSuscripcion().getTiempoSuscripcion());
			planSuscripcionFachada.registrar(planSuscripcion);
			
			List<PlanSuscripcionDTO> planesSuscripcion = planSuscripcionFachada.consultar(PlanSuscripcionDTO.crear());
			
			var planSuscripcionDTO = planesSuscripcion.get(planesSuscripcion.size() -1);
			
			tienda.setPlanSuscripcion(planSuscripcionDTO);
			
			List<CiudadDTO> ciudades = ciudadFachada.consultar(CiudadDTO.crear());
			
			var ciudad = CiudadDTO.crear();
			for(int i = 0; i < ciudades.size(); i++)
			{
				if(ciudades.get(i).getNombre().equals(tienda.getCiudad().getNombre()) && ciudades.get(i).getDepartamento().getNombre().equals(tienda.getCiudad().getDepartamento().getNombre()))
				{
					ciudad = ciudades.get(i);
					
				}
			}
			
			tienda.setCiudad(ciudad);
			
			tiendaFachada.registrar(tienda);
			
			List<UsuarioDTO> usuariosDTO = usuarioFachada.consultar(UsuarioDTO.crear());
			
			var usuario = UsuarioDTO.crear();
			
			for(int i = 0; i < usuariosDTO.size(); i++)
			{
				if(usuariosDTO.get(i).getCorreo().equals(correo))
				{
					usuario = usuariosDTO.get(i);
				}
			}
			
			List<TiendaDTO> tiendasDTO = tiendaFachada.consultar(TiendaDTO.crear());
			
			var tiendaDTO = tiendasDTO.get(tiendasDTO.size() -1);
			
			var usuarioTienda = UsuarioTiendaDTO.crear().setUsuario(usuario).setTienda(tiendaDTO);
			
			usuarioTiendaFachada.registrar(usuarioTienda);
			
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