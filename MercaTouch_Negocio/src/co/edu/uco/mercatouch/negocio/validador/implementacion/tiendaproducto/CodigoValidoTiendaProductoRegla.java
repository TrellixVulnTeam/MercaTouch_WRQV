package co.edu.uco.mercatouch.negocio.validador.implementacion.tiendaproducto;

import co.edu.uco.mercatouch.negocio.dominio.TiendaProductoDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilNumero;

public class CodigoValidoTiendaProductoRegla implements Regla<TiendaProductoDominio> 
{
	private static final Regla<TiendaProductoDominio> INSTANCIA = new CodigoValidoTiendaProductoRegla();
	
	private CodigoValidoTiendaProductoRegla()
	{
		super();
	}
	
	public static Regla<TiendaProductoDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}
	
	@Override
	public void validar(TiendaProductoDominio dato) 
	{
		validarCodigoEsMayorQueCero(dato.getCodigo());
	}
	
	private void validarCodigoEsMayorQueCero(int codigo)
	{
		if(UtilNumero.numeroEsMenorOIgual(codigo, 0))
		{
			throw new MercaTouchNegocioExcepcion("El codigo de una TiendaProducto no puede ser menor o igual que cero");
		}
	}
}