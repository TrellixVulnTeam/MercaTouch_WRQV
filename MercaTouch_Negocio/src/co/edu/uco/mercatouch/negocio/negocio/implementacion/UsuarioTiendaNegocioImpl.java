package co.edu.uco.mercatouch.negocio.negocio.implementacion;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uco.mercatouch.datos.dao.UsuarioTiendaDAO;
import co.edu.uco.mercatouch.entidad.UsuarioTiendaEntidad;
import co.edu.uco.mercatouch.negocio.dominio.UsuarioTiendaDominio;
import co.edu.uco.mercatouch.negocio.ensamblador.implementacion.UsuarioTiendaEnsambladorImpl;
import co.edu.uco.mercatouch.negocio.negocio.UsuarioTiendaNegocio;
import co.edu.uco.mercatouch.negocio.validador.enumerador.TipoValidacion;
import co.edu.uco.mercatouch.negocio.validador.implementacion.UsuarioTiendaValidador;

@Service
public class UsuarioTiendaNegocioImpl implements UsuarioTiendaNegocio
{
	@Autowired
	private UsuarioTiendaDAO usuarioTiendaDAO;

	@Override
	public List<UsuarioTiendaDominio> consultar(UsuarioTiendaDominio usuarioTiendanDominio) 
	{
		var resultados = usuarioTiendaDAO.findAll();
		
		return UsuarioTiendaEnsambladorImpl.obtenerUsuarioTiendaEnsamblador().ensamblarDominiosDesdeEntidad((List<UsuarioTiendaEntidad>) resultados);
	}

	@Override
	public void registrar(UsuarioTiendaDominio usuarioTiendanDominio) 
	{
		UsuarioTiendaValidador.obtenerInstancia().validar(usuarioTiendanDominio, TipoValidacion.CREACION);
		usuarioTiendaDAO.save(UsuarioTiendaEnsambladorImpl.obtenerUsuarioTiendaEnsamblador().ensamblarEntidadDesdeDominio(usuarioTiendanDominio));
	}

	@Override
	public void modificar(UsuarioTiendaDominio usuarioTiendanDominio) 
	{
		UsuarioTiendaValidador.obtenerInstancia().validar(usuarioTiendanDominio, TipoValidacion.ACTUALIZACION);
		usuarioTiendaDAO.save(UsuarioTiendaEnsambladorImpl.obtenerUsuarioTiendaEnsamblador().ensamblarEntidadDesdeDominio(usuarioTiendanDominio));
	}

	@Override
	public void eliminar(UsuarioTiendaDominio usuarioTiendanDominio) 
	{
		UsuarioTiendaValidador.obtenerInstancia().validar(usuarioTiendanDominio, TipoValidacion.ELIMINACION);
		usuarioTiendaDAO.delete(UsuarioTiendaEnsambladorImpl.obtenerUsuarioTiendaEnsamblador().ensamblarEntidadDesdeDominio(usuarioTiendanDominio));
	}
}