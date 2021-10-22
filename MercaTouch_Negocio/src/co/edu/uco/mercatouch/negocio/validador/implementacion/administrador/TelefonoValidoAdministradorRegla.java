package co.edu.uco.mercatouch.negocio.validador.implementacion.administrador;

import co.edu.uco.mercatouch.negocio.dominio.AdministradorDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilNumero;

public class TelefonoValidoAdministradorRegla implements Regla<AdministradorDominio>
{
	private static final Regla<AdministradorDominio> INSTANCIA = new TelefonoValidoAdministradorRegla();
	
	private TelefonoValidoAdministradorRegla()
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
		validarTelefonoEsMayorQueCero(dato.getCodigo());
	}
	
	private void validarTelefonoEsMayorQueCero(int telefono)
	{
		if(UtilNumero.numeroEsMenorOIgual(telefono, 0))
		{
			throw new MercaTouchNegocioExcepcion("El numero de un Administrador no puede ser menor o igual que cero");
		}
	}
}
