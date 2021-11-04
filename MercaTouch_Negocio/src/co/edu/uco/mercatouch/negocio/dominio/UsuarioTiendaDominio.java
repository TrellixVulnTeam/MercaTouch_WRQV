package co.edu.uco.mercatouch.negocio.dominio;

import java.util.ArrayList;
import java.util.List;

public class UsuarioTiendaDominio 
{
	private int codigo;
	private UsuarioDominio usuario;
	private List<TiendaDominio> tiendas;
	
	private UsuarioTiendaDominio(int codigo, UsuarioDominio usuario, List<TiendaDominio> tiendas) 
	{
		this.codigo = codigo;
		this.usuario = usuario;
		this.tiendas = tiendas;
	}
	
	public static UsuarioTiendaDominio crear(int codigo, UsuarioDominio usuario, List<TiendaDominio> tiendas)
	{
		return new UsuarioTiendaDominio(codigo, usuario, tiendas);
	}
	
	public static UsuarioTiendaDominio crear()
	{
		return new UsuarioTiendaDominio(0, UsuarioDominio.crear(), new ArrayList<>());
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

	public List<TiendaDominio> getTiendas() 
	{
		return tiendas;
	}

	public UsuarioTiendaDominio setTiendas(List<TiendaDominio> tiendas) 
	{
		this.tiendas = tiendas;
		return this;
	}
}