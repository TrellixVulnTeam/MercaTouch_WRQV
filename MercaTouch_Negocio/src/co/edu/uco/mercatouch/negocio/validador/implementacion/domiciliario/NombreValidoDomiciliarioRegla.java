package co.edu.uco.mercatouch.negocio.validador.implementacion.domiciliario;

import co.edu.uco.mercatouch.negocio.dominio.DomiciliarioDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class NombreValidoDomiciliarioRegla implements Regla<DomiciliarioDominio>
{
	private static final Regla<DomiciliarioDominio> INSTANCIA = new NombreValidoDomiciliarioRegla();
	
	private NombreValidoDomiciliarioRegla()
	{
		super();
	}
	
	public static Regla<DomiciliarioDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}

	@Override
	public void validar(DomiciliarioDominio dato) 
	{
		validarNombreVacio(dato.getNombre());
		validarLongitudNombreValida(dato.getNombre());
		validarNombreContengaLetrasYEspacios(dato.getNombre());
	}
	
	private void validarNombreVacio(String nombre)
	{
		if (UtilTexto.cadenaEstaVacia(nombre))
		{
			throw new MercaTouchNegocioExcepcion("El nombre de un Domiciliario no puede estar vacio");
		}
	}
		
	private void validarLongitudNombreValida(String nombre)
	{
		if(!UtilTexto.longitudEsValida(nombre, 1, 50))
		{
			throw new MercaTouchNegocioExcepcion("El nombre de un Domiciliario debe tener minimo un caracter y maximo 50 caracteres");
		}
	}
		
	private void validarNombreContengaLetrasYEspacios(String nombre)
	{
		if(!UtilTexto.cadenaContieneSoloLetrasYEspacios(nombre))
		{
			throw new MercaTouchNegocioExcepcion("El nombre de un Domiciliario solo puede contener letras y espacios");
		}
	}
}
