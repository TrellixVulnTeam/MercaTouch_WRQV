package co.edu.uco.mercatouch.negocio.ensamblador.implementacion;

import java.util.List;
import java.util.stream.Collectors;
import co.edu.uco.mercatouch.dto.PrecioDTO;
import co.edu.uco.mercatouch.entidad.PrecioEntidad;
import co.edu.uco.mercatouch.negocio.dominio.PrecioDominio;
import co.edu.uco.mercatouch.negocio.ensamblador.PrecioEnsamblador;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilObjeto;

public class PrecioEnsambladorImpl implements PrecioEnsamblador
{
	private static final PrecioEnsamblador INSTANCIA = new PrecioEnsambladorImpl();

	private PrecioEnsambladorImpl()
	{
		
	}
	
	public static PrecioEnsamblador obtenerPrecioEnsamblador()
	{
		return INSTANCIA;
	}
	
	@Override
	public PrecioDominio ensamblarDominioDesdeEntidad(PrecioEntidad entidad) 
	{
		if(UtilObjeto.esNulo(entidad))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un Dominio de Precio a partir de una entidad de un Precio que esta nulo");
		}
		
		return PrecioDominio.crear(entidad.getCodigo(), entidad.getValor(), entidad.getFecha());
	}

	@Override
	public List<PrecioDominio> ensamblarDominiosDesdeEntidad(List<PrecioEntidad> entidades) 
	{
		return entidades.stream().map(obtenerPrecioEnsamblador()::ensamblarDominioDesdeEntidad).collect(Collectors.toList());
	}

	@Override
	public PrecioEntidad ensamblarEntidadDesdeDominio(PrecioDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar una Entidad de Precio a partir de un dominio de un Precio que esta nulo");
		}
		
		return PrecioEntidad.crear(dominio.getCodigo(), dominio.getValor(), dominio.getFecha());
	}

	@Override
	public List<PrecioEntidad> ensamblarEntidadesDesdeDominio(List<PrecioDominio> dominios) 
	{
		return dominios.stream().map(obtenerPrecioEnsamblador()::ensamblarEntidadDesdeDominio).collect(Collectors.toList());
	}

	@Override
	public PrecioDominio ensamblarDominioDesdeDTO(PrecioDTO dto) 
	{
		if(UtilObjeto.esNulo(dto))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un Dominio de Precio a partir de un DTO de un Precio que esta nulo");
		}
		
		return PrecioDominio.crear(dto.getCodigo(), dto.getValor(), dto.getFecha());
	}

	@Override
	public List<PrecioDominio> ensamblarDominiosDesdeDTO(List<PrecioDTO> dtos) 
	{
		return dtos.stream().map(obtenerPrecioEnsamblador()::ensamblarDominioDesdeDTO).collect(Collectors.toList());
	}

	@Override
	public PrecioDTO ensamblarDTODesdeDominio(PrecioDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un DTO de Precio a partir de un Dominio de un Precio que esta nulo");
		}
		
		return PrecioDTO.crear(dominio.getCodigo(), dominio.getValor(), dominio.getFecha());
	}

	@Override
	public List<PrecioDTO> ensamblarDTOsDesdeDominio(List<PrecioDominio> dominios) 
	{
		return dominios.stream().map(obtenerPrecioEnsamblador()::ensamblarDTODesdeDominio).collect(Collectors.toList());
	}
}