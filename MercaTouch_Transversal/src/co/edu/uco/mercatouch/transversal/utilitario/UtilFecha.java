package co.edu.uco.mercatouch.transversal.utilitario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchTransversalExcepcion;

public class UtilFecha 
{
	private static final String FECHA_DEFECTO = "2021/01/01";
	private static final String FORMATO_YYYY_MM_DD = "yyyy/mm/dd";
	
	private UtilFecha()
	{
		
	}
	
	public static Date obtenerFechaDefecto(Date fecha, Date valorDefecto)
	{
		return UtilObjeto.obtenerValorDefecto(fecha, valorDefecto);
	}
	
	public static Date obtenerFechaActual()
	{
		return new Date();
	}
	
	public static Date obtenerFechaPorDefecto()
	{
		return formatearFecha(FECHA_DEFECTO, FORMATO_YYYY_MM_DD);
	}
	
	public static Date obtenerFechaPorDefecto(Date fecha)
	{
		return formatearFecha(FECHA_DEFECTO, FORMATO_YYYY_MM_DD);
	}
	
	public static Date formatearFecha(String fechaTexto, String formato)
	{
		try
		{
			SimpleDateFormat formateador = new SimpleDateFormat(formato);
			
			return formateador.parse(fechaTexto);
		}
		catch(ParseException excepcion)
		{
			throw new MercaTouchTransversalExcepcion(excepcion.getMessage());
		}
		catch(Exception excepcion)
		{
			
			throw new MercaTouchTransversalExcepcion(excepcion.getMessage());
		}
	}
}