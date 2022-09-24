package interfaces;

import java.util.ArrayList;

import entidades.Venda;

public interface IServicoVenda {
	public boolean registrarVenda(String dataCompra, int idProdutoVendido, int idCliente, float preco, float desconto, float precoFinal,String estado);
	public boolean alterarVenda(Venda venda, String dataCompra, int idProdutoVendido, int idCliente, float preco, float desconto, float precoFinal,String estado);
	public boolean removerVenda(Venda venda);
	public ArrayList<Venda> listarVendas();
    public Venda buscarVendaPorCodigo(int codigo);
    public ArrayList<Venda> buscarVendaPorNome(String nome);
}

