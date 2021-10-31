package co.edu.uco.mercatouch.negocio.negocio;

import java.util.List;
import org.springframework.stereotype.Component;
import co.edu.uco.mercatouch.negocio.dominio.DomiciliarioDominio;

@Component
public interface DomiciliarioNegocio 
{
	List<DomiciliarioDominio> consultar(DomiciliarioDominio domiciliarioDominio);
	void registrar(DomiciliarioDominio domiciliarioDominio);
	void modificar(DomiciliarioDominio domiciliarioDominio);
	void eliminar(DomiciliarioDominio domiciliarioDominio);
}