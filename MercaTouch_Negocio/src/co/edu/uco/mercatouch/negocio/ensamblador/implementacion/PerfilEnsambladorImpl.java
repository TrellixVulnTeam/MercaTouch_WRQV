package co.edu.uco.mercatouch.negocio.ensamblador.implementacion;

import java.util.List;
import java.util.stream.Collectors;
import co.edu.uco.mercatouch.dto.PerfilDTO;
import co.edu.uco.mercatouch.entidad.PerfilEntidad;
import co.edu.uco.mercatouch.negocio.dominio.PerfilDominio;
import co.edu.uco.mercatouch.negocio.ensamblador.PerfilEnsamblador;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilObjeto;

public class PerfilEnsambladorImpl implements PerfilEnsamblador
{
	private static final PerfilEnsamblador INSTANCIA = new PerfilEnsambladorImpl();

	private PerfilEnsambladorImpl()
	{
		
	}
	
	public static PerfilEnsamblador obtenerPerfilEnsamblador()
	{
		return INSTANCIA;
	}
	
	@Override
	public PerfilDominio ensamblarDominioDesdeEntidad(PerfilEntidad entidad) 
	{
		if(UtilObjeto.esNulo(entidad))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un Dominio de Perfil a partir de una entidad de un Perfil que esta nulo");
		}
		
		return PerfilDominio.crear(entidad.getCodigo(), entidad.getNombre());
	}

	@Override
	public List<PerfilDominio> ensamblarDominiosDesdeEntidad(List<PerfilEntidad> entidades) 
	{
		return entidades.stream().map(obtenerPerfilEnsamblador()::ensamblarDominioDesdeEntidad).collect(Collectors.toList());
	}

	@Override
	public PerfilEntidad ensamblarEntidadDesdeDominio(PerfilDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar una Entidad de Perfil a partir de un dominio de un Perfil que esta nulo");
		}
		
		return PerfilEntidad.crear(dominio.getCodigo(), dominio.getNombre());
	}

	@Override
	public List<PerfilEntidad> ensamblarEntidadesDesdeDominio(List<PerfilDominio> dominios) 
	{
		return dominios.stream().map(obtenerPerfilEnsamblador()::ensamblarEntidadDesdeDominio).collect(Collectors.toList());
	}

	@Override
	public PerfilDominio ensamblarDominioDesdeDTO(PerfilDTO dto) 
	{
		if(UtilObjeto.esNulo(dto))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un Dominio de Perfil a partir de un DTO de un Perfil que esta nulo");
		}
		
		return PerfilDominio.crear(dto.getCodigo(), dto.getNombre());
	}

	@Override
	public List<PerfilDominio> ensamblarDominiosDesdeDTO(List<PerfilDTO> dtos) 
	{
		return dtos.stream().map(obtenerPerfilEnsamblador()::ensamblarDominioDesdeDTO).collect(Collectors.toList());
	}

	@Override
	public PerfilDTO ensamblarDTODesdeDominio(PerfilDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un DTO de Perfil a partir de un Dominio de un Perfil que esta nulo");
		}
		
		return PerfilDTO.crear(dominio.getCodigo(), dominio.getNombre());
	}

	@Override
	public List<PerfilDTO> ensamblarDTOsDesdeDominio(List<PerfilDominio> dominios) 
	{
		return dominios.stream().map(obtenerPerfilEnsamblador()::ensamblarDTODesdeDominio).collect(Collectors.toList());
	}
}