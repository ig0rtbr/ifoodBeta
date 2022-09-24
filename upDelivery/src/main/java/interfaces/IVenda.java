package interfaces;

import java.util.ArrayList;

import entidades.Venda;

public interface IVenda {
	public boolean registrarVenda(int idPessoa, int idEstabelecimento, String idProduto, int quantidade, float preco, int idCupom);
	public boolean alterarVenda(Venda venda, int idPessoa, int idEstabelecimento, String idProduto, int quantidade, float preco, int idCupom);
	public boolean removerVenda(Venda venda);
	public ArrayList<Venda> listarVendas();
    public Venda buscarVendaPorCodigo(int codigo);
    public Venda buscarVendaPorNome(String nome);
}
