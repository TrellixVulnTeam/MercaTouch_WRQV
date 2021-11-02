package co.edu.uco.mercatouch.negocio.ensamblador.implementacion;

import java.util.List;
import java.util.stream.Collectors;
import co.edu.uco.mercatouch.dto.TiendaDTO;
import co.edu.uco.mercatouch.entidad.TiendaEntidad;
import co.edu.uco.mercatouch.negocio.dominio.TiendaDominio;
import co.edu.uco.mercatouch.negocio.ensamblador.TiendaEnsamblador;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilObjeto;

public class TiendaEnsambladorImpl implements TiendaEnsamblador
{
	private static final TiendaEnsamblador INSTANCIA = new TiendaEnsambladorImpl();

	private TiendaEnsambladorImpl()
	{
		
	}
	
	public static TiendaEnsamblador obtenerTiendaEnsamblador()
	{
		return INSTANCIA;
	}

	@Override
	public TiendaDominio ensamblarDominioDesdeEntidad(TiendaEntidad entidad)
	{
		if(UtilObjeto.esNulo(entidad))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un Dominio de Tienda a partir de una entidad de una Tienda que esta nulo");
		}
		
		return TiendaDominio.crear(entidad.getCodigo(), entidad.getNombre(), entidad.getDireccion(), entidad.getCiudad(), entidad.getDepartamento(), entidad.getTelefono(), entidad.getCalificacion());
	}

	@Override
	public List<TiendaDominio> ensamblarDominiosDesdeEntidad(List<TiendaEntidad> entidades) 
	{
		return entidades.stream().map(obtenerTiendaEnsamblador()::ensamblarDominioDesdeEntidad).collect(Collectors.toList());
	}

	@Override
	public TiendaEntidad ensamblarEntidadDesdeDominio(TiendaDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar una Entidad de Tienda a partir de un dominio de una Tienda que esta nulo");
		}
		
		return TiendaEntidad.crear(dominio.getCodigo(), dominio.getNombre(), dominio.getDireccion(), dominio.getCiudad(), dominio.getDepartamento(), dominio.getTelefono(), dominio.getCalificacion());
	}

	@Override
	public List<TiendaEntidad> ensamblarEntidadesDesdeDominio(List<TiendaDominio> dominios) 
	{
		return dominios.stream().map(obtenerTiendaEnsamblador()::ensamblarEntidadDesdeDominio).collect(Collectors.toList());
	}

	@Override
	public TiendaDominio ensamblarDominioDesdeDTO(TiendaDTO dto) 
	{
		if(UtilObjeto.esNulo(dto))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un Dominio de Tienda a partir de un DTO de una Tienda que esta nulo");
		}
		
		return TiendaDominio.crear(dto.getCodigo(), dto.getNombre(), dto.getDireccion(), dto.getCiudad(), dto.getDepartamento(), dto.getTelefono(), dto.getCalificacion());
	}

	@Override
	public List<TiendaDominio> ensamblarDominiosDesdeDTO(List<TiendaDTO> dtos) 
	{
		return dtos.stream().map(obtenerTiendaEnsamblador()::ensamblarDominioDesdeDTO).collect(Collectors.toList());
	}

	@Override
	public TiendaDTO ensamblarDTODesdeDominio(TiendaDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un DTO de Tienda a partir de un Dominio de una Tienda que esta nulo");
		}
		
		return TiendaDTO.crear(dominio.getCodigo(), dominio.getNombre(), dominio.getDireccion(), dominio.getCiudad(), dominio.getDepartamento(), dominio.getTelefono(), dominio.getCalificacion());
	}

	@Override
	public List<TiendaDTO> ensamblarDTOsDesdeDominio(List<TiendaDominio> dominios) 
	{
		return dominios.stream().map(obtenerTiendaEnsamblador()::ensamblarDTODesdeDominio).collect(Collectors.toList());
	}
}