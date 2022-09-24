package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Fornecedor;
import interfaces.IRepositorioPrincipal;
import interfaces.IRepositorioFornecedor;

public class RepositorioFornecedor implements IRepositorioFornecedor{
	IRepositorioPrincipal dao = new RepositorioPrincipal();
	
	
	@Override
	public ArrayList<Fornecedor> buscarPorNome(String nome) {
		Connection con = dao.conectar();
		ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		try {
			String query = "select * from fornecedor where nomeFornecedor LIKE '"+nome+"'";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				fornecedores.add(criarObjeto(rs));
			}
			if (fornecedores.isEmpty()) {
				query = "select * from fornecedor where nomeFornecedor LIKE '%"+nome+"%'";
				pst = con.prepareStatement(query);
				rs = pst.executeQuery();
				
				while(rs.next()) {
					fornecedores.add(criarObjeto(rs));
				}
				
			}				
			con.close();
			
			if (fornecedores.isEmpty()) return null;
			else return fornecedores;			
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
	public Fornecedor buscarPorId(int id) {
		Connection con = dao.conectar();
		Fornecedor fornecedor = null;
		try {
			String query = "select * from fornecedor where idFornecedor="+id;
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				fornecedor = criarObjeto(rs);
			}
			
			
			if (fornecedor == null) return null;
			else return fornecedor;		
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
	public boolean alterar(int id, int idDono, String nomeFornecedor, String nomeFantasia, String razaoSocial, String cnpj,String tipoComercio, String rua, String numero, String cep, float precoPorKm) {
		Connection con = dao.conectar();
		
		try {
			String query = String.format("UPDATE fornecedor SET idDono='%s', nomeFornecedor='%s', nomeFantasia='%s', razaoSocial='%s', cnpj='%s', tipoComercio='%s', rua='%s', numero='%s', cep='%s', precoPorKm='%s' WHERE (idFornecedor = '%s');", idDono, nomeFornecedor, nomeFantasia, razaoSocial, cnpj, tipoComercio, rua, numero, cep, precoPorKm,id);	
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
				// TODO Auto-generated catch block
				System.out.println(e1);
				return false;
			}	
		}	
	}

	@Override
	public boolean adicionar(int idDono, String nomeFornecedor, String nomeFantasia, String razaoSocial, String cnpj,String tipoComercio, String rua, String numero, String cep, float precoPorKm) {
		Connection con = dao.conectar();
		 try {
			 		 
			String query = String.format("insert into fornecedor values(default, '%s', '%s','%s','%s','%s','%s','%s','%s','%s','%s')",idDono, nomeFornecedor, nomeFantasia, razaoSocial, cnpj, tipoComercio, rua, numero, cep, precoPorKm);
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
	
	public boolean apagar(int id) {
		Connection con = dao.conectar();			
		try {			
			String query = "delete from fornecedor where idFornecedor ="+id;
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
	
	@Override
	public ArrayList<Fornecedor> listar() {
		Connection con = dao.conectar();
		ArrayList<Fornecedor> fornecedor = new ArrayList<Fornecedor>();;
		try {
			String query = "select * from fornecedor";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				fornecedor.add(criarObjeto(rs));
			}
			
			
			if (fornecedor == null) return null;
			else return fornecedor;		
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
	
	private Fornecedor criarObjeto(ResultSet rs) {
		try {
			Fornecedor fornecedor = new Fornecedor(rs.getInt(1),rs.getInt(2), rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getFloat(11));
			return fornecedor;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}



}
