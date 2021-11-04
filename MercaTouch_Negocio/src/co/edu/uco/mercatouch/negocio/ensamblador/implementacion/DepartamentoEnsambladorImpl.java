package co.edu.uco.mercatouch.negocio.ensamblador.implementacion;

import java.util.List;
import java.util.stream.Collectors;
import co.edu.uco.mercatouch.dto.DepartamentoDTO;
import co.edu.uco.mercatouch.entidad.DepartamentoEntidad;
import co.edu.uco.mercatouch.negocio.dominio.DepartamentoDominio;
import co.edu.uco.mercatouch.negocio.ensamblador.DepartamentoEnsamblador;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilObjeto;

public class DepartamentoEnsambladorImpl implements DepartamentoEnsamblador
{
	private static final DepartamentoEnsamblador INSTANCIA = new DepartamentoEnsambladorImpl();

	private DepartamentoEnsambladorImpl()
	{
		
	}
	
	public static DepartamentoEnsamblador obtenerDepartamentoEnsamblador()
	{
		return INSTANCIA;
	}
	
	@Override
	public DepartamentoDominio ensamblarDominioDesdeEntidad(DepartamentoEntidad entidad) 
	{
		if(UtilObjeto.esNulo(entidad))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un Dominio de Departamento a partir de una entidad de un Departamento que esta nulo");
		}
		
		return DepartamentoDominio.crear(entidad.getCodigo(), entidad.getNombre());
	}

	@Override
	public List<DepartamentoDominio> ensamblarDominiosDesdeEntidad(List<DepartamentoEntidad> entidades) 
	{
		return entidades.stream().map(obtenerDepartamentoEnsamblador()::ensamblarDominioDesdeEntidad).collect(Collectors.toList());
	}

	@Override
	public DepartamentoEntidad ensamblarEntidadDesdeDominio(DepartamentoDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar una Entidad de Departamento a partir de un dominio de un Departamento que esta nulo");
		}
		
		return DepartamentoEntidad.crear(dominio.getCodigo(), dominio.getNombre());
	}

	@Override
	public List<DepartamentoEntidad> ensamblarEntidadesDesdeDominio(List<DepartamentoDominio> dominios) 
	{
		return dominios.stream().map(obtenerDepartamentoEnsamblador()::ensamblarEntidadDesdeDominio).collect(Collectors.toList());
	}

	@Override
	public DepartamentoDominio ensamblarDominioDesdeDTO(DepartamentoDTO dto) 
	{
		if(UtilObjeto.esNulo(dto))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un Dominio de Departamento a partir de un DTO de un Departamento que esta nulo");
		}
		
		return DepartamentoDominio.crear(dto.getCodigo(), dto.getNombre());
	}

	@Override
	public List<DepartamentoDominio> ensamblarDominiosDesdeDTO(List<DepartamentoDTO> dtos) 
	{
		return dtos.stream().map(obtenerDepartamentoEnsamblador()::ensamblarDominioDesdeDTO).collect(Collectors.toList());
	}

	@Override
	public DepartamentoDTO ensamblarDTODesdeDominio(DepartamentoDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un DTO de Departamento a partir de un Dominio de un Departamento que esta nulo");
		}
		
		return DepartamentoDTO.crear(dominio.getCodigo(), dominio.getNombre());
	}

	@Override
	public List<DepartamentoDTO> ensamblarDTOsDesdeDominio(List<DepartamentoDominio> dominios) 
	{
		return dominios.stream().map(obtenerDepartamentoEnsamblador()::ensamblarDTODesdeDominio).collect(Collectors.toList());
	}
}