package co.edu.uco.mercatouch.negocio.validador.implementacion.usuario;

import co.edu.uco.mercatouch.negocio.dominio.UsuarioDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class ApellidosValidoUsuarioRegla implements Regla<UsuarioDominio>
{
	private static final Regla<UsuarioDominio> INSTANCIA = new ApellidosValidoUsuarioRegla();
	
	private ApellidosValidoUsuarioRegla()
	{
		super();
	}
	
	public static Regla<UsuarioDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}

	@Override
	public void validar(UsuarioDominio dato) 
	{
		validarApellidosVacio(dato.getApellidos());
		validarLongitudApellidosValida(dato.getApellidos());
		validarApellidosContengaLetrasYEspacios(dato.getApellidos());
	}
	
	private void validarApellidosVacio(String apellidos)
	{
		if (UtilTexto.cadenaEstaVacia(apellidos))
		{
			throw new MercaTouchNegocioExcepcion("Los Apellidos de un Usuario no puede estar vacio");
		}
	}
		
	private void validarLongitudApellidosValida(String apellidos)
	{
		if(!UtilTexto.longitudEsValida(apellidos, 1, 100))
		{
			throw new MercaTouchNegocioExcepcion("Los Apellidos de un Usuario debe tener minimo un caracter y maximo 100 caracteres");
		}
	}
		
	private void validarApellidosContengaLetrasYEspacios(String apellidos)
	{
		if(!UtilTexto.cadenaContieneSoloLetrasYEspacios(apellidos))
		{
			throw new MercaTouchNegocioExcepcion("Los Apellidos de un Usuario solo puede contener letras y espacios");
		}
	}
}
