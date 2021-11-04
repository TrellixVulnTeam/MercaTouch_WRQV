package co.edu.uco.mercatouch.negocio.ensamblador.implementacion;

import java.util.List;
import java.util.stream.Collectors;
import co.edu.uco.mercatouch.dto.CiudadDTO;
import co.edu.uco.mercatouch.entidad.CiudadEntidad;
import co.edu.uco.mercatouch.negocio.dominio.CiudadDominio;
import co.edu.uco.mercatouch.negocio.ensamblador.CiudadEnsamblador;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilObjeto;

public class CiudadEnsambladorImpl implements CiudadEnsamblador
{
	private static final CiudadEnsamblador INSTANCIA = new CiudadEnsambladorImpl();

	private CiudadEnsambladorImpl()
	{
		
	}
	
	public static CiudadEnsamblador obtenerCiudadEnsamblador()
	{
		return INSTANCIA;
	}
	
	@Override
	public CiudadDominio ensamblarDominioDesdeEntidad(CiudadEntidad entidad) 
	{
		if(UtilObjeto.esNulo(entidad))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un Dominio de Ciudad a partir de una entidad de una Ciudad que esta nulo");
		}
		
		return CiudadDominio.crear(entidad.getCodigo(), entidad.getNombre(), DepartamentoEnsambladorImpl.obtenerDepartamentoEnsamblador().ensamblarDominioDesdeEntidad(entidad.getDepartamento()));
	}

	@Override
	public List<CiudadDominio> ensamblarDominiosDesdeEntidad(List<CiudadEntidad> entidades) 
	{
		return entidades.stream().map(obtenerCiudadEnsamblador()::ensamblarDominioDesdeEntidad).collect(Collectors.toList());
	}

	@Override
	public CiudadEntidad ensamblarEntidadDesdeDominio(CiudadDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar una Entidad de Ciudad a partir de un dominio de una Ciudad que esta nulo");
		}
		
		return CiudadEntidad.crear(dominio.getCodigo(), dominio.getNombre(), DepartamentoEnsambladorImpl.obtenerDepartamentoEnsamblador().ensamblarEntidadDesdeDominio(dominio.getDepartamento()));
	}

	@Override
	public List<CiudadEntidad> ensamblarEntidadesDesdeDominio(List<CiudadDominio> dominios) 
	{
		return dominios.stream().map(obtenerCiudadEnsamblador()::ensamblarEntidadDesdeDominio).collect(Collectors.toList());
	}

	@Override
	public CiudadDominio ensamblarDominioDesdeDTO(CiudadDTO dto) 
	{
		if(UtilObjeto.esNulo(dto))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un Dominio de Ciudad a partir de un DTO de una Ciudad que esta nulo");
		}
		
		return CiudadDominio.crear(dto.getCodigo(), dto.getNombre(), DepartamentoEnsambladorImpl.obtenerDepartamentoEnsamblador().ensamblarDominioDesdeDTO(dto.getDepartamento()));
	}

	@Override
	public List<CiudadDominio> ensamblarDominiosDesdeDTO(List<CiudadDTO> dtos) 
	{
		return dtos.stream().map(obtenerCiudadEnsamblador()::ensamblarDominioDesdeDTO).collect(Collectors.toList());
	}

	@Override
	public CiudadDTO ensamblarDTODesdeDominio(CiudadDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un DTO de Ciudad a partir de un Dominio de una Ciudad que esta nulo");
		}
		
		return CiudadDTO.crear(dominio.getCodigo(), dominio.getNombre(), DepartamentoEnsambladorImpl.obtenerDepartamentoEnsamblador().ensamblarDTODesdeDominio(dominio.getDepartamento()));
	}

	@Override
	public List<CiudadDTO> ensamblarDTOsDesdeDominio(List<CiudadDominio> dominios) 
	{
		return dominios.stream().map(obtenerCiudadEnsamblador()::ensamblarDTODesdeDominio).collect(Collectors.toList());
	}
}