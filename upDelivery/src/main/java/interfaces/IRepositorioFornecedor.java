package interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Fornecedor;

public interface IRepositorioFornecedor {
	public ArrayList<Fornecedor> buscarPorNome(String nome);
	public Fornecedor buscarPorId(int id);
	public ArrayList<Fornecedor> listar();
	public boolean alterar(int id, int idDono, String nomeFornecedor, String nomeFantasia, String razaoSocial, String cnpj, String tipoComercio,String rua,String numero,String cep,float precoPorKm);
	public boolean adicionar(int idDono, String nomeFornecedor, String nomeFantasia, String razaoSocial, String cnpj, String tipoComercio,String rua,String numero,String cep,float precoPorKm);
	public boolean apagar(int id);
}
