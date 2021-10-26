package co.edu.uco.mercatouch.negocio.implementacion;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import co.edu.uco.mercatouch.datos.dao.AdministradorDAO;
import co.edu.uco.mercatouch.entidad.AdministradorEntidad;
import co.edu.uco.mercatouch.negocio.AdministradorNegocio;
import co.edu.uco.mercatouch.negocio.dominio.AdministradorDominio;
import co.edu.uco.mercatouch.negocio.ensamblador.implementacion.AdministradorEnsambladorImpl;
import co.edu.uco.mercatouch.negocio.validador.enumerador.TipoValidacion;
import co.edu.uco.mercatouch.negocio.validador.implementacion.AdministradorValidador;

public class AdministradorNegocioImpl implements AdministradorNegocio 
{
	@Autowired
	private AdministradorDAO administradorDAO;
	
	@Override
	public List<AdministradorDominio> consultar(AdministradorEntidad administradorEntidad) 
	{
		var resultados = administradorDAO.findAll();
		
		return AdministradorEnsambladorImpl.obtenerAdministradorEnsamblador().ensamblarDominiosDesdeEntidad((List<AdministradorEntidad>) resultados);
	}

	@Override
	public void registrar(AdministradorDominio administradorDominio) 
	{
		AdministradorValidador.obtenerInstancia().validar(administradorDominio, TipoValidacion.CREACION);
		administradorDAO.save(AdministradorEnsambladorImpl.obtenerAdministradorEnsamblador().ensamblarEntidadDesdeDominio(administradorDominio));
	}

	@Override
	public void modificar(AdministradorDominio administradorDominio) 
	{
		AdministradorValidador.obtenerInstancia().validar(administradorDominio, TipoValidacion.ACTUALIZACION);
		administradorDAO.save(AdministradorEnsambladorImpl.obtenerAdministradorEnsamblador().ensamblarEntidadDesdeDominio(administradorDominio));
	}

	@Override
	public void eliminar(AdministradorDominio administradorDominio) 
	{
		AdministradorValidador.obtenerInstancia().validar(administradorDominio, TipoValidacion.ELIMINACION);
		administradorDAO.delete(AdministradorEnsambladorImpl.obtenerAdministradorEnsamblador().ensamblarEntidadDesdeDominio(administradorDominio));
	}
}
