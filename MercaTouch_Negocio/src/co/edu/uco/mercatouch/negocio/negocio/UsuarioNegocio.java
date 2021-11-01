package co.edu.uco.mercatouch.negocio.negocio;

import java.util.List;
import org.springframework.stereotype.Component;
import co.edu.uco.mercatouch.negocio.dominio.UsuarioDominio;

@Component
public interface UsuarioNegocio 
{
	List<UsuarioDominio> consultar(UsuarioDominio usuarioDominio);
	void registrar(UsuarioDominio usuarioDominio);
	void modificar(UsuarioDominio usuarioDominio);
	void eliminar(UsuarioDominio usuarioDominio);
	boolean verificarCredenciales(UsuarioDominio usuarioDominio);
}