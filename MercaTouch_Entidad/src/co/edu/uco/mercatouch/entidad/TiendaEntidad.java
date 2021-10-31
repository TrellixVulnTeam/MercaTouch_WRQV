package co.edu.uco.mercatouch.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

@Entity
@Table(name = "tienda")
public class TiendaEntidad 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="tienda_codigo_seq")
	@SequenceGenerator(name="tienda_codigo_seq", sequenceName="tienda_codigo_seq", allocationSize=1)
    @Column(name = "codigo")
	int codigo;
	@Column
	String nombre;
	@Column
	String rutaLogo;
	@Column
	String direccion;
	@Column
	String ciudad;
	@Column
	String departamento;
	@Column
	long telefono;
	@Column
	int calificacion;
	
	private TiendaEntidad(int codigo, String nombre, String rutaLogo, String direccion, String ciudad, String departamento, long telefono, int calificacion) 
	{
		setCodigo(codigo);
		setNombre(nombre);
		setRutaLogo(rutaLogo);
		setDireccion(direccion);
		setCiudad(ciudad);
		setDepartamento(departamento);
		setTelefono(telefono);
		setCalificacion(calificacion);
	}
	
	public static TiendaEntidad crear(int codigo, String nombre, String rutaLogo, String direccion, String ciudad, String departamento, long telefono, int calificacion)
	{
		return new TiendaEntidad(codigo, nombre, rutaLogo, direccion, ciudad, departamento, telefono, calificacion);
	}
	
	public static TiendaEntidad crear()
	{
		return new TiendaEntidad(0, UtilTexto.BLANCO, UtilTexto.BLANCO, UtilTexto.BLANCO, UtilTexto.BLANCO, UtilTexto.BLANCO, 0, 0);
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public TiendaEntidad setCodigo(int codigo)
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public TiendaEntidad setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}

	public String getRutaLogo() 
	{
		return rutaLogo;
	}

	public TiendaEntidad setRutaLogo(String rutaLogo) 
	{
		this.rutaLogo = UtilTexto.aplicarTrim(rutaLogo);
		return this;
	}

	public String getDireccion() 
	{
		return direccion;
	}

	public TiendaEntidad setDireccion(String direccion) 
	{
		this.direccion = UtilTexto.aplicarTrim(direccion);
		return this;
	}

	public String getCiudad() 
	{
		return ciudad;
	}

	public TiendaEntidad setCiudad(String ciudad) 
	{
		this.ciudad = UtilTexto.aplicarTrim(ciudad);
		return this;
	}

	public String getDepartamento() 
	{
		return departamento;
	}

	public TiendaEntidad setDepartamento(String departamento) 
	{
		this.departamento = UtilTexto.aplicarTrim(departamento);
		return this;
	}

	public long getTelefono() 
	{
		return telefono;
	}

	public TiendaEntidad setTelefono(long telefono) 
	{
		this.telefono = telefono;
		return this;
	}

	public int getCalificacion() 
	{
		return calificacion;
	}

	public TiendaEntidad setCalificacion(int calificacion) 
	{
		this.calificacion = calificacion;
		return this;
	}
}
