package co.edu.uco.mercatouch.negocio.validador.implementacion;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import co.edu.uco.mercatouch.negocio.dominio.PlanSuscripcionDominio;
import co.edu.uco.mercatouch.negocio.validador.Validador;
import co.edu.uco.mercatouch.negocio.validador.enumerador.TipoValidacion;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;

public class PlanSuscripcionValidador implements Validador<PlanSuscripcionDominio> 
{
	private EnumMap<TipoValidacion, List<Regla<PlanSuscripcionDominio>>> reglas =  new EnumMap<>(TipoValidacion.class);
	private static final Validador<PlanSuscripcionDominio> INSTANCIA = new PlanSuscripcionValidador();
	
	private PlanSuscripcionValidador()
	{
		reglas.put(TipoValidacion.CREACION, obtenerReglasCreacion());
		reglas.put(TipoValidacion.ACTUALIZACION, obtenerReglasActualizacion());
		reglas.put(TipoValidacion.ELIMINACION, obtenerReglasEliminacion());
	}

	public static Validador<PlanSuscripcionDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}
	
	@Override
	public void validar(PlanSuscripcionDominio dominio, TipoValidacion validacion) 
	{
		for(Regla<PlanSuscripcionDominio> regla : obtenerReglas(validacion)) 
		{
			regla.validar(dominio);
		}
	}
	
	private List<Regla<PlanSuscripcionDominio>> obtenerReglas(TipoValidacion tipoValidacion)
	{
		if(!reglas.containsKey(tipoValidacion))
		{
			throw new MercaTouchNegocioExcepcion("No existen reglas para el tipo de validacion " + tipoValidacion);
		}
			
		return reglas.get(tipoValidacion);
	}
	
	private List<Regla<PlanSuscripcionDominio>> obtenerReglasCreacion()
	{
		List<Regla<PlanSuscripcionDominio>> listadoReglas = new ArrayList<>();
			
		return listadoReglas;
	}
		
	private List<Regla<PlanSuscripcionDominio>> obtenerReglasActualizacion()
	{
		List<Regla<PlanSuscripcionDominio>> listadoReglas = new ArrayList<>();
			
		return listadoReglas;
	}
		
	private List<Regla<PlanSuscripcionDominio>> obtenerReglasEliminacion()
	{
		List<Regla<PlanSuscripcionDominio>> listadoReglas = new ArrayList<>();

		return listadoReglas;
	}
}
