package entidades;

public class Login extends EntidadeBasica{
	private String token;
	private String login;
	private String senha;
	private String ip;
	private String dataLogin;
	private String dataExpiracao;
	
	public Login(String token, String login, String senha, String ip, String dataLogin, String dataExpiracao) {
		super();
		this.token = token;
		this.login = login;
		this.senha = senha;
		this.ip = ip;
		this.dataLogin = dataLogin;
		this.dataExpiracao = dataExpiracao;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
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
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getDataLogin() {
		return dataLogin;
	}
	public void setDataLogin(String dataLogin) {
		this.dataLogin = dataLogin;
	}
	public String getDataExpiracao() {
		return dataExpiracao;
	}
	public void setDataExpiracao(String dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}

}
