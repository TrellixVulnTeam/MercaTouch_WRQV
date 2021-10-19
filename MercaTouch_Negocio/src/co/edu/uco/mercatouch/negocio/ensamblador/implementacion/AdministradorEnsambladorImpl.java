package co.edu.uco.mercatouch.negocio.ensamblador.implementacion;

import java.util.List;
import java.util.stream.Collectors;
import co.edu.uco.mercatouch.dto.AdministradorDTO;
import co.edu.uco.mercatouch.entidad.AdministradorEntidad;
import co.edu.uco.mercatouch.negocio.dominio.AdministradorDominio;
import co.edu.uco.mercatouch.negocio.ensamblador.AdministradorEnsamblador;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilObjeto;

public class AdministradorEnsambladorImpl  implements AdministradorEnsamblador
{
	private static final AdministradorEnsamblador INSTANCIA = new AdministradorEnsambladorImpl();

	private AdministradorEnsambladorImpl()
	{
		
	}
	
	public static AdministradorEnsamblador obtenerAdministradorEnsamblador()
	{
		return INSTANCIA;
	}

	@Override
	public AdministradorDominio ensamblarDominioDesdeEntidad(AdministradorEntidad entidad) 
	{
		if(UtilObjeto.esNulo(entidad))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un Dominio de Administrador a partir de una entidad de un Administrador que esta nulo");
		}
		
		return AdministradorDominio.crear(entidad.getCodigo(), entidad.getNombre(), entidad.getApellidos(), entidad.getNumeroIdentificacion(), entidad.getTelefono(), entidad.getCorreo(), entidad.getClave(), TiendaEnsambladorImpl.obtenerTiendaEnsamblador().ensamblarDominiosDesdeEntidad(entidad.getTiendas()));
	}

	@Override
	public List<AdministradorDominio> ensamblarDominiosDesdeEntidad(List<AdministradorEntidad> entidades) 
	{
		return entidades.stream().map(obtenerAdministradorEnsamblador()::ensamblarDominioDesdeEntidad).collect(Collectors.toList());
	}

	@Override
	public AdministradorEntidad ensamblarEntidadDesdeDominio(AdministradorDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar una Entidad de Administrador a partir de un dominio de un Administrador que esta nulo");
		}
		
		return AdministradorEntidad.crear(dominio.getCodigo(), dominio.getNombre(), dominio.getApellidos(), dominio.getNumeroIdentificacion(), dominio.getTelefono(), dominio.getCorreo(), dominio.getClave(), TiendaEnsambladorImpl.obtenerTiendaEnsamblador().ensamblarEntidadesDesdeDominio(dominio.getTiendas()));
	}

	@Override
	public List<AdministradorEntidad> ensamblarEntidadesDesdeDominio(List<AdministradorDominio> dominios) 
	{
		return dominios.stream().map(obtenerAdministradorEnsamblador()::ensamblarEntidadDesdeDominio).collect(Collectors.toList());
	}

	@Override
	public AdministradorDominio ensamblarDominioDesdeDTO(AdministradorDTO dto) 
	{
		if(UtilObjeto.esNulo(dto))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un Dominio de Administrador a partir de un DTO de un Administrador que esta nulo");
		}
		
		return AdministradorDominio.crear(dto.getCodigo(), dto.getNombre(), dto.getApellidos(), dto.getNumeroIdentificacion(), dto.getTelefono(), dto.getCorreo(), dto.getClave(), TiendaEnsambladorImpl.obtenerTiendaEnsamblador().ensamblarDominiosDesdeDTO(dto.getTiendas()));
	}

	@Override
	public List<AdministradorDominio> ensamblarDominiosDesdeDTO(List<AdministradorDTO> dtos) 
	{
		return dtos.stream().map(obtenerAdministradorEnsamblador()::ensamblarDominioDesdeDTO).collect(Collectors.toList());
	}

	@Override
	public AdministradorDTO ensamblarDTODesdeDominio(AdministradorDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un DTO de Administrador a partir de un Dominio de un Administrador que esta nulo");
		}
		
		return AdministradorDTO.crear(dominio.getCodigo(), dominio.getNombre(), dominio.getApellidos(), dominio.getNumeroIdentificacion(), dominio.getTelefono(), dominio.getCorreo(), dominio.getClave(), TiendaEnsambladorImpl.obtenerTiendaEnsamblador().ensamblarDTOsDesdeDominio(dominio.getTiendas()));
	}

	@Override
	public List<AdministradorDTO> ensamblarDTOsDesdeDominio(List<AdministradorDominio> dominios) 
	{
		return dominios.stream().map(obtenerAdministradorEnsamblador()::ensamblarDTODesdeDominio).collect(Collectors.toList());
	}
}