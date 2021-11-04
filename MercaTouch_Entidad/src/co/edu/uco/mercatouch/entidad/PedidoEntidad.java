package co.edu.uco.mercatouch.entidad;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PedidoEntidad 
{
	private int codigo;
	private double pagoTotal;
	private double descuento;
	private Date fecha;
	private boolean incluyeDomicilio;
	private MetodoPagoEntidad metodoPago;
	private List<DetallePedidoEntidad> detallesPedido;
	
	private PedidoEntidad(int codigo, double pagoTotal, double descuento, Date fecha, boolean incluyeDomicilio, MetodoPagoEntidad metodoPago, List<DetallePedidoEntidad> detallesPedido) 
	{
		setCodigo(codigo);
		setPagoTotal(pagoTotal);
		setDescuento(descuento);
		setFecha(fecha);
		setIncluyeDomicilio(incluyeDomicilio);
		setMetodoPago(metodoPago);
		setDetallesPedido(detallesPedido);
	}
	
	public static PedidoEntidad crear(int codigo, double pagoTotal, double descuento, Date fecha, boolean incluyeDomicilio, MetodoPagoEntidad metodoPago, List<DetallePedidoEntidad> detallesPedido)
	{
		return new PedidoEntidad(codigo, pagoTotal, descuento, fecha, incluyeDomicilio, metodoPago, detallesPedido);
	}
	
	public static PedidoEntidad crear()
	{
		return new PedidoEntidad(0, 0, 0, new Date(), false, MetodoPagoEntidad.crear(), new ArrayList<>());
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

	public Date getFecha() 
	{
		return fecha;
	}

	public PedidoEntidad setFecha(Date fecha) 
	{
		this.fecha = fecha;
		return this;
	}

	public boolean isIncluyeDomicilio() 
	{
		return incluyeDomicilio;
	}

	public PedidoEntidad setIncluyeDomicilio(boolean incluyeDomicilio) 
	{
		this.incluyeDomicilio = incluyeDomicilio;
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

	public List<DetallePedidoEntidad> getDetallesPedido() 
	{
		return detallesPedido;
	}

	public PedidoEntidad setDetallesPedido(List<DetallePedidoEntidad> detallesPedido) 
	{
		this.detallesPedido = detallesPedido;
		return this;
	}
}