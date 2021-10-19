package co.edu.uco.mercatouch.transversal.utilitario;

public class UtilTexto 
{
	private static final String PATRON_SOLO_LETRAS_ESPACIOS = "^[a-zA-Z·ÈÌÛ˙¡…Õ”⁄Ò— ]*$";
	private static final String PATRON_ALFANUMERICO = "^[a-zA-Z·ÈÌÛ˙¡…Õ”⁄Ò— .-_+*/#$!=,;?@0123456789]*$";
	private static final String PATRON_CORREO_ELECTRONICO = "^(([^<>()\\[\\]\\\\.,;:\\s@î]+(\\.[^<>()\\[\\]\\\\.,;:\\s@î]+)*)|(ì.+î))@((\\[[0ñ9]{1,3}\\.[0ñ9]{1,3}\\.[0ñ9]{1,3}\\.[0ñ9]{1,3}])|(([a-zA-Z\\-0ñ9]+\\.)+[a-zA-Z]{2,}))$";
	private static final String PATRON_NIT = "^([0-9]{5,15}-[0-9]{1})?$";
	private static final String PATRON_CLAVE = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
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