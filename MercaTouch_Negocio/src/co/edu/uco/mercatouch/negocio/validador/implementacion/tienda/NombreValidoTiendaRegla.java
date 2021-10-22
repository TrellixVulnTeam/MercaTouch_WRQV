package co.edu.uco.mercatouch.negocio.validador.implementacion.tienda;

import co.edu.uco.mercatouch.negocio.dominio.TiendaDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class NombreValidoTiendaRegla implements Regla<TiendaDominio>
{
	private static final Regla<TiendaDominio> INSTANCIA = new NombreValidoTiendaRegla();
	
	private NombreValidoTiendaRegla()
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
		validarNombreVacio(dato.getNombre());
		validarLongitudNombreValida(dato.getNombre());
		validarNombreContengaLetrasYEspacios(dato.getNombre());
	}
	
	private void validarNombreVacio(String nombre)
	{
		if (UtilTexto.cadenaEstaVacia(nombre))
		{
			throw new MercaTouchNegocioExcepcion("El nombre de una Tienda no puede estar vacio");
		}
	}
		
	private void validarLongitudNombreValida(String nombre)
	{
		if(!UtilTexto.longitudEsValida(nombre, 1, 50))
		{
			throw new MercaTouchNegocioExcepcion("El nombre de una Tienda debe tener minimo un caracter y maximo 50 caracteres");
		}
	}
		
	private void validarNombreContengaLetrasYEspacios(String nombre)
	{
		if(!UtilTexto.cadenaContieneSoloLetrasYEspacios(nombre))
		{
			throw new MercaTouchNegocioExcepcion("El nombre de una Tienda solo puede contener letras y espacios");
		}
	}
}
