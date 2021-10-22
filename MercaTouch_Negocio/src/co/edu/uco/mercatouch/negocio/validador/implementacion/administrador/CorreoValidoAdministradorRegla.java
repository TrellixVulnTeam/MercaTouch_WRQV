package co.edu.uco.mercatouch.negocio.validador.implementacion.administrador;

import co.edu.uco.mercatouch.negocio.dominio.AdministradorDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class CorreoValidoAdministradorRegla implements Regla<AdministradorDominio>
{
	private static final Regla<AdministradorDominio> INSTANCIA = new CorreoValidoAdministradorRegla();
	
	private CorreoValidoAdministradorRegla()
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
		validarCorreoVacio(dato.getCorreo());
		validarLongitudCorreoValida(dato.getCorreo());
		validarFormatoCorreoElectronico(dato.getCorreo());
	}
	
	private void validarCorreoVacio(String correo)
	{
		if (UtilTexto.cadenaEstaVacia(correo))
		{
			throw new MercaTouchNegocioExcepcion("El correo de un Administrador no puede estar vacio");
		}
	}
		
	private void validarLongitudCorreoValida(String correo)
	{
		if(!UtilTexto.longitudEsValida(correo, 1, 100))
		{
			throw new MercaTouchNegocioExcepcion("El correo de un Administrador debe tener minimo un caracter y maximo 100 caracteres");
		}
	}
		
	private void validarFormatoCorreoElectronico(String correo)
	{
		if(!UtilTexto.cadenaCorreoElectronico(correo))
		{
			throw new MercaTouchNegocioExcepcion("El correo de un Administrador debe tener el formato de Correo Electronico");
		}
	}
}
