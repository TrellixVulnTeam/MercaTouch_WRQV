package co.edu.uco.mercatouch.dto;

import java.util.ArrayList;
import java.util.List;

public class UsuarioTiendaDTO 
{
	private int codigo;
	private UsuarioDTO usuario;
	private List<TiendaDTO> tiendas;
	
	public UsuarioTiendaDTO()
	{
		
	}
	
	private UsuarioTiendaDTO(int codigo, UsuarioDTO usuario, List<TiendaDTO> tiendas) 
	{
		this.codigo = codigo;
		this.usuario = usuario;
		this.tiendas = tiendas;
	}
	
	public static UsuarioTiendaDTO crear(int codigo, UsuarioDTO usuario, List<TiendaDTO> tiendas)
	{
		return new UsuarioTiendaDTO(codigo, usuario, tiendas);
	}
	
	public static UsuarioTiendaDTO crear()
	{
		return new UsuarioTiendaDTO(0, UsuarioDTO.crear(), new ArrayList<>());
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

	public List<TiendaDTO> getTiendas() 
	{
		return tiendas;
	}

	public UsuarioTiendaDTO setTiendas(List<TiendaDTO> tiendas) 
	{
		this.tiendas = tiendas;
		return this;
	}
}