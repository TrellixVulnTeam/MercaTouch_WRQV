package co.edu.uco.mercatouch.negocio.dominio;

import java.util.ArrayList;
import java.util.List;

public class PedidoDominio 
{
	int codigo;
	double pagoTotal;
	double descuento;
	TiendaDominio tienda;
	MetodoPagoDominio metodoPago;
	List<ProductoDominio> productosPedidos;
	
	private PedidoDominio(int codigo, double pagoTotal, double descuento, TiendaDominio tienda, MetodoPagoDominio metodoPago, List<ProductoDominio> productosPedidos) 
	{
		setCodigo(codigo);
		setPagoTotal(pagoTotal);
		setDescuento(descuento);
		setTienda(tienda);
		setMetodoPago(metodoPago);
		setProductosPedidos(productosPedidos);
	}
	
	public static PedidoDominio crear(int codigo, double pagoTotal, double descuento, TiendaDominio tienda, MetodoPagoDominio metodoPago, List<ProductoDominio> productosPedidos)
	{
		return new PedidoDominio(codigo, pagoTotal, descuento, tienda, metodoPago, productosPedidos);
	}
	
	public static PedidoDominio crear()
	{
		return new PedidoDominio(0, 0, 0, null, MetodoPagoDominio.crear(), new ArrayList<>());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public PedidoDominio setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public double getPagoTotal() 
	{
		return pagoTotal;
	}

	public PedidoDominio setPagoTotal(double pagoTotal) 
	{
		this.pagoTotal = pagoTotal;
		return this;
	}

	public double getDescuento() 
	{
		return descuento;
	}

	public PedidoDominio setDescuento(double descuento) 
	{
		this.descuento = descuento;
		return this;
	}

	public TiendaDominio getTienda() 
	{
		return tienda;
	}

	public PedidoDominio setTienda(TiendaDominio tienda) 
	{
		this.tienda = tienda;
		return this;
	}

	public MetodoPagoDominio getMetodoPago() 
	{
		return metodoPago;
	}

	public PedidoDominio setMetodoPago(MetodoPagoDominio metodoPago) 
	{
		this.metodoPago = metodoPago;
		return this;
	}

	public List<ProductoDominio> getProductosPedidos() 
	{
		return productosPedidos;
	}

	public PedidoDominio setProductosPedidos(List<ProductoDominio> productosPedidos) 
	{
		this.productosPedidos = productosPedidos;
		return this;
	}
}