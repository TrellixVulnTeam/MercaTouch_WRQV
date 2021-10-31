package co.edu.uco.mercatouch.negocio.negocio;

import java.util.List;
import org.springframework.stereotype.Component;
import co.edu.uco.mercatouch.negocio.dominio.AdministradorDominio;

@Component
public interface AdministradorNegocio 
{
	List<AdministradorDominio> consultar(AdministradorDominio administradorDominio);
	void registrar(AdministradorDominio administradorDominio);
	void modificar(AdministradorDominio administradorDominio);
	void eliminar(AdministradorDominio administradorDominio);
}