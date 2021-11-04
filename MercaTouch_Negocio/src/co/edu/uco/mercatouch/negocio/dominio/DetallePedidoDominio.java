package co.edu.uco.mercatouch.negocio.dominio;

public class DetallePedidoDominio 
{
	private int codigo;
	private int cantidad;
	private ProductoDominio producto;
	private PedidoDominio pedido;
	
	private DetallePedidoDominio(int codigo, int cantidad, ProductoDominio producto, PedidoDominio pedido) 
	{
		setCodigo(codigo);
		setCantidad(cantidad);
		setProducto(producto);
		setPedido(pedido);
	}
	
	public static DetallePedidoDominio crear(int codigo, int cantidad, ProductoDominio producto, PedidoDominio pedido)
	{
		return new DetallePedidoDominio(codigo, cantidad, producto, pedido);
	}
	
	public static DetallePedidoDominio crear()
	{
		return new DetallePedidoDominio(0, 0, ProductoDominio.crear(), PedidoDominio.crear());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public DetallePedidoDominio setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public int getCantidad() 
	{
		return cantidad;
	}

	public DetallePedidoDominio setCantidad(int cantidad) 
	{
		this.cantidad = cantidad;
		return this;
	}

	public ProductoDominio getProducto() 
	{
		return producto;
	}

	public DetallePedidoDominio setProducto(ProductoDominio producto) 
	{
		this.producto = producto;
		return this;
	}

	public PedidoDominio getPedido() 
	{
		return pedido;
	}

	public DetallePedidoDominio setPedido(PedidoDominio pedido) 
	{
		this.pedido = pedido;
		return this;
	}
}