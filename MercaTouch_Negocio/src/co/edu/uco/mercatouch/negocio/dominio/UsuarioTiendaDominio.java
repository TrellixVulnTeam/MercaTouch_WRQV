package co.edu.uco.mercatouch.negocio.dominio;

public class UsuarioTiendaDominio 
{
	private int codigo;
	private UsuarioDominio usuario;
	private TiendaDominio tienda;
	
	private UsuarioTiendaDominio(int codigo, UsuarioDominio usuario, TiendaDominio tienda) 
	{
		this.codigo = codigo;
		this.usuario = usuario;
		this.tienda = tienda;
	}
	
	public static UsuarioTiendaDominio crear(int codigo, UsuarioDominio usuario, TiendaDominio tienda)
	{
		return new UsuarioTiendaDominio(codigo, usuario, tienda);
	}
	
	public static UsuarioTiendaDominio crear()
	{
		return new UsuarioTiendaDominio(0, UsuarioDominio.crear(), TiendaDominio.crear());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public UsuarioTiendaDominio setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public UsuarioDominio getUsuario() 
	{
		return usuario;
	}

	public UsuarioTiendaDominio setUsuario(UsuarioDominio usuario) 
	{
		this.usuario = usuario;
		return this;
	}

	public TiendaDominio getTienda() 
	{
		return tienda;
	}

	public UsuarioTiendaDominio setTienda(TiendaDominio tienda) 
	{
		this.tienda = tienda;
		return this;
	}
}