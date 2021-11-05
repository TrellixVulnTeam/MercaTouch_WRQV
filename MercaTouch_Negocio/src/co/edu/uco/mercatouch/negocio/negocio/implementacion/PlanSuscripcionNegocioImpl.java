package co.edu.uco.mercatouch.negocio.negocio.implementacion;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import co.edu.uco.mercatouch.datos.dao.PlanSuscripcionDAO;
import co.edu.uco.mercatouch.entidad.PlanSuscripcionEntidad;
import co.edu.uco.mercatouch.negocio.dominio.PlanSuscripcionDominio;
import co.edu.uco.mercatouch.negocio.ensamblador.implementacion.PlanSuscripcionEnsambladorImpl;
import co.edu.uco.mercatouch.negocio.negocio.PlanSuscripcionNegocio;
import co.edu.uco.mercatouch.negocio.validador.enumerador.TipoValidacion;
import co.edu.uco.mercatouch.negocio.validador.implementacion.PlanSuscripcionValidador;

public class PlanSuscripcionNegocioImpl implements PlanSuscripcionNegocio 
{
	@Autowired
	private PlanSuscripcionDAO planSuscripcionDAO;
	
	@Override
	public List<PlanSuscripcionDominio> consultar(PlanSuscripcionDominio planSuscripcionDominio) 
	{
		var resultados = planSuscripcionDAO.findAll();
		
		return PlanSuscripcionEnsambladorImpl.obtenerPlanSuscripcionEnsamblador().ensamblarDominiosDesdeEntidad((List<PlanSuscripcionEntidad>) resultados);
	}

	@Override
	public void registrar(PlanSuscripcionDominio planSuscripcionDominio) 
	{
		PlanSuscripcionValidador.obtenerInstancia().validar(planSuscripcionDominio, TipoValidacion.CREACION);
		planSuscripcionDAO.save(PlanSuscripcionEnsambladorImpl.obtenerPlanSuscripcionEnsamblador().ensamblarEntidadDesdeDominio(planSuscripcionDominio));
	}

	@Override
	public void modificar(PlanSuscripcionDominio planSuscripcionDominio) 
	{
		PlanSuscripcionValidador.obtenerInstancia().validar(planSuscripcionDominio, TipoValidacion.ACTUALIZACION);
		planSuscripcionDAO.save(PlanSuscripcionEnsambladorImpl.obtenerPlanSuscripcionEnsamblador().ensamblarEntidadDesdeDominio(planSuscripcionDominio));
	}

	@Override
	public void eliminar(PlanSuscripcionDominio planSuscripcionDominio) 
	{
		PlanSuscripcionValidador.obtenerInstancia().validar(planSuscripcionDominio, TipoValidacion.ELIMINACION);
		planSuscripcionDAO.delete(PlanSuscripcionEnsambladorImpl.obtenerPlanSuscripcionEnsamblador().ensamblarEntidadDesdeDominio(planSuscripcionDominio));
	}
}