package co.edu.uco.mercatouch.negocio.negocio;

import java.util.List;
import org.springframework.stereotype.Component;
import co.edu.uco.mercatouch.negocio.dominio.TiendaDominio;

@Component
public interface TiendaNegocio 
{
	List<TiendaDominio> consultar(TiendaDominio tiendaDominio);
	void registrar(TiendaDominio tiendaDominio);
	void modificar(TiendaDominio tiendaDominio);
	void eliminar(TiendaDominio tiendaDominio);
}