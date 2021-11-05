package co.edu.uco.mercatouch.negocio.dominio;

import java.util.Date;

import co.edu.uco.mercatouch.transversal.utilitario.UtilFecha;
import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class PlanSuscripcionDominio 
{
	private int codigo;
	private String nombre;
	private String descripcion;
	private double precio;
	private int tiempoSuscripcion;
	private Date fechaRegistro;
	
	private PlanSuscripcionDominio(int codigo, String nombre, String descripcion, double precio, int tiempoSuscripcion, Date fechaRegistro) 
	{
		setCodigo(codigo);
		setNombre(nombre);
		setDescripcion(descripcion);
		setPrecio(precio);
		setTiempoSuscripcion(tiempoSuscripcion);
		setFechaRegistro(fechaRegistro);
	}
	
	public static PlanSuscripcionDominio crear(int codigo, String nombre, String descripcion, double precio, int tiempoSuscripcion, Date fechaRegistro)
	{
		return new PlanSuscripcionDominio(codigo, nombre, descripcion, precio, tiempoSuscripcion, fechaRegistro);
	}
	
	public static PlanSuscripcionDominio crear()
	{
		return new PlanSuscripcionDominio(0, UtilTexto.BLANCO, UtilTexto.BLANCO, 0, 0, new Date());
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

	public Date getFechaRegistro() 
	{
		return fechaRegistro;
	}

	public PlanSuscripcionDominio setFechaRegistro(Date fechaRegistro) 
	{
		this.fechaRegistro = UtilFecha.obtenerFechaActual();
		return this;
	}
}
