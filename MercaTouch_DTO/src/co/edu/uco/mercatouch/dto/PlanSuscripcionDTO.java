package co.edu.uco.mercatouch.dto;

import java.util.Date;
import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class PlanSuscripcionDTO 
{
	private int codigo;
	private String nombre;
	private String descripcion;
	private double precio;
	private int tiempoSuscripcion;
	private Date fechaRegistro;
	
	public PlanSuscripcionDTO()
	{
		
	}
	
	private PlanSuscripcionDTO(int codigo, String nombre, String descripcion, double precio, int tiempoSuscripcion, Date fechaRegistro) 
	{
		setCodigo(codigo);
		setNombre(nombre);
		setDescripcion(descripcion);
		setPrecio(precio);
		setTiempoSuscripcion(tiempoSuscripcion);
		setFechaRegistro(fechaRegistro);
	}
	
	public static PlanSuscripcionDTO crear(int codigo, String nombre, String descripcion, double precio, int tiempoSuscripcion, Date fechaRegistro)
	{
		return new PlanSuscripcionDTO(codigo, nombre, descripcion, precio, tiempoSuscripcion, fechaRegistro);
	}
	
	public static PlanSuscripcionDTO crear()
	{
		return new PlanSuscripcionDTO(0, UtilTexto.BLANCO, UtilTexto.BLANCO, 0, 0, new Date());
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

	public Date getFechaRegistro() 
	{
		return fechaRegistro;
	}

	public PlanSuscripcionDTO setFechaRegistro(Date fechaRegistro) 
	{
		this.fechaRegistro = fechaRegistro;
		return this;
	}
}
