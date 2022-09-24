package entidades;

public class Pessoa extends EntidadeBasica{
	private String nome;
	private String sobrenome;
	private String cpf;
	private String dataNascimento;
	private String rua;
	private String numero;
	private String cep;
	private String login;
	private String senha;
		
	public Pessoa(int idUsarioBanco, String nome, String sobrenome, String cpf, String dataNascimento, String rua,
			String numero, String cep, String login, String senha) {
		super();
		setCodigo(idUsarioBanco);
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.login = login;
		this.senha = senha;
	}
	
	public Pessoa(String nome, String sobrenome, String cpf, String dataNascimento, String rua,
			String numero, String cep, String login, String senha) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.login = login;
		this.senha = senha;
	}
	

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
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
