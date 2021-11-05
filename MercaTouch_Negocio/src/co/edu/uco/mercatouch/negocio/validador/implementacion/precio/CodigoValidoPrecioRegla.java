package co.edu.uco.mercatouch.negocio.validador.implementacion.precio;

import co.edu.uco.mercatouch.negocio.dominio.PrecioDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilNumero;

public class CodigoValidoPrecioRegla implements Regla<PrecioDominio> 
{
	private static final Regla<PrecioDominio> INSTANCIA = new CodigoValidoPrecioRegla();
	
	private CodigoValidoPrecioRegla()
	{
		super();
	}
	
	public static Regla<PrecioDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}
	
	@Override
	public void validar(PrecioDominio dato) 
	{
		validarCodigoEsMayorQueCero(dato.getCodigo());
	}
	
	private void validarCodigoEsMayorQueCero(int codigo)
	{
		if(UtilNumero.numeroEsMenorOIgual(codigo, 0))
		{
			throw new MercaTouchNegocioExcepcion("El codigo de un Precio no puede ser menor o igual que cero");
		}
	}
}