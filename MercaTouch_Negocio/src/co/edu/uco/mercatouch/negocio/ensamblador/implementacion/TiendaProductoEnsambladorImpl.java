package co.edu.uco.mercatouch.negocio.ensamblador.implementacion;

import java.util.List;
import java.util.stream.Collectors;
import co.edu.uco.mercatouch.dto.TiendaProductoDTO;
import co.edu.uco.mercatouch.entidad.TiendaProductoEntidad;
import co.edu.uco.mercatouch.negocio.dominio.TiendaProductoDominio;
import co.edu.uco.mercatouch.negocio.ensamblador.TiendaProductoEnsamblador;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilObjeto;

public class TiendaProductoEnsambladorImpl implements TiendaProductoEnsamblador
{
	private static final TiendaProductoEnsamblador INSTANCIA = new TiendaProductoEnsambladorImpl();

	private TiendaProductoEnsambladorImpl()
	{
		
	}
	
	public static TiendaProductoEnsamblador obtenerTiendaProductoEnsamblador()
	{
		return INSTANCIA;
	}
	
	@Override
	public TiendaProductoDominio ensamblarDominioDesdeEntidad(TiendaProductoEntidad entidad) 
	{
		if(UtilObjeto.esNulo(entidad))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un Dominio de TiendaProducto a partir de una entidad de una TiendaProducto que esta nulo");
		}
		
		return TiendaProductoDominio.crear(entidad.getCodigo(), TiendaEnsambladorImpl.obtenerTiendaEnsamblador().ensamblarDominioDesdeEntidad(entidad.getTienda()), ProductoEnsambladorImpl.obtenerProductoEnsamblador().ensamblarDominiosDesdeEntidad(entidad.getProductos()));
	}

	@Override
	public List<TiendaProductoDominio> ensamblarDominiosDesdeEntidad(List<TiendaProductoEntidad> entidades) 
	{
		return entidades.stream().map(obtenerTiendaProductoEnsamblador()::ensamblarDominioDesdeEntidad).collect(Collectors.toList());
	}

	@Override
	public TiendaProductoEntidad ensamblarEntidadDesdeDominio(TiendaProductoDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar una Entidad de TiendaProducto a partir de un dominio de una TiendaProducto que esta nulo");
		}
		
		return TiendaProductoEntidad.crear(dominio.getCodigo(), TiendaEnsambladorImpl.obtenerTiendaEnsamblador().ensamblarEntidadDesdeDominio(dominio.getTienda()), ProductoEnsambladorImpl.obtenerProductoEnsamblador().ensamblarEntidadesDesdeDominio(dominio.getProductos()));
	}

	@Override
	public List<TiendaProductoEntidad> ensamblarEntidadesDesdeDominio(List<TiendaProductoDominio> dominios) 
	{
		return dominios.stream().map(obtenerTiendaProductoEnsamblador()::ensamblarEntidadDesdeDominio).collect(Collectors.toList());
	}

	@Override
	public TiendaProductoDominio ensamblarDominioDesdeDTO(TiendaProductoDTO dto) 
	{
		if(UtilObjeto.esNulo(dto))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un Dominio de TiendaProducto a partir de un DTO de una TiendaProducto que esta nulo");
		}
		
		return TiendaProductoDominio.crear(dto.getCodigo(), TiendaEnsambladorImpl.obtenerTiendaEnsamblador().ensamblarDominioDesdeDTO(dto.getTienda()), ProductoEnsambladorImpl.obtenerProductoEnsamblador().ensamblarDominiosDesdeDTO(dto.getProductos()));
	}

	@Override
	public List<TiendaProductoDominio> ensamblarDominiosDesdeDTO(List<TiendaProductoDTO> dtos) 
	{
		return dtos.stream().map(obtenerTiendaProductoEnsamblador()::ensamblarDominioDesdeDTO).collect(Collectors.toList());
	}

	@Override
	public TiendaProductoDTO ensamblarDTODesdeDominio(TiendaProductoDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un DTO de TiendaProducto a partir de un Dominio de una TiendaProducto que esta nulo");
		}
		
		return TiendaProductoDTO.crear(dominio.getCodigo(), TiendaEnsambladorImpl.obtenerTiendaEnsamblador().ensamblarDTODesdeDominio(dominio.getTienda()), ProductoEnsambladorImpl.obtenerProductoEnsamblador().ensamblarDTOsDesdeDominio(dominio.getProductos()));
	}

	@Override
	public List<TiendaProductoDTO> ensamblarDTOsDesdeDominio(List<TiendaProductoDominio> dominios) 
	{
		return dominios.stream().map(obtenerTiendaProductoEnsamblador()::ensamblarDTODesdeDominio).collect(Collectors.toList());
	}
}
