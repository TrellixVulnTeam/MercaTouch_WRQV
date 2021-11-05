package co.edu.uco.mercatouch.negocio.negocio;

import java.util.List;
import org.springframework.stereotype.Component;
import co.edu.uco.mercatouch.negocio.dominio.PerfilDominio;

@Component
public interface PerfilNegocio 
{
	List<PerfilDominio> consultar(PerfilDominio perfilDominio);
}
