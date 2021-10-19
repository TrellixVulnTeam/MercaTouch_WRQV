package co.edu.uco.mercatouch.negocio.ensamblador;

import java.util.List;

public interface Ensamblador<D, E, T> 
{
	D ensamblarDominioDesdeEntidad(E entidad);
	
	List<D> ensamblarDominiosDesdeEntidad(List<E> entidades);
	
	E ensamblarEntidadDesdeDominio(D dominio);
	
	List<E> ensamblarEntidadesDesdeDominio(List<D> dominios);
	
	D ensamblarDominioDesdeDTO(T dto);
	
	List<D> ensamblarDominiosDesdeDTO(List<T> dtos);
	
	T ensamblarDTODesdeDominio(D dominio);
	
	List<T> ensamblarDTOsDesdeDominio(List<D> dominios);
}