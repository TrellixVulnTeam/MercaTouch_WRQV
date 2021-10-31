package co.edu.uco.mercatouch.negocio.fachada.implementacion;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uco.mercatouch.dto.DomiciliarioDTO;
import co.edu.uco.mercatouch.negocio.dominio.DomiciliarioDominio;
import co.edu.uco.mercatouch.negocio.ensamblador.implementacion.DomiciliarioEnsambladorImpl;
import co.edu.uco.mercatouch.negocio.fachada.DomiciliarioFachada;
import co.edu.uco.mercatouch.negocio.negocio.DomiciliarioNegocio;

@Service
@Transactional
public class DomiciliarioFachadaImpl implements DomiciliarioFachada 
{
	@Autowired
	DomiciliarioNegocio domiciliarioNegocio;
	
	@Override
	public List<DomiciliarioDTO> consultar(DomiciliarioDTO domiciliarioDTO) 
	{
		List<DomiciliarioDominio> domiciliariosDominio = domiciliarioNegocio.consultar(DomiciliarioEnsambladorImpl.obtenerDomiciliarioEnsamblador().ensamblarDominioDesdeDTO(domiciliarioDTO));
		return DomiciliarioEnsambladorImpl.obtenerDomiciliarioEnsamblador().ensamblarDTOsDesdeDominio(domiciliariosDominio);
	}

	@Override
	public void registrar(DomiciliarioDTO domiciliarioDTO) 
	{
		DomiciliarioDominio domiciliarioDominio = DomiciliarioEnsambladorImpl.obtenerDomiciliarioEnsamblador().ensamblarDominioDesdeDTO(domiciliarioDTO);
		domiciliarioNegocio.registrar(domiciliarioDominio);
	}

	@Override
	public void modificar(DomiciliarioDTO domiciliarioDTO) 
	{
		DomiciliarioDominio domiciliarioDominio = DomiciliarioEnsambladorImpl.obtenerDomiciliarioEnsamblador().ensamblarDominioDesdeDTO(domiciliarioDTO);
		domiciliarioNegocio.modificar(domiciliarioDominio);
	}

	@Override
	public void eliminar(DomiciliarioDTO domiciliarioDTO) 
	{
		DomiciliarioDominio domiciliarioDominio = DomiciliarioEnsambladorImpl.obtenerDomiciliarioEnsamblador().ensamblarDominioDesdeDTO(domiciliarioDTO);
		domiciliarioNegocio.eliminar(domiciliarioDominio);
	}
}
