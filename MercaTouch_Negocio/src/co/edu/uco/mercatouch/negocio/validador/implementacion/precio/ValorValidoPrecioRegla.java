package co.edu.uco.mercatouch.negocio.validador.implementacion.precio;

import co.edu.uco.mercatouch.negocio.dominio.PrecioDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilNumero;

public class ValorValidoPrecioRegla implements Regla<PrecioDominio> 
{
	private static final Regla<PrecioDominio> INSTANCIA = new ValorValidoPrecioRegla();
	
	private ValorValidoPrecioRegla()
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
		validarValorEsMayorQueCero(dato.getValor());
	}
	
	private void validarValorEsMayorQueCero(double valor)
	{
		if(UtilNumero.numeroEsMenorOIgual(valor, 0))
		{
			throw new MercaTouchNegocioExcepcion("El valor de un Precio no puede ser menor o igual que cero");
		}
	}
}