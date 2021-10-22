package co.edu.uco.mercatouch.negocio.validador.implementacion.producto;

import co.edu.uco.mercatouch.negocio.dominio.ProductoDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilNumero;

public class PrecioValidoProductoRegla implements Regla<ProductoDominio>
{
	private static final Regla<ProductoDominio> INSTANCIA = new PrecioValidoProductoRegla();
	
	private PrecioValidoProductoRegla()
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
		validarPrecioEsMayorQueCero(dato.getPrecio());
	}
	
	private void validarPrecioEsMayorQueCero(double precio)
	{
		if(UtilNumero.numeroEsMenorOIgual(precio, 0))
		{
			throw new MercaTouchNegocioExcepcion("El Precio de un Producto no puede ser menor o igual que cero");
		}
	}
}
