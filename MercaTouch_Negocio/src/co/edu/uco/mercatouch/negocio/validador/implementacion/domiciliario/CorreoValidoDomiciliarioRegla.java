package co.edu.uco.mercatouch.negocio.validador.implementacion.domiciliario;

import co.edu.uco.mercatouch.negocio.dominio.DomiciliarioDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class CorreoValidoDomiciliarioRegla implements Regla<DomiciliarioDominio>
{
	private static final Regla<DomiciliarioDominio> INSTANCIA = new CorreoValidoDomiciliarioRegla();
	
	private CorreoValidoDomiciliarioRegla()
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
		validarCorreoVacio(dato.getCorreo());
		validarLongitudCorreoValida(dato.getCorreo());
		validarFormatoCorreoElectronico(dato.getCorreo());
	}
	
	private void validarCorreoVacio(String correo)
	{
		if (UtilTexto.cadenaEstaVacia(correo))
		{
			throw new MercaTouchNegocioExcepcion("El correo de un Domiciliario no puede estar vacio");
		}
	}
		
	private void validarLongitudCorreoValida(String correo)
	{
		if(!UtilTexto.longitudEsValida(correo, 1, 100))
		{
			throw new MercaTouchNegocioExcepcion("El correo de un Domiciliario debe tener minimo un caracter y maximo 100 caracteres");
		}
	}
		
	private void validarFormatoCorreoElectronico(String correo)
	{
		if(!UtilTexto.cadenaCorreoElectronico(correo))
		{
			throw new MercaTouchNegocioExcepcion("El correo de un Domiciliario debe tener el formato de Correo Electronico");
		}
	}
}
