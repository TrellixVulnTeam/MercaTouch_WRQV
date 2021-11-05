package co.edu.uco.mercatouch.negocio.validador.implementacion.perfil;

import co.edu.uco.mercatouch.negocio.dominio.PerfilDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class NombreValidoPerfilRegla implements Regla<PerfilDominio>
{
	private static final Regla<PerfilDominio> INSTANCIA = new NombreValidoPerfilRegla();
	
	private NombreValidoPerfilRegla()
	{
		super();
	}
	
	public static Regla<PerfilDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}

	@Override
	public void validar(PerfilDominio dato) 
	{
		validarNombreVacio(dato.getNombre());
		validarLongitudNombreValida(dato.getNombre());
		validarNombreContengaLetrasYEspacios(dato.getNombre());
	}
	
	private void validarNombreVacio(String nombre)
	{
		if (UtilTexto.cadenaEstaVacia(nombre))
		{
			throw new MercaTouchNegocioExcepcion("El nombre de un Perfil no puede estar vacio");
		}
	}
		
	private void validarLongitudNombreValida(String nombre)
	{
		if(!UtilTexto.longitudEsValida(nombre, 1, 200))
		{
			throw new MercaTouchNegocioExcepcion("El nombre de un Perfil debe tener minimo un caracter y maximo 50 caracteres");
		}
	}
		
	private void validarNombreContengaLetrasYEspacios(String nombre)
	{
		if(!UtilTexto.cadenaContieneSoloLetrasYEspacios(nombre))
		{
			throw new MercaTouchNegocioExcepcion("El nombre de un Perfil solo puede contener letras y espacios");
		}
	}
}
