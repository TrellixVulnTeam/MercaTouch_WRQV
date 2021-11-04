package co.edu.uco.mercatouch.dto;

public class DetallePedidoDTO 
{
	private int codigo;
	private int cantidad;
	private ProductoDTO producto;
	private PedidoDTO pedido;
	
	public DetallePedidoDTO()
	{
		
	}
	
	private DetallePedidoDTO(int codigo, int cantidad, ProductoDTO producto, PedidoDTO pedido) 
	{
		setCodigo(codigo);
		setCantidad(cantidad);
		setProducto(producto);
		setPedido(pedido);
	}
	
	public static DetallePedidoDTO crear(int codigo, int cantidad, ProductoDTO producto, PedidoDTO pedido)
	{
		return new DetallePedidoDTO(codigo, cantidad, producto, pedido);
	}
	
	public static DetallePedidoDTO crear()
	{
		return new DetallePedidoDTO(0, 0, ProductoDTO.crear(), PedidoDTO.crear());
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public DetallePedidoDTO setCodigo(int codigo) 
	{
		this.codigo = codigo;
		return this;
	}

	public int getCantidad() 
	{
		return cantidad;
	}

	public DetallePedidoDTO setCantidad(int cantidad) 
	{
		this.cantidad = cantidad;
		return this;
	}

	public ProductoDTO getProducto() 
	{
		return producto;
	}

	public DetallePedidoDTO setProducto(ProductoDTO producto) 
	{
		this.producto = producto;
		return this;
	}

	public PedidoDTO getPedido() 
	{
		return pedido;
	}

	public DetallePedidoDTO setPedido(PedidoDTO pedido) 
	{
		this.pedido = pedido;
		return this;
	}
}