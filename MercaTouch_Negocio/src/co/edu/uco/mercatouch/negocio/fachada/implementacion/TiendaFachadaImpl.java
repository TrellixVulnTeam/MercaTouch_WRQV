package co.edu.uco.mercatouch.negocio.fachada.implementacion;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uco.mercatouch.dto.TiendaDTO;
import co.edu.uco.mercatouch.negocio.dominio.TiendaDominio;
import co.edu.uco.mercatouch.negocio.ensamblador.implementacion.TiendaEnsambladorImpl;
import co.edu.uco.mercatouch.negocio.fachada.TiendaFachada;
import co.edu.uco.mercatouch.negocio.negocio.TiendaNegocio;

@Service
@Transactional
public class TiendaFachadaImpl implements TiendaFachada 
{
	@Autowired
	TiendaNegocio tiendaNegocio;
	
	@Override
	public List<TiendaDTO> consultar(TiendaDTO tiendaDTO) 
	{
		List<TiendaDominio> tiendasDominio = tiendaNegocio.consultar(TiendaEnsambladorImpl.obtenerTiendaEnsamblador().ensamblarDominioDesdeDTO(tiendaDTO));
		return TiendaEnsambladorImpl.obtenerTiendaEnsamblador().ensamblarDTOsDesdeDominio(tiendasDominio);
	}

	@Override
	public void registrar(TiendaDTO tiendaDTO) 
	{
		TiendaDominio tiendaDominio = TiendaEnsambladorImpl.obtenerTiendaEnsamblador().ensamblarDominioDesdeDTO(tiendaDTO);
		tiendaNegocio.registrar(tiendaDominio);
	}

	@Override
	public void modificar(TiendaDTO tiendaDTO) 
	{
		TiendaDominio tiendaDominio = TiendaEnsambladorImpl.obtenerTiendaEnsamblador().ensamblarDominioDesdeDTO(tiendaDTO);
		tiendaNegocio.modificar(tiendaDominio);
	}

	@Override
	public void eliminar(TiendaDTO tiendaDTO) 
	{
		TiendaDominio tiendaDominio = TiendaEnsambladorImpl.obtenerTiendaEnsamblador().ensamblarDominioDesdeDTO(tiendaDTO);
		tiendaNegocio.eliminar(tiendaDominio);
	}
}
