package co.edu.uco.mercatouch.negocio;

import java.util.List;
import co.edu.uco.mercatouch.entidad.UsuarioEntidad;
import co.edu.uco.mercatouch.negocio.dominio.UsuarioDominio;

public interface UsuarioNegocio 
{
	List<UsuarioDominio> consultar(UsuarioEntidad usuarioEntidad);
	void registrar(UsuarioDominio usuarioDominio);
	void modificar(UsuarioDominio usuarioDominio);
	void eliminar(UsuarioDominio usuarioDominio);
}