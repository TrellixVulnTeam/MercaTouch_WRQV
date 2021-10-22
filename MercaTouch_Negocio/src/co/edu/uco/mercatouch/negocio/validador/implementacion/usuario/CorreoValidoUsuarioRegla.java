package co.edu.uco.mercatouch.negocio.validador.implementacion.usuario;

import co.edu.uco.mercatouch.negocio.dominio.UsuarioDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class CorreoValidoUsuarioRegla implements Regla<UsuarioDominio>
{
	private static final Regla<UsuarioDominio> INSTANCIA = new CorreoValidoUsuarioRegla();
	
	private CorreoValidoUsuarioRegla()
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
		validarCorreoVacio(dato.getCorreo());
		validarLongitudCorreoValida(dato.getCorreo());
		validarFormatoCorreoElectronico(dato.getCorreo());
	}
	
	private void validarCorreoVacio(String correo)
	{
		if (UtilTexto.cadenaEstaVacia(correo))
		{
			throw new MercaTouchNegocioExcepcion("El correo de un Usuario no puede estar vacio");
		}
	}
		
	private void validarLongitudCorreoValida(String correo)
	{
		if(!UtilTexto.longitudEsValida(correo, 1, 100))
		{
			throw new MercaTouchNegocioExcepcion("El correo de un Usuario debe tener minimo un caracter y maximo 100 caracteres");
		}
	}
		
	private void validarFormatoCorreoElectronico(String correo)
	{
		if(!UtilTexto.cadenaCorreoElectronico(correo))
		{
			throw new MercaTouchNegocioExcepcion("El correo de un Usuario debe tener el formato de Correo Electronico");
		}
	}
}
