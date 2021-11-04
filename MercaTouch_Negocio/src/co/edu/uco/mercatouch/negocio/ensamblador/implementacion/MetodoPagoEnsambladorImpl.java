package co.edu.uco.mercatouch.negocio.ensamblador.implementacion;

import java.util.List;
import java.util.stream.Collectors;
import co.edu.uco.mercatouch.dto.MetodoPagoDTO;
import co.edu.uco.mercatouch.entidad.MetodoPagoEntidad;
import co.edu.uco.mercatouch.negocio.dominio.MetodoPagoDominio;
import co.edu.uco.mercatouch.negocio.ensamblador.MetodoPagoEnsamblador;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilObjeto;

public class MetodoPagoEnsambladorImpl implements MetodoPagoEnsamblador
{
	private static final MetodoPagoEnsamblador INSTANCIA = new MetodoPagoEnsambladorImpl();

	private MetodoPagoEnsambladorImpl()
	{
		
	}
	
	public static MetodoPagoEnsamblador obtenerMetodoPagoEnsamblador()
	{
		return INSTANCIA;
	}

	@Override
	public MetodoPagoDominio ensamblarDominioDesdeEntidad(MetodoPagoEntidad entidad) 
	{
		if(UtilObjeto.esNulo(entidad))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un Dominio de MetodoPago a partir de una entidad de un MetodoPago que esta nulo");
		}
		
		return MetodoPagoDominio.crear(entidad.getCodigo(), entidad.getNombre());
	}

	@Override
	public List<MetodoPagoDominio> ensamblarDominiosDesdeEntidad(List<MetodoPagoEntidad> entidades) 
	{
		return entidades.stream().map(obtenerMetodoPagoEnsamblador()::ensamblarDominioDesdeEntidad).collect(Collectors.toList());
	}

	@Override
	public MetodoPagoEntidad ensamblarEntidadDesdeDominio(MetodoPagoDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar una Entidad de MetodoPago a partir de un dominio de un MetodoPago que esta nulo");
		}
		
		return MetodoPagoEntidad.crear(dominio.getCodigo(), dominio.getNombre());
	}

	@Override
	public List<MetodoPagoEntidad> ensamblarEntidadesDesdeDominio(List<MetodoPagoDominio> dominios) 
	{
		return dominios.stream().map(obtenerMetodoPagoEnsamblador()::ensamblarEntidadDesdeDominio).collect(Collectors.toList());
	}

	@Override
	public MetodoPagoDominio ensamblarDominioDesdeDTO(MetodoPagoDTO dto) 
	{
		if(UtilObjeto.esNulo(dto))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un Dominio de MetodoPago a partir de un DTO de un MetodoPago que esta nulo");
		}
		
		return MetodoPagoDominio.crear(dto.getCodigo(), dto.getNombre());
	}

	@Override
	public List<MetodoPagoDominio> ensamblarDominiosDesdeDTO(List<MetodoPagoDTO> dtos) 
	{
		return dtos.stream().map(obtenerMetodoPagoEnsamblador()::ensamblarDominioDesdeDTO).collect(Collectors.toList());
	}

	@Override
	public MetodoPagoDTO ensamblarDTODesdeDominio(MetodoPagoDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un DTO de MetodoPago a partir de un Dominio de un MetodoPago que esta nulo");
		}
		
		return MetodoPagoDTO.crear(dominio.getCodigo(), dominio.getNombre());
	}

	@Override
	public List<MetodoPagoDTO> ensamblarDTOsDesdeDominio(List<MetodoPagoDominio> dominios) 
	{
		return dominios.stream().map(obtenerMetodoPagoEnsamblador()::ensamblarDTODesdeDominio).collect(Collectors.toList());
	}
}