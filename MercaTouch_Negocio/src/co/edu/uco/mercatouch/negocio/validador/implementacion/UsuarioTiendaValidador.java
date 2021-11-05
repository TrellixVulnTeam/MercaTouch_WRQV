package co.edu.uco.mercatouch.negocio.validador.implementacion;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import co.edu.uco.mercatouch.negocio.dominio.UsuarioTiendaDominio;
import co.edu.uco.mercatouch.negocio.validador.Validador;
import co.edu.uco.mercatouch.negocio.validador.enumerador.TipoValidacion;
import co.edu.uco.mercatouch.negocio.validador.implementacion.usuariotienda.CodigoValidoUsuarioTiendaRegla;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;

public class UsuarioTiendaValidador implements Validador<UsuarioTiendaDominio>
{
	private EnumMap<TipoValidacion, List<Regla<UsuarioTiendaDominio>>> reglas =  new EnumMap<>(TipoValidacion.class);
	private static final Validador<UsuarioTiendaDominio> INSTANCIA = new UsuarioTiendaValidador();
	
	private UsuarioTiendaValidador()
	{
		reglas.put(TipoValidacion.CREACION, obtenerReglasCreacion());
		reglas.put(TipoValidacion.ACTUALIZACION, obtenerReglasActualizacion());
		reglas.put(TipoValidacion.ELIMINACION, obtenerReglasEliminacion());
	}

	public static Validador<UsuarioTiendaDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}
	
	@Override
	public void validar(UsuarioTiendaDominio dominio, TipoValidacion validacion) 
	{
		for(Regla<UsuarioTiendaDominio> regla : obtenerReglas(validacion)) 
		{
			regla.validar(dominio);
		}
	}
	
	private List<Regla<UsuarioTiendaDominio>> obtenerReglas(TipoValidacion tipoValidacion)
	{
		if(!reglas.containsKey(tipoValidacion))
		{
			throw new MercaTouchNegocioExcepcion("No existen reglas para el tipo de validacion " + tipoValidacion);
		}
			
		return reglas.get(tipoValidacion);
	}
	
	private List<Regla<UsuarioTiendaDominio>> obtenerReglasCreacion()
	{
		return new ArrayList<>();
	}
		
	private List<Regla<UsuarioTiendaDominio>> obtenerReglasActualizacion()
	{
		List<Regla<UsuarioTiendaDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(CodigoValidoUsuarioTiendaRegla.obtenerInstancia());
			
		return listadoReglas;
	}
		
	private List<Regla<UsuarioTiendaDominio>> obtenerReglasEliminacion()
	{
		List<Regla<UsuarioTiendaDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(CodigoValidoUsuarioTiendaRegla.obtenerInstancia());

		return listadoReglas;
	}
}