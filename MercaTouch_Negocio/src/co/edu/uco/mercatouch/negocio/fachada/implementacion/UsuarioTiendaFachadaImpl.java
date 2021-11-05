package co.edu.uco.mercatouch.negocio.fachada.implementacion;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uco.mercatouch.dto.UsuarioTiendaDTO;
import co.edu.uco.mercatouch.negocio.dominio.UsuarioTiendaDominio;
import co.edu.uco.mercatouch.negocio.ensamblador.implementacion.UsuarioTiendaEnsambladorImpl;
import co.edu.uco.mercatouch.negocio.fachada.UsuarioTiendaFachada;
import co.edu.uco.mercatouch.negocio.negocio.UsuarioTiendaNegocio;

@Service
@Transactional
public class UsuarioTiendaFachadaImpl implements UsuarioTiendaFachada
{
	@Autowired
	UsuarioTiendaNegocio usuarioTiendaNegocio;
	
	@Override
	public List<UsuarioTiendaDTO> consultar(UsuarioTiendaDTO usuarioTiendanDTO) 
	{
		List<UsuarioTiendaDominio> usuariosTiendaDominio = usuarioTiendaNegocio.consultar(UsuarioTiendaEnsambladorImpl.obtenerUsuarioTiendaEnsamblador().ensamblarDominioDesdeDTO(usuarioTiendanDTO));
		return UsuarioTiendaEnsambladorImpl.obtenerUsuarioTiendaEnsamblador().ensamblarDTOsDesdeDominio(usuariosTiendaDominio);
	}

	@Override
	public void registrar(UsuarioTiendaDTO usuarioTiendanDTO) 
	{
		UsuarioTiendaDominio usuarioTiendaDominio = UsuarioTiendaEnsambladorImpl.obtenerUsuarioTiendaEnsamblador().ensamblarDominioDesdeDTO(usuarioTiendanDTO);
		usuarioTiendaNegocio.registrar(usuarioTiendaDominio);
	}

	@Override
	public void modificar(UsuarioTiendaDTO usuarioTiendanDTO) 
	{
		UsuarioTiendaDominio usuarioTiendaDominio = UsuarioTiendaEnsambladorImpl.obtenerUsuarioTiendaEnsamblador().ensamblarDominioDesdeDTO(usuarioTiendanDTO);
		usuarioTiendaNegocio.modificar(usuarioTiendaDominio);
	}

	@Override
	public void eliminar(UsuarioTiendaDTO usuarioTiendanDTO) 
	{
		UsuarioTiendaDominio usuarioTiendaDominio = UsuarioTiendaEnsambladorImpl.obtenerUsuarioTiendaEnsamblador().ensamblarDominioDesdeDTO(usuarioTiendanDTO);
		usuarioTiendaNegocio.eliminar(usuarioTiendaDominio);
	}
}
