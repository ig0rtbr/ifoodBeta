package entidades;

public class Venda extends EntidadeBasica{
	private int idPessoa;
	private int idEstabelecimento;
	private String idProduto;
	private int quantidade;	
	private float preco;
	private int idCupom;
	
	public Venda(int idPessoa, int idEstabelecimento, String idProduto, int quantidade, float preco, int idCupom) {
		super();
		this.idPessoa = idPessoa;
		this.idEstabelecimento = idEstabelecimento;
		this.idProduto = idProduto;
		this.quantidade = quantidade;
		this.preco = preco;
		this.idCupom = idCupom;
	}
	public int getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}
	public int getIdEstabelecimento() {
		return idEstabelecimento;
	}
	public void setIdEstabelecimento(int idEstabelecimento) {
		this.idEstabelecimento = idEstabelecimento;
	}
	public String getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public int getIdCupom() {
		return idCupom;
	}
	public void setIdCupom(int idCupom) {
		this.idCupom = idCupom;
	}
	
}
