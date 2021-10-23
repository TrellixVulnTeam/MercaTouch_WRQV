package co.edu.uco.mercatouch.negocio.validador.implementacion;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import co.edu.uco.mercatouch.negocio.dominio.TiendaDominio;
import co.edu.uco.mercatouch.negocio.validador.Validador;
import co.edu.uco.mercatouch.negocio.validador.enumerador.TipoValidacion;
import co.edu.uco.mercatouch.negocio.validador.implementacion.tienda.CiudadValidoTiendaRegla;
import co.edu.uco.mercatouch.negocio.validador.implementacion.tienda.CodigoValidoTiendaRegla;
import co.edu.uco.mercatouch.negocio.validador.implementacion.tienda.DepartamentoValidoTiendaRegla;
import co.edu.uco.mercatouch.negocio.validador.implementacion.tienda.NombreValidoTiendaRegla;
import co.edu.uco.mercatouch.negocio.validador.implementacion.tienda.RutaLogoValidoTiendaRegla;
import co.edu.uco.mercatouch.negocio.validador.implementacion.tienda.TelefonoValidoTiendaRegla;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;

public class TiendaValidador implements Validador<TiendaDominio> 
{
	private EnumMap<TipoValidacion, List<Regla<TiendaDominio>>> reglas =  new EnumMap<>(TipoValidacion.class);
	private static final Validador<TiendaDominio> INSTANCIA = new TiendaValidador();
	
	private TiendaValidador()
	{
		reglas.put(TipoValidacion.CREACION, obtenerReglasCreacion());
		reglas.put(TipoValidacion.ACTUALIZACION, obtenerReglasActualizacion());
		reglas.put(TipoValidacion.ELIMINACION, obtenerReglasEliminacion());
	}

	public static Validador<TiendaDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}
	
	@Override
	public void validar(TiendaDominio dominio, TipoValidacion validacion) 
	{
		for(Regla<TiendaDominio> regla : obtenerReglas(validacion)) 
		{
			regla.validar(dominio);
		}
	}
	
	private List<Regla<TiendaDominio>> obtenerReglas(TipoValidacion tipoValidacion)
	{
		if(!reglas.containsKey(tipoValidacion))
		{
			throw new MercaTouchNegocioExcepcion("No existen reglas para el tipo de validacion " + tipoValidacion);
		}
			
		return reglas.get(tipoValidacion);
	}
	
	private List<Regla<TiendaDominio>> obtenerReglasCreacion()
	{
		List<Regla<TiendaDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(NombreValidoTiendaRegla.obtenerInstancia());
		listadoReglas.add(CiudadValidoTiendaRegla.obtenerInstancia());
		listadoReglas.add(DepartamentoValidoTiendaRegla.obtenerInstancia());
		listadoReglas.add(TelefonoValidoTiendaRegla.obtenerInstancia());
		listadoReglas.add(RutaLogoValidoTiendaRegla.obtenerInstancia());
			
		return listadoReglas;
	}
		
	private List<Regla<TiendaDominio>> obtenerReglasActualizacion()
	{
		List<Regla<TiendaDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(CodigoValidoTiendaRegla.obtenerInstancia());
		listadoReglas.add(NombreValidoTiendaRegla.obtenerInstancia());
		listadoReglas.add(CiudadValidoTiendaRegla.obtenerInstancia());
		listadoReglas.add(DepartamentoValidoTiendaRegla.obtenerInstancia());
		listadoReglas.add(TelefonoValidoTiendaRegla.obtenerInstancia());
		listadoReglas.add(RutaLogoValidoTiendaRegla.obtenerInstancia());
			
		return listadoReglas;
	}
		
	private List<Regla<TiendaDominio>> obtenerReglasEliminacion()
	{
		List<Regla<TiendaDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(CodigoValidoTiendaRegla.obtenerInstancia());

		return listadoReglas;
	}
}
