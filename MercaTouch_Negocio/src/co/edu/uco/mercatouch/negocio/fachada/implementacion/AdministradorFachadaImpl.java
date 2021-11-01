package co.edu.uco.mercatouch.negocio.fachada.implementacion;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uco.mercatouch.dto.AdministradorDTO;
import co.edu.uco.mercatouch.negocio.dominio.AdministradorDominio;
import co.edu.uco.mercatouch.negocio.ensamblador.implementacion.AdministradorEnsambladorImpl;
import co.edu.uco.mercatouch.negocio.fachada.AdministradorFachada;
import co.edu.uco.mercatouch.negocio.negocio.AdministradorNegocio;

@Service
@Transactional
public class AdministradorFachadaImpl implements AdministradorFachada 
{
	@Autowired
	AdministradorNegocio administradorNegocio;
	
	@Override
	public List<AdministradorDTO> consultar(AdministradorDTO administradorDTO) 
	{
		List<AdministradorDominio> administradoresDominio = administradorNegocio.consultar(AdministradorEnsambladorImpl.obtenerAdministradorEnsamblador().ensamblarDominioDesdeDTO(administradorDTO));
		return AdministradorEnsambladorImpl.obtenerAdministradorEnsamblador().ensamblarDTOsDesdeDominio(administradoresDominio);
	}

	@Override
	public void registrar(AdministradorDTO administradorDTO) 
	{
		AdministradorDominio administradorDominio = AdministradorEnsambladorImpl.obtenerAdministradorEnsamblador().ensamblarDominioDesdeDTO(administradorDTO);
		administradorNegocio.registrar(administradorDominio);
	}

	@Override
	public void modificar(AdministradorDTO administradorDTO) 
	{
		AdministradorDominio administradorDominio = AdministradorEnsambladorImpl.obtenerAdministradorEnsamblador().ensamblarDominioDesdeDTO(administradorDTO);
		administradorNegocio.modificar(administradorDominio);
	}

	@Override
	public void eliminar(AdministradorDTO administradorDTO) 
	{
		AdministradorDominio administradorDominio = AdministradorEnsambladorImpl.obtenerAdministradorEnsamblador().ensamblarDominioDesdeDTO(administradorDTO);
		administradorNegocio.eliminar(administradorDominio);
	}

	@Override
	public boolean verificarCredenciales(AdministradorDTO administradorDTO) 
	{
		AdministradorDominio administradorDominio = AdministradorEnsambladorImpl.obtenerAdministradorEnsamblador().ensamblarDominioDesdeDTO(administradorDTO);
		return administradorNegocio.verificarCredenciales(administradorDominio);
	}
}
