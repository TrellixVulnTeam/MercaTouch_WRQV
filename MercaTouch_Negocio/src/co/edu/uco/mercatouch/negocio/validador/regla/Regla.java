package co.edu.uco.mercatouch.negocio.validador.regla;

public interface Regla<T> 
{
	void validar(T dato);
}
