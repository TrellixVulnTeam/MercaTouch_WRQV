package co.edu.uco.mercatouch.negocio.negocio;

import java.util.List;
import org.springframework.stereotype.Component;
import co.edu.uco.mercatouch.negocio.dominio.UsuarioTiendaDominio;

@Component
public interface UsuarioTiendaNegocio 
{
	List<UsuarioTiendaDominio> consultar(UsuarioTiendaDominio usuarioTiendanDominio);
	void registrar(UsuarioTiendaDominio usuarioTiendanDominio);
	void modificar(UsuarioTiendaDominio usuarioTiendanDominio);
	void eliminar(UsuarioTiendaDominio usuarioTiendanDominio);
}
