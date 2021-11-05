package co.edu.uco.mercatouch.negocio.negocio;

import java.util.List;
import org.springframework.stereotype.Component;
import co.edu.uco.mercatouch.negocio.dominio.DepartamentoDominio;

@Component
public interface DepartamentoNegocio 
{
	List<DepartamentoDominio> consultar(DepartamentoDominio departamentoDominio);
}