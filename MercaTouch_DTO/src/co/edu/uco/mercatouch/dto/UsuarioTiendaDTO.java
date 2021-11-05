package co.edu.uco.mercatouch.dto;

public class UsuarioTiendaDTO 
{
	private int codigo;
	private UsuarioDTO usuario;
	TiendaDTO tienda;
	
	public UsuarioTiendaDTO()
	{
		
	}
	
	private UsuarioTiendaDTO(int codigo, UsuarioDTO usuario, TiendaDTO tienda) 
	{
		setCodigo(codigo);
		setUsuario(usuario);
		setTienda(tienda);
	}
	
	public static UsuarioTiendaDTO crear(int codigo, UsuarioDTO usuario, TiendaDTO tienda)
	{
		return new UsuarioTiendaDTO(codigo, usuario, tienda);
	}
	
	public static UsuarioTiendaDTO crear()
	{
		return new UsuarioTiendaDTO(0, UsuarioDTO.crear(), TiendaDTO.crear());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public UsuarioTiendaDTO setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public UsuarioDTO getUsuario() 
	{
		return usuario;
	}

	public UsuarioTiendaDTO setUsuario(UsuarioDTO usuario) 
	{
		this.usuario = usuario;
		return this;
	}

	public TiendaDTO getTienda() 
	{
		return tienda;
	}

	public UsuarioTiendaDTO setTienda(TiendaDTO tienda) 
	{
		this.tienda = tienda;
		return this;
	}
}