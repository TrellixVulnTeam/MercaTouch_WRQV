package co.edu.uco.mercatouch.dto;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class PlanSuscripcionDTO 
{
	int codigo;
	String nombre;
	String descripcion;
	double precio;
	int tiempoSuscripcion;
	
	private PlanSuscripcionDTO(int codigo, String nombre, String descripcion, double precio, int tiempoSuscripcion) 
	{
		setCodigo(codigo);
		setNombre(nombre);
		setDescripcion(descripcion);
		setPrecio(precio);
		setTiempoSuscripcion(tiempoSuscripcion);
	}
	
	public static PlanSuscripcionDTO crear(int codigo, String nombre, String descripcion, double precio, int tiempoSuscripcion)
	{
		return new PlanSuscripcionDTO(codigo, nombre, descripcion, precio, tiempoSuscripcion);
	}
	
	public static PlanSuscripcionDTO crear()
	{
		return new PlanSuscripcionDTO(0, UtilTexto.BLANCO, UtilTexto.BLANCO, 0, 0);
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public PlanSuscripcionDTO setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public PlanSuscripcionDTO setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}

	public String getDescripcion() 
	{
		return descripcion;
	}

	public PlanSuscripcionDTO setDescripcion(String descripcion) 
	{
		this.descripcion =  UtilTexto.aplicarTrim(descripcion);
		return this;
	}

	public double getPrecio() 
	{
		return precio;
	}

	public PlanSuscripcionDTO setPrecio(double precio) 
	{
		this.precio = precio;
		return this;
	}

	public int getTiempoSuscripcion() 
	{
		return tiempoSuscripcion;
	}

	public PlanSuscripcionDTO setTiempoSuscripcion(int tiempoSuscripcion) 
	{
		this.tiempoSuscripcion = tiempoSuscripcion;
		return this;
	}
}
