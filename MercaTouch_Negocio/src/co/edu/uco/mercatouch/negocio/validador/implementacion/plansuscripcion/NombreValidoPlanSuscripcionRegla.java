package co.edu.uco.mercatouch.negocio.validador.implementacion.plansuscripcion;

import co.edu.uco.mercatouch.negocio.dominio.PlanSuscripcionDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class NombreValidoPlanSuscripcionRegla implements Regla<PlanSuscripcionDominio>
{
	private static final Regla<PlanSuscripcionDominio> INSTANCIA = new NombreValidoPlanSuscripcionRegla();
	
	private NombreValidoPlanSuscripcionRegla()
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
		validarNombreVacio(dato.getNombre());
		validarLongitudNombreValida(dato.getNombre());
		validarNombreContengaLetrasYEspacios(dato.getNombre());
	}
	
	private void validarNombreVacio(String nombre)
	{
		if (UtilTexto.cadenaEstaVacia(nombre))
		{
			throw new MercaTouchNegocioExcepcion("El nombre de un Plan de Suscripcion no puede estar vacio");
		}
	}
		
	private void validarLongitudNombreValida(String nombre)
	{
		if(!UtilTexto.longitudEsValida(nombre, 1, 50))
		{
			throw new MercaTouchNegocioExcepcion("El nombre de un Plan de Suscripcion debe tener minimo un caracter y maximo 50 caracteres");
		}
	}
		
	private void validarNombreContengaLetrasYEspacios(String nombre)
	{
		if(!UtilTexto.cadenaContieneSoloLetrasYEspacios(nombre))
		{
			throw new MercaTouchNegocioExcepcion("El nombre de un Plan de Suscripcion solo puede contener letras y espacios");
		}
	}
}
