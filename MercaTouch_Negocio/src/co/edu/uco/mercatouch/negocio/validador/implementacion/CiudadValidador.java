package co.edu.uco.mercatouch.negocio.validador.implementacion;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import co.edu.uco.mercatouch.negocio.dominio.CiudadDominio;
import co.edu.uco.mercatouch.negocio.validador.Validador;
import co.edu.uco.mercatouch.negocio.validador.enumerador.TipoValidacion;
import co.edu.uco.mercatouch.negocio.validador.implementacion.ciudad.CodigoValidoCiudadRegla;
import co.edu.uco.mercatouch.negocio.validador.implementacion.ciudad.NombreValidoCiudadRegla;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;

public class CiudadValidador implements Validador<CiudadDominio>
{
	private EnumMap<TipoValidacion, List<Regla<CiudadDominio>>> reglas =  new EnumMap<>(TipoValidacion.class);
	private static final Validador<CiudadDominio> INSTANCIA = new CiudadValidador();
	
	private CiudadValidador()
	{
		reglas.put(TipoValidacion.CREACION, obtenerReglasCreacion());
		reglas.put(TipoValidacion.ACTUALIZACION, obtenerReglasActualizacion());
		reglas.put(TipoValidacion.ELIMINACION, obtenerReglasEliminacion());
	}

	public static Validador<CiudadDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}
	
	@Override
	public void validar(CiudadDominio dominio, TipoValidacion validacion) 
	{
		for(Regla<CiudadDominio> regla : obtenerReglas(validacion)) 
		{
			regla.validar(dominio);
		}
	}
	
	private List<Regla<CiudadDominio>> obtenerReglas(TipoValidacion tipoValidacion)
	{
		if(!reglas.containsKey(tipoValidacion))
		{
			throw new MercaTouchNegocioExcepcion("No existen reglas para el tipo de validacion " + tipoValidacion);
		}
			
		return reglas.get(tipoValidacion);
	}
	
	private List<Regla<CiudadDominio>> obtenerReglasCreacion()
	{
		List<Regla<CiudadDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(NombreValidoCiudadRegla.obtenerInstancia());
			
		return listadoReglas;
	}
		
	private List<Regla<CiudadDominio>> obtenerReglasActualizacion()
	{
		List<Regla<CiudadDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(CodigoValidoCiudadRegla.obtenerInstancia());
		listadoReglas.add(NombreValidoCiudadRegla.obtenerInstancia());
			
		return listadoReglas;
	}
		
	private List<Regla<CiudadDominio>> obtenerReglasEliminacion()
	{
		List<Regla<CiudadDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(CodigoValidoCiudadRegla.obtenerInstancia());

		return listadoReglas;
	}
}