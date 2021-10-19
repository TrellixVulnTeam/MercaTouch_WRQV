package co.edu.uco.mercatouch.dto;

import java.util.ArrayList;
import java.util.List;
import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class AdministradorDTO 
{
	int codigo;
	String nombre;
	String apellidos;
	long numeroIdentificacion;
	long telefono;
	String correo;
	String clave;
	List<TiendaDTO> tiendas;
	
	private AdministradorDTO(int codigo, String nombre, String apellidos, long numeroIdentificacion, long telefono, String correo, String clave, List<TiendaDTO> tiendas) 
	{
		setCodigo(codigo);
		setNombre(nombre);
		setApellidos(apellidos);
		setNumeroIdentificacion(numeroIdentificacion);
		setTelefono(telefono);
		setCorreo(correo);
		setClave(clave);
		setTiendas(tiendas);
	}
	
	public static AdministradorDTO crear(int codigo, String nombre, String apellidos, long numeroIdentificacion, long telefono, String correo, String clave, List<TiendaDTO> tiendas)
	{
		return new AdministradorDTO(codigo, nombre, apellidos, numeroIdentificacion, telefono, correo, clave, tiendas);
	}
	
	public static AdministradorDTO crear()
	{
		return new AdministradorDTO(0, UtilTexto.BLANCO,  UtilTexto.BLANCO, 0, 0,  UtilTexto.BLANCO,  UtilTexto.BLANCO, new ArrayList<>());
	}
	
	public int getCodigo() 
	{
		return codigo;
	}
	
	public AdministradorDTO setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}
	
	public String getNombre() 
	{
		return nombre;
	}
	public AdministradorDTO setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}
	
	public String getApellidos() 
	{
		return apellidos;
	}
	
	public AdministradorDTO setApellidos(String apellidos) 
	{
		this.apellidos = UtilTexto.aplicarTrim(apellidos);
		return this;
	}
	
	public long getNumeroIdentificacion() 
	{
		return numeroIdentificacion;
	}
	
	public AdministradorDTO setNumeroIdentificacion(long numeroIdentificacion) 
	{
		this.numeroIdentificacion = numeroIdentificacion;
		return this;
	}
	
	public long getTelefono() 
	{
		return telefono;
	}
	
	public AdministradorDTO setTelefono(long telefono) 
	{
		this.telefono = telefono;
		return this;
	}
	
	public String getCorreo() 
	{
		return correo;
	}
	
	public AdministradorDTO setCorreo(String correo) 
	{
		this.correo = UtilTexto.aplicarTrim(correo);
		return this;
	}
	
	public String getClave() 
	{
		return clave;
	}
	
	public AdministradorDTO setClave(String clave) 
	{
		this.clave = UtilTexto.aplicarTrim(clave);
		return this;
	}
	
	public List<TiendaDTO> getTiendas() 
	{
		return tiendas;
	}
	
	public AdministradorDTO setTiendas(List<TiendaDTO> tiendas) 
	{
		this.tiendas = tiendas;
		return this;
	}
}