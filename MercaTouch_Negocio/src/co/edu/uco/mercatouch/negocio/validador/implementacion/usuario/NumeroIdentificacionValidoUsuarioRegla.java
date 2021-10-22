package co.edu.uco.mercatouch.negocio.validador.implementacion.usuario;

import co.edu.uco.mercatouch.negocio.dominio.UsuarioDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilNumero;

public class NumeroIdentificacionValidoUsuarioRegla implements Regla<UsuarioDominio>
{
	private static final Regla<UsuarioDominio> INSTANCIA = new NumeroIdentificacionValidoUsuarioRegla();
	
	private NumeroIdentificacionValidoUsuarioRegla()
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
		validarCodigoEsMayorQueCero(dato.getNumeroIdentificacion());
	}
	
	private void validarCodigoEsMayorQueCero(long numeroIdentificacion)
	{
		if(UtilNumero.numeroEsMenorOIgual(numeroIdentificacion, 0))
		{
			throw new MercaTouchNegocioExcepcion("El numero de identificacion de un Usuario no puede ser menor o igual que cero");
		}
	}
}
