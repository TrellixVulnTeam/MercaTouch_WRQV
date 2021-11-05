package co.edu.uco.mercatouch.negocio.validador.implementacion.tienda;

import co.edu.uco.mercatouch.negocio.dominio.TiendaDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class DireccionValidoTiendaRegla implements Regla<TiendaDominio>
{
	private static final Regla<TiendaDominio> INSTANCIA = new DireccionValidoTiendaRegla();
	
	private DireccionValidoTiendaRegla()
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
		validarNombreVacio(dato.getDireccion());
		validarLongitudNombreValida(dato.getDireccion());
		validarNombreContengaLetrasYEspacios(dato.getDireccion());
	}
	
	private void validarNombreVacio(String direccion)
	{
		if (UtilTexto.cadenaEstaVacia(direccion))
		{
			throw new MercaTouchNegocioExcepcion("La direccion de una Tienda no puede estar vacia");
		}
	}
		
	private void validarLongitudNombreValida(String direccion)
	{
		if(!UtilTexto.longitudEsValida(direccion, 1, 200))
		{
			throw new MercaTouchNegocioExcepcion("La direccion de una Tienda debe tener minimo un caracter y maximo 50 caracteres");
		}
	}
		
	private void validarNombreContengaLetrasYEspacios(String direccion)
	{
		if(!UtilTexto.cadenaContieneSoloLetrasYEspacios(direccion))
		{
			throw new MercaTouchNegocioExcepcion("La direccion de una Tienda solo puede contener letras y espacios");
		}
	}
}
