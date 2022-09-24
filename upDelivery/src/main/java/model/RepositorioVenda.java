package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Produto;
import entidades.Venda;
import interfaces.IRepositorioPrincipal;
import interfaces.IRepositorioVenda;

public class RepositorioVenda implements IRepositorioVenda{
	IRepositorioPrincipal dao = new RepositorioPrincipal();

	@Override
	public ArrayList<Venda> buscarPorNome(String nome) {
		Connection con = dao.conectar();
		ArrayList<Venda> vendas = new ArrayList<Venda>();
		try {
			String query = "select v.idVenda,v.dataCompra, pr.nomeProduto , pe.nome , v.desconto , v.precoFInal , v.estado from vendas v join pessoa pe on pe.id = v.idCliente join produto pr on pr.idproduto = v.idProdutoVendido where pe.nome LIKE '"+nome+"'";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				vendas.add(criarObjeto(rs));
			}
			if (vendas.isEmpty()) {
				query = "select v.idVenda,v.dataCompra, pr.nomeProduto , pe.nome , v.desconto , v.precoFInal , v.estado from vendas v join pessoa pe on pe.id = v.idCliente join produto pr on pr.idproduto = v.idProdutoVendido where pe.nome LIKE '%"+nome+"%'";
				pst = con.prepareStatement(query);
				rs = pst.executeQuery();
				
				while(rs.next()) {
					vendas.add(criarObjeto(rs));
				}
				
			}				
			con.close();
			
			if (vendas.isEmpty()) return null;
			else return vendas;			
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
	public Venda buscarPorId(int id) {
		Connection con = dao.conectar();
		Venda venda = null;
		try {
			String query = "select * from vendas where idVenda="+id;
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				venda = criarObjeto(rs);
			}
			
			
			if (venda == null) return null;
			else return venda;		
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
	public ArrayList<Venda> listar() {
		Connection con = dao.conectar();
		ArrayList<Venda> vendas = new ArrayList<Venda>();
		try {
			String query = "select * from vendas";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				vendas.add(criarObjeto(rs));
			}
					
			if (vendas == null) return null;
			else return vendas;		
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
	public boolean atualizar(int id, String dataCompra, int idProdutoVendido, int idCliente, float preco, float desconto,float precoFinal, String estado) {
		Connection con = dao.conectar();
		
		try {
			String query = String.format("UPDATE vendas SET dataCompra='%s',idProdutoVendido='%s',idCliente='%s',preco='%s',desconto='%s',precoFinal='%s',estado='%s' WHERE (id = %s);", dataCompra,idProdutoVendido,idCliente,preco,desconto,precoFinal,estado, id);		
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
	public boolean adicionar(String dataCompra, int idProdutoVendido, int idCliente, float preco, float desconto,float precoFinal, String estado) {
		
		Connection con = dao.conectar();
		 try {		 		 
			String query = String.format("insert into vendas values(default, '%s', '%s','%s','%s','%s','%s','%s')",dataCompra,idProdutoVendido,idCliente,preco,desconto,precoFinal,estado);
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
			String query = "delete from vendas where idVenda="+id;
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

	private Venda criarObjeto(ResultSet rs) {
		try {
			Venda venda = new Venda(rs.getInt(1),rs.getString(2), rs.getInt(3),rs.getInt(4), rs.getFloat(5), rs.getFloat(6), rs.getFloat(7), rs.getString(8));
			return venda;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	
}
