package co.edu.uco.mercatouch.negocio.validador.implementacion;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import co.edu.uco.mercatouch.negocio.dominio.UsuarioDominio;
import co.edu.uco.mercatouch.negocio.validador.Validador;
import co.edu.uco.mercatouch.negocio.validador.enumerador.TipoValidacion;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;

public class UsuarioValidador implements Validador<UsuarioDominio> 
{
	private EnumMap<TipoValidacion, List<Regla<UsuarioDominio>>> reglas =  new EnumMap<>(TipoValidacion.class);
	private static final Validador<UsuarioDominio> INSTANCIA = new UsuarioValidador();
	
	private UsuarioValidador()
	{
		reglas.put(TipoValidacion.CREACION, obtenerReglasCreacion());
		reglas.put(TipoValidacion.ACTUALIZACION, obtenerReglasActualizacion());
		reglas.put(TipoValidacion.ELIMINACION, obtenerReglasEliminacion());
	}

	public static Validador<UsuarioDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}
	
	@Override
	public void validar(UsuarioDominio dominio, TipoValidacion validacion) 
	{
		for(Regla<UsuarioDominio> regla : obtenerReglas(validacion)) 
		{
			regla.validar(dominio);
		}
	}
	
	private List<Regla<UsuarioDominio>> obtenerReglas(TipoValidacion tipoValidacion)
	{
		if(!reglas.containsKey(tipoValidacion))
		{
			throw new MercaTouchNegocioExcepcion("No existen reglas para el tipo de validacion " + tipoValidacion);
		}
			
		return reglas.get(tipoValidacion);
	}
	
	private List<Regla<UsuarioDominio>> obtenerReglasCreacion()
	{
		List<Regla<UsuarioDominio>> listadoReglas = new ArrayList<>();
			
		return listadoReglas;
	}
		
	private List<Regla<UsuarioDominio>> obtenerReglasActualizacion()
	{
		List<Regla<UsuarioDominio>> listadoReglas = new ArrayList<>();
			
		return listadoReglas;
	}
		
	private List<Regla<UsuarioDominio>> obtenerReglasEliminacion()
	{
		List<Regla<UsuarioDominio>> listadoReglas = new ArrayList<>();

		return listadoReglas;
	}
}
