package co.edu.uco.mercatouch.negocio.negocio.implementacion;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.uco.mercatouch.datos.dao.AdministradorDAO;
import co.edu.uco.mercatouch.entidad.AdministradorEntidad;
import co.edu.uco.mercatouch.negocio.dominio.AdministradorDominio;
import co.edu.uco.mercatouch.negocio.ensamblador.implementacion.AdministradorEnsambladorImpl;
import co.edu.uco.mercatouch.negocio.negocio.AdministradorNegocio;
import co.edu.uco.mercatouch.negocio.validador.enumerador.TipoValidacion;
import co.edu.uco.mercatouch.negocio.validador.implementacion.AdministradorValidador;
import co.edu.uco.mercatouch.transversal.excepcion.MercaTouchNegocioExcepcion;

@Service
public class AdministradorNegocioImpl implements AdministradorNegocio 
{
	@Autowired
	private AdministradorDAO administradorDAO;
	
	@Override
	public List<AdministradorDominio> consultar(AdministradorDominio administradorDominio) 
	{
		var resultados = administradorDAO.findAll();
		
		return AdministradorEnsambladorImpl.obtenerAdministradorEnsamblador().ensamblarDominiosDesdeEntidad((List<AdministradorEntidad>) resultados);
	}

	@Override
	public void registrar(AdministradorDominio administradorDominio) 
	{
		AdministradorValidador.obtenerInstancia().validar(administradorDominio, TipoValidacion.CREACION);
		asegurarAdministradorNoExistaConCorreo(administradorDominio);
		asegurarAdministradorNoExistaConNumeroIdentificacion(administradorDominio);
		administradorDAO.save(AdministradorEnsambladorImpl.obtenerAdministradorEnsamblador().ensamblarEntidadDesdeDominio(administradorDominio));
	}

	@Override
	public void modificar(AdministradorDominio administradorDominio) 
	{
		AdministradorValidador.obtenerInstancia().validar(administradorDominio, TipoValidacion.ACTUALIZACION);
		asegurarAdministradorNoExistaConCorreoModificar(administradorDominio);
		asegurarAdministradorNoExistaConNumeroIdentificacionModificar(administradorDominio);
		administradorDAO.save(AdministradorEnsambladorImpl.obtenerAdministradorEnsamblador().ensamblarEntidadDesdeDominio(administradorDominio));
	}

	@Override
	public void eliminar(AdministradorDominio administradorDominio) 
	{
		AdministradorValidador.obtenerInstancia().validar(administradorDominio, TipoValidacion.ELIMINACION);
		administradorDAO.delete(AdministradorEnsambladorImpl.obtenerAdministradorEnsamblador().ensamblarEntidadDesdeDominio(administradorDominio));
	}
	
	private void asegurarAdministradorNoExistaConCorreo(AdministradorDominio administradorDominio)
	{
		var administrador = AdministradorDominio.crear().setCorreo(administradorDominio.getCorreo());
		
		List<AdministradorDominio> lista = consultar(administrador);
		
		for(int i = 0; i < lista.size(); i ++)
		{
			if(administrador.getCorreo().equals(lista.get(i).getCorreo()))
			{
				throw new MercaTouchNegocioExcepcion("Ya existe un Administrador con el correo " + administradorDominio.getCorreo());
			}
		}
	}
	
	private void asegurarAdministradorNoExistaConCorreoModificar(AdministradorDominio administradorDominio)
	{	
		var administrador = AdministradorDominio.crear().setCorreo(administradorDominio.getCorreo());
		
		List<AdministradorDominio> lista = consultar(administrador);
		
		for(int i = 0; i < lista.size(); i ++)
		{
			if(administrador.getCorreo().equals(lista.get(i).getCorreo()) && administradorDominio.getCodigo() != lista.get(i).getCodigo())
			{
				throw new MercaTouchNegocioExcepcion("Ya existe un Administrador con el correo " + administradorDominio.getCorreo());
			}
		}
	}
	
	private void asegurarAdministradorNoExistaConNumeroIdentificacion(AdministradorDominio administradorDominio)
	{
		var administrador = AdministradorDominio.crear().setNumeroIdentificacion(administradorDominio.getNumeroIdentificacion());
		
		List<AdministradorDominio> lista = consultar(administrador);
		
		for(int i = 0; i < lista.size(); i ++)
		{
			if(administrador.getNumeroIdentificacion() == lista.get(i).getNumeroIdentificacion())
			{
				throw new MercaTouchNegocioExcepcion("Ya existe un Administrador con el numero de identificacion " + administradorDominio.getNumeroIdentificacion());
			}
		}
	}
	
	private void asegurarAdministradorNoExistaConNumeroIdentificacionModificar(AdministradorDominio administradorDominio)
	{	
		var administrador = AdministradorDominio.crear().setNumeroIdentificacion(administradorDominio.getNumeroIdentificacion());
		
		List<AdministradorDominio> lista = consultar(administrador);
		
		for(int i = 0; i < lista.size(); i ++)
		{
			if(administrador.getNumeroIdentificacion() == lista.get(i).getNumeroIdentificacion() && administradorDominio.getCodigo() != lista.get(i).getCodigo())
			{
				throw new MercaTouchNegocioExcepcion("Ya existe un Administrador con el numero de identificacion " + administradorDominio.getNumeroIdentificacion());
			}
		}
	}
}
