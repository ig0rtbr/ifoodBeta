package entidades;

public class Pessoa extends EntidadeBasica{
	private int idUsarioBanco;
	private String nome;
	private String cpf;
	private String endereco;
	private String dataNascimento;
	private String login;
	private String senha;
	
	public Pessoa(int idUsarioBanco, String nome, String cpf, String dataNascimento, String login, String senha) {
		super();
		this.idUsarioBanco = idUsarioBanco;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.login = login;
		this.senha = senha;
	}
	
	public int getIdUsarioBanco() {
		return idUsarioBanco;
	}
	public void setIdUsarioBanco(int idUsarioBanco) {
		this.idUsarioBanco = idUsarioBanco;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
