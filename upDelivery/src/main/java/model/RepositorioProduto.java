package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Pessoa;
import entidades.Produto;
import interfaces.IRepositorioPrincipal;
import interfaces.IRepositorioProduto;

public class RepositorioProduto implements IRepositorioProduto{
	IRepositorioPrincipal dao = new RepositorioPrincipal();

	@Override
	public ArrayList<Produto> buscarPorNome(String nome) {
		Connection con = dao.conectar();
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		try {
			String query = "select * from produto where nomeProduto LIKE '"+nome+"'";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				produtos.add(criarObjeto(rs));
			}
			if (produtos.isEmpty()) {
				query = "select * from produto where nomeProduto LIKE '%"+nome+"%'";
				pst = con.prepareStatement(query);
				rs = pst.executeQuery();
				
				while(rs.next()) {
					produtos.add(criarObjeto(rs));
				}
				
			}				
			con.close();
			
			if (produtos.isEmpty()) return null;
			else return produtos;			
		}catch (Exception e) {
			try {
				System.out.println(e);
				con.close();
				return null;
			} catch (SQLException e1) {
				System.out.println(e1);
				return null;
			}
		}		
	}
	@Override
	public Produto buscarPorId(int id) {
		Connection con = dao.conectar();
		Produto produto = null;
		try {
			String query = "select * from produto where idProduto="+id;
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				produto = criarObjeto(rs);
			}
			
			
			if (produto == null) return null;
			else return produto;		
		}catch (Exception e) {
			try {
				System.out.println(e);
				con.close();
				return null;
			} catch (SQLException e1) {
				System.out.println(e1);
				return null;
			}
		}		
	}

	@Override
	public ArrayList<Produto> listar() {
		Connection con = dao.conectar();
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		try {
			String query = "select * from produto";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				produtos.add(criarObjeto(rs));
			}
					
			if (produtos == null) return null;
			else return produtos;		
		}catch (Exception e) {
			try {
				System.out.println(e);
				con.close();
				return null;
			} catch (SQLException e1) {
				System.out.println(e1);
				return null;
			}
		}
	}

	@Override
	public boolean alterar(int id, int fornecedorResponsavel, String nomeProduto, String descricaoProduto,String dataFabricacao, String dataValidade, String codigoBarras, String tipoProduto, float preco,float desconto) {
		Connection con = dao.conectar();
		
		try {
			String query = String.format("UPDATE produto SET fornecedorResponsavel='%s',nomeProduto='%s',descricaoProduto='%s',dataFabricacao='%s',dataValidade='%s',codigoBarras='%s',tipoProduto='%s',preco='%s',desconto='%s' WHERE (id = %s);", fornecedorResponsavel,nomeProduto,descricaoProduto,dataFabricacao,dataValidade,codigoBarras,tipoProduto,preco,desconto, id);		
			PreparedStatement pst = con.prepareStatement(query);
			int resposta = pst.executeUpdate();	
			
			con.close();
			if (resposta == 0) return false;
			else return true;
		} catch (Exception e) {
			try {
				System.out.println(e);
				con.close();
				return false;
			} catch (SQLException e1) {
				System.out.println(e1);
				return false;
			}	
		}	
	}

	@Override
	public boolean adicionar(int fornecedorResponsavel, String nomeProduto, String descricaoProduto, String dataFabricacao,String dataValidade, String codigoBarras, String tipoProduto, float preco, float desconto) {
		Connection con = dao.conectar();
		 try {		 		 
			String query = String.format("insert into produto values(default, '%s', '%s','%s','%s','%s','%s','%s','%s','%s')",fornecedorResponsavel,nomeProduto,descricaoProduto,dataFabricacao,dataValidade,codigoBarras,tipoProduto,preco,desconto);
			PreparedStatement pst = con.prepareStatement(query);
			int resposta = pst.executeUpdate();	
			
			con.close();
			if (resposta == 0) return false;
			else return true;
		} catch (Exception e) { 
			try {
				System.out.println(e);
				con.close();
				return false;
			} catch (SQLException e1) {
				e1.printStackTrace();
				return false;
			}
		}

	}

	@Override
	public boolean apagar(int id) {
		Connection con = dao.conectar();			
		try {			
			String query = "delete from produto where idProduto="+id;
			PreparedStatement pst = con.prepareStatement(query);
			int resposta = pst.executeUpdate();	
			
			con.close();
			if (resposta == 0) return false;
			else return true;
		}catch (Exception e) {
			try {
				System.out.println(e);
				con.close();
				return false;
			} catch (SQLException e1) {
				System.out.println(e1);
				return false;
			}
		}		
	}
	
	private Produto criarObjeto(ResultSet rs) {
		try {
			Produto produto = new Produto(rs.getInt(1),rs.getInt(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8), rs.getFloat(9), rs.getFloat(10));
			return produto;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
