package co.edu.uco.mercatouch.negocio.validador.implementacion.usuariotienda;

import co.edu.uco.mercatouch.negocio.dominio.UsuarioTiendaDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilNumero;

public class CodigoValidoUsuarioTiendaRegla implements Regla<UsuarioTiendaDominio> 
{
	private static final Regla<UsuarioTiendaDominio> INSTANCIA = new CodigoValidoUsuarioTiendaRegla();
	
	private CodigoValidoUsuarioTiendaRegla()
	{
		super();
	}
	
	public static Regla<UsuarioTiendaDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}
	
	@Override
	public void validar(UsuarioTiendaDominio dato) 
	{
		validarCodigoEsMayorQueCero(dato.getCodigo());
	}
	
	private void validarCodigoEsMayorQueCero(int codigo)
	{
		if(UtilNumero.numeroEsMenorOIgual(codigo, 0))
		{
			throw new MercaTouchNegocioExcepcion("El codigo de un UsuarioTienda no puede ser menor o igual que cero");
		}
	}
}