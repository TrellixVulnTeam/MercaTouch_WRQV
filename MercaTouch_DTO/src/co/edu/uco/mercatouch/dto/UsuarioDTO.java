package co.edu.uco.mercatouch.dto;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class UsuarioDTO 
{
	int codigo;
	String nombre;
	String apellidos;
	long numeroIdentificacion;
	long telefono;
	String correo;
	String clave;
	int puntuacion;
	
	public UsuarioDTO()
	{
		
	}
	
	private UsuarioDTO(int codigo, String nombre, String apellidos, long numeroIdentificacion, long telefono, String correo, String clave, int puntuacion) 
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
	
	public static UsuarioDTO crear(int codigo, String nombre, String apellidos, long numeroIdentificacion, long telefono, String correo, String clave, int puntuacion)
	{
		return new UsuarioDTO(codigo, nombre, apellidos, numeroIdentificacion, telefono, correo, clave, puntuacion);
	}
	
	public static UsuarioDTO crear()
	{
		return new UsuarioDTO(0, UtilTexto.BLANCO, UtilTexto.BLANCO, 0, 0, UtilTexto.BLANCO, UtilTexto.BLANCO, 0);
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public UsuarioDTO setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public UsuarioDTO setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}

	public String getApellidos() 
	{
		return apellidos;
	}

	public UsuarioDTO setApellidos(String apellidos) 
	{
		this.apellidos = UtilTexto.aplicarTrim(apellidos);
		return this;
	}

	public long getNumeroIdentificacion() 
	{
		return numeroIdentificacion;
	}

	public UsuarioDTO setNumeroIdentificacion(long numeroIdentificacion) 
	{
		this.numeroIdentificacion = numeroIdentificacion;
		return this;
	}

	public long getTelefono() 
	{
		return telefono;
	}

	public UsuarioDTO setTelefono(long telefono) 
	{
		this.telefono = telefono;
		return this;
	}

	public String getCorreo() 
	{
		return correo;
	}

	public UsuarioDTO setCorreo(String correo) 
	{
		this.correo = UtilTexto.aplicarTrim(correo);
		return this;
	}

	public String getClave() 
	{
		return clave;
	}

	public UsuarioDTO setClave(String clave) 
	{
		this.clave = UtilTexto.aplicarTrim(clave);
		return this;
	}

	public int getPuntuacion() 
	{
		return puntuacion;
	}

	public UsuarioDTO setPuntuacion(int puntuacion) 
	{
		this.puntuacion = puntuacion;
		return this;
	}
}
