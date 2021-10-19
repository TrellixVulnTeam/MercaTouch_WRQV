package co.edu.uco.mercatouch.negocio.validador.implementacion.plansuscripcion;

import co.edu.uco.mercatouch.negocio.dominio.PlanSuscripcionDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilNumero;

public class CodigoValidoPlanSuscripcionRegla implements Regla<PlanSuscripcionDominio> 
{
	private static final Regla<PlanSuscripcionDominio> INSTANCIA = new CodigoValidoPlanSuscripcionRegla();
	
	private CodigoValidoPlanSuscripcionRegla()
	{
		super();
	}
	
	public static Regla<PlanSuscripcionDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}
	
	@Override
	public void validar(PlanSuscripcionDominio dato) 
	{
		validarCodigoEsMayorQueCero(dato.getCodigo());
	}
	
	private void validarCodigoEsMayorQueCero(int codigo)
	{
		if(UtilNumero.numeroEsMenorOIgual(codigo, 0))
		{
			throw new MercaTouchNegocioExcepcion("El codigo de un PlanSuscripcion no puede ser menor o igual que cero");
		}
	}
}