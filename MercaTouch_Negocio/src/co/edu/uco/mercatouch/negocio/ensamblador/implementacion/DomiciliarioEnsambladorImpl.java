package co.edu.uco.mercatouch.negocio.ensamblador.implementacion;

import java.util.List;
import java.util.stream.Collectors;
import co.edu.uco.mercatouch.dto.DomiciliarioDTO;
import co.edu.uco.mercatouch.entidad.DomiciliarioEntidad;
import co.edu.uco.mercatouch.negocio.dominio.DomiciliarioDominio;
import co.edu.uco.mercatouch.negocio.ensamblador.DomiciliarioEnsamblador;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilObjeto;

public class DomiciliarioEnsambladorImpl implements DomiciliarioEnsamblador
{
	private static final DomiciliarioEnsamblador INSTANCIA = new DomiciliarioEnsambladorImpl();

	private DomiciliarioEnsambladorImpl()
	{
		
	}
	
	public static DomiciliarioEnsamblador obtenerDomiciliarioEnsamblador()
	{
		return INSTANCIA;
	}

	@Override
	public DomiciliarioDominio ensamblarDominioDesdeEntidad(DomiciliarioEntidad entidad) 
	{
		if(UtilObjeto.esNulo(entidad))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un Domiciliario de Administrador a partir de una entidad de un Domiciliario que esta nulo");
		}
		
		return DomiciliarioDominio.crear(entidad.getCodigo(), entidad.getNombre(), entidad.getApellidos(), entidad.getNumeroIdentificacion(), entidad.getTelefono(), entidad.getCorreo(), entidad.getClave(), entidad.getPuntuacion(), TiendaEnsambladorImpl.obtenerTiendaEnsamblador().ensamblarDominioDesdeEntidad(entidad.getTienda()));
	}

	@Override
	public List<DomiciliarioDominio> ensamblarDominiosDesdeEntidad(List<DomiciliarioEntidad> entidades) 
	{
		return entidades.stream().map(obtenerDomiciliarioEnsamblador()::ensamblarDominioDesdeEntidad).collect(Collectors.toList());
	}

	@Override
	public DomiciliarioEntidad ensamblarEntidadDesdeDominio(DomiciliarioDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar una Entidad de Domiciliario a partir de un dominio de un Domiciliario que esta nulo");
		}
		
		return DomiciliarioEntidad.crear(dominio.getCodigo(), dominio.getNombre(), dominio.getApellidos(), dominio.getNumeroIdentificacion(), dominio.getTelefono(), dominio.getCorreo(), dominio.getClave(), dominio.getPuntuacion(), TiendaEnsambladorImpl.obtenerTiendaEnsamblador().ensamblarEntidadDesdeDominio(dominio.getTienda()));
	}

	@Override
	public List<DomiciliarioEntidad> ensamblarEntidadesDesdeDominio(List<DomiciliarioDominio> dominios) 
	{
		return dominios.stream().map(obtenerDomiciliarioEnsamblador()::ensamblarEntidadDesdeDominio).collect(Collectors.toList());
	}

	@Override
	public DomiciliarioDominio ensamblarDominioDesdeDTO(DomiciliarioDTO dto) 
	{
		if(UtilObjeto.esNulo(dto))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un Dominio de Domiciliario a partir de un DTO de un Domiciliario que esta nulo");
		}
		
		return DomiciliarioDominio.crear(dto.getCodigo(), dto.getNombre(), dto.getApellidos(), dto.getNumeroIdentificacion(), dto.getTelefono(), dto.getCorreo(), dto.getClave(), dto.getPuntuacion(), TiendaEnsambladorImpl.obtenerTiendaEnsamblador().ensamblarDominioDesdeDTO(dto.getTienda()));
	}

	@Override
	public List<DomiciliarioDominio> ensamblarDominiosDesdeDTO(List<DomiciliarioDTO> dtos) 
	{
		return dtos.stream().map(obtenerDomiciliarioEnsamblador()::ensamblarDominioDesdeDTO).collect(Collectors.toList());
	}

	@Override
	public DomiciliarioDTO ensamblarDTODesdeDominio(DomiciliarioDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un DTO de Domiciliario a partir de un Dominio de un Domiciliario que esta nulo");
		}
		
		return DomiciliarioDTO.crear(dominio.getCodigo(), dominio.getNombre(), dominio.getApellidos(), dominio.getNumeroIdentificacion(), dominio.getTelefono(), dominio.getCorreo(), dominio.getClave(), dominio.getPuntuacion(), TiendaEnsambladorImpl.obtenerTiendaEnsamblador().ensamblarDTODesdeDominio(dominio.getTienda()));
	}

	@Override
	public List<DomiciliarioDTO> ensamblarDTOsDesdeDominio(List<DomiciliarioDominio> dominios) 
	{
		return dominios.stream().map(obtenerDomiciliarioEnsamblador()::ensamblarDTODesdeDominio).collect(Collectors.toList());
	}
}