package co.edu.uco.mercatouch.negocio.ensamblador.implementacion;

import java.util.List;
import java.util.stream.Collectors;
import co.edu.uco.mercatouch.dto.ProductoDTO;
import co.edu.uco.mercatouch.entidad.ProductoEntidad;
import co.edu.uco.mercatouch.negocio.dominio.ProductoDominio;
import co.edu.uco.mercatouch.negocio.ensamblador.ProductoEnsamblador;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilObjeto;

public class ProductoEnsambladorImpl implements ProductoEnsamblador
{
	private static final ProductoEnsamblador INSTANCIA = new ProductoEnsambladorImpl();

	private ProductoEnsambladorImpl()
	{
		
	}
	
	public static ProductoEnsamblador obtenerProductoEnsamblador()
	{
		return INSTANCIA;
	}

	@Override
	public ProductoDominio ensamblarDominioDesdeEntidad(ProductoEntidad entidad) 
	{
		if(UtilObjeto.esNulo(entidad))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un Dominio de Producto a partir de una entidad de un Producto que esta nulo");
		}
		
		return ProductoDominio.crear(entidad.getCodigo(), entidad.getNombre(), entidad.getDescripcion(), entidad.getPrecio(), CategoriaEnsambladorImpl.obtenerCategoriaEnsamblador().ensamblarDominioDesdeEntidad(entidad.getCategoria()));
	}

	@Override
	public List<ProductoDominio> ensamblarDominiosDesdeEntidad(List<ProductoEntidad> entidades) 
	{
		return entidades.stream().map(obtenerProductoEnsamblador()::ensamblarDominioDesdeEntidad).collect(Collectors.toList());
	}

	@Override
	public ProductoEntidad ensamblarEntidadDesdeDominio(ProductoDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar una Entidad de Producto a partir de un dominio de un Producto que esta nulo");
		}
		
		return ProductoEntidad.crear(dominio.getCodigo(), dominio.getNombre(), dominio.getDescripcion(), dominio.getPrecio(), CategoriaEnsambladorImpl.obtenerCategoriaEnsamblador().ensamblarEntidadDesdeDominio(dominio.getCategoria()));
	}

	@Override
	public List<ProductoEntidad> ensamblarEntidadesDesdeDominio(List<ProductoDominio> dominios) 
	{
		return dominios.stream().map(obtenerProductoEnsamblador()::ensamblarEntidadDesdeDominio).collect(Collectors.toList());
	}

	@Override
	public ProductoDominio ensamblarDominioDesdeDTO(ProductoDTO dto) 
	{
		if(UtilObjeto.esNulo(dto))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un Dominio de Producto a partir de un DTO de un Producto que esta nulo");
		}
		
		return ProductoDominio.crear(dto.getCodigo(), dto.getNombre(), dto.getDescripcion(), dto.getPrecio(), CategoriaEnsambladorImpl.obtenerCategoriaEnsamblador().ensamblarDominioDesdeDTO(dto.getCategoria()));
	}

	@Override
	public List<ProductoDominio> ensamblarDominiosDesdeDTO(List<ProductoDTO> dtos) 
	{
		return dtos.stream().map(obtenerProductoEnsamblador()::ensamblarDominioDesdeDTO).collect(Collectors.toList());
	}

	@Override
	public ProductoDTO ensamblarDTODesdeDominio(ProductoDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un DTO de Producto a partir de un Dominio de un Producto que esta nulo");
		}
		
		return ProductoDTO.crear(dominio.getCodigo(), dominio.getNombre(), dominio.getDescripcion(), dominio.getPrecio(), CategoriaEnsambladorImpl.obtenerCategoriaEnsamblador().ensamblarDTODesdeDominio(dominio.getCategoria()));
	}

	@Override
	public List<ProductoDTO> ensamblarDTOsDesdeDominio(List<ProductoDominio> dominios) 
	{
		return dominios.stream().map(obtenerProductoEnsamblador()::ensamblarDTODesdeDominio).collect(Collectors.toList());
	}
}