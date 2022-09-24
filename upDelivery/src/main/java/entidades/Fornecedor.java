package entidades;

public class Fornecedor extends EntidadeBasica{
	private int idDono;
	private String nomeFornecedor;
	private String nomeFantasia;
	private String razaoSocial;
	private String cnpj;
	private String tipoComercio;
	private String rua;
	private String numero;
	private String cep;
	private float precoPorKm;
	
	
	public Fornecedor(int idFornecedor, int idDono, String nomeFornecedor, String nomeFantasia, String razaoSocial, String cnpj,
			String tipoComercio, String rua, String numero, String cep, float precoPorKm) { 
		super(); 
		setCodigo(idFornecedor);
		this.idDono = idDono;
		this.nomeFornecedor = nomeFornecedor;
		this.nomeFantasia = nomeFantasia;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.tipoComercio = tipoComercio;
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.precoPorKm = precoPorKm;
	}
	
	public Fornecedor(int idDono, String nomeFornecedor, String nomeFantasia, String razaoSocial, String cnpj,
			String tipoComercio, String rua, String numero, String cep, float precoPorKm) {
		super();
		this.idDono = idDono;
		this.nomeFornecedor = nomeFornecedor;
		this.nomeFantasia = nomeFantasia;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.tipoComercio = tipoComercio;
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.precoPorKm = precoPorKm;
	}

	public int getIdDono() {
		return idDono;
	}
	public void setIdDono(int idDono) {
		this.idDono = idDono;
	}
	public String getNomeFornecedor() {
		return nomeFornecedor;
	}
	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getTipoComercio() {
		return tipoComercio;
	}
	public void setTipoComercio(String tipoComercio) {
		this.tipoComercio = tipoComercio;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public float getPrecoPorKm() {
		return precoPorKm;
	}
	public void setPrecoPorKm(float precoPorKm) {
		this.precoPorKm = precoPorKm;
	}
	
	
}
