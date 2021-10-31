package co.edu.uco.mercatouch.negocio.ensamblador.implementacion;

import java.util.List;
import java.util.stream.Collectors;
import co.edu.uco.mercatouch.dto.UsuarioDTO;
import co.edu.uco.mercatouch.entidad.UsuarioEntidad;
import co.edu.uco.mercatouch.negocio.dominio.UsuarioDominio;
import co.edu.uco.mercatouch.negocio.ensamblador.UsuarioEnsamblador;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilObjeto;

public class UsuarioEnsambladorImpl implements UsuarioEnsamblador
{
	private static final UsuarioEnsamblador INSTANCIA = new UsuarioEnsambladorImpl();

	private UsuarioEnsambladorImpl()
	{
		
	}
	
	public static UsuarioEnsamblador obtenerUsuarioEnsamblador()
	{
		return INSTANCIA;
	}

	@Override
	public UsuarioDominio ensamblarDominioDesdeEntidad(UsuarioEntidad entidad) 
	{
		if(UtilObjeto.esNulo(entidad))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un Dominio de Usuario a partir de una entidad de un Usuario que esta nulo");
		}
		
		return UsuarioDominio.crear(entidad.getCodigo(), entidad.getNombre(), entidad.getApellidos(), entidad.getNumeroIdentificacion(), entidad.getTelefono(), entidad.getCorreo(), entidad.getClave(), entidad.getPuntuacion());
	}

	@Override
	public List<UsuarioDominio> ensamblarDominiosDesdeEntidad(List<UsuarioEntidad> entidades) 
	{
		return entidades.stream().map(obtenerUsuarioEnsamblador()::ensamblarDominioDesdeEntidad).collect(Collectors.toList());
	}

	@Override
	public UsuarioEntidad ensamblarEntidadDesdeDominio(UsuarioDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar una Entidad de Usuario a partir de un dominio de un Usuario que esta nulo");
		}
		
		return UsuarioEntidad.crear(dominio.getCodigo(), dominio.getNombre(), dominio.getApellidos(), dominio.getNumeroIdentificacion(), dominio.getTelefono(), dominio.getCorreo(), dominio.getClave(), dominio.getPuntuacion());
	}

	@Override
	public List<UsuarioEntidad> ensamblarEntidadesDesdeDominio(List<UsuarioDominio> dominios) 
	{
		return dominios.stream().map(obtenerUsuarioEnsamblador()::ensamblarEntidadDesdeDominio).collect(Collectors.toList());
	}

	@Override
	public UsuarioDominio ensamblarDominioDesdeDTO(UsuarioDTO dto) 
	{
		if(UtilObjeto.esNulo(dto))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un Dominio de Usuario a partir de un DTO de un Usuario que esta nulo");
		}
		
		return UsuarioDominio.crear(dto.getCodigo(), dto.getNombre(), dto.getApellidos(), dto.getNumeroIdentificacion(), dto.getTelefono(), dto.getCorreo(), dto.getClave(), dto.getPuntuacion());
	}

	@Override
	public List<UsuarioDominio> ensamblarDominiosDesdeDTO(List<UsuarioDTO> dtos) 
	{
		return dtos.stream().map(obtenerUsuarioEnsamblador()::ensamblarDominioDesdeDTO).collect(Collectors.toList());
	}

	@Override
	public UsuarioDTO ensamblarDTODesdeDominio(UsuarioDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un DTO de Usuario a partir de un Dominio de un Usuario que esta nulo");
		}
		
		return UsuarioDTO.crear(dominio.getCodigo(), dominio.getNombre(), dominio.getApellidos(), dominio.getNumeroIdentificacion(), dominio.getTelefono(), dominio.getCorreo(), dominio.getClave(), dominio.getPuntuacion());
	}

	@Override
	public List<UsuarioDTO> ensamblarDTOsDesdeDominio(List<UsuarioDominio> dominios) 
	{
		return dominios.stream().map(obtenerUsuarioEnsamblador()::ensamblarDTODesdeDominio).collect(Collectors.toList());
	}
}