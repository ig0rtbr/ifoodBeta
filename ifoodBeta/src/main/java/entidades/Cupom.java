package entidades;

public class Cupom extends EntidadeBasica{
	private String codigoCupom;
	private String tipoCupom;
	private float valorMinimo;
	private int idCriador;
	private String dataCriacao;
	private String dataExpiracao;
	
	public Cupom(String codigoCupom, String tipoCupom, float valorMinimo, int idCriador, String dataCriacao,
			String dataExpiracao) {
		super();
		this.codigoCupom = codigoCupom;
		this.tipoCupom = tipoCupom;
		this.valorMinimo = valorMinimo;
		this.idCriador = idCriador;
		this.dataCriacao = dataCriacao;
		this.dataExpiracao = dataExpiracao;
	}
	
	public String getCodigoCupom() {
		return codigoCupom;
	}
	public void setCodigoCupom(String codigoCupom) {
		this.codigoCupom = codigoCupom;
	}
	public String getTipoCupom() {
		return tipoCupom;
	}
	public void setTipoCupom(String tipoCupom) {
		this.tipoCupom = tipoCupom;
	}
	public float getValorMinimo() {
		return valorMinimo;
	}
	public void setValorMinimo(float valorMinimo) {
		this.valorMinimo = valorMinimo;
	}
	public int getIdCriador() {
		return idCriador;
	}
	public void setIdCriador(int idCriador) {
		this.idCriador = idCriador;
	}
	public String getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public String getDataExpiracao() {
		return dataExpiracao;
	}
	public void setDataExpiracao(String dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}
	
}
