package co.edu.uco.mercatouch.negocio.dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PedidoDominio 
{
	private int codigo;
	private double pagoTotal;
	private double descuento;
	private Date fecha;
	private boolean incluyeDomicilio;
	private MetodoPagoDominio metodoPago;
	private List<DetallePedidoDominio> detallesPedido;
	
	private PedidoDominio(int codigo, double pagoTotal, double descuento, Date fecha, boolean incluyeDomicilio, MetodoPagoDominio metodoPago, List<DetallePedidoDominio> detallesPedido) 
	{
		setCodigo(codigo);
		setPagoTotal(pagoTotal);
		setDescuento(descuento);
		setFecha(fecha);
		setIncluyeDomicilio(incluyeDomicilio);
		setMetodoPago(metodoPago);
		setDetallesPedido(detallesPedido);
	}
	
	public static PedidoDominio crear(int codigo, double pagoTotal, double descuento, Date fecha, boolean incluyeDomicilio, MetodoPagoDominio metodoPago, List<DetallePedidoDominio> detallesPedido)
	{
		return new PedidoDominio(codigo, pagoTotal, descuento, fecha, incluyeDomicilio, metodoPago, detallesPedido);
	}
	
	public static PedidoDominio crear()
	{
		return new PedidoDominio(0, 0, 0, new Date(), false, MetodoPagoDominio.crear(), new ArrayList<>());
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

	public Date getFecha() 
	{
		return fecha;
	}

	public PedidoDominio setFecha(Date fecha) 
	{
		this.fecha = fecha;
		return this;
	}

	public boolean isIncluyeDomicilio() 
	{
		return incluyeDomicilio;
	}

	public PedidoDominio setIncluyeDomicilio(boolean incluyeDomicilio) 
	{
		this.incluyeDomicilio = incluyeDomicilio;
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

	public List<DetallePedidoDominio> getDetallesPedido() 
	{
		return detallesPedido;
	}

	public PedidoDominio setDetallesPedido(List<DetallePedidoDominio> detallesPedido) 
	{
		this.detallesPedido = detallesPedido;
		return this;
	}
}