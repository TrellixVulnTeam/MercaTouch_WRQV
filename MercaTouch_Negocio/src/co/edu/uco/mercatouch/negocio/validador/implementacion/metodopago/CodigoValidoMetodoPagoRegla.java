package co.edu.uco.mercatouch.negocio.validador.implementacion.metodopago;

import co.edu.uco.mercatouch.negocio.dominio.MetodoPagoDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilNumero;

public class CodigoValidoMetodoPagoRegla implements Regla<MetodoPagoDominio> 
{
	private static final Regla<MetodoPagoDominio> INSTANCIA = new CodigoValidoMetodoPagoRegla();
	
	private CodigoValidoMetodoPagoRegla()
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
		validarCodigoEsMayorQueCero(dato.getCodigo());
	}
	
	private void validarCodigoEsMayorQueCero(int codigo)
	{
		if(UtilNumero.numeroEsMenorOIgual(codigo, 0))
		{
			throw new MercaTouchNegocioExcepcion("El codigo de un MetodoPago no puede ser menor o igual que cero");
		}
	}
}