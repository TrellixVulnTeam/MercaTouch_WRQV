package co.edu.uco.mercatouch.negocio.fachada.implementacion;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uco.mercatouch.dto.UsuarioDTO;
import co.edu.uco.mercatouch.negocio.dominio.UsuarioDominio;
import co.edu.uco.mercatouch.negocio.ensamblador.implementacion.UsuarioEnsambladorImpl;
import co.edu.uco.mercatouch.negocio.fachada.UsuarioFachada;
import co.edu.uco.mercatouch.negocio.negocio.UsuarioNegocio;

@Service
@Transactional
public class UsuarioFachadaImpl implements UsuarioFachada 
{
	@Autowired
	UsuarioNegocio usuarioNegocio;
	
	@Override
	public List<UsuarioDTO> consultar(UsuarioDTO usuarioDTO) 
	{
		List<UsuarioDominio> usuariosDominio = usuarioNegocio.consultar(UsuarioEnsambladorImpl.obtenerUsuarioEnsamblador().ensamblarDominioDesdeDTO(usuarioDTO));
		return UsuarioEnsambladorImpl.obtenerUsuarioEnsamblador().ensamblarDTOsDesdeDominio(usuariosDominio);
	}

	@Override
	public void registrar(UsuarioDTO usuarioDTO) 
	{
		UsuarioDominio usuarioDominio = UsuarioEnsambladorImpl.obtenerUsuarioEnsamblador().ensamblarDominioDesdeDTO(usuarioDTO);
		usuarioNegocio.registrar(usuarioDominio);
	}

	@Override
	public void modificar(UsuarioDTO usuarioDTO) 
	{
		UsuarioDominio usuarioDominio = UsuarioEnsambladorImpl.obtenerUsuarioEnsamblador().ensamblarDominioDesdeDTO(usuarioDTO);
		usuarioNegocio.modificar(usuarioDominio);
	}

	@Override
	public void eliminar(UsuarioDTO usuarioDTO) 
	{
		UsuarioDominio usuarioDominio = UsuarioEnsambladorImpl.obtenerUsuarioEnsamblador().ensamblarDominioDesdeDTO(usuarioDTO);
		usuarioNegocio.eliminar(usuarioDominio);
	}

	@Override
	public boolean verificarCredenciales(UsuarioDTO usuarioDTO) 
	{
		UsuarioDominio usuarioDominio = UsuarioEnsambladorImpl.obtenerUsuarioEnsamblador().ensamblarDominioDesdeDTO(usuarioDTO);
		
		return usuarioNegocio.verificarCredenciales(usuarioDominio);
	}
}
