package co.edu.uco.mercatouch.negocio.ensamblador.implementacion;

import java.util.List;
import java.util.stream.Collectors;
import co.edu.uco.mercatouch.dto.PlanSuscripcionDTO;
import co.edu.uco.mercatouch.entidad.PlanSuscripcionEntidad;
import co.edu.uco.mercatouch.negocio.dominio.PlanSuscripcionDominio;
import co.edu.uco.mercatouch.negocio.ensamblador.PlanSuscripcionEnsamblador;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilObjeto;

public class PlanSuscripcionEnsambladorImpl implements PlanSuscripcionEnsamblador
{
	private static final PlanSuscripcionEnsamblador INSTANCIA = new PlanSuscripcionEnsambladorImpl();

	private PlanSuscripcionEnsambladorImpl()
	{
		
	}
	
	public static PlanSuscripcionEnsamblador obtenerPlanSuscripcionEnsamblador()
	{
		return INSTANCIA;
	}

	@Override
	public PlanSuscripcionDominio ensamblarDominioDesdeEntidad(PlanSuscripcionEntidad entidad) 
	{
		if(UtilObjeto.esNulo(entidad))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un Dominio de PlanSuscripcion a partir de una entidad de un PlanSuscripcion que esta nulo");
		}
		
		return PlanSuscripcionDominio.crear(entidad.getCodigo(), entidad.getNombre(), entidad.getDescripcion(), entidad.getPrecio(), entidad.getTiempoSuscripcion());
	}

	@Override
	public List<PlanSuscripcionDominio> ensamblarDominiosDesdeEntidad(List<PlanSuscripcionEntidad> entidades) 
	{
		return entidades.stream().map(obtenerPlanSuscripcionEnsamblador()::ensamblarDominioDesdeEntidad).collect(Collectors.toList());
	}

	@Override
	public PlanSuscripcionEntidad ensamblarEntidadDesdeDominio(PlanSuscripcionDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar una Entidad de PlanSuscripcion a partir de un dominio de un PlanSuscripcion que esta nulo");
		}
		
		return PlanSuscripcionEntidad.crear(dominio.getCodigo(), dominio.getNombre(), dominio.getDescripcion(), dominio.getPrecio(), dominio.getTiempoSuscripcion());
	}

	@Override
	public List<PlanSuscripcionEntidad> ensamblarEntidadesDesdeDominio(List<PlanSuscripcionDominio> dominios) 
	{
		return dominios.stream().map(obtenerPlanSuscripcionEnsamblador()::ensamblarEntidadDesdeDominio).collect(Collectors.toList());
	}

	@Override
	public PlanSuscripcionDominio ensamblarDominioDesdeDTO(PlanSuscripcionDTO dto) 
	{
		if(UtilObjeto.esNulo(dto))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un Dominio de PlanSuscripcion a partir de un DTO de un PlanSuscripcion que esta nulo");
		}
		
		return PlanSuscripcionDominio.crear(dto.getCodigo(), dto.getNombre(), dto.getDescripcion(), dto.getPrecio(), dto.getTiempoSuscripcion());
	}

	@Override
	public List<PlanSuscripcionDominio> ensamblarDominiosDesdeDTO(List<PlanSuscripcionDTO> dtos) 
	{
		return dtos.stream().map(obtenerPlanSuscripcionEnsamblador()::ensamblarDominioDesdeDTO).collect(Collectors.toList());
	}

	@Override
	public PlanSuscripcionDTO ensamblarDTODesdeDominio(PlanSuscripcionDominio dominio) 
	{
		if(UtilObjeto.esNulo(dominio))
		{
			throw new MercaTouchNegocioExcepcion("No es posible ensamblar un DTO de PlanSuscripcion a partir de un Dominio de un PlanSuscripcion que esta nulo");
		}
		
		return PlanSuscripcionDTO.crear(dominio.getCodigo(), dominio.getNombre(), dominio.getDescripcion(), dominio.getPrecio(), dominio.getTiempoSuscripcion());
	}

	@Override
	public List<PlanSuscripcionDTO> ensamblarDTOsDesdeDominio(List<PlanSuscripcionDominio> dominios) 
	{
		return dominios.stream().map(obtenerPlanSuscripcionEnsamblador()::ensamblarDTODesdeDominio).collect(Collectors.toList());
	}
}