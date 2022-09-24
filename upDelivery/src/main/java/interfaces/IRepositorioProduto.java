package interfaces;

import java.util.ArrayList;

import entidades.Produto;

public interface IRepositorioProduto {
	public ArrayList<Produto> buscarPorNome(String nome);
	public Produto buscarPorId(int id);
	public ArrayList<Produto> listar();
	public boolean alterar(int id, int fornecedorResponsavel, String nomeProduto, String descricaoProduto,String dataFabricacao, String dataValidade, String codigoBarras, String tipoProduto, float preco,float desconto);
	public boolean adicionar(int fornecedorResponsavel, String nomeProduto, String descricaoProduto,String dataFabricacao, String dataValidade, String codigoBarras, String tipoProduto, float preco,float desconto);
	public boolean apagar(int id);
}
