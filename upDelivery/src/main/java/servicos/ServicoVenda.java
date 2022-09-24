package servicos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import entidades.Produto;
import entidades.Venda;
import interfaces.IRepositorioPessoa;
import interfaces.IRepositorioProduto;
import interfaces.IRepositorioVenda;
import interfaces.IServicoProduto;
import interfaces.IServicoVenda;
import model.RepositorioPessoa;
import model.RepositorioProduto;
import model.RepositorioVenda;

public class ServicoVenda implements IServicoVenda{
	IRepositorioVenda repositorio = new RepositorioVenda();
	IRepositorioProduto repositorioProduto = new RepositorioProduto();
	IRepositorioPessoa repositorioPessoa = new RepositorioPessoa();


	@Override
	public boolean registrarVenda(String dataCompra, int idProdutoVendido, int idCliente, float preco, float desconto,float precoFinal, String estado) {
		try {
			if (dataCompra.isEmpty() &&  idProdutoVendido == 0 &&  idCliente == 0 &&  preco == 0 &&  desconto == 0 && precoFinal == 0 &&  estado.isEmpty()) {
					if (repositorioProduto.buscarPorId(idProdutoVendido) != null) {
						if (repositorioPessoa.buscarPorId(idCliente) != null) {
							repositorio.adicionar(dataCompra, idProdutoVendido, idCliente, preco, desconto, precoFinal, estado);
							System.out.println("Venda cadastrado com sucesso");
						}else {
							System.out.println("Cliente não existem");
						}
					}else {
						System.out.println("Não existe este produto");
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
	public boolean alterarVenda(Venda venda, String dataCompra, int idProdutoVendido, int idCliente, float preco,float desconto, float precoFinal, String estado) {
		try {
			if (dataCompra.isEmpty() &&  idProdutoVendido == 0 &&  idCliente == 0 &&  preco == 0 &&  desconto == 0 && precoFinal == 0 &&  estado.isEmpty()) {
					if (repositorioProduto.buscarPorId(idProdutoVendido) != null) {
						if (repositorioPessoa.buscarPorId(idCliente) != null) {
							repositorio.atualizar(venda.getCodigo(), dataCompra, idProdutoVendido, idCliente, preco, desconto, precoFinal, estado);
							System.out.println("Venda cadastrado com sucesso");
						}else {
							System.out.println("Cliente não existem");
						}
					}else {
						System.out.println("Não existe este produto");
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
	public boolean removerVenda(Venda venda) {
		if (repositorio.buscarPorId(venda.getCodigo()) != null) {
			repositorio.apagar(venda.getCodigo());
			return true;
		}else {
			System.out.println("A venda não existe no banco de dados");
			return false;
		}
	}

	@Override
	public ArrayList<Venda> listarVendas() {
		ArrayList<Venda> vendas = repositorio.listar();
		if (vendas.isEmpty() == false) return vendas;
		else {
			System.out.println("Não existem registros de vendas");
			return null;
		}
	}

	@Override
	public Venda buscarVendaPorCodigo(int codigo) {
		Venda vendas = repositorio.buscarPorId(codigo);
		if (vendas == null) return vendas;
		else {
			System.out.println("Não existem registros desta/destas vendas");
			return null;
		}
	}

	@Override
	public ArrayList<Venda> buscarVendaPorNome(String nome) {
		ArrayList<Venda> vendas = repositorio.buscarPorNome(nome);
		if (vendas.isEmpty() == false) return vendas;
		else {
			System.out.println("Não existem registros desta/destas vendas");
			return null;
		}
	}

}
