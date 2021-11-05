package co.edu.uco.mercatouch.negocio.negocio;

import java.util.List;
import org.springframework.stereotype.Component;
import co.edu.uco.mercatouch.negocio.dominio.PlanSuscripcionDominio;

@Component
public interface PlanSuscripcionNegocio 
{
	List<PlanSuscripcionDominio> consultar(PlanSuscripcionDominio planSuscripcionDominio);
	void registrar(PlanSuscripcionDominio planSuscripcionDominio);
	void modificar(PlanSuscripcionDominio planSuscripcionDominio);
	void eliminar(PlanSuscripcionDominio planSuscripcionDominio);
}