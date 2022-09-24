package interfaces;

import java.util.ArrayList;

import entidades.Fornecedor;

public interface IServicoFornecedor {
	public boolean cadastrar(int idDono, String nomeFornecedor, String nomeFantasia, String razaoSocial, String cnpj, String tipoComercio,String rua,String numero,String cep,float precoPorKm);
    public boolean atualizar(Fornecedor fornecedor, int idDono, String nomeFornecedor, String nomeFantasia, String razaoSocial, String cnpj, String tipoComercio,String rua,String numero,String cep,float precoPorKm);
    public boolean remover(Fornecedor fornecedor);
    public ArrayList<Fornecedor> listar();
    public Fornecedor buscarPorCodigo(int codigo);
    public ArrayList<Fornecedor> buscarPorNome(String nome);

}
