package co.edu.uco.mercatouch.negocio.validador.implementacion.producto;

import co.edu.uco.mercatouch.negocio.dominio.ProductoDominio;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class DescripcionValidoProductoRegla implements Regla<ProductoDominio>
{
	private static final Regla<ProductoDominio> INSTANCIA = new DescripcionValidoProductoRegla();
	
	private DescripcionValidoProductoRegla()
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
		validarNombreVacio(dato.getDescripcion());
		validarLongitudNombreValida(dato.getDescripcion());
		validarNombreContengaLetrasYEspacios(dato.getDescripcion());
	}
	
	private void validarNombreVacio(String nombre)
	{
		if (UtilTexto.cadenaEstaVacia(nombre))
		{
			throw new MercaTouchNegocioExcepcion("La descripcion de un Producto no puede estar vacio");
		}
	}
		
	private void validarLongitudNombreValida(String nombre)
	{
		if(!UtilTexto.longitudEsValida(nombre, 1, 200))
		{
			throw new MercaTouchNegocioExcepcion("La descripcion de un Producto debe tener minimo un caracter y maximo 50 caracteres");
		}
	}
		
	private void validarNombreContengaLetrasYEspacios(String nombre)
	{
		if(!UtilTexto.cadenaContieneSoloLetrasYEspacios(nombre))
		{
			throw new MercaTouchNegocioExcepcion("La descripcion de un Producto solo puede contener letras y espacios");
		}
	}
}
