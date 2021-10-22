package co.edu.uco.mercatouch.negocio.validador.implementacion.domiciliario;

import co.edu.uco.mercatouch.negocio.dominio.DomiciliarioDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class ApellidosValidoDomiciliarioRegla implements Regla<DomiciliarioDominio>
{
	private static final Regla<DomiciliarioDominio> INSTANCIA = new ApellidosValidoDomiciliarioRegla();
	
	private ApellidosValidoDomiciliarioRegla()
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
		validarApellidosVacio(dato.getApellidos());
		validarLongitudApellidosValida(dato.getApellidos());
		validarApellidosContengaLetrasYEspacios(dato.getApellidos());
	}
	
	private void validarApellidosVacio(String apellidos)
	{
		if (UtilTexto.cadenaEstaVacia(apellidos))
		{
			throw new MercaTouchNegocioExcepcion("Los Apellidos de un Domiciliario no puede estar vacio");
		}
	}
		
	private void validarLongitudApellidosValida(String apellidos)
	{
		if(!UtilTexto.longitudEsValida(apellidos, 1, 100))
		{
			throw new MercaTouchNegocioExcepcion("Los Apellidos de un Domiciliario debe tener minimo un caracter y maximo 100 caracteres");
		}
	}
		
	private void validarApellidosContengaLetrasYEspacios(String apellidos)
	{
		if(!UtilTexto.cadenaContieneSoloLetrasYEspacios(apellidos))
		{
			throw new MercaTouchNegocioExcepcion("Los Apellidos de un Domiciliario solo puede contener letras y espacios");
		}
	}
}
