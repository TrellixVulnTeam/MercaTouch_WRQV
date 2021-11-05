package co.edu.uco.mercatouch.negocio.fachada.implementacion;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uco.mercatouch.dto.DepartamentoDTO;
import co.edu.uco.mercatouch.negocio.dominio.DepartamentoDominio;
import co.edu.uco.mercatouch.negocio.ensamblador.implementacion.DepartamentoEnsambladorImpl;
import co.edu.uco.mercatouch.negocio.fachada.DepartamentoFachada;
import co.edu.uco.mercatouch.negocio.negocio.DepartamentoNegocio;

@Service
@Transactional
public class DepartamentoFachadaImpl implements DepartamentoFachada
{
	@Autowired
	DepartamentoNegocio departamentoNegocio;
	
	@Override
	public List<DepartamentoDTO> consultar(DepartamentoDTO departamentoDTO) 
	{
		List<DepartamentoDominio> departamentosDominio = departamentoNegocio.consultar(DepartamentoEnsambladorImpl.obtenerDepartamentoEnsamblador().ensamblarDominioDesdeDTO(departamentoDTO));
		return DepartamentoEnsambladorImpl.obtenerDepartamentoEnsamblador().ensamblarDTOsDesdeDominio(departamentosDominio);
	}
}
