package co.edu.uco.mercatouch.negocio.validador.implementacion.metodopago;

import co.edu.uco.mercatouch.negocio.dominio.MetodoPagoDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class NombreValidoMetodoPagoRegla implements Regla<MetodoPagoDominio>
{
	private static final Regla<MetodoPagoDominio> INSTANCIA = new NombreValidoMetodoPagoRegla();
	
	private NombreValidoMetodoPagoRegla()
	{
		super();
	}
	
	public static Regla<MetodoPagoDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}

	@Override
	public void validar(MetodoPagoDominio dato) 
	{
		validarNombreVacio(dato.getNombre());
		validarLongitudNombreValida(dato.getNombre());
		validarNombreContengaLetrasYEspacios(dato.getNombre());
	}
	
	private void validarNombreVacio(String nombre)
	{
		if (UtilTexto.cadenaEstaVacia(nombre))
		{
			throw new MercaTouchNegocioExcepcion("El nombre de un MetodoPago no puede estar vacio");
		}
	}
		
	private void validarLongitudNombreValida(String nombre)
	{
		if(!UtilTexto.longitudEsValida(nombre, 1, 50))
		{
			throw new MercaTouchNegocioExcepcion("El nombre de un MetodoPago debe tener minimo un caracter y maximo 50 caracteres");
		}
	}
		
	private void validarNombreContengaLetrasYEspacios(String nombre)
	{
		if(!UtilTexto.cadenaContieneSoloLetrasYEspacios(nombre))
		{
			throw new MercaTouchNegocioExcepcion("El nombre de un MetodoPago solo puede contener letras y espacios");
		}
	}
}
