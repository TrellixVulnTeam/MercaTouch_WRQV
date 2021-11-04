package co.edu.uco.mercatouch.negocio.ensamblador.implementacion;

import java.util.List;
import java.util.stream.Collectors;
import co.edu.uco.mercatouch.dto.DetallePedidoDTO;
import co.edu.uco.mercatouch.entidad.DetallePedidoEntidad;
import co.edu.uco.mercatouch.negocio.dominio.DetallePedidoDominio;
import co.edu.uco.mercatouch.negocio.ensamblador.DetallePedidoEnsamblador;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilObjeto;

public class DetallePedidoEnsambladorImpl implements DetallePedidoEnsamblador
{
	private static final DetallePedidoEnsamblador INSTANCIA = new DetallePedidoEnsambladorImpl();

	private DetallePedidoEnsambladorImpl()
	{
		
	}
	
	public static DetallePedidoEnsamblador obtenerDetallePedidoEnsamblador()
	{
		return INSTANCIA;
	}
	
	@Override
	public DetallePedidoDominio ensamblarDominioDesdeEntidad(DetallePedidoEntidad entidad) 
	{
		if(UtilObjeto.esNulo(entidad))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un Dominio de DetallePedido a partir de una entidad de un DetallePedido que esta nulo");
		}
		
		return DetallePedidoDominio.crear(entidad.getCodigo(), entidad.getCantidad(), ProductoEnsambladorImpl.obtenerProductoEnsamblador().ensamblarDominioDesdeEntidad(entidad.getProducto()), PedidoEnsambladorImpl.obtenerPedidoEnsamblador().ensamblarDominioDesdeEntidad(entidad.getPedido()));
	}

	@Override
	public List<DetallePedidoDominio> ensamblarDominiosDesdeEntidad(List<DetallePedidoEntidad> entidades) 
	{
		return entidades.stream().map(obtenerDetallePedidoEnsamblador()::ensamblarDominioDesdeEntidad).collect(Collectors.toList());
	}

	@Override
	public DetallePedidoEntidad ensamblarEntidadDesdeDominio(DetallePedidoDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar una Entidad de DetallePedido a partir de un dominio de un DetallePedido que esta nulo");
		}
		
		return DetallePedidoEntidad.crear(dominio.getCodigo(), dominio.getCantidad(), ProductoEnsambladorImpl.obtenerProductoEnsamblador().ensamblarEntidadDesdeDominio(dominio.getProducto()), PedidoEnsambladorImpl.obtenerPedidoEnsamblador().ensamblarEntidadDesdeDominio(dominio.getPedido()));
	}

	@Override
	public List<DetallePedidoEntidad> ensamblarEntidadesDesdeDominio(List<DetallePedidoDominio> dominios) 
	{
		return dominios.stream().map(obtenerDetallePedidoEnsamblador()::ensamblarEntidadDesdeDominio).collect(Collectors.toList());
	}

	@Override
	public DetallePedidoDominio ensamblarDominioDesdeDTO(DetallePedidoDTO dto) 
	{
		if(UtilObjeto.esNulo(dto))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un Dominio de DetallePedido a partir de un DTO de un DetallePedido que esta nulo");
		}
		
		return DetallePedidoDominio.crear(dto.getCodigo(), dto.getCantidad(), ProductoEnsambladorImpl.obtenerProductoEnsamblador().ensamblarDominioDesdeDTO(dto.getProducto()), PedidoEnsambladorImpl.obtenerPedidoEnsamblador().ensamblarDominioDesdeDTO(dto.getPedido()));
	}

	@Override
	public List<DetallePedidoDominio> ensamblarDominiosDesdeDTO(List<DetallePedidoDTO> dtos) 
	{
		return dtos.stream().map(obtenerDetallePedidoEnsamblador()::ensamblarDominioDesdeDTO).collect(Collectors.toList());
	}

	@Override
	public DetallePedidoDTO ensamblarDTODesdeDominio(DetallePedidoDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un DTO de DetallePedido a partir de un Dominio de un DetallePedido que esta nulo");
		}
		
		return DetallePedidoDTO.crear(dominio.getCodigo(), dominio.getCantidad(), ProductoEnsambladorImpl.obtenerProductoEnsamblador().ensamblarDTODesdeDominio(dominio.getProducto()), PedidoEnsambladorImpl.obtenerPedidoEnsamblador().ensamblarDTODesdeDominio(dominio.getPedido()));
	}

	@Override
	public List<DetallePedidoDTO> ensamblarDTOsDesdeDominio(List<DetallePedidoDominio> dominios) 
	{
		return dominios.stream().map(obtenerDetallePedidoEnsamblador()::ensamblarDTODesdeDominio).collect(Collectors.toList());
	}
}