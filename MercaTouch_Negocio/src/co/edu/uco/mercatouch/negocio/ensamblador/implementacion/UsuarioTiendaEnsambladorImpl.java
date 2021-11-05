package co.edu.uco.mercatouch.negocio.ensamblador.implementacion;

import java.util.List;
import java.util.stream.Collectors;
import co.edu.uco.mercatouch.dto.UsuarioTiendaDTO;
import co.edu.uco.mercatouch.entidad.UsuarioTiendaEntidad;
import co.edu.uco.mercatouch.negocio.dominio.UsuarioTiendaDominio;
import co.edu.uco.mercatouch.negocio.ensamblador.UsuarioTiendaEnsamblador;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilObjeto;

public class UsuarioTiendaEnsambladorImpl implements UsuarioTiendaEnsamblador
{
	private static final UsuarioTiendaEnsamblador INSTANCIA = new UsuarioTiendaEnsambladorImpl();

	private UsuarioTiendaEnsambladorImpl()
	{
		
	}
	
	public static UsuarioTiendaEnsamblador obtenerUsuarioTiendaEnsamblador()
	{
		return INSTANCIA;
	}
	
	@Override
	public UsuarioTiendaDominio ensamblarDominioDesdeEntidad(UsuarioTiendaEntidad entidad) 
	{
		if(UtilObjeto.esNulo(entidad))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un Dominio de UsuarioTienda a partir de una entidad de un UsuarioTienda que esta nulo");
		}
		
		return UsuarioTiendaDominio.crear(entidad.getCodigo(), UsuarioEnsambladorImpl.obtenerUsuarioEnsamblador().ensamblarDominioDesdeEntidad(entidad.getUsuario()), TiendaEnsambladorImpl.obtenerTiendaEnsamblador().ensamblarDominioDesdeEntidad(entidad.getTienda()));
	}

	@Override
	public List<UsuarioTiendaDominio> ensamblarDominiosDesdeEntidad(List<UsuarioTiendaEntidad> entidades) 
	{

		return entidades.stream().map(obtenerUsuarioTiendaEnsamblador()::ensamblarDominioDesdeEntidad).collect(Collectors.toList());
	}

	@Override
	public UsuarioTiendaEntidad ensamblarEntidadDesdeDominio(UsuarioTiendaDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar una Entidad de UsuarioTienda a partir de un dominio de un UsuarioTienda que esta nulo");
		}
		
		return UsuarioTiendaEntidad.crear(dominio.getCodigo(), UsuarioEnsambladorImpl.obtenerUsuarioEnsamblador().ensamblarEntidadDesdeDominio(dominio.getUsuario()), TiendaEnsambladorImpl.obtenerTiendaEnsamblador().ensamblarEntidadDesdeDominio(dominio.getTienda()));
	}

	@Override
	public List<UsuarioTiendaEntidad> ensamblarEntidadesDesdeDominio(List<UsuarioTiendaDominio> dominios) 
	{
		return dominios.stream().map(obtenerUsuarioTiendaEnsamblador()::ensamblarEntidadDesdeDominio).collect(Collectors.toList());
	}

	@Override
	public UsuarioTiendaDominio ensamblarDominioDesdeDTO(UsuarioTiendaDTO dto) 
	{
		if(UtilObjeto.esNulo(dto))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un Dominio de UsuarioTienda a partir de un DTO de un UsuarioTienda que esta nulo");
		}
		
		return UsuarioTiendaDominio.crear(dto.getCodigo(), UsuarioEnsambladorImpl.obtenerUsuarioEnsamblador().ensamblarDominioDesdeDTO(dto.getUsuario()), TiendaEnsambladorImpl.obtenerTiendaEnsamblador().ensamblarDominioDesdeDTO(dto.getTienda()));
	}

	@Override
	public List<UsuarioTiendaDominio> ensamblarDominiosDesdeDTO(List<UsuarioTiendaDTO> dtos) 
	{
		return dtos.stream().map(obtenerUsuarioTiendaEnsamblador()::ensamblarDominioDesdeDTO).collect(Collectors.toList());
	}

	@Override
	public UsuarioTiendaDTO ensamblarDTODesdeDominio(UsuarioTiendaDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un DTO de UsuarioTienda a partir de un Dominio de un UsuarioTienda que esta nulo");
		}
		
		return UsuarioTiendaDTO.crear(dominio.getCodigo(), UsuarioEnsambladorImpl.obtenerUsuarioEnsamblador().ensamblarDTODesdeDominio(dominio.getUsuario()), TiendaEnsambladorImpl.obtenerTiendaEnsamblador().ensamblarDTODesdeDominio(dominio.getTienda()));
	}

	@Override
	public List<UsuarioTiendaDTO> ensamblarDTOsDesdeDominio(List<UsuarioTiendaDominio> dominios) 
	{
		return dominios.stream().map(obtenerUsuarioTiendaEnsamblador()::ensamblarDTODesdeDominio).collect(Collectors.toList());
	}
}
