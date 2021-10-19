package co.edu.uco.mercatouch.dto;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class DomiciliarioDTO 
{
	int codigo;
	String nombre;
	String apellidos;
	long numeroIdentificacion;
	long telefono;
	String correo;
	String clave;
	int puntuacion;
	TiendaDTO tienda;
	
	private DomiciliarioDTO(int codigo, String nombre, String apellidos, long numeroIdentificacion, long telefono, String correo, String clave, int puntuacion, TiendaDTO tienda) 
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
	
	public static DomiciliarioDTO crear(int codigo, String nombre, String apellidos, long numeroIdentificacion, long telefono, String correo, String clave, int puntuacion, TiendaDTO tienda)
	{
		return new DomiciliarioDTO(codigo, nombre, apellidos, numeroIdentificacion, telefono, correo, clave, puntuacion, tienda);
	}
	
	public static DomiciliarioDTO crear()
	{
		return new DomiciliarioDTO(0, UtilTexto.BLANCO, UtilTexto.BLANCO, 0, 0, UtilTexto.BLANCO, UtilTexto.BLANCO, 0, TiendaDTO.crear());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public DomiciliarioDTO setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() {
		return nombre;
	}

	public DomiciliarioDTO setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}

	public String getApellidos() 
	{
		return apellidos;
	}

	public DomiciliarioDTO setApellidos(String apellidos) 
	{
		this.apellidos = UtilTexto.aplicarTrim(apellidos);
		return this;
	}

	public long getNumeroIdentificacion() 
	{
		return numeroIdentificacion;
	}

	public DomiciliarioDTO setNumeroIdentificacion(long numeroIdentificacion) 
	{
		this.numeroIdentificacion = numeroIdentificacion;
		return this;
	}

	public long getTelefono() 
	{
		return telefono;
	}

	public DomiciliarioDTO setTelefono(long telefono) 
	{
		this.telefono = telefono;
		return this;
	}

	public String getCorreo() 
	{
		return correo;
	}

	public DomiciliarioDTO setCorreo(String correo) 
	{
		this.correo = UtilTexto.aplicarTrim(correo);
		return this;
	}

	public String getClave() {
		return clave;
	}

	public DomiciliarioDTO setClave(String clave) 
	{
		this.clave = UtilTexto.aplicarTrim(clave);
		return this;
	}

	public int getPuntuacion() 
	{
		return puntuacion;
	}

	public DomiciliarioDTO setPuntuacion(int puntuacion) 
	{
		this.puntuacion = puntuacion;
		return this;
	}

	public TiendaDTO getTienda() {
		return tienda;
	}

	public DomiciliarioDTO setTienda(TiendaDTO tienda) 
	{
		this.tienda = tienda;
		return this;
	}
}