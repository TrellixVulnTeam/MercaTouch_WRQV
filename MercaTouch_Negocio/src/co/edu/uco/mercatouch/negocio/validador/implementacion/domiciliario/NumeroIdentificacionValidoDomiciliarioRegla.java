package co.edu.uco.mercatouch.negocio.validador.implementacion.domiciliario;

import co.edu.uco.mercatouch.negocio.dominio.DomiciliarioDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilNumero;

public class NumeroIdentificacionValidoDomiciliarioRegla implements Regla<DomiciliarioDominio>
{
	private static final Regla<DomiciliarioDominio> INSTANCIA = new NumeroIdentificacionValidoDomiciliarioRegla();
	
	private NumeroIdentificacionValidoDomiciliarioRegla()
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
		validarCodigoEsMayorQueCero(dato.getNumeroIdentificacion());
	}
	
	private void validarCodigoEsMayorQueCero(long numeroIdentificacion)
	{
		if(UtilNumero.numeroEsMenorOIgual(numeroIdentificacion, 0))
		{
			throw new MercaTouchNegocioExcepcion("El numero de identificacion de un Domiciliario no puede ser menor o igual que cero");
		}
	}
}
