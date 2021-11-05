package co.edu.uco.mercatouch.entidad;

import java.util.Date;

import co.edu.uco.mercatouch.transversal.utilitario.UtilFecha;
import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class PlanSuscripcionEntidad 
{
	private int codigo;
	private String nombre;
	private String descripcion;
	private double precio;
	private int tiempoSuscripcion;
	private Date fechaRegistro;
	
	private PlanSuscripcionEntidad(int codigo, String nombre, String descripcion, double precio, int tiempoSuscripcion, Date fechaRegistro) 
	{
		setCodigo(codigo);
		setNombre(nombre);
		setDescripcion(descripcion);
		setPrecio(precio);
		setTiempoSuscripcion(tiempoSuscripcion);
		setFechaRegistro(fechaRegistro);
	}
	
	public static PlanSuscripcionEntidad crear(int codigo, String nombre, String descripcion, double precio, int tiempoSuscripcion, Date fechaRegistro)
	{
		return new PlanSuscripcionEntidad(codigo, nombre, descripcion, precio, tiempoSuscripcion, fechaRegistro);
	}
	
	public static PlanSuscripcionEntidad crear()
	{
		return new PlanSuscripcionEntidad(0, UtilTexto.BLANCO, UtilTexto.BLANCO, 0, 0, new Date());
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

	public Date getFechaRegistro() 
	{
		return fechaRegistro;
	}

	public PlanSuscripcionEntidad setFechaRegistro(Date fechaRegistro) 
	{
		this.fechaRegistro = UtilFecha.obtenerFechaActual();
		return this;
	}
}
