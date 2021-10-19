package co.edu.uco.mercatouch.negocio;

import java.util.List;
import co.edu.uco.mercatouch.entidad.AdministradorEntidad;
import co.edu.uco.mercatouch.negocio.dominio.AdministradorDominio;

public interface AdministradorNegocio 
{
	List<AdministradorDominio> consultar(AdministradorEntidad administradorEntidad);
	void registrar(AdministradorDominio administradorDominio);
	void modificar(AdministradorDominio administradorDominio);
	void eliminar(AdministradorDominio administradorDominio);
}