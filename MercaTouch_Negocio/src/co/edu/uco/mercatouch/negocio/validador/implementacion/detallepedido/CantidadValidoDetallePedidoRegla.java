package co.edu.uco.mercatouch.negocio.validador.implementacion.detallepedido;

import co.edu.uco.mercatouch.negocio.dominio.DetallePedidoDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilNumero;

public class CantidadValidoDetallePedidoRegla implements Regla<DetallePedidoDominio> 
{
	private static final Regla<DetallePedidoDominio> INSTANCIA = new CantidadValidoDetallePedidoRegla();
	
	private CantidadValidoDetallePedidoRegla()
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
		validarCantidadEsMayorQueCero(dato.getCantidad());
	}
	
	private void validarCantidadEsMayorQueCero(int cantidad)
	{
		if(UtilNumero.numeroEsMenorOIgual(cantidad, 0))
		{
			throw new MercaTouchNegocioExcepcion("La cantidad de un DetallePedido no puede ser menor o igual que cero");
		}
	}
}