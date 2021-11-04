package co.edu.uco.mercatouch.dto;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class TiendaDTO 
{
	private int codigo;
	private String nombre;
	private String rutaLogo;
	private String direccion;
	private long telefono;
	private CiudadDTO ciudad;
	private UsuarioTiendaDTO administrador;
	private PlanSuscripcionDTO planSuscripcion;
	
	public TiendaDTO()
	{
		
	}
	
	private TiendaDTO(int codigo, String nombre, String rutaLogo, String direccion, long telefono, CiudadDTO ciudad, UsuarioTiendaDTO administrador, PlanSuscripcionDTO planSuscripcion) 
	{
		setCodigo(codigo);
		setNombre(nombre);
		setRutaLogo(rutaLogo);
		setDireccion(direccion);
		setTelefono(telefono);
		setCiudad(ciudad);
		setAdministrador(administrador);
		setPlanSuscripcion(planSuscripcion);
	}
	
	public static TiendaDTO crear(int codigo, String nombre, String rutaLogo, String direccion, long telefono, CiudadDTO ciudad, UsuarioTiendaDTO administrador, PlanSuscripcionDTO planSuscripcion)
	{
		return new TiendaDTO(codigo, nombre, rutaLogo, direccion, telefono, ciudad, administrador, planSuscripcion);
	}
	
	public static TiendaDTO crear()
	{
		return new TiendaDTO(0, UtilTexto.BLANCO, UtilTexto.BLANCO, UtilTexto.BLANCO, 0, CiudadDTO.crear(), UsuarioTiendaDTO.crear(), PlanSuscripcionDTO.crear());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public TiendaDTO setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public TiendaDTO setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}

	public String getRutaLogo() 
	{
		return rutaLogo;
	}

	public TiendaDTO setRutaLogo(String rutaLogo) 
	{
		this.rutaLogo = UtilTexto.aplicarTrim(rutaLogo);
		return this;
	}

	public String getDireccion() 
	{
		return direccion;
	}

	public TiendaDTO setDireccion(String direccion) 
	{
		this.direccion = UtilTexto.aplicarTrim(direccion);
		return this;
	}

	public long getTelefono() 
	{
		return telefono;
	}

	public TiendaDTO setTelefono(long telefono) 
	{
		this.telefono = telefono;
		return this;
	}

	public CiudadDTO getCiudad() 
	{
		return ciudad;
	}

	public TiendaDTO setCiudad(CiudadDTO ciudad) 
	{
		this.ciudad = ciudad;
		return this;
	}

	public UsuarioTiendaDTO getAdministrador() 
	{
		return administrador;
	}

	public TiendaDTO setAdministrador(UsuarioTiendaDTO administrador) 
	{
		this.administrador = administrador;
		return this;
	}

	public PlanSuscripcionDTO getPlanSuscripcion() 
	{
		return planSuscripcion;
	}

	public TiendaDTO setPlanSuscripcion(PlanSuscripcionDTO planSuscripcion) 
	{
		this.planSuscripcion = planSuscripcion;
		return this;
	}
}
