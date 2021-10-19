package co.edu.uco.mercatouch.negocio.dominio;

import java.util.ArrayList;
import java.util.List;
import co.edu.uco.mercatouch.transversal.utilitario.UtilTexto;

public class TiendaDominio 
{
	int codigo;
	String nombre;
	String rutaLogo;
	String direccion;
	String ciudad;
	String departamento;
	long telefono;
	int calificacion;
	AdministradorDominio administrador;
	List<DomiciliarioDominio> domiciliarios;
	List<ProductoDominio> productos;
	List<PedidoDominio> pedidos;
	
	private TiendaDominio(int codigo, String nombre, String rutaLogo, String direccion, String ciudad, String departamento, long telefono, int calificacion, AdministradorDominio administrador, List<DomiciliarioDominio> domiciliarios, List<ProductoDominio> productos, List<PedidoDominio> pedidos) 
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
	
	public static TiendaDominio crear(int codigo, String nombre, String rutaLogo, String direccion, String ciudad, String departamento, long telefono, int calificacion, AdministradorDominio administrador, List<DomiciliarioDominio> domiciliarios, List<ProductoDominio> productos, List<PedidoDominio> pedidos)
	{
		return new TiendaDominio(codigo, nombre, rutaLogo, direccion, ciudad, departamento, telefono, calificacion, administrador, domiciliarios, productos, pedidos);
	}
	
	public static TiendaDominio crear()
	{
		return new TiendaDominio(0, UtilTexto.BLANCO, UtilTexto.BLANCO, UtilTexto.BLANCO, UtilTexto.BLANCO, UtilTexto.BLANCO, 0, 0, AdministradorDominio.crear(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public TiendaDominio setCodigo(int codigo)
	{
		this.codigo = codigo;
		return this;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public TiendaDominio setNombre(String nombre) 
	{
		this.nombre = UtilTexto.aplicarTrim(nombre);
		return this;
	}

	public String getRutaLogo() 
	{
		return rutaLogo;
	}

	public TiendaDominio setRutaLogo(String rutaLogo) 
	{
		this.rutaLogo = UtilTexto.aplicarTrim(rutaLogo);
		return this;
	}

	public String getDireccion() 
	{
		return direccion;
	}

	public TiendaDominio setDireccion(String direccion) 
	{
		this.direccion = UtilTexto.aplicarTrim(direccion);
		return this;
	}

	public String getCiudad() 
	{
		return ciudad;
	}

	public TiendaDominio setCiudad(String ciudad) 
	{
		this.ciudad = UtilTexto.aplicarTrim(ciudad);
		return this;
	}

	public String getDepartamento() 
	{
		return departamento;
	}

	public TiendaDominio setDepartamento(String departamento) 
	{
		this.departamento = UtilTexto.aplicarTrim(departamento);
		return this;
	}

	public long getTelefono() 
	{
		return telefono;
	}

	public TiendaDominio setTelefono(long telefono) 
	{
		this.telefono = telefono;
		return this;
	}

	public int getCalificacion() 
	{
		return calificacion;
	}

	public TiendaDominio setCalificacion(int calificacion) 
	{
		this.calificacion = calificacion;
		return this;
	}

	public AdministradorDominio getAdministrador() 
	{
		return administrador;
	}

	public TiendaDominio setAdministrador(AdministradorDominio administrador) 
	{
		this.administrador = administrador;
		return this;
	}

	public List<DomiciliarioDominio> getDomiciliarios() 
	{
		return domiciliarios;
	}

	public TiendaDominio setDomiciliarios(List<DomiciliarioDominio> domiciliarios) 
	{
		this.domiciliarios = domiciliarios;
		return this;
	}

	public List<ProductoDominio> getProductos() 
	{
		return productos;
	}

	public TiendaDominio setProductos(List<ProductoDominio> productos) 
	{
		this.productos = productos;
		return this;
	}

	public List<PedidoDominio> getPedidos() 
	{
		return pedidos;
	}

	public TiendaDominio setPedidos(List<PedidoDominio> pedidos) 
	{
		this.pedidos = pedidos;
		return this;
	}
}
