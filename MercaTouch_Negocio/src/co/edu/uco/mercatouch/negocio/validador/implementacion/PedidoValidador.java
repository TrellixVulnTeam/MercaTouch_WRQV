package co.edu.uco.mercatouch.negocio.validador.implementacion;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import co.edu.uco.mercatouch.negocio.dominio.PedidoDominio;
import co.edu.uco.mercatouch.negocio.validador.Validador;
import co.edu.uco.mercatouch.negocio.validador.enumerador.TipoValidacion;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;

public class PedidoValidador implements Validador<PedidoDominio> 
{
	private EnumMap<TipoValidacion, List<Regla<PedidoDominio>>> reglas =  new EnumMap<>(TipoValidacion.class);
	private static final Validador<PedidoDominio> INSTANCIA = new PedidoValidador();
	
	private PedidoValidador()
	{
		reglas.put(TipoValidacion.CREACION, obtenerReglasCreacion());
		reglas.put(TipoValidacion.ACTUALIZACION, obtenerReglasActualizacion());
		reglas.put(TipoValidacion.ELIMINACION, obtenerReglasEliminacion());
	}

	public static Validador<PedidoDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}
	
	@Override
	public void validar(PedidoDominio dominio, TipoValidacion validacion) 
	{
		for(Regla<PedidoDominio> regla : obtenerReglas(validacion)) 
		{
			regla.validar(dominio);
		}
	}
	
	private List<Regla<PedidoDominio>> obtenerReglas(TipoValidacion tipoValidacion)
	{
		if(!reglas.containsKey(tipoValidacion))
		{
			throw new MercaTouchNegocioExcepcion("No existen reglas para el tipo de validacion " + tipoValidacion);
		}
			
		return reglas.get(tipoValidacion);
	}
	
	private List<Regla<PedidoDominio>> obtenerReglasCreacion()
	{
		List<Regla<PedidoDominio>> listadoReglas = new ArrayList<>();
			
		return listadoReglas;
	}
		
	private List<Regla<PedidoDominio>> obtenerReglasActualizacion()
	{
		List<Regla<PedidoDominio>> listadoReglas = new ArrayList<>();
			
		return listadoReglas;
	}
		
	private List<Regla<PedidoDominio>> obtenerReglasEliminacion()
	{
		List<Regla<PedidoDominio>> listadoReglas = new ArrayList<>();

		return listadoReglas;
	}
}