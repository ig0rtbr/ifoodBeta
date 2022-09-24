package interfaces;

import java.util.ArrayList;

import entidades.Pessoa;

public interface IRepositorioPessoa {
	public ArrayList<Pessoa> buscarPorNome(String nome);
	public Pessoa buscarPorId(int id);
	public ArrayList<Pessoa> listar();
	public boolean alterar(int id, String nome, String sobrenome, String cpf, String dataNascimento, String rua,String numero, String cep, String login, String senha);
	public boolean adicionar(String nome, String sobrenome, String cpf, String dataNascimento, String rua,String numero, String cep, String login, String senha);
	public boolean apagar(int id);
	
}
