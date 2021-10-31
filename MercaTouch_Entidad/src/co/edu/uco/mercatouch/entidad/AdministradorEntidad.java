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
@Table(name = "administrador")
public class AdministradorEntidad 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@SequenceGenerator(name="administrador_codigo_seq", sequenceName="administrador_codigo_seq", allocationSize=1)
    @Column(name = "codigo")
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
	@OneToOne
	@JoinColumn(name="administrador")
	TiendaEntidad tienda;
	
	private AdministradorEntidad(int codigo, String nombre, String apellidos, long numeroIdentificacion, long telefono, String correo, String clave, TiendaEntidad tienda) 
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
	
	public static AdministradorEntidad crear(int codigo, String nombre, String apellidos, long numeroIdentificacion, long telefono, String correo, String clave, TiendaEntidad tienda)
	{
		return new AdministradorEntidad(codigo, nombre, apellidos, numeroIdentificacion, telefono, correo, clave, tienda);
	}
	
	public static AdministradorEntidad crear()
	{
		return new AdministradorEntidad(0, UtilTexto.BLANCO,  UtilTexto.BLANCO, 0, 0,  UtilTexto.BLANCO,  UtilTexto.BLANCO, TiendaEntidad.crear());
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
	
	public TiendaEntidad getTienda() 
	{
		return tienda;
	}
	
	public AdministradorEntidad setTienda(TiendaEntidad tienda) 
	{
		this.tienda = tienda;
		return this;
	}
}