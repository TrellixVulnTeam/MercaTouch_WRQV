package co.edu.uco.mercatouch.negocio.validador.implementacion.producto;

import co.edu.uco.mercatouch.negocio.dominio.ProductoDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilNumero;

public class CodigoValidoProductoRegla implements Regla<ProductoDominio> 
{
	private static final Regla<ProductoDominio> INSTANCIA = new CodigoValidoProductoRegla();
	
	private CodigoValidoProductoRegla()
	{
		super();
	}
	
	public static Regla<ProductoDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}
	
	@Override
	public void validar(ProductoDominio dato) 
	{
		validarCodigoEsMayorQueCero(dato.getCodigo());
	}
	
	private void validarCodigoEsMayorQueCero(int codigo)
	{
		if(UtilNumero.numeroEsMenorOIgual(codigo, 0))
		{
			throw new MercaTouchNegocioExcepcion("El codigo de un Producto no puede ser menor o igual que cero");
		}
	}
}