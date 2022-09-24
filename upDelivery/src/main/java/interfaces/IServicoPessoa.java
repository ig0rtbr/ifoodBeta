package interfaces;

import java.util.ArrayList;

import entidades.Pessoa;

public interface IServicoPessoa {
	public boolean cadastrar(String nome, String sobrenome, String cpf, String dataNascimento, String rua,String numero, String cep, String login, String senha);
	public boolean alterar(Pessoa pessoa,String nome, String sobrenome, String cpf, String dataNascimento, String rua,String numero, String cep, String login, String senha);
	public boolean remover(Pessoa pessoa);
    public ArrayList<Pessoa> listar();
    public Pessoa buscarPorCodigo(int codigo);
    public ArrayList<Pessoa> buscarPorNome(String nome);

}
