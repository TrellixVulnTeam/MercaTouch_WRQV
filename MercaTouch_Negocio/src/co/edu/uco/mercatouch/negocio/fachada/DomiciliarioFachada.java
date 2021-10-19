package co.edu.uco.mercatouch.negocio.fachada;

import java.util.List;
import co.edu.uco.mercatouch.dto.DomiciliarioDTO;

public interface DomiciliarioFachada 
{
	List<DomiciliarioDTO> consultar(DomiciliarioDTO domiciliarioDTO);
	void registrar(DomiciliarioDTO domiciliarioDTO);
	void modificar(DomiciliarioDTO domiciliarioDTO);
	void eliminar(DomiciliarioDTO domiciliarioDTO);
}