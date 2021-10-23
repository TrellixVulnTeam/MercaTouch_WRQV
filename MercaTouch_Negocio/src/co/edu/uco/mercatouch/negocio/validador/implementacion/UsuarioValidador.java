package co.edu.uco.mercatouch.negocio.validador.implementacion;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import co.edu.uco.mercatouch.negocio.dominio.UsuarioDominio;
import co.edu.uco.mercatouch.negocio.validador.Validador;
import co.edu.uco.mercatouch.negocio.validador.enumerador.TipoValidacion;
import co.edu.uco.mercatouch.negocio.validador.implementacion.usuario.ApellidosValidoUsuarioRegla;
import co.edu.uco.mercatouch.negocio.validador.implementacion.usuario.ClaveValidoUsuarioRegla;
import co.edu.uco.mercatouch.negocio.validador.implementacion.usuario.CodigoValidoUsuarioRegla;
import co.edu.uco.mercatouch.negocio.validador.implementacion.usuario.CorreoValidoUsuarioRegla;
import co.edu.uco.mercatouch.negocio.validador.implementacion.usuario.NombreValidoUsuarioRegla;
import co.edu.uco.mercatouch.negocio.validador.implementacion.usuario.NumeroIdentificacionValidoUsuarioRegla;
import co.edu.uco.mercatouch.negocio.validador.implementacion.usuario.TelefonoValidoUsuarioRegla;
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
		
		listadoReglas.add(NombreValidoUsuarioRegla.obtenerInstancia());
		listadoReglas.add(ApellidosValidoUsuarioRegla.obtenerInstancia());
		listadoReglas.add(NumeroIdentificacionValidoUsuarioRegla.obtenerInstancia());
		listadoReglas.add(TelefonoValidoUsuarioRegla.obtenerInstancia());
		listadoReglas.add(CorreoValidoUsuarioRegla.obtenerInstancia());
		listadoReglas.add(ClaveValidoUsuarioRegla.obtenerInstancia());
			
		return listadoReglas;
	}
		
	private List<Regla<UsuarioDominio>> obtenerReglasActualizacion()
	{
		List<Regla<UsuarioDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(CodigoValidoUsuarioRegla.obtenerInstancia());
		listadoReglas.add(NombreValidoUsuarioRegla.obtenerInstancia());
		listadoReglas.add(ApellidosValidoUsuarioRegla.obtenerInstancia());
		listadoReglas.add(NumeroIdentificacionValidoUsuarioRegla.obtenerInstancia());
		listadoReglas.add(TelefonoValidoUsuarioRegla.obtenerInstancia());
		listadoReglas.add(CorreoValidoUsuarioRegla.obtenerInstancia());
		listadoReglas.add(ClaveValidoUsuarioRegla.obtenerInstancia());
			
		return listadoReglas;
	}
		
	private List<Regla<UsuarioDominio>> obtenerReglasEliminacion()
	{
		List<Regla<UsuarioDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(CodigoValidoUsuarioRegla.obtenerInstancia());

		return listadoReglas;
	}
}
