package co.edu.uco.mercatouch.negocio.dominio;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class AdministradorDominio 
{
	int codigo;
	String nombre;
	String apellidos;
	long numeroIdentificacion;
	long telefono;
	String correo;
	String clave;
	TiendaDominio tienda;
	
	private AdministradorDominio(int codigo, String nombre, String apellidos, long numeroIdentificacion, long telefono, String correo, String clave, TiendaDominio tienda) 
	{
		setCodigo(codigo);
		setNombre(nombre);
		setApellidos(apellidos);
		setNumeroIdentificacion(numeroIdentificacion);
		setTelefono(telefono);
		setCorreo(correo);
		setClave(clave);
		setTienda(tienda);
	}
	
	public static AdministradorDominio crear(int codigo, String nombre, String apellidos, long numeroIdentificacion, long telefono, String correo, String clave, TiendaDominio tienda)
	{
		return new AdministradorDominio(codigo, nombre, apellidos, numeroIdentificacion, telefono, correo, clave, tienda);
	}
	
	public static AdministradorDominio crear()
	{
		return new AdministradorDominio(0, UtilTexto.BLANCO,  UtilTexto.BLANCO, 0, 0,  UtilTexto.BLANCO,  UtilTexto.BLANCO, TiendaDominio.crear());
	}
	
	public int getCodigo() 
	{
		return codigo;
	}
	
	public AdministradorDominio setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}
	
	public String getNombre() 
	{
		return nombre;
	}
	public AdministradorDominio setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}
	
	public String getApellidos() 
	{
		return apellidos;
	}
	
	public AdministradorDominio setApellidos(String apellidos) 
	{
		this.apellidos = UtilTexto.aplicarTrim(apellidos);
		return this;
	}
	
	public long getNumeroIdentificacion() 
	{
		return numeroIdentificacion;
	}
	
	public AdministradorDominio setNumeroIdentificacion(long numeroIdentificacion) 
	{
		this.numeroIdentificacion = numeroIdentificacion;
		return this;
	}
	
	public long getTelefono() 
	{
		return telefono;
	}
	
	public AdministradorDominio setTelefono(long telefono) 
	{
		this.telefono = telefono;
		return this;
	}
	
	public String getCorreo() 
	{
		return correo;
	}
	
	public AdministradorDominio setCorreo(String correo) 
	{
		this.correo = UtilTexto.aplicarTrim(correo);
		return this;
	}
	
	public String getClave() 
	{
		return clave;
	}
	
	public AdministradorDominio setClave(String clave) 
	{
		this.clave = UtilTexto.aplicarTrim(clave);
		return this;
	}
	
	public TiendaDominio getTienda() 
	{
		return tienda;
	}
	
	public AdministradorDominio setTienda(TiendaDominio tienda) 
	{
		this.tienda = tienda;
		return this;
	}
}