package servicos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import entidades.Produto;
import interfaces.IRepositorioFornecedor;
import interfaces.IRepositorioProduto;
import interfaces.IServicoProduto;
import model.RepositorioFornecedor;
import model.RepositorioProduto;

public class ServicoProduto implements IServicoProduto{
	IRepositorioProduto repositorio = new RepositorioProduto();
	IRepositorioFornecedor repositorioFornecedor = new RepositorioFornecedor();

	@Override
	public boolean cadastrar(int fornecedorResponsavel, String nomeProduto, String descricaoProduto,String dataFabricacao, String dataValidade, String codigoBarras, String tipoProduto, float preco,float desconto) {
		try {
			if (fornecedorResponsavel == 0 &&  nomeProduto.isEmpty() &&  descricaoProduto.isEmpty() && dataFabricacao.isEmpty() &&  dataValidade.isEmpty() &&  codigoBarras.isEmpty() &&  tipoProduto.isEmpty() &&  preco == 0 && desconto == 0) {
				if (repositorioFornecedor.buscarPorId(fornecedorResponsavel) != null) {
					try {
						SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
						Date data1 = formato.parse(dataFabricacao);
						Date data2 = formato.parse(dataValidade);
						repositorio.adicionar(fornecedorResponsavel, nomeProduto, descricaoProduto, dataFabricacao, dataValidade, codigoBarras, tipoProduto, preco, desconto);
					} catch (Exception e) {
						System.out.println("Datas invalidas.");
					}
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
	public boolean atualizar(Produto produto, int fornecedorResponsavel, String nomeProduto, String descricaoProduto,String dataFabricacao, String dataValidade, String codigoBarras, String tipoProduto, float preco,float desconto) {
		try {
			if (produto != null && fornecedorResponsavel == 0 &&  nomeProduto.isEmpty() &&  descricaoProduto.isEmpty() && dataFabricacao.isEmpty() &&  dataValidade.isEmpty() &&  codigoBarras.isEmpty() &&  tipoProduto.isEmpty() &&  preco == 0 && desconto == 0) {
				if (repositorioFornecedor.buscarPorId(fornecedorResponsavel) != null) {
					if (repositorio.buscarPorId(produto.getCodigo()) != null) {
						try {
							SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); 
							Date data1 = formato.parse(dataFabricacao);
							Date data2 = formato.parse(dataValidade);
							repositorio.alterar(produto.getCodigo(),fornecedorResponsavel, nomeProduto, descricaoProduto, dataFabricacao, dataValidade, codigoBarras, tipoProduto, preco, desconto);
						} catch (Exception e) {
							System.out.println("Datas invalidas.");
						}
					}else {
						System.out.println("Produto não existe");
					}
				}else {
					System.out.println("Fornecedor não existe");
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
	public boolean remover(Produto produto) {
		if (repositorio.buscarPorId(produto.getCodigo()) != null) {
			repositorio.apagar(produto.getCodigo());
			return true;
		}else {
			System.out.println("O produto não existe no banco de dados");
			return false;
		}
	}

	@Override
	public ArrayList<Produto> listar() {
		ArrayList<Produto> produtos = repositorio.listar();
		if (produtos.isEmpty() == false) return produtos;
		else {
			System.out.println("Não existem registros de produtos");
			return null;
		}
	}

	@Override
	public Produto buscarPorCodigo(int codigo) {
		Produto produtos = repositorio.buscarPorId(codigo);
		if (produtos == null) return produtos;
		else {
			System.out.println("Não existem registros deste produto");
			return null;
		}
	}

	@Override
	public ArrayList<Produto> buscarPorNome(String nome) {
		ArrayList<Produto> produtos = repositorio.buscarPorNome(nome);
		if (produtos.isEmpty() == false) return produtos;
		else {
			System.out.println("Não existem registros deste/destes produtos");
			return null;
		}
	}

	
}
