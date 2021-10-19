package co.edu.uco.mercatouch.negocio.validador;

import co.edu.uco.mercatouch.negocio.validador.enumerador.TipoValidacion;

public interface Validador<D> 
{
	void validar(D dominio, TipoValidacion validacion);
}
