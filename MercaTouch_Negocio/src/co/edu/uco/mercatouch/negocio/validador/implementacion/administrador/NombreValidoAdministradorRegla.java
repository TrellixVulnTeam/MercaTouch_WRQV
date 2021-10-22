package co.edu.uco.mercatouch.negocio.validador.implementacion.administrador;

import co.edu.uco.mercatouch.negocio.dominio.AdministradorDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class NombreValidoAdministradorRegla implements Regla<AdministradorDominio>
{
	private static final Regla<AdministradorDominio> INSTANCIA = new NombreValidoAdministradorRegla();
	
	private NombreValidoAdministradorRegla()
	{
		super();
	}
	
	public static Regla<AdministradorDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}

	@Override
	public void validar(AdministradorDominio dato) 
	{
		validarNombreVacio(dato.getNombre());
		validarLongitudNombreValida(dato.getNombre());
		validarNombreContengaLetrasYEspacios(dato.getNombre());
	}
	
	private void validarNombreVacio(String nombre)
	{
		if (UtilTexto.cadenaEstaVacia(nombre))
		{
			throw new MercaTouchNegocioExcepcion("El nombre de un Administrador no puede estar vacio");
		}
	}
		
	private void validarLongitudNombreValida(String nombre)
	{
		if(!UtilTexto.longitudEsValida(nombre, 1, 50))
		{
			throw new MercaTouchNegocioExcepcion("El nombre de un Administrador debe tener minimo un caracter y maximo 50 caracteres");
		}
	}
		
	private void validarNombreContengaLetrasYEspacios(String nombre)
	{
		if(!UtilTexto.cadenaContieneSoloLetrasYEspacios(nombre))
		{
			throw new MercaTouchNegocioExcepcion("El nombre de un Administrador solo puede contener letras y espacios");
		}
	}
}
