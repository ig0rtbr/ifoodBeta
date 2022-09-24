package servicos;

import java.util.ArrayList;

import entidades.Fornecedor;
import interfaces.IRepositorioFornecedor;
import interfaces.IRepositorioPessoa;
import interfaces.IServicoFornecedor;
import model.RepositorioFornecedor;
import model.RepositorioPessoa;

public class ServicoFornecedor implements IServicoFornecedor{
	IRepositorioFornecedor repositorio = new RepositorioFornecedor();
	IRepositorioPessoa repositorioPessoa = new RepositorioPessoa();

	@Override
	public boolean cadastrar(int idDono, String nomeFornecedor, String nomeFantasia, String razaoSocial, String cnpj, String tipoComercio,String rua,String numero,String cep,float precoPorKm) {
		try {
			if (idDono != 0 && !nomeFornecedor.isEmpty() && !nomeFantasia.isEmpty() && !razaoSocial.isEmpty() && !cnpj.isEmpty() && !tipoComercio.isEmpty() && !rua.isEmpty() && !numero.isEmpty() && !cep.isEmpty() && precoPorKm != 0) {
				if (repositorioPessoa.buscarPorId(idDono) != null) {
					repositorio.adicionar(idDono, nomeFornecedor, nomeFantasia, razaoSocial, cnpj, tipoComercio, rua, numero, cep, precoPorKm);		
					
					System.out.println("Fornecedor adicionado com sucesso!!"); 
					return true;
				}else {
					System.out.println("Dono não existe");
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
	public boolean atualizar(Fornecedor fornecedor, int idDono, String nomeFornecedor, String nomeFantasia, String razaoSocial, String cnpj, String tipoComercio,String rua,String numero,String cep,float precoPorKm) {
		try {
			if (idDono != 0 && !nomeFornecedor.isEmpty() && !nomeFantasia.isEmpty() && !razaoSocial.isEmpty() && !cnpj.isEmpty() && !tipoComercio.isEmpty() && !rua.isEmpty() && !numero.isEmpty() && !cep.isEmpty() && precoPorKm != 0) {
				if (repositorio.buscarPorId(fornecedor.getCodigo()) != null) {
					repositorio.alterar(fornecedor.getCodigo(),idDono, nomeFornecedor, nomeFantasia, razaoSocial, cnpj, tipoComercio, rua, numero, cep, precoPorKm);		
					return true;
				}else {
					System.out.println("O fornecedor solicitado não existe");
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
	public boolean remover(Fornecedor fornecedor) {
		if (repositorio.buscarPorId(fornecedor.getCodigo()) != null) {
			repositorio.apagar(fornecedor.getCodigo());
			return true;
		}else {
			System.out.println("O fornecedor não existe no banco de dados");
			return false;
		}
		
	}

	@Override
	public ArrayList<Fornecedor> listar() {
		ArrayList<Fornecedor> fornecedor = repositorio.listar();
		if (!fornecedor.isEmpty()) return fornecedor;
		else {
			System.out.println("Não existem registros de fornecedores");
			return null;
		}

	}

	@Override
	public Fornecedor buscarPorCodigo(int codigo) {
		Fornecedor fornecedor = repositorio.buscarPorId(codigo);
		if (fornecedor != null) return fornecedor;
		else {
			System.out.println("Não existem registros deste fornecedor");
			return null;
		}
	}

	@Override
	public ArrayList<Fornecedor> buscarPorNome(String nome) {
		ArrayList<Fornecedor> fornecedor = repositorio.buscarPorNome(nome);
		if (!fornecedor.isEmpty()) return fornecedor;
		else {
			System.out.println("Não existem registros de fornecedores");
			return null;
		}	
	}
	
}
