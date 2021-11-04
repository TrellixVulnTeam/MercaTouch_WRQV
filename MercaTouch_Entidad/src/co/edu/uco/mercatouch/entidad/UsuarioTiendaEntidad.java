package co.edu.uco.mercatouch.entidad;

import java.util.ArrayList;
import java.util.List;

public class UsuarioTiendaEntidad 
{
	private int codigo;
	private UsuarioEntidad usuario;
	private List<TiendaEntidad> tiendas;
	
	private UsuarioTiendaEntidad(int codigo, UsuarioEntidad usuario, List<TiendaEntidad> tiendas) 
	{
		this.codigo = codigo;
		this.usuario = usuario;
		this.tiendas = tiendas;
	}
	
	public static UsuarioTiendaEntidad crear(int codigo, UsuarioEntidad usuario, List<TiendaEntidad> tiendas)
	{
		return new UsuarioTiendaEntidad(codigo, usuario, tiendas);
	}
	
	public static UsuarioTiendaEntidad crear()
	{
		return new UsuarioTiendaEntidad(0, UsuarioEntidad.crear(), new ArrayList<>());
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

	public List<TiendaEntidad> getTiendas() 
	{
		return tiendas;
	}

	public UsuarioTiendaEntidad setTiendas(List<TiendaEntidad> tiendas) 
	{
		this.tiendas = tiendas;
		return this;
	}
}