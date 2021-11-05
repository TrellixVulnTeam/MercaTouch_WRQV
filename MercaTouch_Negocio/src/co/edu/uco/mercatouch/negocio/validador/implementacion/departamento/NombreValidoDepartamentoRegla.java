package co.edu.uco.mercatouch.negocio.validador.implementacion.departamento;

import co.edu.uco.mercatouch.negocio.dominio.DepartamentoDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class NombreValidoDepartamentoRegla implements Regla<DepartamentoDominio>
{
	private static final Regla<DepartamentoDominio> INSTANCIA = new NombreValidoDepartamentoRegla();
	
	private NombreValidoDepartamentoRegla()
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
		validarNombreVacio(dato.getNombre());
		validarLongitudNombreValida(dato.getNombre());
		validarNombreContengaLetrasYEspacios(dato.getNombre());
	}
	
	private void validarNombreVacio(String nombre)
	{
		if (UtilTexto.cadenaEstaVacia(nombre))
		{
			throw new MercaTouchNegocioExcepcion("El nombre de un Departamento no puede estar vacio");
		}
	}
		
	private void validarLongitudNombreValida(String nombre)
	{
		if(!UtilTexto.longitudEsValida(nombre, 1, 200))
		{
			throw new MercaTouchNegocioExcepcion("El nombre de un Departamento debe tener minimo un caracter y maximo 50 caracteres");
		}
	}
		
	private void validarNombreContengaLetrasYEspacios(String nombre)
	{
		if(!UtilTexto.cadenaContieneSoloLetrasYEspacios(nombre))
		{
			throw new MercaTouchNegocioExcepcion("El nombre de un Departamento solo puede contener letras y espacios");
		}
	}
}
