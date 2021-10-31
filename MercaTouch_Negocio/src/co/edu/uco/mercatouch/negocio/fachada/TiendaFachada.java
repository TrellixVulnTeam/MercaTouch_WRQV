package co.edu.uco.mercatouch.negocio.fachada;

import java.util.List;
import org.springframework.stereotype.Component;
import co.edu.uco.mercatouch.dto.TiendaDTO;

@Component
public interface TiendaFachada 
{
	List<TiendaDTO> consultar(TiendaDTO tiendaDTO);
	void registrar(TiendaDTO tiendaDTO);
	void modificar(TiendaDTO tiendaDTO);
	void eliminar(TiendaDTO tiendaDTO);
}