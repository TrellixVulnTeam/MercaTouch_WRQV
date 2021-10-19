package co.edu.uco.mercatouch.negocio.validador.implementacion.pedido;

import co.edu.uco.mercatouch.negocio.dominio.PedidoDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilNumero;

public class CodigoValidoPedidoRegla implements Regla<PedidoDominio> 
{
	private static final Regla<PedidoDominio> INSTANCIA = new CodigoValidoPedidoRegla();
	
	private CodigoValidoPedidoRegla()
	{
		super();
	}
	
	public static Regla<PedidoDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}
	
	@Override
	public void validar(PedidoDominio dato) 
	{
		validarCodigoEsMayorQueCero(dato.getCodigo());
	}
	
	private void validarCodigoEsMayorQueCero(int codigo)
	{
		if(UtilNumero.numeroEsMenorOIgual(codigo, 0))
		{
			throw new MercaTouchNegocioExcepcion("El codigo de un Pedido no puede ser menor o igual que cero");
		}
	}
}