package co.edu.uco.mercatouch.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

@Entity
@Table(name = "tienda", schema = "public")
public class TiendaEntidad 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="tienda_codigo_seq")
	@SequenceGenerator(name="tienda_codigo_seq", sequenceName="tienda_codigo_seq", allocationSize=1)
    @Column(name = "codigo")
	private int codigo;
	@Column
	private String nombre;
	@Column(name="rutalogo")
	private String rutaLogo;
	@Column
	private String direccion;
	@Column
	private long telefono;
	@OneToOne
	@JoinColumn(name="ciudad")
	private CiudadEntidad ciudad;
	@OneToOne
	@JoinColumn(name="plansuscripcion")
	private PlanSuscripcionEntidad planSuscripcion;
	
	public TiendaEntidad()
	{
		
	}
	
	private TiendaEntidad(int codigo, String nombre, String rutaLogo, String direccion, long telefono, CiudadEntidad ciudad, PlanSuscripcionEntidad planSuscripcion) 
	{
		setCodigo(codigo);
		setNombre(nombre);
		setRutaLogo(rutaLogo);
		setDireccion(direccion);
		setTelefono(telefono);
		setCiudad(ciudad);
		setPlanSuscripcion(planSuscripcion);
	}
	
	public static TiendaEntidad crear(int codigo, String nombre, String rutaLogo, String direccion, long telefono, CiudadEntidad ciudad, PlanSuscripcionEntidad planSuscripcion)
	{
		return new TiendaEntidad(codigo, nombre, rutaLogo, direccion, telefono, ciudad, planSuscripcion);
	}
	
	public static TiendaEntidad crear()
	{
		return new TiendaEntidad(0, UtilTexto.BLANCO, UtilTexto.BLANCO, UtilTexto.BLANCO, 0, CiudadEntidad.crear(), PlanSuscripcionEntidad.crear());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public TiendaEntidad setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public TiendaEntidad setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}

	public String getRutaLogo() 
	{
		return rutaLogo;
	}

	public TiendaEntidad setRutaLogo(String rutaLogo) 
	{
		this.rutaLogo = UtilTexto.aplicarTrim(rutaLogo);
		return this;
	}

	public String getDireccion() 
	{
		return direccion;
	}

	public TiendaEntidad setDireccion(String direccion) 
	{
		this.direccion = UtilTexto.aplicarTrim(direccion);
		return this;
	}

	public long getTelefono() 
	{
		return telefono;
	}

	public TiendaEntidad setTelefono(long telefono) 
	{
		this.telefono = telefono;
		return this;
	}

	public CiudadEntidad getCiudad() 
	{
		return ciudad;
	}

	public TiendaEntidad setCiudad(CiudadEntidad ciudad) 
	{
		this.ciudad = ciudad;
		return this;
	}

	public PlanSuscripcionEntidad getPlanSuscripcion() 
	{
		return planSuscripcion;
	}

	public TiendaEntidad setPlanSuscripcion(PlanSuscripcionEntidad planSuscripcion) 
	{
		this.planSuscripcion = planSuscripcion;
		return this;
	}
}
