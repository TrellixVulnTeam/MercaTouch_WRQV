package co.edu.uco.mercatouch.negocio.validador.implementacion;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import co.edu.uco.mercatouch.negocio.dominio.PerfilDominio;
import co.edu.uco.mercatouch.negocio.validador.Validador;
import co.edu.uco.mercatouch.negocio.validador.enumerador.TipoValidacion;
import co.edu.uco.mercatouch.negocio.validador.implementacion.perfil.CodigoValidoPerfilRegla;
import co.edu.uco.mercatouch.negocio.validador.implementacion.perfil.NombreValidoPerfilRegla;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;

public class PerfilValidador implements Validador<PerfilDominio>
{
	private EnumMap<TipoValidacion, List<Regla<PerfilDominio>>> reglas =  new EnumMap<>(TipoValidacion.class);
	private static final Validador<PerfilDominio> INSTANCIA = new PerfilValidador();
	
	private PerfilValidador()
	{
		reglas.put(TipoValidacion.CREACION, obtenerReglasCreacion());
		reglas.put(TipoValidacion.ACTUALIZACION, obtenerReglasActualizacion());
		reglas.put(TipoValidacion.ELIMINACION, obtenerReglasEliminacion());
	}

	public static Validador<PerfilDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}
	
	@Override
	public void validar(PerfilDominio dominio, TipoValidacion validacion) 
	{
		for(Regla<PerfilDominio> regla : obtenerReglas(validacion)) 
		{
			regla.validar(dominio);
		}
	}
	
	private List<Regla<PerfilDominio>> obtenerReglas(TipoValidacion tipoValidacion)
	{
		if(!reglas.containsKey(tipoValidacion))
		{
			throw new MercaTouchNegocioExcepcion("No existen reglas para el tipo de validacion " + tipoValidacion);
		}
			
		return reglas.get(tipoValidacion);
	}
	
	private List<Regla<PerfilDominio>> obtenerReglasCreacion()
	{
		List<Regla<PerfilDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(NombreValidoPerfilRegla.obtenerInstancia());
			
		return listadoReglas;
	}
		
	private List<Regla<PerfilDominio>> obtenerReglasActualizacion()
	{
		List<Regla<PerfilDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(CodigoValidoPerfilRegla.obtenerInstancia());
		listadoReglas.add(NombreValidoPerfilRegla.obtenerInstancia());
			
		return listadoReglas;
	}
		
	private List<Regla<PerfilDominio>> obtenerReglasEliminacion()
	{
		List<Regla<PerfilDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(CodigoValidoPerfilRegla.obtenerInstancia());

		return listadoReglas;
	}
}