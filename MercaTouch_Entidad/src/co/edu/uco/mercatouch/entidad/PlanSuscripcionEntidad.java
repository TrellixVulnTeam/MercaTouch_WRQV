package co.edu.uco.mercatouch.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import co.edu.uco.mercatouch.transversal.utilitario.UtilFecha;
import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

@Entity
@Table(name = "plansuscripcion", schema = "public")
public class PlanSuscripcionEntidad 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="plansuscripcion_codigo_seq")
	@SequenceGenerator(name="plansuscripcion_codigo_seq", sequenceName="plansuscripcion_codigo_seq", allocationSize=1)
    @Column(name = "codigo")
	private int codigo;
	@Column
	private String nombre;
	@Column
	private String descripcion;
	@Column
	private double precio;
	@Column(name="tiemposuscripcion")
	private int tiempoSuscripcion;
	@Column(name="fecharegistro")
	private Date fechaRegistro;
	
	public PlanSuscripcionEntidad()
	{
		
	}
	
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
