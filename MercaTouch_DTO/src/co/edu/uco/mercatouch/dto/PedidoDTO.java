package co.edu.uco.mercatouch.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PedidoDTO 
{
	private int codigo;
	private double pagoTotal;
	private double descuento;
	private Date fecha;
	private boolean incluyeDomicilio;
	private MetodoPagoDTO metodoPago;
	private List<DetallePedidoDTO> detallesPedido;
	
	public PedidoDTO()
	{
		
	}
	
	private PedidoDTO(int codigo, double pagoTotal, double descuento, Date fecha, boolean incluyeDomicilio, MetodoPagoDTO metodoPago, List<DetallePedidoDTO> detallesPedido) 
	{
		setCodigo(codigo);
		setPagoTotal(pagoTotal);
		setDescuento(descuento);
		setFecha(fecha);
		setIncluyeDomicilio(incluyeDomicilio);
		setMetodoPago(metodoPago);
		setDetallesPedido(detallesPedido);
	}
	
	public static PedidoDTO crear(int codigo, double pagoTotal, double descuento, Date fecha, boolean incluyeDomicilio, MetodoPagoDTO metodoPago, List<DetallePedidoDTO> detallesPedido)
	{
		return new PedidoDTO(codigo, pagoTotal, descuento, fecha, incluyeDomicilio, metodoPago, detallesPedido);
	}
	
	public static PedidoDTO crear()
	{
		return new PedidoDTO(0, 0, 0, new Date(), false, MetodoPagoDTO.crear(), new ArrayList<>());
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

	public Date getFecha() 
	{
		return fecha;
	}

	public PedidoDTO setFecha(Date fecha) 
	{
		this.fecha = fecha;
		return this;
	}

	public boolean isIncluyeDomicilio() 
	{
		return incluyeDomicilio;
	}

	public PedidoDTO setIncluyeDomicilio(boolean incluyeDomicilio) 
	{
		this.incluyeDomicilio = incluyeDomicilio;
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

	public List<DetallePedidoDTO> getDetallesPedido() 
	{
		return detallesPedido;
	}

	public PedidoDTO setDetallesPedido(List<DetallePedidoDTO> detallesPedido) 
	{
		this.detallesPedido = detallesPedido;
		return this;
	}
}