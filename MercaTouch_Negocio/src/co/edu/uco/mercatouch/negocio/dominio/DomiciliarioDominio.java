package co.edu.uco.mercatouch.negocio.dominio;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class DomiciliarioDominio 
{
	int codigo;
	String nombre;
	String apellidos;
	long numeroIdentificacion;
	long telefono;
	String correo;
	String clave;
	int puntuacion;
	TiendaDominio tienda;
	
	private DomiciliarioDominio(int codigo, String nombre, String apellidos, long numeroIdentificacion, long telefono, String correo, String clave, int puntuacion, TiendaDominio tienda) 
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
	
	public static DomiciliarioDominio crear(int codigo, String nombre, String apellidos, long numeroIdentificacion, long telefono, String correo, String clave, int puntuacion, TiendaDominio tienda)
	{
		return new DomiciliarioDominio(codigo, nombre, apellidos, numeroIdentificacion, telefono, correo, clave, puntuacion, tienda);
	}
	
	public static DomiciliarioDominio crear()
	{
		return new DomiciliarioDominio(0, UtilTexto.BLANCO, UtilTexto.BLANCO, 0, 0, UtilTexto.BLANCO, UtilTexto.BLANCO, 0, TiendaDominio.crear());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public DomiciliarioDominio setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() {
		return nombre;
	}

	public DomiciliarioDominio setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}

	public String getApellidos() 
	{
		return apellidos;
	}

	public DomiciliarioDominio setApellidos(String apellidos) 
	{
		this.apellidos = UtilTexto.aplicarTrim(apellidos);
		return this;
	}

	public long getNumeroIdentificacion() 
	{
		return numeroIdentificacion;
	}

	public DomiciliarioDominio setNumeroIdentificacion(long numeroIdentificacion) 
	{
		this.numeroIdentificacion = numeroIdentificacion;
		return this;
	}

	public long getTelefono() 
	{
		return telefono;
	}

	public DomiciliarioDominio setTelefono(long telefono) 
	{
		this.telefono = telefono;
		return this;
	}

	public String getCorreo() 
	{
		return correo;
	}

	public DomiciliarioDominio setCorreo(String correo) 
	{
		this.correo = UtilTexto.aplicarTrim(correo);
		return this;
	}

	public String getClave() {
		return clave;
	}

	public DomiciliarioDominio setClave(String clave) 
	{
		this.clave = UtilTexto.aplicarTrim(clave);
		return this;
	}

	public int getPuntuacion() 
	{
		return puntuacion;
	}

	public DomiciliarioDominio setPuntuacion(int puntuacion) 
	{
		this.puntuacion = puntuacion;
		return this;
	}

	public TiendaDominio getTienda() {
		return tienda;
	}

	public DomiciliarioDominio setTienda(TiendaDominio tienda) 
	{
		this.tienda = tienda;
		return this;
	}
}