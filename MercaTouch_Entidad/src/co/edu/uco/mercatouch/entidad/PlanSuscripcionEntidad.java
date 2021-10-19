package co.edu.uco.mercatouch.entidad;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class PlanSuscripcionEntidad 
{
	int codigo;
	String nombre;
	String descripcion;
	double precio;
	int tiempoSuscripcion;
	
	private PlanSuscripcionEntidad(int codigo, String nombre, String descripcion, double precio, int tiempoSuscripcion) 
	{
		setCodigo(codigo);
		setNombre(nombre);
		setDescripcion(descripcion);
		setPrecio(precio);
		setTiempoSuscripcion(tiempoSuscripcion);
	}
	
	public static PlanSuscripcionEntidad crear(int codigo, String nombre, String descripcion, double precio, int tiempoSuscripcion)
	{
		return new PlanSuscripcionEntidad(codigo, nombre, descripcion, precio, tiempoSuscripcion);
	}
	
	public static PlanSuscripcionEntidad crear()
	{
		return new PlanSuscripcionEntidad(0, UtilTexto.BLANCO, UtilTexto.BLANCO, 0, 0);
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public PlanSuscripcionEntidad setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public PlanSuscripcionEntidad setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}

	public String getDescripcion() 
	{
		return descripcion;
	}

	public PlanSuscripcionEntidad setDescripcion(String descripcion) 
	{
		this.descripcion =  UtilTexto.aplicarTrim(descripcion);
		return this;
	}

	public double getPrecio() 
	{
		return precio;
	}

	public PlanSuscripcionEntidad setPrecio(double precio) 
	{
		this.precio = precio;
		return this;
	}

	public int getTiempoSuscripcion() 
	{
		return tiempoSuscripcion;
	}

	public PlanSuscripcionEntidad setTiempoSuscripcion(int tiempoSuscripcion) 
	{
		this.tiempoSuscripcion = tiempoSuscripcion;
		return this;
	}
}
