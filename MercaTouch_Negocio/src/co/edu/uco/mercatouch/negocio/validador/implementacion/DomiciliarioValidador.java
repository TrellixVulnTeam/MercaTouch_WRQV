package co.edu.uco.mercatouch.negocio.validador.implementacion;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import co.edu.uco.mercatouch.negocio.dominio.DomiciliarioDominio;
import co.edu.uco.mercatouch.negocio.validador.Validador;
import co.edu.uco.mercatouch.negocio.validador.enumerador.TipoValidacion;
import co.edu.uco.mercatouch.negocio.validador.implementacion.domiciliario.ApellidosValidoDomiciliarioRegla;
import co.edu.uco.mercatouch.negocio.validador.implementacion.domiciliario.ClaveValidoDomiciliarioRegla;
import co.edu.uco.mercatouch.negocio.validador.implementacion.domiciliario.CodigoValidoDomiciliarioRegla;
import co.edu.uco.mercatouch.negocio.validador.implementacion.domiciliario.CorreoValidoDomiciliarioRegla;
import co.edu.uco.mercatouch.negocio.validador.implementacion.domiciliario.NombreValidoDomiciliarioRegla;
import co.edu.uco.mercatouch.negocio.validador.implementacion.domiciliario.NumeroIdentificacionValidoDomiciliarioRegla;
import co.edu.uco.mercatouch.negocio.validador.implementacion.domiciliario.TelefonoValidoDomiciliarioRegla;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;

public class DomiciliarioValidador implements Validador<DomiciliarioDominio> 
{
	private EnumMap<TipoValidacion, List<Regla<DomiciliarioDominio>>> reglas =  new EnumMap<>(TipoValidacion.class);
	private static final Validador<DomiciliarioDominio> INSTANCIA = new DomiciliarioValidador();
	
	private DomiciliarioValidador()
	{
		reglas.put(TipoValidacion.CREACION, obtenerReglasCreacion());
		reglas.put(TipoValidacion.ACTUALIZACION, obtenerReglasActualizacion());
		reglas.put(TipoValidacion.ELIMINACION, obtenerReglasEliminacion());
	}

	public static Validador<DomiciliarioDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}
	
	@Override
	public void validar(DomiciliarioDominio dominio, TipoValidacion validacion) 
	{
		for(Regla<DomiciliarioDominio> regla : obtenerReglas(validacion)) 
		{
			regla.validar(dominio);
		}
	}
	
	private List<Regla<DomiciliarioDominio>> obtenerReglas(TipoValidacion tipoValidacion)
	{
		if(!reglas.containsKey(tipoValidacion))
		{
			throw new MercaTouchNegocioExcepcion("No existen reglas para el tipo de validacion " + tipoValidacion);
		}
			
		return reglas.get(tipoValidacion);
	}
	
	private List<Regla<DomiciliarioDominio>> obtenerReglasCreacion()
	{
		List<Regla<DomiciliarioDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(NombreValidoDomiciliarioRegla.obtenerInstancia());
		listadoReglas.add(ApellidosValidoDomiciliarioRegla.obtenerInstancia());
		listadoReglas.add(NumeroIdentificacionValidoDomiciliarioRegla.obtenerInstancia());
		listadoReglas.add(TelefonoValidoDomiciliarioRegla.obtenerInstancia());
		listadoReglas.add(CorreoValidoDomiciliarioRegla.obtenerInstancia());
		listadoReglas.add(ClaveValidoDomiciliarioRegla.obtenerInstancia());
			
		return listadoReglas;
	}
		
	private List<Regla<DomiciliarioDominio>> obtenerReglasActualizacion()
	{
		List<Regla<DomiciliarioDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(CodigoValidoDomiciliarioRegla.obtenerInstancia());
		listadoReglas.add(NombreValidoDomiciliarioRegla.obtenerInstancia());
		listadoReglas.add(ApellidosValidoDomiciliarioRegla.obtenerInstancia());
		listadoReglas.add(NumeroIdentificacionValidoDomiciliarioRegla.obtenerInstancia());
		listadoReglas.add(TelefonoValidoDomiciliarioRegla.obtenerInstancia());
		listadoReglas.add(CorreoValidoDomiciliarioRegla.obtenerInstancia());
		listadoReglas.add(ClaveValidoDomiciliarioRegla.obtenerInstancia());
			
		return listadoReglas;
	}
		
	private List<Regla<DomiciliarioDominio>> obtenerReglasEliminacion()
	{
		List<Regla<DomiciliarioDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(CodigoValidoDomiciliarioRegla.obtenerInstancia());

		return listadoReglas;
	}
}