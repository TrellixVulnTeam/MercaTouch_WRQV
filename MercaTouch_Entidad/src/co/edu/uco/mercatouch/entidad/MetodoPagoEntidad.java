package co.edu.uco.mercatouch.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

@Entity
@Table(name = "metodopago")
public class MetodoPagoEntidad 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int codigo;
	@Column
	String nombre;
	@Column
	boolean incluyeDomicilio;
	
	private MetodoPagoEntidad(int codigo, String nombre, boolean incluyeDomicilio) 
	{
		setCodigo(codigo);
		setNombre(nombre);
		setIncluyeDomicilio(incluyeDomicilio);
	}
	
	public static MetodoPagoEntidad crear(int codigo, String nombre, boolean incluyeDomicilio)
	{
		return new MetodoPagoEntidad(codigo, nombre, incluyeDomicilio);
	}
	
	public static MetodoPagoEntidad crear()
	{
		return new MetodoPagoEntidad(0, UtilTexto.BLANCO, false);
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public MetodoPagoEntidad setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public MetodoPagoEntidad setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}

	public boolean isIncluyeDomicilio() 
	{
		return incluyeDomicilio;
	}

	public MetodoPagoEntidad setIncluyeDomicilio(boolean incluyeDomicilio) 
	{
		this.incluyeDomicilio = incluyeDomicilio;
		return this;
	}
}