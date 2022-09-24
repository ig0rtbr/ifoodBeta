package entidades;

public class Venda extends EntidadeBasica{
	private String dataCompra;
	private int idProdutoVendido;
	private int idCliente;
	private float preco;
	private float desconto;
	private float precoFinal;
	private String estado;
	
	
	public Venda(int idVenda, String dataCompra, int idProdutoVendido, int idCliente, float preco, float desconto, float precoFinal,
			String estado) {
		super();
		setCodigo(idVenda);
		this.dataCompra = dataCompra;
		this.idProdutoVendido = idProdutoVendido;
		this.idCliente = idCliente;
		this.preco = preco;
		this.desconto = desconto;
		this.precoFinal = precoFinal;
		this.estado = estado;
	}
	
	public Venda(String dataCompra, int idProdutoVendido, int idCliente, float preco, float desconto, float precoFinal,
			String estado) {
		super();
		this.dataCompra = dataCompra;
		this.idProdutoVendido = idProdutoVendido;
		this.idCliente = idCliente;
		this.preco = preco;
		this.desconto = desconto;
		this.precoFinal = precoFinal;
		this.estado = estado;
	}
	public String getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(String dataCompra) {
		this.dataCompra = dataCompra;
	}
	public int getIdProdutoVendido() {
		return idProdutoVendido;
	}
	public void setIdProdutoVendido(int idProdutoVendido) {
		this.idProdutoVendido = idProdutoVendido;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public float getDesconto() {
		return desconto;
	}
	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}
	public float getPrecoFinal() {
		return precoFinal;
	}
	public void setPrecoFinal(float precoFinal) {
		this.precoFinal = precoFinal;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
