package co.edu.uco.mercatouch.negocio.validador.implementacion.departamento;

import co.edu.uco.mercatouch.negocio.dominio.DepartamentoDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilNumero;

public class CodigoValidoDepartamentoRegla implements Regla<DepartamentoDominio> 
{
	private static final Regla<DepartamentoDominio> INSTANCIA = new CodigoValidoDepartamentoRegla();
	
	private CodigoValidoDepartamentoRegla()
	{
		super();
	}
	
	public static Regla<DepartamentoDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}
	
	@Override
	public void validar(DepartamentoDominio dato) 
	{
		validarCodigoEsMayorQueCero(dato.getCodigo());
	}
	
	private void validarCodigoEsMayorQueCero(int codigo)
	{
		if(UtilNumero.numeroEsMenorOIgual(codigo, 0))
		{
			throw new MercaTouchNegocioExcepcion("El codigo de un Departamento no puede ser menor o igual que cero");
		}
	}
}