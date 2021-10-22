package co.edu.uco.mercatouch.negocio.validador.implementacion.domiciliario;

import co.edu.uco.mercatouch.negocio.dominio.DomiciliarioDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilNumero;

public class TelefonoValidoDomiciliarioRegla implements Regla<DomiciliarioDominio>
{
	private static final Regla<DomiciliarioDominio> INSTANCIA = new TelefonoValidoDomiciliarioRegla();
	
	private TelefonoValidoDomiciliarioRegla()
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
		validarTelefonoEsMayorQueCero(dato.getTelefono());
	}
	
	private void validarTelefonoEsMayorQueCero(long telefono)
	{
		if(UtilNumero.numeroEsMenorOIgual(telefono, 0))
		{
			throw new MercaTouchNegocioExcepcion("El numero de un Domiciliario no puede ser menor o igual que cero");
		}
	}
}
