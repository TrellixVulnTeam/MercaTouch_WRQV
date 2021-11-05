package co.edu.uco.mercatouch.negocio.validador.implementacion.perfil;

import co.edu.uco.mercatouch.negocio.dominio.PerfilDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilNumero;

public class CodigoValidoPerfilRegla implements Regla<PerfilDominio> 
{
	private static final Regla<PerfilDominio> INSTANCIA = new CodigoValidoPerfilRegla();
	
	private CodigoValidoPerfilRegla()
	{
		super();
	}
	
	public static Regla<PerfilDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}
	
	@Override
	public void validar(PerfilDominio dato) 
	{
		validarCodigoEsMayorQueCero(dato.getCodigo());
	}
	
	private void validarCodigoEsMayorQueCero(int codigo)
	{
		if(UtilNumero.numeroEsMenorOIgual(codigo, 0))
		{
			throw new MercaTouchNegocioExcepcion("El codigo de un Perfil no puede ser menor o igual que cero");
		}
	}
}