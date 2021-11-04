package co.edu.uco.mercatouch.negocio.fachada;

import java.util.List;
import org.springframework.stereotype.Component;
import co.edu.uco.mercatouch.dto.UsuarioTiendaDTO;

@Component
public interface UsuarioTiendaFachada 
{
	List<UsuarioTiendaDTO> consultar(UsuarioTiendaDTO usuarioTiendanDTO);
	void registrar(UsuarioTiendaDTO usuarioTiendanDTO);
	void modificar(UsuarioTiendaDTO usuarioTiendanDTO);
	void eliminar(UsuarioTiendaDTO usuarioTiendanDTO);
}
