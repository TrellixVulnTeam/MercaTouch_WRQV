package co.edu.uco.mercatouch.negocio.implementacion;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import co.edu.uco.mercatouch.datos.dao.TiendaDAO;
import co.edu.uco.mercatouch.entidad.TiendaEntidad;
import co.edu.uco.mercatouch.negocio.TiendaNegocio;
import co.edu.uco.mercatouch.negocio.dominio.TiendaDominio;
import co.edu.uco.mercatouch.negocio.ensamblador.implementacion.TiendaEnsambladorImpl;
import co.edu.uco.mercatouch.negocio.validador.enumerador.TipoValidacion;
import co.edu.uco.mercatouch.negocio.validador.implementacion.TiendaValidador;

public class TiendaNegocioImpl implements TiendaNegocio 
{
	@Autowired
	private TiendaDAO tiendarDAO;
	
	@Override
	public List<TiendaDominio> consultar(TiendaEntidad tiendaEntidad) 
	{
		var resultados = tiendarDAO.findAll();
		
		return TiendaEnsambladorImpl.obtenerTiendaEnsamblador().ensamblarDominiosDesdeEntidad((List<TiendaEntidad>) resultados);
	}

	@Override
	public void registrar(TiendaDominio tiendaDominio) 
	{
		TiendaValidador.obtenerInstancia().validar(tiendaDominio, TipoValidacion.CREACION);
		tiendarDAO.save(TiendaEnsambladorImpl.obtenerTiendaEnsamblador().ensamblarEntidadDesdeDominio(tiendaDominio));
	}

	@Override
	public void modificar(TiendaDominio tiendaDominio) 
	{
		TiendaValidador.obtenerInstancia().validar(tiendaDominio, TipoValidacion.ACTUALIZACION);
		tiendarDAO.save(TiendaEnsambladorImpl.obtenerTiendaEnsamblador().ensamblarEntidadDesdeDominio(tiendaDominio));
	}

	@Override
	public void eliminar(TiendaDominio tiendaDominio) 
	{
		TiendaValidador.obtenerInstancia().validar(tiendaDominio, TipoValidacion.ELIMINACION);
		tiendarDAO.delete(TiendaEnsambladorImpl.obtenerTiendaEnsamblador().ensamblarEntidadDesdeDominio(tiendaDominio));
	}
}
