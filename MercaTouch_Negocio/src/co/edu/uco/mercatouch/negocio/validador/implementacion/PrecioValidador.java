package co.edu.uco.mercatouch.negocio.validador.implementacion;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import co.edu.uco.mercatouch.negocio.dominio.PrecioDominio;
import co.edu.uco.mercatouch.negocio.validador.Validador;
import co.edu.uco.mercatouch.negocio.validador.enumerador.TipoValidacion;
import co.edu.uco.mercatouch.negocio.validador.implementacion.precio.CodigoValidoPrecioRegla;
import co.edu.uco.mercatouch.negocio.validador.implementacion.precio.ValorValidoPrecioRegla;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;

public class PrecioValidador implements Validador<PrecioDominio>
{
	private EnumMap<TipoValidacion, List<Regla<PrecioDominio>>> reglas =  new EnumMap<>(TipoValidacion.class);
	private static final Validador<PrecioDominio> INSTANCIA = new PrecioValidador();
	
	private PrecioValidador()
	{
		reglas.put(TipoValidacion.CREACION, obtenerReglasCreacion());
		reglas.put(TipoValidacion.ACTUALIZACION, obtenerReglasActualizacion());
		reglas.put(TipoValidacion.ELIMINACION, obtenerReglasEliminacion());
	}

	public static Validador<PrecioDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}
	
	@Override
	public void validar(PrecioDominio dominio, TipoValidacion validacion) 
	{
		for(Regla<PrecioDominio> regla : obtenerReglas(validacion)) 
		{
			regla.validar(dominio);
		}
	}
	
	private List<Regla<PrecioDominio>> obtenerReglas(TipoValidacion tipoValidacion)
	{
		if(!reglas.containsKey(tipoValidacion))
		{
			throw new MercaTouchNegocioExcepcion("No existen reglas para el tipo de validacion " + tipoValidacion);
		}
			
		return reglas.get(tipoValidacion);
	}
	
	private List<Regla<PrecioDominio>> obtenerReglasCreacion()
	{
		List<Regla<PrecioDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(ValorValidoPrecioRegla.obtenerInstancia());
			
		return listadoReglas;
	}
		
	private List<Regla<PrecioDominio>> obtenerReglasActualizacion()
	{
		List<Regla<PrecioDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(CodigoValidoPrecioRegla.obtenerInstancia());
		listadoReglas.add(ValorValidoPrecioRegla.obtenerInstancia());
			
		return listadoReglas;
	}
		
	private List<Regla<PrecioDominio>> obtenerReglasEliminacion()
	{
		List<Regla<PrecioDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(CodigoValidoPrecioRegla.obtenerInstancia());

		return listadoReglas;
	}
}