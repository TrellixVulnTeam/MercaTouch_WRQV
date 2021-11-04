package co.edu.uco.mercatouch.negocio.fachada;

import java.util.List;
import org.springframework.stereotype.Component;
import co.edu.uco.mercatouch.dto.DepartamentoDTO;

@Component
public interface DepartamentoFachada 
{
	List<DepartamentoDTO> consultar(DepartamentoDTO departamentoDTO);
}