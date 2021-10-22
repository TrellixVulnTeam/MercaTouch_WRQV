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
		validarNombreVacio(dato.getRutaLogo());
		validarLongitudNombreValida(dato.getRutaLogo());
		validarPatronDeLaRuta(dato.getRutaLogo());
	}
	
	private void validarNombreVacio(String nombre)
	{
		if (UtilTexto.cadenaEstaVacia(nombre))
		{
			throw new MercaTouchNegocioExcepcion("La ruta del logo de una tienda no puede estar vacio");
		}
	}
		
	private void validarLongitudNombreValida(String nombre)
	{
		if(!UtilTexto.longitudEsValida(nombre, 1, 500))
		{
			throw new MercaTouchNegocioExcepcion("La ruta del logo de una tienda debe tener minimo un caracter y maximo 50 caracteres");
		}
	}
		
	private void validarPatronDeLaRuta(String nombre)
	{
		if(!UtilTexto.cadenaURL(nombre))
		{
			throw new MercaTouchNegocioExcepcion("La ruta del logo de una tienda tiene el patron incorrecto");
		}
	}
}
