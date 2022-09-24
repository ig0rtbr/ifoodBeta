package entidades;

public class Produto extends EntidadeBasica{
	private int fornecedorResponsavel;
	private String nomeProduto;
	private String descricaoProduto;
	private String dataFabricacao;
	private String dataValidade;
	private String codigoBarras;
	private String tipoProduto;
	private float preco;
	private float desconto;
	
	public Produto(int idProduto, int fornecedorResponsavel, String nomeProduto, String descricaoProduto,
			String dataFabricacao, String dataValidade, String codigoBarras, String tipoProduto, float preco,
			float desconto) {
		super();
		setCodigo(idProduto);
		this.fornecedorResponsavel = fornecedorResponsavel;
		this.nomeProduto = nomeProduto;
		this.descricaoProduto = descricaoProduto;
		this.dataFabricacao = dataFabricacao;
		this.dataValidade = dataValidade;
		this.codigoBarras = codigoBarras;
		this.tipoProduto = tipoProduto;
		this.preco = preco;
		this.desconto = desconto;
	}
	
	public Produto (int fornecedorResponsavel, String nomeProduto, String descricaoProduto,
			String dataFabricacao, String dataValidade, String codigoBarras, String tipoProduto, float preco,
			float desconto) {
		super();
		this.fornecedorResponsavel = fornecedorResponsavel;
		this.nomeProduto = nomeProduto;
		this.descricaoProduto = descricaoProduto;
		this.dataFabricacao = dataFabricacao;
		this.dataValidade = dataValidade;
		this.codigoBarras = codigoBarras;
		this.tipoProduto = tipoProduto;
		this.preco = preco;
		this.desconto = desconto;
	}
	
	public int getFornecedorResponsavel() {
		return fornecedorResponsavel;
	}
	public void setFornecedorResponsavel(int fornecedorResponsavel) {
		this.fornecedorResponsavel = fornecedorResponsavel;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getDescricaoProduto() {
		return descricaoProduto;
	}
	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}
	public String getDataFabricacao() {
		return dataFabricacao;
	}
	public void setDataFabricacao(String dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}
	public String getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
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
	public float getDesconto() {
		return desconto;
	}
	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}
		
}
