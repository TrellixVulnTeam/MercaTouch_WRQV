package co.edu.uco.mercatouch.negocio.validador.implementacion;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import co.edu.uco.mercatouch.negocio.dominio.MetodoPagoDominio;
import co.edu.uco.mercatouch.negocio.validador.Validador;
import co.edu.uco.mercatouch.negocio.validador.enumerador.TipoValidacion;
import co.edu.uco.mercatouch.negocio.validador.implementacion.metodopago.CodigoValidoMetodoPagoRegla;
import co.edu.uco.mercatouch.negocio.validador.implementacion.metodopago.NombreValidoMetodoPagoRegla;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;

public class MetodoPagoValidador implements Validador<MetodoPagoDominio> 
{
	private EnumMap<TipoValidacion, List<Regla<MetodoPagoDominio>>> reglas =  new EnumMap<>(TipoValidacion.class);
	private static final Validador<MetodoPagoDominio> INSTANCIA = new MetodoPagoValidador();
	
	private MetodoPagoValidador()
	{
		reglas.put(TipoValidacion.CREACION, obtenerReglasCreacion());
		reglas.put(TipoValidacion.ACTUALIZACION, obtenerReglasActualizacion());
		reglas.put(TipoValidacion.ELIMINACION, obtenerReglasEliminacion());
	}

	public static Validador<MetodoPagoDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}
	
	@Override
	public void validar(MetodoPagoDominio dominio, TipoValidacion validacion) 
	{
		for(Regla<MetodoPagoDominio> regla : obtenerReglas(validacion)) 
		{
			regla.validar(dominio);
		}
	}
	
	private List<Regla<MetodoPagoDominio>> obtenerReglas(TipoValidacion tipoValidacion)
	{
		if(!reglas.containsKey(tipoValidacion))
		{
			throw new MercaTouchNegocioExcepcion("No existen reglas para el tipo de validacion " + tipoValidacion);
		}
			
		return reglas.get(tipoValidacion);
	}
	
	private List<Regla<MetodoPagoDominio>> obtenerReglasCreacion()
	{
		List<Regla<MetodoPagoDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(NombreValidoMetodoPagoRegla.obtenerInstancia());
			
		return listadoReglas;
	}
		
	private List<Regla<MetodoPagoDominio>> obtenerReglasActualizacion()
	{
		List<Regla<MetodoPagoDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(CodigoValidoMetodoPagoRegla.obtenerInstancia());
		listadoReglas.add(NombreValidoMetodoPagoRegla.obtenerInstancia());
			
		return listadoReglas;
	}
		
	private List<Regla<MetodoPagoDominio>> obtenerReglasEliminacion()
	{
		List<Regla<MetodoPagoDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(CodigoValidoMetodoPagoRegla.obtenerInstancia());

		return listadoReglas;
	}
}
