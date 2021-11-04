package co.edu.uco.mercatouch.datos.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import co.edu.uco.mercatouch.entidad.UsuarioTiendaEntidad;

@Repository
@Component
public interface UsuarioTiendaDAO extends CrudRepository<UsuarioTiendaEntidad, Integer>
{
	
}