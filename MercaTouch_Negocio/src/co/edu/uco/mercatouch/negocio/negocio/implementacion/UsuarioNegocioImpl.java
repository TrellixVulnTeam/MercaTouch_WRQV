package co.edu.uco.mercatouch.negocio.negocio.implementacion;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.uco.mercatouch.datos.dao.UsuarioDAO;
import co.edu.uco.mercatouch.entidad.UsuarioEntidad;
import co.edu.uco.mercatouch.negocio.dominio.UsuarioDominio;
import co.edu.uco.mercatouch.negocio.ensamblador.implementacion.UsuarioEnsambladorImpl;
import co.edu.uco.mercatouch.negocio.negocio.UsuarioNegocio;
import co.edu.uco.mercatouch.negocio.validador.enumerador.TipoValidacion;
import co.edu.uco.mercatouch.negocio.validador.implementacion.UsuarioValidador;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@Service
public class UsuarioNegocioImpl implements UsuarioNegocio 
{
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Override
	public List<UsuarioDominio> consultar(UsuarioDominio usuarioDominio) 
	{
		var resultados = usuarioDAO.findAll();
		
		return UsuarioEnsambladorImpl.obtenerUsuarioEnsamblador().ensamblarDominiosDesdeEntidad((List<UsuarioEntidad>) resultados);
	}

	@Override
	public void registrar(UsuarioDominio usuarioDominio) 
	{
		UsuarioValidador.obtenerInstancia().validar(usuarioDominio, TipoValidacion.CREACION);
		asegurarUsuarioNoExistaConCorreo(usuarioDominio);
		asegurarUsuarioNoExistaConNumeroIdentificacion(usuarioDominio);
		usuarioDAO.save(UsuarioEnsambladorImpl.obtenerUsuarioEnsamblador().ensamblarEntidadDesdeDominio(usuarioDominio));
	}

	@Override
	public void modificar(UsuarioDominio usuarioDominio) 
	{
		UsuarioValidador.obtenerInstancia().validar(usuarioDominio, TipoValidacion.ACTUALIZACION);
		asegurarUsuarioNoExistaConCorreoModificar(usuarioDominio);
		asegurarUsuarioNoExistaConNumeroIdentificacionModificar(usuarioDominio);
		usuarioDAO.save(UsuarioEnsambladorImpl.obtenerUsuarioEnsamblador().ensamblarEntidadDesdeDominio(usuarioDominio));
	}

	@Override
	public void eliminar(UsuarioDominio usuarioDominio) 
	{
		UsuarioValidador.obtenerInstancia().validar(usuarioDominio, TipoValidacion.ELIMINACION);
		usuarioDAO.delete(UsuarioEnsambladorImpl.obtenerUsuarioEnsamblador().ensamblarEntidadDesdeDominio(usuarioDominio));
	}
	
	@Override
	public boolean verificarCredenciales(UsuarioDominio usuarioDominio) 
	{
		var usuario = UsuarioDominio.crear().setCorreo(usuarioDominio.getCorreo());
		
		List<UsuarioDominio> listaUsuario = consultar(usuario);
		
		List<UsuarioDominio> lista = new ArrayList<>();
		
		for(int i = 0; i < listaUsuario.size(); i ++)
		{
			if(usuario.getCorreo().equals(listaUsuario.get(i).getCorreo()))
			{
				lista.add(listaUsuario.get(i));
			}
		}
		
		if(lista.isEmpty())
		{
			return false;
		}
		
		String claveHashed = listaUsuario.get(0).getClave();
		
		Argon2 argon = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
		
		return argon.verify(claveHashed, usuarioDominio.getClave());
	}
	
	private void asegurarUsuarioNoExistaConCorreo(UsuarioDominio usuarioDominio)
	{
		var usuario = UsuarioDominio.crear().setCorreo(usuarioDominio.getCorreo());
		
		List<UsuarioDominio> lista = consultar(usuario);
		
		for(int i = 0; i < lista.size(); i ++)
		{
			if(usuario.getCorreo().equals(lista.get(i).getCorreo()))
			{
				throw new MercaTouchNegocioExcepcion("Ya existe un Usuario con el correo " + usuarioDominio.getCorreo());
			}
		}
	}
	
	private void asegurarUsuarioNoExistaConCorreoModificar(UsuarioDominio usuarioDominio)
	{	
		var usuario = UsuarioDominio.crear().setCorreo(usuarioDominio.getCorreo());
		
		List<UsuarioDominio> lista = consultar(usuario);
		
		for(int i = 0; i < lista.size(); i ++)
		{
			if(usuario.getCorreo().equals(lista.get(i).getCorreo()) && usuarioDominio.getCodigo() != lista.get(i).getCodigo())
			{
				throw new MercaTouchNegocioExcepcion("Ya existe un Usuario con el correo " + usuarioDominio.getCorreo());
			}
		}
	}
	
	private void asegurarUsuarioNoExistaConNumeroIdentificacion(UsuarioDominio usuarioDominio)
	{
		var usuario = UsuarioDominio.crear().setNumeroIdentificacion(usuarioDominio.getNumeroIdentificacion());
		
		List<UsuarioDominio> lista = consultar(usuario);
		
		for(int i = 0; i < lista.size(); i ++)
		{
			if(usuario.getNumeroIdentificacion() == lista.get(i).getNumeroIdentificacion())
			{
				throw new MercaTouchNegocioExcepcion("Ya existe un Usuario con el numero de identificacion " + usuarioDominio.getNumeroIdentificacion());
			}
		}
	}
	
	private void asegurarUsuarioNoExistaConNumeroIdentificacionModificar(UsuarioDominio usuarioDominio)
	{	
		var usuario = UsuarioDominio.crear().setNumeroIdentificacion(usuarioDominio.getNumeroIdentificacion());
		
		List<UsuarioDominio> lista = consultar(usuario);
		
		for(int i = 0; i < lista.size(); i ++)
		{
			if(usuario.getNumeroIdentificacion() == lista.get(i).getNumeroIdentificacion() && usuarioDominio.getCodigo() != lista.get(i).getCodigo())
			{
				throw new MercaTouchNegocioExcepcion("Ya existe un Usuario con el numero de identificacion " + usuarioDominio.getNumeroIdentificacion());
			}
		}
	}
}
