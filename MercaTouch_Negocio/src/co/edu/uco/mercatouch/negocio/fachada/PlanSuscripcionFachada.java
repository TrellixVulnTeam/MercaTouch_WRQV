package co.edu.uco.mercatouch.negocio.fachada;

import java.util.List;
import org.springframework.stereotype.Component;
import co.edu.uco.mercatouch.dto.PlanSuscripcionDTO;

@Component
public interface PlanSuscripcionFachada 
{
	List<PlanSuscripcionDTO> consultar(PlanSuscripcionDTO planSuscripcionDTO);
	void registrar(PlanSuscripcionDTO planSuscripcionDTO);
	void modificar(PlanSuscripcionDTO planSuscripcionDTO);
	void eliminar(PlanSuscripcionDTO planSuscripcionDTO);
}