package co.edu.uco.mercatouch.negocio.negocio.implementacion;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.uco.mercatouch.datos.dao.DomiciliarioDAO;
import co.edu.uco.mercatouch.entidad.DomiciliarioEntidad;
import co.edu.uco.mercatouch.negocio.dominio.DomiciliarioDominio;
import co.edu.uco.mercatouch.negocio.ensamblador.implementacion.DomiciliarioEnsambladorImpl;
import co.edu.uco.mercatouch.negocio.negocio.DomiciliarioNegocio;
import co.edu.uco.mercatouch.negocio.validador.enumerador.TipoValidacion;
import co.edu.uco.mercatouch.negocio.validador.implementacion.DomiciliarioValidador;

@Service
public class DomiciliarioNegocioImpl implements DomiciliarioNegocio 
{
	@Autowired
	DomiciliarioDAO domiciliarioDAO;
	
	@Override
	public List<DomiciliarioDominio> consultar(DomiciliarioDominio domiciliarioDominio) 
	{
		var resultados = domiciliarioDAO.findAll();
		
		return DomiciliarioEnsambladorImpl.obtenerDomiciliarioEnsamblador().ensamblarDominiosDesdeEntidad((List<DomiciliarioEntidad>) resultados);
	}

	@Override
	public void registrar(DomiciliarioDominio domiciliarioDominio) 
	{
		DomiciliarioValidador.obtenerInstancia().validar(domiciliarioDominio, TipoValidacion.CREACION);
		domiciliarioDAO.save(DomiciliarioEnsambladorImpl.obtenerDomiciliarioEnsamblador().ensamblarEntidadDesdeDominio(domiciliarioDominio));
	}

	@Override
	public void modificar(DomiciliarioDominio domiciliarioDominio) 
	{
		DomiciliarioValidador.obtenerInstancia().validar(domiciliarioDominio, TipoValidacion.ACTUALIZACION);
		domiciliarioDAO.save(DomiciliarioEnsambladorImpl.obtenerDomiciliarioEnsamblador().ensamblarEntidadDesdeDominio(domiciliarioDominio));
	}

	@Override
	public void eliminar(DomiciliarioDominio domiciliarioDominio) 
	{
		DomiciliarioValidador.obtenerInstancia().validar(domiciliarioDominio, TipoValidacion.ELIMINACION);
		domiciliarioDAO.delete(DomiciliarioEnsambladorImpl.obtenerDomiciliarioEnsamblador().ensamblarEntidadDesdeDominio(domiciliarioDominio));
	}
}
