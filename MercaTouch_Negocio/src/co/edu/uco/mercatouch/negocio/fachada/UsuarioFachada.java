package co.edu.uco.mercatouch.negocio.fachada;

import java.util.List;
import org.springframework.stereotype.Component;
import co.edu.uco.mercatouch.dto.UsuarioDTO;

@Component
public interface UsuarioFachada 
{
	List<UsuarioDTO> consultar(UsuarioDTO usuarioDTO);
	void registrar(UsuarioDTO usuarioDTO);
	void modificar(UsuarioDTO usuarioDTO);
	void eliminar(UsuarioDTO usuarioDTO);
}