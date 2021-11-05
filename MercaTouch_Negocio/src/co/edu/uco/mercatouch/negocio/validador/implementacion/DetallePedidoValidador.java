package co.edu.uco.mercatouch.negocio.validador.implementacion;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import co.edu.uco.mercatouch.negocio.dominio.DetallePedidoDominio;
import co.edu.uco.mercatouch.negocio.validador.Validador;
import co.edu.uco.mercatouch.negocio.validador.enumerador.TipoValidacion;
import co.edu.uco.mercatouch.negocio.validador.implementacion.detallepedido.CantidadValidoDetallePedidoRegla;
import co.edu.uco.mercatouch.negocio.validador.implementacion.detallepedido.CodigoValidoDetallePedidoRegla;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;

public class DetallePedidoValidador implements Validador<DetallePedidoDominio>
{
	private EnumMap<TipoValidacion, List<Regla<DetallePedidoDominio>>> reglas =  new EnumMap<>(TipoValidacion.class);
	private static final Validador<DetallePedidoDominio> INSTANCIA = new DetallePedidoValidador();
	
	private DetallePedidoValidador()
	{
		reglas.put(TipoValidacion.CREACION, obtenerReglasCreacion());
		reglas.put(TipoValidacion.ACTUALIZACION, obtenerReglasActualizacion());
		reglas.put(TipoValidacion.ELIMINACION, obtenerReglasEliminacion());
	}

	public static Validador<DetallePedidoDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}
	
	@Override
	public void validar(DetallePedidoDominio dominio, TipoValidacion validacion) 
	{
		for(Regla<DetallePedidoDominio> regla : obtenerReglas(validacion)) 
		{
			regla.validar(dominio);
		}
	}
	
	private List<Regla<DetallePedidoDominio>> obtenerReglas(TipoValidacion tipoValidacion)
	{
		if(!reglas.containsKey(tipoValidacion))
		{
			throw new MercaTouchNegocioExcepcion("No existen reglas para el tipo de validacion " + tipoValidacion);
		}
			
		return reglas.get(tipoValidacion);
	}
	
	private List<Regla<DetallePedidoDominio>> obtenerReglasCreacion()
	{
		List<Regla<DetallePedidoDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(CantidadValidoDetallePedidoRegla.obtenerInstancia());
			
		return listadoReglas;
	}
		
	private List<Regla<DetallePedidoDominio>> obtenerReglasActualizacion()
	{
		List<Regla<DetallePedidoDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(CodigoValidoDetallePedidoRegla.obtenerInstancia());
		listadoReglas.add(CantidadValidoDetallePedidoRegla.obtenerInstancia());
			
		return listadoReglas;
	}
		
	private List<Regla<DetallePedidoDominio>> obtenerReglasEliminacion()
	{
		List<Regla<DetallePedidoDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(CodigoValidoDetallePedidoRegla.obtenerInstancia());

		return listadoReglas;
	}
}