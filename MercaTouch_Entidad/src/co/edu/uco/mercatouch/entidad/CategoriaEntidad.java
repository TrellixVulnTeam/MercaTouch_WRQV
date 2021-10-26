package co.edu.uco.mercatouch.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

@Entity
@Table(name = "categoria")
public class CategoriaEntidad 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int codigo;
	@Column
	String nombre;
	@Column
	String descripcion;
	
	private CategoriaEntidad(int codigo, String nombre, String descripcion) 
	{
		setCodigo(codigo);
		setNombre(nombre);
		setDescripcion(descripcion);
	}
	
	public static CategoriaEntidad crear(int codigo, String nombre, String descripcion)
	{
		return new CategoriaEntidad(codigo, nombre, descripcion);
	}
	
	public static CategoriaEntidad crear()
	{
		return new CategoriaEntidad(0, UtilTexto.BLANCO, UtilTexto.BLANCO);
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public CategoriaEntidad setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public CategoriaEntidad setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}

	public String getDescripcion() 
	{
		return descripcion;
	}

	public CategoriaEntidad setDescripcion(String descripcion) 
	{
		this.descripcion = UtilTexto.aplicarTrim(descripcion);
		return this;
	}
}