package co.edu.uco.mercatouch.negocio.validador.implementacion.categoria;

import co.edu.uco.mercatouch.negocio.dominio.CategoriaDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class NombreValidoCategoriaRegla implements Regla<CategoriaDominio>
{
	private static final Regla<CategoriaDominio> INSTANCIA = new NombreValidoCategoriaRegla();
	
	private NombreValidoCategoriaRegla()
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
		validarNombreVacio(dato.getNombre());
		validarLongitudNombreValida(dato.getNombre());
		validarNombreContengaLetrasYEspacios(dato.getNombre());
	}
	
	private void validarNombreVacio(String nombre)
	{
		if (UtilTexto.cadenaEstaVacia(nombre))
		{
			throw new MercaTouchNegocioExcepcion("El nombre de una Categoria no puede estar vacio");
		}
	}
		
	private void validarLongitudNombreValida(String nombre)
	{
		if(!UtilTexto.longitudEsValida(nombre, 1, 50))
		{
			throw new MercaTouchNegocioExcepcion("El nombre de una Categoria debe tener minimo un caracter y maximo 50 caracteres");
		}
	}
		
	private void validarNombreContengaLetrasYEspacios(String nombre)
	{
		if(!UtilTexto.cadenaContieneSoloLetrasYEspacios(nombre))
		{
			throw new MercaTouchNegocioExcepcion("El nombre de una Categoria solo puede contener letras y espacios");
		}
	}
}
