package co.edu.uco.mercatouch.negocio.validador.implementacion;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import co.edu.uco.mercatouch.negocio.dominio.AdministradorDominio;
import co.edu.uco.mercatouch.negocio.validador.Validador;
import co.edu.uco.mercatouch.negocio.validador.enumerador.TipoValidacion;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;

public class AdministradorValidador implements Validador<AdministradorDominio> 
{
	private EnumMap<TipoValidacion, List<Regla<AdministradorDominio>>> reglas =  new EnumMap<>(TipoValidacion.class);
	private static final Validador<AdministradorDominio> INSTANCIA = new AdministradorValidador();
	
	private AdministradorValidador()
	{
		reglas.put(TipoValidacion.CREACION, obtenerReglasCreacion());
		reglas.put(TipoValidacion.ACTUALIZACION, obtenerReglasActualizacion());
		reglas.put(TipoValidacion.ELIMINACION, obtenerReglasEliminacion());
	}

	public static Validador<AdministradorDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}
	
	@Override
	public void validar(AdministradorDominio dominio, TipoValidacion validacion) 
	{
		for(Regla<AdministradorDominio> regla : obtenerReglas(validacion)) 
		{
			regla.validar(dominio);
		}
	}
	
	private List<Regla<AdministradorDominio>> obtenerReglas(TipoValidacion tipoValidacion)
	{
		if(!reglas.containsKey(tipoValidacion))
		{
			throw new MercaTouchNegocioExcepcion("No existen reglas para el tipo de validacion " + tipoValidacion);
		}
			
		return reglas.get(tipoValidacion);
	}
	
	private List<Regla<AdministradorDominio>> obtenerReglasCreacion()
	{
		List<Regla<AdministradorDominio>> listadoReglas = new ArrayList<>();
			
		return listadoReglas;
	}
		
	private List<Regla<AdministradorDominio>> obtenerReglasActualizacion()
	{
		List<Regla<AdministradorDominio>> listadoReglas = new ArrayList<>();
			
		return listadoReglas;
	}
		
	private List<Regla<AdministradorDominio>> obtenerReglasEliminacion()
	{
		List<Regla<AdministradorDominio>> listadoReglas = new ArrayList<>();

		return listadoReglas;
	}
}