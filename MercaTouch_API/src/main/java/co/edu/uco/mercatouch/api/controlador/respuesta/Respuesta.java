package co.edu.uco.mercatouch.api.controlador.respuesta;

import java.util.ArrayList;
import java.util.List;
import co.edu.uco.mercatouch.api.controlador.respuesta.enumerador.EstadoRespuestaEnum;
import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class Respuesta<T>
{
	private EstadoRespuestaEnum estado = EstadoRespuestaEnum.NO_EXITOSA;
	private List<String> mensajes = new ArrayList<>();
	private List<T> datos;
	
	public EstadoRespuestaEnum getEstado() 
	{
		return estado;
	}
	public void setEstado(EstadoRespuestaEnum estado) 
	{
		this.estado = estado;
	}
	public List<String> getMensajes() 
	{
		return mensajes;
	}
	public void setMensajes(List<String> mensajes) 
	{
		this.mensajes = mensajes;
	}
	public List<T> getDatos() 
	{
		return datos;
	}
	public void setDatos(List<T> datos) 
	{
		this.datos = datos;
	}
	
	public void adicionarMensaje(String mensaje)
	{
		if(!UtilTexto.cadenaEsNula(mensaje))
		{
			getMensajes().add(mensaje);
		}
	}
}