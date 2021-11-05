package co.edu.uco.mercatouch.negocio.validador.implementacion;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import co.edu.uco.mercatouch.negocio.dominio.TiendaProductoDominio;
import co.edu.uco.mercatouch.negocio.validador.Validador;
import co.edu.uco.mercatouch.negocio.validador.enumerador.TipoValidacion;
import co.edu.uco.mercatouch.negocio.validador.implementacion.tiendaproducto.CodigoValidoTiendaProductoRegla;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;

public class TiendaProductoValidador implements Validador<TiendaProductoDominio> 
{
	private EnumMap<TipoValidacion, List<Regla<TiendaProductoDominio>>> reglas =  new EnumMap<>(TipoValidacion.class);
	private static final Validador<TiendaProductoDominio> INSTANCIA = new TiendaProductoValidador();
	
	private TiendaProductoValidador()
	{
		reglas.put(TipoValidacion.CREACION, obtenerReglasCreacion());
		reglas.put(TipoValidacion.ACTUALIZACION, obtenerReglasActualizacion());
		reglas.put(TipoValidacion.ELIMINACION, obtenerReglasEliminacion());
	}

	public static Validador<TiendaProductoDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}
	
	@Override
	public void validar(TiendaProductoDominio dominio, TipoValidacion validacion) 
	{
		for(Regla<TiendaProductoDominio> regla : obtenerReglas(validacion)) 
		{
			regla.validar(dominio);
		}
	}
	
	private List<Regla<TiendaProductoDominio>> obtenerReglas(TipoValidacion tipoValidacion)
	{
		if(!reglas.containsKey(tipoValidacion))
		{
			throw new MercaTouchNegocioExcepcion("No existen reglas para el tipo de validacion " + tipoValidacion);
		}
			
		return reglas.get(tipoValidacion);
	}
	
	private List<Regla<TiendaProductoDominio>> obtenerReglasCreacion()
	{	
		return new ArrayList<>();
	}
		
	private List<Regla<TiendaProductoDominio>> obtenerReglasActualizacion()
	{
		List<Regla<TiendaProductoDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(CodigoValidoTiendaProductoRegla.obtenerInstancia());
			
		return listadoReglas;
	}
		
	private List<Regla<TiendaProductoDominio>> obtenerReglasEliminacion()
	{
		List<Regla<TiendaProductoDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(CodigoValidoTiendaProductoRegla.obtenerInstancia());

		return listadoReglas;
	}
}