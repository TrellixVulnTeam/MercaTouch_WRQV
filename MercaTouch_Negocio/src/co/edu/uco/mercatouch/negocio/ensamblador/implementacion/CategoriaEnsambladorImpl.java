package co.edu.uco.mercatouch.negocio.ensamblador.implementacion;

import java.util.List;
import java.util.stream.Collectors;
import co.edu.uco.mercatouch.dto.CategoriaDTO;
import co.edu.uco.mercatouch.entidad.CategoriaEntidad;
import co.edu.uco.mercatouch.negocio.dominio.CategoriaDominio;
import co.edu.uco.mercatouch.negocio.ensamblador.CategoriaEnsamblador;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilObjeto;

public class CategoriaEnsambladorImpl implements CategoriaEnsamblador
{
	private static final CategoriaEnsamblador INSTANCIA = new CategoriaEnsambladorImpl();

	private CategoriaEnsambladorImpl()
	{
		
	}
	
	public static CategoriaEnsamblador obtenerCategoriaEnsamblador()
	{
		return INSTANCIA;
	}

	@Override
	public CategoriaDominio ensamblarDominioDesdeEntidad(CategoriaEntidad entidad) 
	{
		if(UtilObjeto.esNulo(entidad))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un Dominio de Categoria a partir de una entidad de una Categoria que esta nulo");
		}
		
		return CategoriaDominio.crear(entidad.getCodigo(), entidad.getNombre(), entidad.getDescripcion());
	}

	@Override
	public List<CategoriaDominio> ensamblarDominiosDesdeEntidad(List<CategoriaEntidad> entidades) 
	{
		return entidades.stream().map(obtenerCategoriaEnsamblador()::ensamblarDominioDesdeEntidad).collect(Collectors.toList());
	}

	@Override
	public CategoriaEntidad ensamblarEntidadDesdeDominio(CategoriaDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar una Entidad de Categoria a partir de un dominio de una Categoria que esta nulo");
		}
		
		return CategoriaEntidad.crear(dominio.getCodigo(), dominio.getNombre(), dominio.getDescripcion());
	}

	@Override
	public List<CategoriaEntidad> ensamblarEntidadesDesdeDominio(List<CategoriaDominio> dominios) 
	{
		return dominios.stream().map(obtenerCategoriaEnsamblador()::ensamblarEntidadDesdeDominio).collect(Collectors.toList());
	}

	@Override
	public CategoriaDominio ensamblarDominioDesdeDTO(CategoriaDTO dto) 
	{
		if(UtilObjeto.esNulo(dto))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un Dominio de Categoria a partir de un DTO de una Categoria que esta nulo");
		}
		
		return CategoriaDominio.crear(dto.getCodigo(), dto.getNombre(), dto.getDescripcion());
	}

	@Override
	public List<CategoriaDominio> ensamblarDominiosDesdeDTO(List<CategoriaDTO> dtos) 
	{
		return dtos.stream().map(obtenerCategoriaEnsamblador()::ensamblarDominioDesdeDTO).collect(Collectors.toList());
	}

	@Override
	public CategoriaDTO ensamblarDTODesdeDominio(CategoriaDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un DTO de Categoria a partir de un Dominio de una Categoria que esta nulo");
		}
		
		return CategoriaDTO.crear(dominio.getCodigo(), dominio.getNombre(), dominio.getDescripcion());
	}

	@Override
	public List<CategoriaDTO> ensamblarDTOsDesdeDominio(List<CategoriaDominio> dominios) 
	{
		return dominios.stream().map(obtenerCategoriaEnsamblador()::ensamblarDTODesdeDominio).collect(Collectors.toList());
	}
}