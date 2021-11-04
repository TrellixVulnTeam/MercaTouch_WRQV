package co.edu.uco.mercatouch.entidad;

public class DetallePedidoEntidad 
{
	private int codigo;
	private int cantidad;
	private ProductoEntidad producto;
	private PedidoEntidad pedido;
	
	private DetallePedidoEntidad(int codigo, int cantidad, ProductoEntidad producto, PedidoEntidad pedido) 
	{
		setCodigo(codigo);
		setCantidad(cantidad);
		setProducto(producto);
		setPedido(pedido);
	}
	
	public static DetallePedidoEntidad crear(int codigo, int cantidad, ProductoEntidad producto, PedidoEntidad pedido)
	{
		return new DetallePedidoEntidad(codigo, cantidad, producto, pedido);
	}
	
	public static DetallePedidoEntidad crear()
	{
		return new DetallePedidoEntidad(0, 0, ProductoEntidad.crear(), PedidoEntidad.crear());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public DetallePedidoEntidad setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public int getCantidad() 
	{
		return cantidad;
	}

	public DetallePedidoEntidad setCantidad(int cantidad) 
	{
		this.cantidad = cantidad;
		return this;
	}

	public ProductoEntidad getProducto() 
	{
		return producto;
	}

	public DetallePedidoEntidad setProducto(ProductoEntidad producto) 
	{
		this.producto = producto;
		return this;
	}

	public PedidoEntidad getPedido() 
	{
		return pedido;
	}

	public DetallePedidoEntidad setPedido(PedidoEntidad pedido) 
	{
		this.pedido = pedido;
		return this;
	}
}