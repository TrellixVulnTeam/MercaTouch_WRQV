package co.edu.uco.mercatouch.negocio.fachada;

import java.util.List;
import org.springframework.stereotype.Component;
import co.edu.uco.mercatouch.dto.DomiciliarioDTO;

@Component
public interface DomiciliarioFachada 
{
	List<DomiciliarioDTO> consultar(DomiciliarioDTO domiciliarioDTO);
	void registrar(DomiciliarioDTO domiciliarioDTO);
	void modificar(DomiciliarioDTO domiciliarioDTO);
	void eliminar(DomiciliarioDTO domiciliarioDTO);
}