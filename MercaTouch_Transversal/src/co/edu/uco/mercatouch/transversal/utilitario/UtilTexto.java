package co.edu.uco.mercatouch.transversal.utilitario;

public class UtilTexto 
{
	private static final String PATRON_SOLO_LETRAS_ESPACIOS = "^[a-zA-Z·ÈÌÛ˙¡…Õ”⁄Ò— ]*$";
	private static final String PATRON_ALFANUMERICO = "^[a-zA-Z·ÈÌÛ˙¡…Õ”⁄Ò— .-_+*/#$!=,;?@0123456789]*$";
	private static final String PATRON_CORREO_ELECTRONICO = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
	private static final String PATRON_NIT = "^([0-9]{5,15}-[0-9]{1})?$";
	private static final String PATRON_CLAVE = "^(?=.*[a-z])(?=.*[A-Z])(?=.*?[0-9]).{8,}$";
	private static final String PATRON_URL = "^(ftp|http|https):\\/\\/[^ \"]+$";
	public static final String BLANCO = "";

	private UtilTexto()
	{
			
	}
		
	public static boolean cadenaEsNula(String cadena)
	{
		return UtilObjeto.esNulo(cadena);
	}
		
	public static String obtenerValorDefecto(String cadena)
	{
		return UtilObjeto.obtenerValorDefecto(cadena, "");
	}
		
	public static String aplicarTrim(String cadena)
	{
		return obtenerValorDefecto(cadena.trim());
	}

	public static boolean cadenaEstaVacia(String cadena)
	{
		return "".equals(aplicarTrim(cadena));
	}
		
	public static boolean longitudMinimaEsValida(String cadena, int longitudMinima)
	{
		return UtilNumero.numeroEsMayorOIgual(aplicarTrim(cadena).length(), longitudMinima);
	}
		
	public static boolean longitudMaximaEsValida(String cadena, int longitudMaxima)
	{
		return aplicarTrim(cadena).length() <= longitudMaxima;
	}
		
	public static boolean longitudEsValida(String cadena, int longitudMinima, int longitudMaxima)
	{
		return longitudMinimaEsValida(cadena, longitudMinima) && longitudMaximaEsValida( cadena, longitudMaxima);
	}
		
	public static boolean cadenaCumplePatron(String cadena, String patron)
	{
		return aplicarTrim(cadena).matches(patron);
	}
		
	public static boolean cadenaContieneSoloLetrasYEspacios(String cadena)
	{
		return cadenaCumplePatron(cadena, PATRON_SOLO_LETRAS_ESPACIOS);
	}
		
	public static boolean cadenaAlfanumerica(String cadena)
	{
		return cadenaCumplePatron(cadena, PATRON_ALFANUMERICO);
	}
	
	public static boolean cadenaCorreoElectronico(String cadena)
	{
		return cadenaCumplePatron(cadena, PATRON_CORREO_ELECTRONICO);
	}
	
	public static boolean cadenaClave(String cadena)
	{
		return cadenaCumplePatron(cadena, PATRON_CLAVE);
	}
	
	public static boolean cadenaNIT(String cadena)
	{
		return cadenaCumplePatron(cadena, PATRON_NIT);
	}
	
	public static boolean cadenaURL(String cadena)
	{
		return cadenaCumplePatron(cadena, PATRON_URL);
	}
}