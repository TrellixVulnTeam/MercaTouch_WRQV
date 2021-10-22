package co.edu.uco.mercatouch.negocio.validador.implementacion.domiciliario;

import co.edu.uco.mercatouch.negocio.dominio.DomiciliarioDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class ClaveValidoDomiciliarioRegla implements Regla<DomiciliarioDominio>
{
	private static final Regla<DomiciliarioDominio> INSTANCIA = new ClaveValidoDomiciliarioRegla();
	
	private ClaveValidoDomiciliarioRegla()
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
		validarClaveVacio(dato.getClave());
		validarLongitudClaveValida(dato.getClave());
		validarFormatoClaveElectronico(dato.getClave());
		
	}
	
	private void validarClaveVacio(String clave)
	{
		if (UtilTexto.cadenaEstaVacia(clave))
		{
			throw new MercaTouchNegocioExcepcion("la Clave de un Domiciliario no puede estar vacio");
		}
	}
		
	private void validarLongitudClaveValida(String clave)
	{
		if(!UtilTexto.longitudEsValida(clave, 8, 100))
		{
			throw new MercaTouchNegocioExcepcion("la Clave de un Domiciliario debe tener minimo 8 caracteres y maximo 100 caracteres");
		}
	}
		
	private void validarFormatoClaveElectronico(String clave)
	{
		if(!UtilTexto.cadenaClave(clave))
		{
			throw new MercaTouchNegocioExcepcion("la Clave de un Domiciliario debe tener minimo 8 caracteres, un caracter en mayuscula, otro en minuscula y un numero");
		}
	}
}
