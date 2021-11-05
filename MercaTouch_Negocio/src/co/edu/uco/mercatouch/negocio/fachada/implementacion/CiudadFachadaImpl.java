package co.edu.uco.mercatouch.negocio.fachada.implementacion;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uco.mercatouch.dto.CiudadDTO;
import co.edu.uco.mercatouch.negocio.dominio.CiudadDominio;
import co.edu.uco.mercatouch.negocio.ensamblador.implementacion.CiudadEnsambladorImpl;
import co.edu.uco.mercatouch.negocio.fachada.CiudadFachada;
import co.edu.uco.mercatouch.negocio.negocio.CiudadNegocio;

@Service
@Transactional
public class CiudadFachadaImpl implements CiudadFachada
{
	@Autowired
	CiudadNegocio ciudadNegocio;
	
	@Override
	public List<CiudadDTO> consultar(CiudadDTO ciudadDTO) 
	{
		List<CiudadDominio> ciudadesDominio = ciudadNegocio.consultar(CiudadEnsambladorImpl.obtenerCiudadEnsamblador().ensamblarDominioDesdeDTO(ciudadDTO));
		return CiudadEnsambladorImpl.obtenerCiudadEnsamblador().ensamblarDTOsDesdeDominio(ciudadesDominio);
	}
}
