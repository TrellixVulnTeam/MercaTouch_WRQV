package co.edu.uco.mercatouch.negocio.dominio;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class TiendaDominio 
{
	private int codigo;
	private String nombre;
	private String rutaLogo;
	private String direccion;
	private long telefono;
	private CiudadDominio ciudad;
	private PlanSuscripcionDominio planSuscripcion;
	
	private TiendaDominio(int codigo, String nombre, String rutaLogo, String direccion, long telefono, CiudadDominio ciudad, PlanSuscripcionDominio planSuscripcion) 
	{
		setCodigo(codigo);
		setNombre(nombre);
		setRutaLogo(rutaLogo);
		setDireccion(direccion);
		setTelefono(telefono);
		setCiudad(ciudad);
		setPlanSuscripcion(planSuscripcion);
	}
	
	public static TiendaDominio crear(int codigo, String nombre, String rutaLogo, String direccion, long telefono, CiudadDominio ciudad, PlanSuscripcionDominio planSuscripcion)
	{
		return new TiendaDominio(codigo, nombre, rutaLogo, direccion, telefono, ciudad, planSuscripcion);
	}
	
	public static TiendaDominio crear()
	{
		return new TiendaDominio(0, UtilTexto.BLANCO, UtilTexto.BLANCO, UtilTexto.BLANCO, 0, CiudadDominio.crear(), PlanSuscripcionDominio.crear());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public TiendaDominio setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public TiendaDominio setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}

	public String getRutaLogo() 
	{
		return rutaLogo;
	}

	public TiendaDominio setRutaLogo(String rutaLogo) 
	{
		this.rutaLogo = UtilTexto.aplicarTrim(rutaLogo);
		return this;
	}

	public String getDireccion() 
	{
		return direccion;
	}

	public TiendaDominio setDireccion(String direccion) 
	{
		this.direccion = UtilTexto.aplicarTrim(direccion);
		return this;
	}

	public long getTelefono() 
	{
		return telefono;
	}

	public TiendaDominio setTelefono(long telefono) 
	{
		this.telefono = telefono;
		return this;
	}

	public CiudadDominio getCiudad() 
	{
		return ciudad;
	}

	public TiendaDominio setCiudad(CiudadDominio ciudad) 
	{
		this.ciudad = ciudad;
		return this;
	}

	public PlanSuscripcionDominio getPlanSuscripcion() 
	{
		return planSuscripcion;
	}

	public TiendaDominio setPlanSuscripcion(PlanSuscripcionDominio planSuscripcion) 
	{
		this.planSuscripcion = planSuscripcion;
		return this;
	}
}
