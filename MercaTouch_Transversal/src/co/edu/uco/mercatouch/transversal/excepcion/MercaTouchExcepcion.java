package co.edu.uco.mercatouch.transversal.excepcion;

public class MercaTouchExcepcion extends RuntimeException
{
	private static final long serialVersionUID = 6841996169026143892L;
	
	public MercaTouchExcepcion(String mensaje)
	{
		super(mensaje);
	}
}