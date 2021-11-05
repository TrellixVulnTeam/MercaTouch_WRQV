package co.edu.uco.mercatouch.negocio.validador.implementacion;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import co.edu.uco.mercatouch.negocio.dominio.DepartamentoDominio;
import co.edu.uco.mercatouch.negocio.validador.Validador;
import co.edu.uco.mercatouch.negocio.validador.enumerador.TipoValidacion;
import co.edu.uco.mercatouch.negocio.validador.implementacion.departamento.CodigoValidoDepartamentoRegla;
import co.edu.uco.mercatouch.negocio.validador.implementacion.departamento.NombreValidoDepartamentoRegla;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;

public class DepartamentoValidador implements Validador<DepartamentoDominio>
{
	private EnumMap<TipoValidacion, List<Regla<DepartamentoDominio>>> reglas =  new EnumMap<>(TipoValidacion.class);
	private static final Validador<DepartamentoDominio> INSTANCIA = new DepartamentoValidador();
	
	private DepartamentoValidador()
	{
		reglas.put(TipoValidacion.CREACION, obtenerReglasCreacion());
		reglas.put(TipoValidacion.ACTUALIZACION, obtenerReglasActualizacion());
		reglas.put(TipoValidacion.ELIMINACION, obtenerReglasEliminacion());
	}

	public static Validador<DepartamentoDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}
	
	@Override
	public void validar(DepartamentoDominio dominio, TipoValidacion validacion) 
	{
		for(Regla<DepartamentoDominio> regla : obtenerReglas(validacion)) 
		{
			regla.validar(dominio);
		}
	}
	
	private List<Regla<DepartamentoDominio>> obtenerReglas(TipoValidacion tipoValidacion)
	{
		if(!reglas.containsKey(tipoValidacion))
		{
			throw new MercaTouchNegocioExcepcion("No existen reglas para el tipo de validacion " + tipoValidacion);
		}
			
		return reglas.get(tipoValidacion);
	}
	
	private List<Regla<DepartamentoDominio>> obtenerReglasCreacion()
	{
		List<Regla<DepartamentoDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(NombreValidoDepartamentoRegla.obtenerInstancia());
			
		return listadoReglas;
	}
		
	private List<Regla<DepartamentoDominio>> obtenerReglasActualizacion()
	{
		List<Regla<DepartamentoDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(CodigoValidoDepartamentoRegla.obtenerInstancia());
		listadoReglas.add(NombreValidoDepartamentoRegla.obtenerInstancia());
			
		return listadoReglas;
	}
		
	private List<Regla<DepartamentoDominio>> obtenerReglasEliminacion()
	{
		List<Regla<DepartamentoDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(CodigoValidoDepartamentoRegla.obtenerInstancia());

		return listadoReglas;
	}
}