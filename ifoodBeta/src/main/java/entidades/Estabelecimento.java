package entidades;

public class Estabelecimento extends EntidadeBasica{
	private String nomeEstabelecimento;
	private String nomeFantasia;
	private String razaoSocial;
	private String cnpj;
	private String tipoComercio;
	private int idDono;
	private String endereco;
	private float precoPorKm;
	
	public Estabelecimento(int idComercio, String nome, String cnpj, String tipoComercio,  int idDono, String endereco, float precoPorKm) {
		super();
		this.nomeEstabelecimento = nome;
		this.cnpj = cnpj;
		this.tipoComercio = tipoComercio;
		this.idDono = idDono;
		this.endereco = endereco;
		this.precoPorKm = precoPorKm;
	}
	
	public String getnomeEstabelecimento() {
		return nomeEstabelecimento;
	}
	public void setnomeEstabelecimento(String nome) {
		this.nomeEstabelecimento = nome;
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
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

	public float getPrecoPorKm() {
		return precoPorKm;
	}

	public void setPrecoPorKm(float precoPorKm) {
		this.precoPorKm = precoPorKm;
	}

	public int getIdDono() {
		return idDono;
	}

	public void setIdDono(int idDono) {
		this.idDono = idDono;
	}
	
	
}
