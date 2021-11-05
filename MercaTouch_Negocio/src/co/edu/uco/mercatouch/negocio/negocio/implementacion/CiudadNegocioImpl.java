package co.edu.uco.mercatouch.negocio.negocio.implementacion;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.uco.mercatouch.datos.dao.CiudadDAO;
import co.edu.uco.mercatouch.entidad.CiudadEntidad;
import co.edu.uco.mercatouch.negocio.dominio.CiudadDominio;
import co.edu.uco.mercatouch.negocio.ensamblador.implementacion.CiudadEnsambladorImpl;
import co.edu.uco.mercatouch.negocio.negocio.CiudadNegocio;

@Service
public class CiudadNegocioImpl implements CiudadNegocio
{
	@Autowired
	private CiudadDAO ciudadDAO;
	
	@Override
	public List<CiudadDominio> consultar(CiudadDominio ciudadDominio) 
	{
		var resultados = ciudadDAO.findAll();
		
		return CiudadEnsambladorImpl.obtenerCiudadEnsamblador().ensamblarDominiosDesdeEntidad((List<CiudadEntidad>) resultados);
	}
}