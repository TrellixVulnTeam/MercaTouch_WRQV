package co.edu.uco.mercatouch.negocio.validador.implementacion;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import co.edu.uco.mercatouch.negocio.dominio.ProductoDominio;
import co.edu.uco.mercatouch.negocio.validador.Validador;
import co.edu.uco.mercatouch.negocio.validador.enumerador.TipoValidacion;
import co.edu.uco.mercatouch.negocio.validador.implementacion.producto.CodigoValidoProductoRegla;
import co.edu.uco.mercatouch.negocio.validador.implementacion.producto.DescripcionValidoProductoRegla;
import co.edu.uco.mercatouch.negocio.validador.implementacion.producto.NombreValidoProductoRegla;
import co.edu.uco.mercatouch.negocio.validador.implementacion.producto.PrecioValidoProductoRegla;
import co.edu.uco.mercatouch.negocio.validador.regla.Regla;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;

public class ProductoValidador implements Validador<ProductoDominio> 
{
	private EnumMap<TipoValidacion, List<Regla<ProductoDominio>>> reglas =  new EnumMap<>(TipoValidacion.class);
	private static final Validador<ProductoDominio> INSTANCIA = new ProductoValidador();
	
	private ProductoValidador()
	{
		reglas.put(TipoValidacion.CREACION, obtenerReglasCreacion());
		reglas.put(TipoValidacion.ACTUALIZACION, obtenerReglasActualizacion());
		reglas.put(TipoValidacion.ELIMINACION, obtenerReglasEliminacion());
	}

	public static Validador<ProductoDominio> obtenerInstancia()
	{
		return INSTANCIA;
	}
	
	@Override
	public void validar(ProductoDominio dominio, TipoValidacion validacion) 
	{
		for(Regla<ProductoDominio> regla : obtenerReglas(validacion)) 
		{
			regla.validar(dominio);
		}
	}
	
	private List<Regla<ProductoDominio>> obtenerReglas(TipoValidacion tipoValidacion)
	{
		if(!reglas.containsKey(tipoValidacion))
		{
			throw new MercaTouchNegocioExcepcion("No existen reglas para el tipo de validacion " + tipoValidacion);
		}
			
		return reglas.get(tipoValidacion);
	}
	
	private List<Regla<ProductoDominio>> obtenerReglasCreacion()
	{
		List<Regla<ProductoDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(NombreValidoProductoRegla.obtenerInstancia());
		listadoReglas.add(DescripcionValidoProductoRegla.obtenerInstancia());
		listadoReglas.add(PrecioValidoProductoRegla.obtenerInstancia());
			
		return listadoReglas;
	}
		
	private List<Regla<ProductoDominio>> obtenerReglasActualizacion()
	{
		List<Regla<ProductoDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(CodigoValidoProductoRegla.obtenerInstancia());
		listadoReglas.add(NombreValidoProductoRegla.obtenerInstancia());
		listadoReglas.add(DescripcionValidoProductoRegla.obtenerInstancia());
		listadoReglas.add(PrecioValidoProductoRegla.obtenerInstancia());
			
		return listadoReglas;
	}
		
	private List<Regla<ProductoDominio>> obtenerReglasEliminacion()
	{
		List<Regla<ProductoDominio>> listadoReglas = new ArrayList<>();
		
		listadoReglas.add(CodigoValidoProductoRegla.obtenerInstancia());

		return listadoReglas;
	}
}