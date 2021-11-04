package co.edu.uco.mercatouch.entidad;

import java.util.Date;

public class PrecioEntidad 
{
	private int codigo;
	private double valor;
	private Date fecha;
	
	private PrecioEntidad(int codigo, double valor, Date fecha) 
	{
		setCodigo(codigo);
		setValor(valor);
		setFecha(fecha);
	}
	
	public static PrecioEntidad crear(int codigo, double valor, Date fecha)
	{
		return new PrecioEntidad(codigo, valor, fecha);
	}
	
	public static PrecioEntidad crear()
	{
		return new PrecioEntidad(0, 0, new Date());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public PrecioEntidad setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public double getValor() 
	{
		return valor;
	}

	public PrecioEntidad setValor(double valor) 
	{
		this.valor = valor;
		return this;
	}

	public Date getFecha() 
	{
		return fecha;
	}

	public PrecioEntidad setFecha(Date fecha) 
	{
		this.fecha = fecha;
		return this;
	}
}