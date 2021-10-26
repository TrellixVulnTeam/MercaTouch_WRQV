package co.edu.uco.mercatouch.negocio.implementacion;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import co.edu.uco.mercatouch.datos.dao.UsuarioDAO;
import co.edu.uco.mercatouch.entidad.UsuarioEntidad;
import co.edu.uco.mercatouch.negocio.UsuarioNegocio;
import co.edu.uco.mercatouch.negocio.dominio.UsuarioDominio;
import co.edu.uco.mercatouch.negocio.ensamblador.implementacion.UsuarioEnsambladorImpl;
import co.edu.uco.mercatouch.negocio.validador.enumerador.TipoValidacion;
import co.edu.uco.mercatouch.negocio.validador.implementacion.UsuarioValidador;

public class UsuarioNegocioImpl implements UsuarioNegocio 
{
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Override
	public List<UsuarioDominio> consultar(UsuarioEntidad usuarioEntidad) 
	{
		var resultados = usuarioDAO.findAll();
		
		return UsuarioEnsambladorImpl.obtenerUsuarioEnsamblador().ensamblarDominiosDesdeEntidad((List<UsuarioEntidad>) resultados);
	}

	@Override
	public void registrar(UsuarioDominio usuarioDominio) 
	{
		UsuarioValidador.obtenerInstancia().validar(usuarioDominio, TipoValidacion.CREACION);
		usuarioDAO.save(UsuarioEnsambladorImpl.obtenerUsuarioEnsamblador().ensamblarEntidadDesdeDominio(usuarioDominio));
	}

	@Override
	public void modificar(UsuarioDominio usuarioDominio) 
	{
		UsuarioValidador.obtenerInstancia().validar(usuarioDominio, TipoValidacion.ACTUALIZACION);
		usuarioDAO.save(UsuarioEnsambladorImpl.obtenerUsuarioEnsamblador().ensamblarEntidadDesdeDominio(usuarioDominio));
	}

	@Override
	public void eliminar(UsuarioDominio usuarioDominio) 
	{
		UsuarioValidador.obtenerInstancia().validar(usuarioDominio, TipoValidacion.ELIMINACION);
		usuarioDAO.delete(UsuarioEnsambladorImpl.obtenerUsuarioEnsamblador().ensamblarEntidadDesdeDominio(usuarioDominio));
	}
}
