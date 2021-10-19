package co.edu.uco.mercatouch.negocio.validador.implementacion.categoria;

import co.edu.uco.mercatouch.negocio.dominio.CategoriaDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilNumero;

public class CodigoValidoCategoriaRegla implements Regla<CategoriaDominio> 
{
	private static final Regla<CategoriaDominio> INSTANCIA = new CodigoValidoCategoriaRegla();
	
	private CodigoValidoCategoriaRegla()
	{
		super();
	}
	
	public static Regla<CategoriaDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}
	
	@Override
	public void validar(CategoriaDominio dato) 
	{
		validarCodigoEsMayorQueCero(dato.getCodigo());
	}
	
	private void validarCodigoEsMayorQueCero(int codigo)
	{
		if(UtilNumero.numeroEsMenorOIgual(codigo, 0))
		{
			throw new MercaTouchNegocioExcepcion("El codigo de una Categoria no puede ser menor o igual que cero");
		}
	}
}