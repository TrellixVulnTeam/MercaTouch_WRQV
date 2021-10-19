package co.edu.uco.mercatouch.negocio;

import java.util.List;
import co.edu.uco.mercatouch.entidad.DomiciliarioEntidad;
import co.edu.uco.mercatouch.negocio.dominio.DomiciliarioDominio;

public interface DomiciliarioNegocio 
{
	List<DomiciliarioDominio> consultar(DomiciliarioEntidad domiciliarioEntidad);
	void registrar(DomiciliarioDominio domiciliarioDominio);
	void modificar(DomiciliarioDominio domiciliarioDominio);
	void eliminar(DomiciliarioDominio domiciliarioDominio);
}