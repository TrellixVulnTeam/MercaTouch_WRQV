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
@Table(name = "departamento", schema = "public")
public class DepartamentoEntidad 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="departamento_codigo_seq")
	@SequenceGenerator(name="departamento_codigo_seq", sequenceName="departamento_codigo_seq", allocationSize=1)
    @Column(name = "codigo")
	private int codigo;
	@Column
	private String nombre;
	
	public DepartamentoEntidad()
	{
		
	}
	
	private DepartamentoEntidad(int codigo, String nombre) 
	{
		this.codigo = codigo;
		this.nombre = nombre;
	}
	
	public static DepartamentoEntidad crear(int codigo, String nombre)
	{
		return new DepartamentoEntidad(codigo, nombre);
	}
	
	public static DepartamentoEntidad crear()
	{
		return new DepartamentoEntidad(0, UtilTexto.BLANCO);
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public DepartamentoEntidad setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public DepartamentoEntidad setNombre(String nombre) 
	{
		this.nombre = nombre;
		return this;
	}
}