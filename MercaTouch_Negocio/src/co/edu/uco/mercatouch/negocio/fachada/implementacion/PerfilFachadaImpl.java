package co.edu.uco.mercatouch.negocio.fachada.implementacion;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uco.mercatouch.dto.PerfilDTO;
import co.edu.uco.mercatouch.negocio.dominio.PerfilDominio;
import co.edu.uco.mercatouch.negocio.ensamblador.implementacion.PerfilEnsambladorImpl;
import co.edu.uco.mercatouch.negocio.fachada.PerfilFachada;
import co.edu.uco.mercatouch.negocio.negocio.PerfilNegocio;

@Service
@Transactional
public class PerfilFachadaImpl implements PerfilFachada
{
	@Autowired
	PerfilNegocio perfilNegocio;
	
	@Override
	public List<PerfilDTO> consultar(PerfilDTO perfilDTO) 
	{
		List<PerfilDominio> perfilesDominio = perfilNegocio.consultar(PerfilEnsambladorImpl.obtenerPerfilEnsamblador().ensamblarDominioDesdeDTO(perfilDTO));
		return PerfilEnsambladorImpl.obtenerPerfilEnsamblador().ensamblarDTOsDesdeDominio(perfilesDominio);
	}
}
