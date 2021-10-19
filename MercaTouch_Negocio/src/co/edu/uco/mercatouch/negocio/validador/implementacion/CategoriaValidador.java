package co.edu.uco.mercatouch.negocio.validador.implementacion;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import co.edu.uco.mercatouch.negocio.dominio.CategoriaDominio;
import co.edu.uco.mercatouch.negocio.validador.Validador;
import co.edu.uco.mercatouch.negocio.validador.enumerador.TipoValidacion;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;

public class CategoriaValidador implements Validador<CategoriaDominio>
{
	private EnumMap<TipoValidacion, List<Regla<CategoriaDominio>>> reglas =  new EnumMap<>(TipoValidacion.class);
	private static final Validador<CategoriaDominio> INSTANCIA = new CategoriaValidador();
	
	private CategoriaValidador()
	{
		reglas.put(TipoValidacion.CREACION, obtenerReglasCreacion());
		reglas.put(TipoValidacion.ACTUALIZACION, obtenerReglasActualizacion());
		reglas.put(TipoValidacion.ELIMINACION, obtenerReglasEliminacion());
	}

	public static Validador<CategoriaDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}
	
	@Override
	public void validar(CategoriaDominio dominio, TipoValidacion validacion) 
	{
		for(Regla<CategoriaDominio> regla : obtenerReglas(validacion)) 
		{
			regla.validar(dominio);
		}
	}
	
	private List<Regla<CategoriaDominio>> obtenerReglas(TipoValidacion tipoValidacion)
	{
		if(!reglas.containsKey(tipoValidacion))
		{
			throw new MercaTouchNegocioExcepcion("No existen reglas para el tipo de validacion " + tipoValidacion);
		}
			
		return reglas.get(tipoValidacion);
	}
	
	private List<Regla<CategoriaDominio>> obtenerReglasCreacion()
	{
		List<Regla<CategoriaDominio>> listadoReglas = new ArrayList<>();
			
		return listadoReglas;
	}
		
	private List<Regla<CategoriaDominio>> obtenerReglasActualizacion()
	{
		List<Regla<CategoriaDominio>> listadoReglas = new ArrayList<>();
			
		return listadoReglas;
	}
		
	private List<Regla<CategoriaDominio>> obtenerReglasEliminacion()
	{
		List<Regla<CategoriaDominio>> listadoReglas = new ArrayList<>();

		return listadoReglas;
	}
}