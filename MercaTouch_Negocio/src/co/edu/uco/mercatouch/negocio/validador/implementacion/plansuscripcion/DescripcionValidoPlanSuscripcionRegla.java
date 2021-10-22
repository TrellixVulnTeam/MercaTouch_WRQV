package co.edu.uco.mercatouch.negocio.validador.implementacion.plansuscripcion;

import co.edu.uco.mercatouch.negocio.dominio.PlanSuscripcionDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class DescripcionValidoPlanSuscripcionRegla implements Regla<PlanSuscripcionDominio>
{
	private static final Regla<PlanSuscripcionDominio> INSTANCIA = new DescripcionValidoPlanSuscripcionRegla();
	
	private DescripcionValidoPlanSuscripcionRegla()
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
		validarNombreVacio(dato.getDescripcion());
		validarLongitudNombreValida(dato.getDescripcion());
		validarNombreContengaLetrasYEspacios(dato.getDescripcion());
	}
	
	private void validarNombreVacio(String nombre)
	{
		if (UtilTexto.cadenaEstaVacia(nombre))
		{
			throw new MercaTouchNegocioExcepcion("La descripcion de un Plan de Suscripcion no puede estar vacio");
		}
	}
		
	private void validarLongitudNombreValida(String nombre)
	{
		if(!UtilTexto.longitudEsValida(nombre, 1, 200))
		{
			throw new MercaTouchNegocioExcepcion("La descripcion de un Plan de Suscripcion debe tener minimo un caracter y maximo 50 caracteres");
		}
	}
		
	private void validarNombreContengaLetrasYEspacios(String nombre)
	{
		if(!UtilTexto.cadenaContieneSoloLetrasYEspacios(nombre))
		{
			throw new MercaTouchNegocioExcepcion("La descripcion de un Plan de Suscripcion solo puede contener letras y espacios");
		}
	}
}
