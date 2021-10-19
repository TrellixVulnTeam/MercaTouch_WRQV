package co.edu.uco.mercatouch.negocio.ensamblador.implementacion;

import java.util.List;
import java.util.stream.Collectors;
import co.edu.uco.mercatouch.dto.PedidoDTO;
import co.edu.uco.mercatouch.entidad.PedidoEntidad;
import co.edu.uco.mercatouch.negocio.dominio.PedidoDominio;
import co.edu.uco.mercatouch.negocio.ensamblador.PedidoEnsamblador;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilObjeto;

public class PedidoEnsambladorImpl implements PedidoEnsamblador
{
	private static final PedidoEnsamblador INSTANCIA = new PedidoEnsambladorImpl();

	private PedidoEnsambladorImpl()
	{
		
	}
	
	public static PedidoEnsamblador obtenerPedidoEnsamblador()
	{
		return INSTANCIA;
	}

	@Override
	public PedidoDominio ensamblarDominioDesdeEntidad(PedidoEntidad entidad) 
	{
		if(UtilObjeto.esNulo(entidad))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un Dominio de Pedido a partir de una entidad de un Pedido que esta nulo");
		}
		
		return PedidoDominio.crear(entidad.getCodigo(), entidad.getPagoTotal(), entidad.getDescuento(), TiendaEnsambladorImpl.obtenerTiendaEnsamblador().ensamblarDominioDesdeEntidad(entidad.getTienda()), MetodoPagoEnsambladorImpl.obtenerMetodoPagoEnsamblador().ensamblarDominioDesdeEntidad(entidad.getMetodoPago()), ProductoEnsambladorImpl.obtenerProductoEnsamblador().ensamblarDominiosDesdeEntidad(entidad.getProductosPedidos()));
	}

	@Override
	public List<PedidoDominio> ensamblarDominiosDesdeEntidad(List<PedidoEntidad> entidades) 
	{
		return entidades.stream().map(obtenerPedidoEnsamblador()::ensamblarDominioDesdeEntidad).collect(Collectors.toList());
	}

	@Override
	public PedidoEntidad ensamblarEntidadDesdeDominio(PedidoDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar una Entidad de Pedido a partir de un dominio de un Pedido que esta nulo");
		}
		
		return PedidoEntidad.crear(dominio.getCodigo(), dominio.getPagoTotal(), dominio.getDescuento(), TiendaEnsambladorImpl.obtenerTiendaEnsamblador().ensamblarEntidadDesdeDominio(dominio.getTienda()), MetodoPagoEnsambladorImpl.obtenerMetodoPagoEnsamblador().ensamblarEntidadDesdeDominio(dominio.getMetodoPago()), ProductoEnsambladorImpl.obtenerProductoEnsamblador().ensamblarEntidadesDesdeDominio(dominio.getProductosPedidos()));
	}

	@Override
	public List<PedidoEntidad> ensamblarEntidadesDesdeDominio(List<PedidoDominio> dominios) 
	{
		return dominios.stream().map(obtenerPedidoEnsamblador()::ensamblarEntidadDesdeDominio).collect(Collectors.toList());
	}

	@Override
	public PedidoDominio ensamblarDominioDesdeDTO(PedidoDTO dto) 
	{
		if(UtilObjeto.esNulo(dto))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un Dominio de Pedido a partir de un DTO de un Pedido que esta nulo");
		}
		
		return PedidoDominio.crear(dto.getCodigo(), dto.getPagoTotal(), dto.getDescuento(), TiendaEnsambladorImpl.obtenerTiendaEnsamblador().ensamblarDominioDesdeDTO(dto.getTienda()), MetodoPagoEnsambladorImpl.obtenerMetodoPagoEnsamblador().ensamblarDominioDesdeDTO(dto.getMetodoPago()), ProductoEnsambladorImpl.obtenerProductoEnsamblador().ensamblarDominiosDesdeDTO(dto.getProductosPedidos()));
	}

	@Override
	public List<PedidoDominio> ensamblarDominiosDesdeDTO(List<PedidoDTO> dtos) 
	{
		return dtos.stream().map(obtenerPedidoEnsamblador()::ensamblarDominioDesdeDTO).collect(Collectors.toList());
	}

	@Override
	public PedidoDTO ensamblarDTODesdeDominio(PedidoDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un DTO de Pedido a partir de un Dominio de un Pedido que esta nulo");
		}
		
		return PedidoDTO.crear(dominio.getCodigo(), dominio.getPagoTotal(), dominio.getDescuento(), TiendaEnsambladorImpl.obtenerTiendaEnsamblador().ensamblarDTODesdeDominio(dominio.getTienda()), MetodoPagoEnsambladorImpl.obtenerMetodoPagoEnsamblador().ensamblarDTODesdeDominio(dominio.getMetodoPago()), ProductoEnsambladorImpl.obtenerProductoEnsamblador().ensamblarDTOsDesdeDominio(dominio.getProductosPedidos()));
	}

	@Override
	public List<PedidoDTO> ensamblarDTOsDesdeDominio(List<PedidoDominio> dominios) 
	{
		return dominios.stream().map(obtenerPedidoEnsamblador()::ensamblarDTODesdeDominio).collect(Collectors.toList());
	}
}