package co.edu.uco.mercatouch.negocio.validador.implementacion.administrador;

import co.edu.uco.mercatouch.negocio.dominio.AdministradorDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class ApellidosValidoAdministradorRegla implements Regla<AdministradorDominio>
{
	private static final Regla<AdministradorDominio> INSTANCIA = new ApellidosValidoAdministradorRegla();
	
	private ApellidosValidoAdministradorRegla()
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
		validarApellidosVacio(dato.getApellidos());
		validarLongitudApellidosValida(dato.getApellidos());
		validarApellidosContengaLetrasYEspacios(dato.getApellidos());
	}
	
	private void validarApellidosVacio(String apellidos)
	{
		if (UtilTexto.cadenaEstaVacia(apellidos))
		{
			throw new MercaTouchNegocioExcepcion("Los Apellidos de un Administrador no puede estar vacio");
		}
	}
		
	private void validarLongitudApellidosValida(String apellidos)
	{
		if(!UtilTexto.longitudEsValida(apellidos, 1, 100))
		{
			throw new MercaTouchNegocioExcepcion("Los Apellidos de un Administrador debe tener minimo un caracter y maximo 100 caracteres");
		}
	}
		
	private void validarApellidosContengaLetrasYEspacios(String apellidos)
	{
		if(!UtilTexto.cadenaContieneSoloLetrasYEspacios(apellidos))
		{
			throw new MercaTouchNegocioExcepcion("Los Apellidos de un Administrador solo puede contener letras y espacios");
		}
	}
}
