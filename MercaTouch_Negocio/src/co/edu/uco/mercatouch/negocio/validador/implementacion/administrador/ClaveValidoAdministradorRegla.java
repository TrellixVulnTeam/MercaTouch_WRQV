package co.edu.uco.mercatouch.negocio.validador.implementacion.administrador;

import co.edu.uco.mercatouch.negocio.dominio.AdministradorDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class ClaveValidoAdministradorRegla implements Regla<AdministradorDominio>
{
	private static final Regla<AdministradorDominio> INSTANCIA = new ClaveValidoAdministradorRegla();
	
	private ClaveValidoAdministradorRegla()
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
		validarClaveVacio(dato.getClave());
		validarLongitudClaveValida(dato.getClave());
		validarFormatoClaveElectronico(dato.getClave());
		
	}
	
	private void validarClaveVacio(String clave)
	{
		if (UtilTexto.cadenaEstaVacia(clave))
		{
			throw new MercaTouchNegocioExcepcion("la Clave de un Administrador no puede estar vacio");
		}
	}
		
	private void validarLongitudClaveValida(String clave)
	{
		if(!UtilTexto.longitudEsValida(clave, 8, 100))
		{
			throw new MercaTouchNegocioExcepcion("la Clave de un Administrador debe tener minimo 8 caracteres y maximo 100 caracteres");
		}
	}
		
	private void validarFormatoClaveElectronico(String clave)
	{
		if(!UtilTexto.cadenaClave(clave))
		{
			throw new MercaTouchNegocioExcepcion("la Clave de un Administrador debe tener minimo 8 caracteres, un caracter en mayuscula, otro en minuscula y un numero");
		}
	}
}
