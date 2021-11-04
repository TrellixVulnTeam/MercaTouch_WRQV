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
@Table(name = "usuario", schema = "public")
public class UsuarioEntidad 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="usuario_codigo_seq")
	@SequenceGenerator(name="usuario_codigo_seq", sequenceName="usuario_codigo_seq", allocationSize=1)
	@Column(name = "codigo")
	private int codigo;
	@Column
	private String nombre;
	@Column
	private String apellidos;
	@Column(name="numeroidentificacion")
	private long numeroIdentificacion;
	@Column
	private long telefono;
	@Column
	private String correo;
	@Column
	private String clave;
	@Column
	private int puntuacion;
	@OneToOne
	@JoinColumn(name="perfil")
	private PerfilEntidad perfil;
	
	public UsuarioEntidad()
	{
		
	}
	
	private UsuarioEntidad(int codigo, String nombre, String apellidos, long numeroIdentificacion, long telefono, String correo, String clave, int puntuacion, PerfilEntidad perfil) 
	{
		setCodigo(codigo);
		setNombre(nombre);
		setApellidos(apellidos);
		setNumeroIdentificacion(numeroIdentificacion);
		setTelefono(telefono);
		setCorreo(correo);
		setClave(clave);
		setPuntuacion(puntuacion);
		setPerfil(perfil);
	}
	
	public static UsuarioEntidad crear(int codigo, String nombre, String apellidos, long numeroIdentificacion, long telefono, String correo, String clave, int puntuacion, PerfilEntidad perfil)
	{
		return new UsuarioEntidad(codigo, nombre, apellidos, numeroIdentificacion, telefono, correo, clave, puntuacion, perfil);
	}
	
	public static UsuarioEntidad crear()
	{
		return new UsuarioEntidad(0, UtilTexto.BLANCO, UtilTexto.BLANCO, 0, 0, UtilTexto.BLANCO, UtilTexto.BLANCO, 0, PerfilEntidad.crear());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public UsuarioEntidad setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public UsuarioEntidad setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}

	public String getApellidos() 
	{
		return apellidos;
	}

	public UsuarioEntidad setApellidos(String apellidos) 
	{
		this.apellidos = UtilTexto.aplicarTrim(apellidos);
		return this;
	}

	public long getNumeroIdentificacion() 
	{
		return numeroIdentificacion;
	}

	public UsuarioEntidad setNumeroIdentificacion(long numeroIdentificacion) 
	{
		this.numeroIdentificacion = numeroIdentificacion;
		return this;
	}

	public long getTelefono() 
	{
		return telefono;
	}

	public UsuarioEntidad setTelefono(long telefono) 
	{
		this.telefono = telefono;
		return this;
	}

	public String getCorreo() 
	{
		return correo;
	}

	public UsuarioEntidad setCorreo(String correo) 
	{
		this.correo = UtilTexto.aplicarTrim(correo);
		return this;
	}

	public String getClave() 
	{
		return clave;
	}

	public UsuarioEntidad setClave(String clave) 
	{
		this.clave = UtilTexto.aplicarTrim(clave);
		return this;
	}

	public int getPuntuacion() 
	{
		return puntuacion;
	}

	public UsuarioEntidad setPuntuacion(int puntuacion) 
	{
		this.puntuacion = puntuacion;
		return this;
	}

	public PerfilEntidad getPerfil() 
	{
		return perfil;
	}

	public UsuarioEntidad setPerfil(PerfilEntidad perfil) 
	{
		this.perfil = perfil;
		return this;
	}
}
