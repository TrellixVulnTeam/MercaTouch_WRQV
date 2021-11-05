package co.edu.uco.mercatouch.negocio.validador.implementacion.tienda;

import co.edu.uco.mercatouch.negocio.dominio.TiendaDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class RutaLogoValidoTiendaRegla implements Regla<TiendaDominio>
{
	private static final Regla<TiendaDominio> INSTANCIA = new RutaLogoValidoTiendaRegla();
	
	private RutaLogoValidoTiendaRegla()
	{
		super();
	}
	
	public static Regla<TiendaDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}

	@Override
	public void validar(TiendaDominio dato) 
	{
		validarRutaLogoVacio(dato.getRutaLogo());
		validarLongitudRutaLogoValida(dato.getRutaLogo());
		validarPatronRuta(dato.getRutaLogo());
	}
	
	private void validarRutaLogoVacio(String rutaLogo)
	{
		if (UtilTexto.cadenaEstaVacia(rutaLogo))
		{
			throw new MercaTouchNegocioExcepcion("La ruta del logo de una Tienda no puede estar vacio");
		}
	}
		
	private void validarLongitudRutaLogoValida(String rutaLogo)
	{
		if(!UtilTexto.longitudEsValida(rutaLogo, 1, 500))
		{
			throw new MercaTouchNegocioExcepcion("La ruta del logo de una Tienda debe tener minimo un caracter y maximo 50 caracteres");
		}
	}
		
	private void validarPatronRuta(String rutaLogo)
	{
		if(!UtilTexto.cadenaURL(rutaLogo))
		{
			throw new MercaTouchNegocioExcepcion("La ruta del logo de una Tienda solo puede contener letras y espacios");
		}
	}
}
