package co.edu.uco.mercatouch.negocio.validador.implementacion.ciudad;

import co.edu.uco.mercatouch.negocio.dominio.CiudadDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilNumero;

public class CodigoValidoCiudadRegla implements Regla<CiudadDominio> 
{
	private static final Regla<CiudadDominio> INSTANCIA = new CodigoValidoCiudadRegla();
	
	private CodigoValidoCiudadRegla()
	{
		super();
	}
	
	public static Regla<CiudadDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}
	
	@Override
	public void validar(CiudadDominio dato) 
	{
		validarCodigoEsMayorQueCero(dato.getCodigo());
	}
	
	private void validarCodigoEsMayorQueCero(int codigo)
	{
		if(UtilNumero.numeroEsMenorOIgual(codigo, 0))
		{
			throw new MercaTouchNegocioExcepcion("El codigo de una Ciudad no puede ser menor o igual que cero");
		}
	}
}