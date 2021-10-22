package co.edu.uco.mercatouch.negocio.validador.implementacion.usuario;

import co.edu.uco.mercatouch.negocio.dominio.UsuarioDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class ClaveValidoUsuarioRegla implements Regla<UsuarioDominio>
{
	private static final Regla<UsuarioDominio> INSTANCIA = new ClaveValidoUsuarioRegla();
	
	private ClaveValidoUsuarioRegla()
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
		validarClaveVacio(dato.getClave());
		validarLongitudClaveValida(dato.getClave());
		validarFormatoClaveElectronico(dato.getClave());
		
	}
	
	private void validarClaveVacio(String clave)
	{
		if (UtilTexto.cadenaEstaVacia(clave))
		{
			throw new MercaTouchNegocioExcepcion("la Clave de un Usuario no puede estar vacio");
		}
	}
		
	private void validarLongitudClaveValida(String clave)
	{
		if(!UtilTexto.longitudEsValida(clave, 8, 100))
		{
			throw new MercaTouchNegocioExcepcion("la Clave de un Usuario debe tener minimo 8 caracteres y maximo 100 caracteres");
		}
	}
		
	private void validarFormatoClaveElectronico(String clave)
	{
		if(!UtilTexto.cadenaClave(clave))
		{
			throw new MercaTouchNegocioExcepcion("la Clave de un Usuario debe tener minimo 8 caracteres, un caracter en mayuscula, otro en minuscula y un numero");
		}
	}
}
