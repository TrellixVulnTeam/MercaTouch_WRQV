package co.edu.uco.mercatouch.negocio.negocio.implementacion;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import co.edu.uco.mercatouch.datos.dao.PerfilDAO;
import co.edu.uco.mercatouch.entidad.PerfilEntidad;
import co.edu.uco.mercatouch.negocio.dominio.PerfilDominio;
import co.edu.uco.mercatouch.negocio.ensamblador.implementacion.PerfilEnsambladorImpl;
import co.edu.uco.mercatouch.negocio.negocio.PerfilNegocio;

public class PerfilNegocioImpl implements PerfilNegocio
{
	@Autowired
	private PerfilDAO perfilDAO;
	
	@Override
	public List<PerfilDominio> consultar(PerfilDominio perfilDominio) 
	{
		var resultados = perfilDAO.findAll();
		
		return PerfilEnsambladorImpl.obtenerPerfilEnsamblador().ensamblarDominiosDesdeEntidad((List<PerfilEntidad>) resultados);
	}
}