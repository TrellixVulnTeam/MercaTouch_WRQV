package co.edu.uco.mercatouch.negocio.validador.implementacion.tienda;

import co.edu.uco.mercatouch.negocio.dominio.TiendaDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilNumero;

public class TelefonoValidoTiendaRegla implements Regla<TiendaDominio>
{
	private static final Regla<TiendaDominio> INSTANCIA = new TelefonoValidoTiendaRegla();
	
	private TelefonoValidoTiendaRegla()
	{
		super();
	}
	
	public static Regla<TiendaDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}
	
	@Override
	public void validar(TiendaDominio dato) 
	{
		validarTelefonoEsMayorQueCero(dato.getTelefono());
	}
	
	private void validarTelefonoEsMayorQueCero(long telefono)
	{
		if(UtilNumero.numeroEsMenorOIgual(telefono, 0))
		{
			throw new MercaTouchNegocioExcepcion("El numero de una tienda no puede ser menor o igual que cero");
		}
	}
}
