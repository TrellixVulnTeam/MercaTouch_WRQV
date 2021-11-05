package co.edu.uco.mercatouch.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

@Entity
@Table(name = "ciudad", schema = "public")
public class CiudadEntidad 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="ciudad_codigo_seq")
	@SequenceGenerator(name="ciudad_codigo_seq", sequenceName="ciudad_codigo_seq", allocationSize=1)
    @Column(name = "codigo")
	private int codigo;
	@Column
	private String nombre;
	@OneToOne
	@JoinColumn(name="departamento")
	private DepartamentoEntidad departamento;
	
	public CiudadEntidad()
	{
		
	}
	
	private CiudadEntidad(int codigo, String nombre, DepartamentoEntidad departamento) 
	{
		this.codigo = codigo;
		this.nombre = nombre;
		this.departamento = departamento;
	}
	
	public static CiudadEntidad crear(int codigo, String nombre, DepartamentoEntidad departamento)
	{
		return new CiudadEntidad(codigo, nombre, departamento);
	}
	
	public static CiudadEntidad crear()
	{
		return new CiudadEntidad(0, UtilTexto.BLANCO, DepartamentoEntidad.crear());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public CiudadEntidad setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public CiudadEntidad setNombre(String nombre) 
	{
		this.nombre = nombre;
		return this;
	}

	public DepartamentoEntidad getDepartamento() 
	{
		return departamento;
	}

	public CiudadEntidad setDepartamento(DepartamentoEntidad departamento) 
	{
		this.departamento = departamento;
		return this;
	}
}
