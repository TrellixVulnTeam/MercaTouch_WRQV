package co.edu.uco.mercatouch.entidad;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

@Entity
@Table(name = "administrador")
public class AdministradorEntidad 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int codigo;
	@Column
	String nombre;
	@Column
	String apellidos;
	@Column
	long numeroIdentificacion;
	@Column
	long telefono;
	@Column
	String correo;
	@Column
	String clave;
	@OneToMany
	List<TiendaEntidad> tiendas;
	
	private AdministradorEntidad(int codigo, String nombre, String apellidos, long numeroIdentificacion, long telefono, String correo, String clave, List<TiendaEntidad> tiendas) 
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
	
	public static AdministradorEntidad crear(int codigo, String nombre, String apellidos, long numeroIdentificacion, long telefono, String correo, String clave, List<TiendaEntidad> tiendas)
	{
		return new AdministradorEntidad(codigo, nombre, apellidos, numeroIdentificacion, telefono, correo, clave, tiendas);
	}
	
	public static AdministradorEntidad crear()
	{
		return new AdministradorEntidad(0, UtilTexto.BLANCO,  UtilTexto.BLANCO, 0, 0,  UtilTexto.BLANCO,  UtilTexto.BLANCO, new ArrayList<>());
	}
	
	public int getCodigo() 
	{
		return codigo;
	}
	
	public AdministradorEntidad setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}
	
	public String getNombre() 
	{
		return nombre;
	}
	public AdministradorEntidad setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}
	
	public String getApellidos() 
	{
		return apellidos;
	}
	
	public AdministradorEntidad setApellidos(String apellidos) 
	{
		this.apellidos = UtilTexto.aplicarTrim(apellidos);
		return this;
	}
	
	public long getNumeroIdentificacion() 
	{
		return numeroIdentificacion;
	}
	
	public AdministradorEntidad setNumeroIdentificacion(long numeroIdentificacion) 
	{
		this.numeroIdentificacion = numeroIdentificacion;
		return this;
	}
	
	public long getTelefono() 
	{
		return telefono;
	}
	
	public AdministradorEntidad setTelefono(long telefono) 
	{
		this.telefono = telefono;
		return this;
	}
	
	public String getCorreo() 
	{
		return correo;
	}
	
	public AdministradorEntidad setCorreo(String correo) 
	{
		this.correo = UtilTexto.aplicarTrim(correo);
		return this;
	}
	
	public String getClave() 
	{
		return clave;
	}
	
	public AdministradorEntidad setClave(String clave) 
	{
		this.clave = UtilTexto.aplicarTrim(clave);
		return this;
	}
	
	public List<TiendaEntidad> getTiendas() 
	{
		return tiendas;
	}
	
	public AdministradorEntidad setTiendas(List<TiendaEntidad> tiendas) 
	{
		this.tiendas = tiendas;
		return this;
	}
}