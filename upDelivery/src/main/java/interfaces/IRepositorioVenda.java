package interfaces;

import java.util.ArrayList;

import entidades.Venda;

public interface IRepositorioVenda {
	public ArrayList<Venda> buscarPorNome(String nome);
	public Venda buscarPorId(int id);
	public ArrayList<Venda> listar();
	public boolean atualizar(int id, String dataCompra, int idProdutoVendido, int idCliente, float preco, float desconto, float precoFinal,String estado);
	public boolean adicionar(String dataCompra, int idProdutoVendido, int idCliente, float preco, float desconto, float precoFinal, String estado);
	public boolean apagar(int id);
}
