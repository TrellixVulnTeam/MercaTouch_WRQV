package co.edu.uco.mercatouch.negocio.validador.implementacion.plansuscripcion;

import co.edu.uco.mercatouch.negocio.dominio.PlanSuscripcionDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilNumero;

public class TiempoSuscripcionValidoPlanSuscripcionRegla implements Regla<PlanSuscripcionDominio>
{
	private static final Regla<PlanSuscripcionDominio> INSTANCIA = new TiempoSuscripcionValidoPlanSuscripcionRegla();
	
	private TiempoSuscripcionValidoPlanSuscripcionRegla()
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
		validarTiempoSuscripcionEsMayorQueCero(dato.getTiempoSuscripcion());
	}
	
	private void validarTiempoSuscripcionEsMayorQueCero(int telefono)
	{
		if(UtilNumero.numeroEsMenorOIgual(telefono, 0))
		{
			throw new MercaTouchNegocioExcepcion("El Tiempo de un Plan de Suscripcion no puede ser menor o igual que cero");
		}
	}
}
