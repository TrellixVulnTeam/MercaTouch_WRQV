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

@Entity
@Table(name = "usuariotienda", schema = "public")
public class UsuarioTiendaEntidad 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="usuariotienda_codigo_seq")
	@SequenceGenerator(name="usuariotienda_codigo_seq", sequenceName="usuariotienda_codigo_seq", allocationSize=1)
    @Column(name = "codigo")
	private int codigo;
	@OneToOne
	@JoinColumn(name="usuario")
	private UsuarioEntidad usuario;
	@OneToOne
	@JoinColumn(name="tienda")
	private TiendaEntidad tienda;
	
	public UsuarioTiendaEntidad()
	{
		
	}
	
	private UsuarioTiendaEntidad(int codigo, UsuarioEntidad usuario, TiendaEntidad tienda) 
	{
		setCodigo(codigo);
		setUsuario(usuario);
		setTienda(tienda);
	}
	
	public static UsuarioTiendaEntidad crear(int codigo, UsuarioEntidad usuario, TiendaEntidad tienda)
	{
		return new UsuarioTiendaEntidad(codigo, usuario, tienda);
	}
	
	public static UsuarioTiendaEntidad crear()
	{
		return new UsuarioTiendaEntidad(0, UsuarioEntidad.crear(), TiendaEntidad.crear());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public UsuarioTiendaEntidad setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public UsuarioEntidad getUsuario() 
	{
		return usuario;
	}

	public UsuarioTiendaEntidad setUsuario(UsuarioEntidad usuario) 
	{
		this.usuario = usuario;
		return this;
	}

	public TiendaEntidad getTienda() 
	{
		return tienda;
	}

	public UsuarioTiendaEntidad setTienda(TiendaEntidad tienda) 
	{
		this.tienda = tienda;
		return this;
	}
}