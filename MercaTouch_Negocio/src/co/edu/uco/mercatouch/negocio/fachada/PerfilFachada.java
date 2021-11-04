package co.edu.uco.mercatouch.negocio.fachada;

import java.util.List;
import org.springframework.stereotype.Component;
import co.edu.uco.mercatouch.dto.PerfilDTO;

@Component
public interface PerfilFachada 
{
	List<PerfilDTO> consultar(PerfilDTO perfilDTO);
}
