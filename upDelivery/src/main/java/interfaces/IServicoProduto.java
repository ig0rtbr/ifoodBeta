package interfaces;

import java.util.ArrayList;

import entidades.Produto;

public interface IServicoProduto {
    public boolean cadastrar(int fornecedorResponsavel, String nomeProduto, String descricaoProduto,String dataFabricacao, String dataValidade, String codigoBarras, String tipoProduto, float preco,float desconto);
    public boolean atualizar(Produto produto, int fornecedorResponsavel, String nomeProduto, String descricaoProduto,String dataFabricacao, String dataValidade, String codigoBarras, String tipoProduto, float preco,float desconto);
    public boolean remover(Produto produto);
    public ArrayList<Produto> listar();
    public Produto buscarPorCodigo(int codigo);
    public ArrayList<Produto> buscarPorNome(String nome);
}