package co.edu.uco.mercatouch.dto;

import java.util.Date;

public class PrecioDTO 
{
	private int codigo;
	private double valor;
	private Date fecha;
	
	public PrecioDTO()
	{
		
	}
	
	private PrecioDTO(int codigo, double valor, Date fecha) 
	{
		setCodigo(codigo);
		setValor(valor);
		setFecha(fecha);
	}
	
	public static PrecioDTO crear(int codigo, double valor, Date fecha)
	{
		return new PrecioDTO(codigo, valor, fecha);
	}
	
	public static PrecioDTO crear()
	{
		return new PrecioDTO(0, 0, new Date());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public PrecioDTO setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public double getValor() 
	{
		return valor;
	}

	public PrecioDTO setValor(double valor) 
	{
		this.valor = valor;
		return this;
	}

	public Date getFecha() 
	{
		return fecha;
	}

	public PrecioDTO setFecha(Date fecha) 
	{
		this.fecha = fecha;
		return this;
	}
}