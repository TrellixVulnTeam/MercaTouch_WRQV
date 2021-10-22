package co.edu.uco.mercatouch.negocio.validador.implementacion.producto;

import co.edu.uco.mercatouch.negocio.dominio.ProductoDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class NombreValidoProductoRegla implements Regla<ProductoDominio>
{
	private static final Regla<ProductoDominio> INSTANCIA = new NombreValidoProductoRegla();
	
	private NombreValidoProductoRegla()
	{
		super();
	}
	
	public static Regla<ProductoDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}

	@Override
	public void validar(ProductoDominio dato) 
	{
		validarNombreVacio(dato.getNombre());
		validarLongitudNombreValida(dato.getNombre());
		validarNombreContengaLetrasYEspacios(dato.getNombre());
	}
	
	private void validarNombreVacio(String nombre)
	{
		if (UtilTexto.cadenaEstaVacia(nombre))
		{
			throw new MercaTouchNegocioExcepcion("El nombre de un Producto no puede estar vacio");
		}
	}
		
	private void validarLongitudNombreValida(String nombre)
	{
		if(!UtilTexto.longitudEsValida(nombre, 1, 50))
		{
			throw new MercaTouchNegocioExcepcion("El nombre de un Producto debe tener minimo un caracter y maximo 50 caracteres");
		}
	}
		
	private void validarNombreContengaLetrasYEspacios(String nombre)
	{
		if(!UtilTexto.cadenaContieneSoloLetrasYEspacios(nombre))
		{
			throw new MercaTouchNegocioExcepcion("El nombre de un Producto solo puede contener letras y espacios");
		}
	}
}
