package co.edu.uco.mercatouch.negocio.dominio;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class PlanSuscripcionDominio 
{
	int codigo;
	String nombre;
	String descripcion;
	double precio;
	int tiempoSuscripcion;
	
	private PlanSuscripcionDominio(int codigo, String nombre, String descripcion, double precio, int tiempoSuscripcion) 
	{
		setCodigo(codigo);
		setNombre(nombre);
		setDescripcion(descripcion);
		setPrecio(precio);
		setTiempoSuscripcion(tiempoSuscripcion);
	}
	
	public static PlanSuscripcionDominio crear(int codigo, String nombre, String descripcion, double precio, int tiempoSuscripcion)
	{
		return new PlanSuscripcionDominio(codigo, nombre, descripcion, precio, tiempoSuscripcion);
	}
	
	public static PlanSuscripcionDominio crear()
	{
		return new PlanSuscripcionDominio(0, UtilTexto.BLANCO, UtilTexto.BLANCO, 0, 0);
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public PlanSuscripcionDominio setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public PlanSuscripcionDominio setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}

	public String getDescripcion() 
	{
		return descripcion;
	}

	public PlanSuscripcionDominio setDescripcion(String descripcion) 
	{
		this.descripcion =  UtilTexto.aplicarTrim(descripcion);
		return this;
	}

	public double getPrecio() 
	{
		return precio;
	}

	public PlanSuscripcionDominio setPrecio(double precio) 
	{
		this.precio = precio;
		return this;
	}

	public int getTiempoSuscripcion() 
	{
		return tiempoSuscripcion;
	}

	public PlanSuscripcionDominio setTiempoSuscripcion(int tiempoSuscripcion) 
	{
		this.tiempoSuscripcion = tiempoSuscripcion;
		return this;
	}
}
