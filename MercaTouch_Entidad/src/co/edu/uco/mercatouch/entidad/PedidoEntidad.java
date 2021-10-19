package co.edu.uco.mercatouch.entidad;

import java.util.ArrayList;
import java.util.List;

public class PedidoEntidad 
{
	int codigo;
	double pagoTotal;
	double descuento;
	TiendaEntidad tienda;
	MetodoPagoEntidad metodoPago;
	List<ProductoEntidad> productosPedidos;
	
	private PedidoEntidad(int codigo, double pagoTotal, double descuento, TiendaEntidad tienda, MetodoPagoEntidad metodoPago, List<ProductoEntidad> productosPedidos) 
	{
		setCodigo(codigo);
		setPagoTotal(pagoTotal);
		setDescuento(descuento);
		setTienda(tienda);
		setMetodoPago(metodoPago);
		setProductosPedidos(productosPedidos);
	}
	
	public static PedidoEntidad crear(int codigo, double pagoTotal, double descuento, TiendaEntidad tienda, MetodoPagoEntidad metodoPago, List<ProductoEntidad> productosPedidos)
	{
		return new PedidoEntidad(codigo, pagoTotal, descuento, tienda, metodoPago, productosPedidos);
	}
	
	public static PedidoEntidad crear()
	{
		return new PedidoEntidad(0, 0, 0, null, MetodoPagoEntidad.crear(), new ArrayList<>());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public PedidoEntidad setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public double getPagoTotal() 
	{
		return pagoTotal;
	}

	public PedidoEntidad setPagoTotal(double pagoTotal) 
	{
		this.pagoTotal = pagoTotal;
		return this;
	}

	public double getDescuento() 
	{
		return descuento;
	}

	public PedidoEntidad setDescuento(double descuento) 
	{
		this.descuento = descuento;
		return this;
	}

	public TiendaEntidad getTienda() 
	{
		return tienda;
	}

	public PedidoEntidad setTienda(TiendaEntidad tienda) 
	{
		this.tienda = tienda;
		return this;
	}

	public MetodoPagoEntidad getMetodoPago() 
	{
		return metodoPago;
	}

	public PedidoEntidad setMetodoPago(MetodoPagoEntidad metodoPago) 
	{
		this.metodoPago = metodoPago;
		return this;
	}

	public List<ProductoEntidad> getProductosPedidos() 
	{
		return productosPedidos;
	}

	public PedidoEntidad setProductosPedidos(List<ProductoEntidad> productosPedidos) 
	{
		this.productosPedidos = productosPedidos;
		return this;
	}
}