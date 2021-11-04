package co.edu.uco.mercatouch.negocio.dominio;

import java.util.Date;

public class PrecioDominio 
{
	private int codigo;
	private double valor;
	private Date fecha;
	
	private PrecioDominio(int codigo, double valor, Date fecha) 
	{
		setCodigo(codigo);
		setValor(valor);
		setFecha(fecha);
	}
	
	public static PrecioDominio crear(int codigo, double valor, Date fecha)
	{
		return new PrecioDominio(codigo, valor, fecha);
	}
	
	public static PrecioDominio crear()
	{
		return new PrecioDominio(0, 0, new Date());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public PrecioDominio setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public double getValor() 
	{
		return valor;
	}

	public PrecioDominio setValor(double valor) 
	{
		this.valor = valor;
		return this;
	}

	public Date getFecha() 
	{
		return fecha;
	}

	public PrecioDominio setFecha(Date fecha) 
	{
		this.fecha = fecha;
		return this;
	}
}