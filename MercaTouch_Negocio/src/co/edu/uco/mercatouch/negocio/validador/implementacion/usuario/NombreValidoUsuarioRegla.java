package co.edu.uco.mercatouch.negocio.validador.implementacion.usuario;

import co.edu.uco.mercatouch.negocio.dominio.UsuarioDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class NombreValidoUsuarioRegla implements Regla<UsuarioDominio>
{
	private static final Regla<UsuarioDominio> INSTANCIA = new NombreValidoUsuarioRegla();
	
	private NombreValidoUsuarioRegla()
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
		validarNombreVacio(dato.getNombre());
		validarLongitudNombreValida(dato.getNombre());
		validarNombreContengaLetrasYEspacios(dato.getNombre());
	}
	
	private void validarNombreVacio(String nombre)
	{
		if (UtilTexto.cadenaEstaVacia(nombre))
		{
			throw new MercaTouchNegocioExcepcion("El nombre de un Usuario no puede estar vacio");
		}
	}
		
	private void validarLongitudNombreValida(String nombre)
	{
		if(!UtilTexto.longitudEsValida(nombre, 1, 50))
		{
			throw new MercaTouchNegocioExcepcion("El nombre de un Usuario debe tener minimo un caracter y maximo 50 caracteres");
		}
	}
		
	private void validarNombreContengaLetrasYEspacios(String nombre)
	{
		if(!UtilTexto.cadenaContieneSoloLetrasYEspacios(nombre))
		{
			throw new MercaTouchNegocioExcepcion("El nombre de un Usuario solo puede contener letras y espacios");
		}
	}
}
