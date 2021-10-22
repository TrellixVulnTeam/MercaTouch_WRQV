package co.edu.uco.mercatouch.negocio.validador.implementacion.usuario;

import co.edu.uco.mercatouch.negocio.dominio.UsuarioDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilNumero;

public class TelefonoValidoUsuarioRegla implements Regla<UsuarioDominio>
{
	private static final Regla<UsuarioDominio> INSTANCIA = new TelefonoValidoUsuarioRegla();
	
	private TelefonoValidoUsuarioRegla()
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
		validarTelefonoEsMayorQueCero(dato.getTelefono());
	}
	
	private void validarTelefonoEsMayorQueCero(long telefono)
	{
		if(UtilNumero.numeroEsMenorOIgual(telefono, 0))
		{
			throw new MercaTouchNegocioExcepcion("El numero de un Usuario no puede ser menor o igual que cero");
		}
	}
}
