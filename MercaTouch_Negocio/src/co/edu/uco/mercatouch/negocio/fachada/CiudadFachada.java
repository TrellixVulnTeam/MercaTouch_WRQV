package co.edu.uco.mercatouch.negocio.fachada;

import java.util.List;
import org.springframework.stereotype.Component;
import co.edu.uco.mercatouch.dto.CiudadDTO;

@Component
public interface CiudadFachada 
{
	List<CiudadDTO> consultar(CiudadDTO ciudadDTO);
}
