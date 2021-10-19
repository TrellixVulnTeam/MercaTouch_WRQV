package co.edu.uco.mercatouch.dto;

import java.util.ArrayList;
import java.util.List;

public class PedidoDTO 
{
	int codigo;
	double pagoTotal;
	double descuento;
	TiendaDTO tienda;
	MetodoPagoDTO metodoPago;
	List<ProductoDTO> productosPedidos;
	
	private PedidoDTO(int codigo, double pagoTotal, double descuento, TiendaDTO tienda, MetodoPagoDTO metodoPago, List<ProductoDTO> productosPedidos) 
	{
		setCodigo(codigo);
		setPagoTotal(pagoTotal);
		setDescuento(descuento);
		setTienda(tienda);
		setMetodoPago(metodoPago);
		setProductosPedidos(productosPedidos);
	}
	
	public static PedidoDTO crear(int codigo, double pagoTotal, double descuento, TiendaDTO tienda, MetodoPagoDTO metodoPago, List<ProductoDTO> productosPedidos)
	{
		return new PedidoDTO(codigo, pagoTotal, descuento, tienda, metodoPago, productosPedidos);
	}
	
	public static PedidoDTO crear()
	{
		return new PedidoDTO(0, 0, 0, null, MetodoPagoDTO.crear(), new ArrayList<>());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public PedidoDTO setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public double getPagoTotal() 
	{
		return pagoTotal;
	}

	public PedidoDTO setPagoTotal(double pagoTotal) 
	{
		this.pagoTotal = pagoTotal;
		return this;
	}

	public double getDescuento() 
	{
		return descuento;
	}

	public PedidoDTO setDescuento(double descuento) 
	{
		this.descuento = descuento;
		return this;
	}

	public TiendaDTO getTienda() 
	{
		return tienda;
	}

	public PedidoDTO setTienda(TiendaDTO tienda) 
	{
		this.tienda = tienda;
		return this;
	}

	public MetodoPagoDTO getMetodoPago() 
	{
		return metodoPago;
	}

	public PedidoDTO setMetodoPago(MetodoPagoDTO metodoPago) 
	{
		this.metodoPago = metodoPago;
		return this;
	}

	public List<ProductoDTO> getProductosPedidos() 
	{
		return productosPedidos;
	}

	public PedidoDTO setProductosPedidos(List<ProductoDTO> productosPedidos) 
	{
		this.productosPedidos = productosPedidos;
		return this;
	}
}