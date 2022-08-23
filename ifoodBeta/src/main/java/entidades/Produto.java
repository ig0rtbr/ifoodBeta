package entidades;

public class Produto extends EntidadeBasica{
	private String nomeProduto;
	private String codigoBarras;
	private String tipoProduto;
	private float preco;
	private boolean promocao;
	private float desconto;
	
	public Produto(String nomeProduto, String codigoBarras, String tipoProduto, float preco, boolean promocao,
			float desconto) {
		super();
		this.nomeProduto = nomeProduto;
		this.codigoBarras = codigoBarras;
		this.tipoProduto = tipoProduto;
		this.preco = preco;
		this.promocao = promocao;
		this.desconto = desconto;
	}
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	public String getTipoProduto() {
		return tipoProduto;
	}
	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public boolean isPromocao() {
		return promocao;
	}
	public void setPromocao(boolean promocao) {
		this.promocao = promocao;
	}
	public float getDesconto() {
		return desconto;
	}
	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}
	
	
	
}
