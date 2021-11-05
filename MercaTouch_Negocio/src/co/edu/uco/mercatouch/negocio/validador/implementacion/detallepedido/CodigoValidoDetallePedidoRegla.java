package co.edu.uco.mercatouch.negocio.validador.implementacion.detallepedido;

import co.edu.uco.mercatouch.negocio.dominio.DetallePedidoDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilNumero;

public class CodigoValidoDetallePedidoRegla implements Regla<DetallePedidoDominio> 
{
	private static final Regla<DetallePedidoDominio> INSTANCIA = new CodigoValidoDetallePedidoRegla();
	
	private CodigoValidoDetallePedidoRegla()
	{
		super();
	}
	
	public static Regla<DetallePedidoDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}
	
	@Override
	public void validar(DetallePedidoDominio dato) 
	{
		validarCodigoEsMayorQueCero(dato.getCodigo());
	}
	
	private void validarCodigoEsMayorQueCero(int codigo)
	{
		if(UtilNumero.numeroEsMenorOIgual(codigo, 0))
		{
			throw new MercaTouchNegocioExcepcion("El codigo de un DetallePedido no puede ser menor o igual que cero");
		}
	}
}