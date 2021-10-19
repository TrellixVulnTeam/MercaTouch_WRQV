package co.edu.uco.mercatouch.negocio.fachada;

import java.util.List;
import co.edu.uco.mercatouch.dto.AdministradorDTO;

public interface AdministradorFachada 
{
	List<AdministradorDTO> consultar(AdministradorDTO administradorDTO);
	void registrar(AdministradorDTO administradorDTO);
	void modificar(AdministradorDTO administradorDTO);
	void eliminar(AdministradorDTO administradorDTO);
}