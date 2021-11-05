package co.edu.uco.mercatouch.negocio.negocio.implementacion;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.uco.mercatouch.datos.dao.DepartamentoDAO;
import co.edu.uco.mercatouch.entidad.DepartamentoEntidad;
import co.edu.uco.mercatouch.negocio.dominio.DepartamentoDominio;
import co.edu.uco.mercatouch.negocio.ensamblador.implementacion.DepartamentoEnsambladorImpl;
import co.edu.uco.mercatouch.negocio.negocio.DepartamentoNegocio;

@Service
public class DepartamentoNegocioImpl implements DepartamentoNegocio
{
	@Autowired
	private DepartamentoDAO departamentoDAO;
	
	@Override
	public List<DepartamentoDominio> consultar(DepartamentoDominio departamentoDominio) 
	{
		var resultados = departamentoDAO.findAll();
		
		return DepartamentoEnsambladorImpl.obtenerDepartamentoEnsamblador().ensamblarDominiosDesdeEntidad((List<DepartamentoEntidad>) resultados);
	}
}