package co.edu.uco.mercatouch.entidad;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class DomiciliarioEntidad 
{
	int codigo;
	String nombre;
	String apellidos;
	long numeroIdentificacion;
	long telefono;
	String correo;
	String clave;
	int puntuacion;
	TiendaEntidad tienda;
	
	private DomiciliarioEntidad(int codigo, String nombre, String apellidos, long numeroIdentificacion, long telefono, String correo, String clave, int puntuacion, TiendaEntidad tienda) 
	{
		setCodigo(codigo);
		setNombre(nombre);
		setApellidos(apellidos);
		setNumeroIdentificacion(numeroIdentificacion);
		setTelefono(telefono);
		setCorreo(correo);
		setClave(clave);
		setPuntuacion(puntuacion);
		setTienda(tienda);
	}
	
	public static DomiciliarioEntidad crear(int codigo, String nombre, String apellidos, long numeroIdentificacion, long telefono, String correo, String clave, int puntuacion, TiendaEntidad tienda)
	{
		return new DomiciliarioEntidad(codigo, nombre, apellidos, numeroIdentificacion, telefono, correo, clave, puntuacion, tienda);
	}
	
	public static DomiciliarioEntidad crear()
	{
		return new DomiciliarioEntidad(0, UtilTexto.BLANCO, UtilTexto.BLANCO, 0, 0, UtilTexto.BLANCO, UtilTexto.BLANCO, 0, TiendaEntidad.crear());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public DomiciliarioEntidad setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() {
		return nombre;
	}

	public DomiciliarioEntidad setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}

	public String getApellidos() 
	{
		return apellidos;
	}

	public DomiciliarioEntidad setApellidos(String apellidos) 
	{
		this.apellidos = UtilTexto.aplicarTrim(apellidos);
		return this;
	}

	public long getNumeroIdentificacion() 
	{
		return numeroIdentificacion;
	}

	public DomiciliarioEntidad setNumeroIdentificacion(long numeroIdentificacion) 
	{
		this.numeroIdentificacion = numeroIdentificacion;
		return this;
	}

	public long getTelefono() 
	{
		return telefono;
	}

	public DomiciliarioEntidad setTelefono(long telefono) 
	{
		this.telefono = telefono;
		return this;
	}

	public String getCorreo() 
	{
		return correo;
	}

	public DomiciliarioEntidad setCorreo(String correo) 
	{
		this.correo = UtilTexto.aplicarTrim(correo);
		return this;
	}

	public String getClave() {
		return clave;
	}

	public DomiciliarioEntidad setClave(String clave) 
	{
		this.clave = UtilTexto.aplicarTrim(clave);
		return this;
	}

	public int getPuntuacion() 
	{
		return puntuacion;
	}

	public DomiciliarioEntidad setPuntuacion(int puntuacion) 
	{
		this.puntuacion = puntuacion;
		return this;
	}

	public TiendaEntidad getTienda() {
		return tienda;
	}

	public DomiciliarioEntidad setTienda(TiendaEntidad tienda) 
	{
		this.tienda = tienda;
		return this;
	}
}