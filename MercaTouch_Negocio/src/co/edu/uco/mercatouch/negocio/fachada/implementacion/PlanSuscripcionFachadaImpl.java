package co.edu.uco.mercatouch.negocio.fachada.implementacion;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uco.mercatouch.dto.PlanSuscripcionDTO;
import co.edu.uco.mercatouch.negocio.dominio.PlanSuscripcionDominio;
import co.edu.uco.mercatouch.negocio.ensamblador.implementacion.PlanSuscripcionEnsambladorImpl;
import co.edu.uco.mercatouch.negocio.fachada.PlanSuscripcionFachada;
import co.edu.uco.mercatouch.negocio.negocio.PlanSuscripcionNegocio;

@Service
@Transactional
public class PlanSuscripcionFachadaImpl implements PlanSuscripcionFachada 
{
	@Autowired
	PlanSuscripcionNegocio planSuscripcionNegocio;
	
	@Override
	public List<PlanSuscripcionDTO> consultar(PlanSuscripcionDTO planSuscripcionDTO) 
	{
		List<PlanSuscripcionDominio> planesSuscripcionDominio = planSuscripcionNegocio.consultar(PlanSuscripcionEnsambladorImpl.obtenerPlanSuscripcionEnsamblador().ensamblarDominioDesdeDTO(planSuscripcionDTO));
		return PlanSuscripcionEnsambladorImpl.obtenerPlanSuscripcionEnsamblador().ensamblarDTOsDesdeDominio(planesSuscripcionDominio);
	}

	@Override
	public void registrar(PlanSuscripcionDTO planSuscripcionDTO) 
	{
		PlanSuscripcionDominio planSuscripcionDominio = PlanSuscripcionEnsambladorImpl.obtenerPlanSuscripcionEnsamblador().ensamblarDominioDesdeDTO(planSuscripcionDTO);
		planSuscripcionNegocio.registrar(planSuscripcionDominio);
	}

	@Override
	public void modificar(PlanSuscripcionDTO planSuscripcionDTO) 
	{
		PlanSuscripcionDominio planSuscripcionDominio = PlanSuscripcionEnsambladorImpl.obtenerPlanSuscripcionEnsamblador().ensamblarDominioDesdeDTO(planSuscripcionDTO);
		planSuscripcionNegocio.modificar(planSuscripcionDominio);
	}

	@Override
	public void eliminar(PlanSuscripcionDTO planSuscripcionDTO) 
	{
		PlanSuscripcionDominio planSuscripcionDominio = PlanSuscripcionEnsambladorImpl.obtenerPlanSuscripcionEnsamblador().ensamblarDominioDesdeDTO(planSuscripcionDTO);
		planSuscripcionNegocio.eliminar(planSuscripcionDominio);
	}
}