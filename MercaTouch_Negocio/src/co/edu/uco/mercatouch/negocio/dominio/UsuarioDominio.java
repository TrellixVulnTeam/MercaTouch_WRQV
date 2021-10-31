package co.edu.uco.mercatouch.negocio.dominio;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class UsuarioDominio 
{
	int codigo;
	String nombre;
	String apellidos;
	long numeroIdentificacion;
	long telefono;
	String correo;
	String clave;
	int puntuacion;
	
	private UsuarioDominio(int codigo, String nombre, String apellidos, long numeroIdentificacion, long telefono, String correo, String clave, int puntuacion) 
	{
		setCodigo(codigo);
		setNombre(nombre);
		setApellidos(apellidos);
		setNumeroIdentificacion(numeroIdentificacion);
		setTelefono(telefono);
		setCorreo(correo);
		setClave(clave);
		setPuntuacion(puntuacion);
	}
	
	public static UsuarioDominio crear(int codigo, String nombre, String apellidos, long numeroIdentificacion, long telefono, String correo, String clave, int puntuacion)
	{
		return new UsuarioDominio(codigo, nombre, apellidos, numeroIdentificacion, telefono, correo, clave, puntuacion);
	}
	
	public static UsuarioDominio crear()
	{
		return new UsuarioDominio(0, UtilTexto.BLANCO, UtilTexto.BLANCO, 0, 0, UtilTexto.BLANCO, UtilTexto.BLANCO, 0);
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public UsuarioDominio setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public UsuarioDominio setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}

	public String getApellidos() 
	{
		return apellidos;
	}

	public UsuarioDominio setApellidos(String apellidos) 
	{
		this.apellidos = UtilTexto.aplicarTrim(apellidos);
		return this;
	}

	public long getNumeroIdentificacion() 
	{
		return numeroIdentificacion;
	}

	public UsuarioDominio setNumeroIdentificacion(long numeroIdentificacion) 
	{
		this.numeroIdentificacion = numeroIdentificacion;
		return this;
	}

	public long getTelefono() 
	{
		return telefono;
	}

	public UsuarioDominio setTelefono(long telefono) 
	{
		this.telefono = telefono;
		return this;
	}

	public String getCorreo() 
	{
		return correo;
	}

	public UsuarioDominio setCorreo(String correo) 
	{
		this.correo = UtilTexto.aplicarTrim(correo);
		return this;
	}

	public String getClave() 
	{
		return clave;
	}

	public UsuarioDominio setClave(String clave) 
	{
		this.clave = UtilTexto.aplicarTrim(clave);
		return this;
	}

	public int getPuntuacion() 
	{
		return puntuacion;
	}

	public UsuarioDominio setPuntuacion(int puntuacion) 
	{
		this.puntuacion = puntuacion;
		return this;
	}
}
