package co.edu.uco.mercatouch.negocio.validador.implementacion.ciudad;

import co.edu.uco.mercatouch.negocio.dominio.CiudadDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class NombreValidoCiudadRegla implements Regla<CiudadDominio>
{
	private static final Regla<CiudadDominio> INSTANCIA = new NombreValidoCiudadRegla();
	
	private NombreValidoCiudadRegla()
	{
		super();
	}
	
	public static Regla<CiudadDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}

	@Override
	public void validar(CiudadDominio dato) 
	{
		validarNombreVacio(dato.getNombre());
		validarLongitudNombreValida(dato.getNombre());
		validarNombreContengaLetrasYEspacios(dato.getNombre());
	}
	
	private void validarNombreVacio(String nombre)
	{
		if (UtilTexto.cadenaEstaVacia(nombre))
		{
			throw new MercaTouchNegocioExcepcion("El nombre de una Ciudad no puede estar vacio");
		}
	}
		
	private void validarLongitudNombreValida(String nombre)
	{
		if(!UtilTexto.longitudEsValida(nombre, 1, 200))
		{
			throw new MercaTouchNegocioExcepcion("El nombre de una Ciudad debe tener minimo un caracter y maximo 50 caracteres");
		}
	}
		
	private void validarNombreContengaLetrasYEspacios(String nombre)
	{
		if(!UtilTexto.cadenaContieneSoloLetrasYEspacios(nombre))
		{
			throw new MercaTouchNegocioExcepcion("El nombre de una Ciudad solo puede contener letras y espacios");
		}
	}
}
