package co.edu.uco.mercatouch.negocio;

import java.util.List;
import co.edu.uco.mercatouch.entidad.TiendaEntidad;
import co.edu.uco.mercatouch.negocio.dominio.TiendaDominio;

public interface TiendaNegocio 
{
	List<TiendaDominio> consultar(TiendaEntidad tiendaEntidad);
	void registrar(TiendaDominio tiendaDominio);
	void modificar(TiendaDominio tiendaDominio);
	void eliminar(TiendaDominio tiendaDominio);
}