package co.edu.uco.mercatouch.negocio.negocio;

import java.util.List;
import org.springframework.stereotype.Component;
import co.edu.uco.mercatouch.negocio.dominio.CiudadDominio;

@Component
public interface CiudadNegocio 
{
	List<CiudadDominio> consultar(CiudadDominio ciudadDominio);
}
