package co.edu.uco.mercatouch.dto;

import java.util.ArrayList;
import java.util.List;
import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class TiendaDTO 
{
	int codigo;
	String nombre;
	String rutaLogo;
	String direccion;
	String ciudad;
	String departamento;
	long telefono;
	int calificacion;
	AdministradorDTO administrador;
	List<DomiciliarioDTO> domiciliarios;
	List<ProductoDTO> productos;
	List<PedidoDTO> pedidos;
	
	private TiendaDTO(int codigo, String nombre, String rutaLogo, String direccion, String ciudad, String departamento, long telefono, int calificacion, AdministradorDTO administrador, List<DomiciliarioDTO> domiciliarios, List<ProductoDTO> productos, List<PedidoDTO> pedidos) 
	{
		setCodigo(codigo);
		setNombre(nombre);
		setRutaLogo(rutaLogo);
		setDireccion(direccion);
		setCiudad(ciudad);
		setDepartamento(departamento);
		setTelefono(telefono);
		setCalificacion(calificacion);
		setAdministrador(administrador);
		setDomiciliarios(domiciliarios);
		setProductos(productos);
		setPedidos(pedidos);
	}
	
	public static TiendaDTO crear(int codigo, String nombre, String rutaLogo, String direccion, String ciudad, String departamento, long telefono, int calificacion, AdministradorDTO administrador, List<DomiciliarioDTO> domiciliarios, List<ProductoDTO> productos, List<PedidoDTO> pedidos)
	{
		return new TiendaDTO(codigo, nombre, rutaLogo, direccion, ciudad, departamento, telefono, calificacion, administrador, domiciliarios, productos, pedidos);
	}
	
	public static TiendaDTO crear()
	{
		return new TiendaDTO(0, UtilTexto.BLANCO, UtilTexto.BLANCO, UtilTexto.BLANCO, UtilTexto.BLANCO, UtilTexto.BLANCO, 0, 0, AdministradorDTO.crear(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public TiendaDTO setCodigo(int codigo)
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public TiendaDTO setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}

	public String getRutaLogo() 
	{
		return rutaLogo;
	}

	public TiendaDTO setRutaLogo(String rutaLogo) 
	{
		this.rutaLogo = UtilTexto.aplicarTrim(rutaLogo);
		return this;
	}

	public String getDireccion() 
	{
		return direccion;
	}

	public TiendaDTO setDireccion(String direccion) 
	{
		this.direccion = UtilTexto.aplicarTrim(direccion);
		return this;
	}

	public String getCiudad() 
	{
		return ciudad;
	}

	public TiendaDTO setCiudad(String ciudad) 
	{
		this.ciudad = UtilTexto.aplicarTrim(ciudad);
		return this;
	}

	public String getDepartamento() 
	{
		return departamento;
	}

	public TiendaDTO setDepartamento(String departamento) 
	{
		this.departamento = UtilTexto.aplicarTrim(departamento);
		return this;
	}

	public long getTelefono() 
	{
		return telefono;
	}

	public TiendaDTO setTelefono(long telefono) 
	{
		this.telefono = telefono;
		return this;
	}

	public int getCalificacion() 
	{
		return calificacion;
	}

	public TiendaDTO setCalificacion(int calificacion) 
	{
		this.calificacion = calificacion;
		return this;
	}

	public AdministradorDTO getAdministrador() 
	{
		return administrador;
	}

	public TiendaDTO setAdministrador(AdministradorDTO administrador) 
	{
		this.administrador = administrador;
		return this;
	}

	public List<DomiciliarioDTO> getDomiciliarios() 
	{
		return domiciliarios;
	}

	public TiendaDTO setDomiciliarios(List<DomiciliarioDTO> domiciliarios) 
	{
		this.domiciliarios = domiciliarios;
		return this;
	}

	public List<ProductoDTO> getProductos() 
	{
		return productos;
	}

	public TiendaDTO setProductos(List<ProductoDTO> productos) 
	{
		this.productos = productos;
		return this;
	}

	public List<PedidoDTO> getPedidos() 
	{
		return pedidos;
	}

	public TiendaDTO setPedidos(List<PedidoDTO> pedidos) 
	{
		this.pedidos = pedidos;
		return this;
	}
}
