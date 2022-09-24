package servicos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import entidades.Pessoa;
import interfaces.IRepositorioPessoa;
import interfaces.IServicoPessoa;
import model.RepositorioPessoa;

public class ServicoPessoa implements IServicoPessoa{
	IRepositorioPessoa repositorio = new RepositorioPessoa();
	
	@Override
	public boolean cadastrar(String nome, String sobrenome, String cpf, String dataNascimento, String rua,String numero, String cep, String login, String senha) {
		try {
			if (!nome.isEmpty() && !sobrenome.isEmpty() && !cpf.isEmpty() && !dataNascimento.isEmpty() && !rua.isEmpty() && !numero.isEmpty() && !cep.isEmpty() && !login.isEmpty() && !senha.isEmpty()) {
				try {
					SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
					Date dataFormatada = formato.parse(dataNascimento);
					repositorio.adicionar(nome, sobrenome, cpf, dataNascimento, rua, numero, cep, login, senha);
					System.out.println("Usuario cadastrado com sucesso");
				} catch (Exception e) {
					System.out.println("Data invalida");
				}		
			}else {
				System.out.println("Preencha todos os campos");
			}
			return false;
		}catch (Exception e) {
			System.out.println("Digite valores validos");
			return false;
		}	
	}

	@Override
	public boolean alterar(Pessoa pessoa, String nome, String sobrenome, String cpf, String dataNascimento, String rua,String numero, String cep, String login, String senha) {
		try {
			if (!nome.isEmpty() && !sobrenome.isEmpty() && !cpf.isEmpty() && !dataNascimento.isEmpty() && !rua.isEmpty() && !numero.isEmpty() && !cep.isEmpty() && !login.isEmpty() && !senha.isEmpty()) {
				if (repositorio.buscarPorId(pessoa.getCodigo()) != null) {
					repositorio.alterar(pessoa.getCodigo(), nome, sobrenome, cpf, dataNascimento, rua, numero, cep, login, senha);		
					return true;
				}else {
					System.out.println("A pessoa não existe");
				}
				
			}else {
				System.out.println("Preencha todos os campos sem exceção");
			}
			return false;

		} catch (Exception e) {
			System.out.println("Digite valores validos");
			return false;
		}
	}


	@Override
	public boolean remover(Pessoa pessoa) {
		if (repositorio.buscarPorId(pessoa.getCodigo()) != null) {
			repositorio.apagar(pessoa.getCodigo());
			return true;
		}else {
			System.out.println("A pessoa não existe no banco de dados");
			return false;
		}
	}

	@Override
	public ArrayList<Pessoa> listar() {
		ArrayList<Pessoa> pessoas = repositorio.listar();
		if (pessoas.isEmpty() == false) return pessoas;
		else {
			System.out.println("Não existem registros de produtos");
			return null;
		}
	}

	@Override
	public Pessoa buscarPorCodigo(int codigo) {
		return repositorio.buscarPorId(codigo);
	}

	@Override
	public ArrayList<Pessoa> buscarPorNome(String nome) {
		return repositorio.buscarPorNome(nome);
	}

}
