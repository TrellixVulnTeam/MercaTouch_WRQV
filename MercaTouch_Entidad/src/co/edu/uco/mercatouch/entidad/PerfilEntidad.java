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
@Table(name = "perfil", schema = "public")
public class PerfilEntidad 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="perfil_codigo_seq")
	@SequenceGenerator(name="perfil_codigo_seq", sequenceName="perfil_codigo_seq", allocationSize=1)
	@Column(name = "codigo")
	private int codigo;
	@Column
	private String nombre;
	
	public PerfilEntidad()
	{
		
	}
	
	private PerfilEntidad(int codigo, String nombre) 
	{
		setCodigo(codigo);
		setNombre(nombre);
	}
	
	public static PerfilEntidad crear(int codigo, String nombre)
	{
		return new PerfilEntidad(codigo, nombre);
	}
	
	public static PerfilEntidad crear()
	{
		return new PerfilEntidad(0, UtilTexto.BLANCO);
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public PerfilEntidad setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public PerfilEntidad setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}
}