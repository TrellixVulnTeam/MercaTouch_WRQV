package co.edu.uco.mercatouch.transversal.utilitario;

import java.sql.Connection;
import java.sql.SQLException;

public class UtilSQL 
{
	private UtilSQL()
	{
			
	}
		
	public static boolean conexionEstaAbierta(Connection conexion)
	{
		var conexionEstaAbierta = true;
			
		try
		{
			conexionEstaAbierta = !UtilObjeto.esNulo(conexion) && !conexion.isClosed();
		}
		catch (SQLException excepcion)
		{
			conexionEstaAbierta = false;
		}
			
		return conexionEstaAbierta;
	}
}