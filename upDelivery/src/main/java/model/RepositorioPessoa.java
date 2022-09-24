package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Fornecedor;
import entidades.Pessoa;
import interfaces.IRepositorioPessoa;
import interfaces.IRepositorioPrincipal;

public class RepositorioPessoa implements IRepositorioPessoa{
	IRepositorioPrincipal dao = new RepositorioPrincipal();

	
	@Override
	public ArrayList<Pessoa> buscarPorNome(String nome) {
		Connection con = dao.conectar();
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		try {
			String query = "select * from pessoa where nome LIKE '"+nome+"'";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				pessoas.add(criarObjeto(rs));
			}
			if (pessoas.isEmpty()) {
				query = "select * from pessoa where nome LIKE '%"+nome+"%'";
				pst = con.prepareStatement(query);
				rs = pst.executeQuery();
				
				while(rs.next()) {
					pessoas.add(criarObjeto(rs));
				}
				
			}				
			con.close();
			
			if (pessoas.isEmpty()) return null;
			else return pessoas;			
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
	public Pessoa buscarPorId(int id) {
		Connection con = dao.conectar();
		Pessoa pessoa = null;
		try {
			String query = "select * from pessoa where id="+id;
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				pessoa = criarObjeto(rs);
			}
			
			
			if (pessoa == null) return null;
			else return pessoa;		
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
	public boolean alterar(int id, String nome, String sobrenome, String cpf, String dataNascimento, String rua,String numero, String cep, String login, String senha) {
		Connection con = dao.conectar();
		
		try {
			String query = String.format("UPDATE pessoa SET nome='%s',sobrenome='%s',cpf='%s',dataNascimento='%s',rua='%s',numero='%s',cep='%s',login='%s',senha='%s' WHERE (id = %s);", nome, sobrenome, cpf, dataNascimento, rua, numero, cep, login, senha, id);		
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
	public boolean adicionar(String nome, String sobrenome, String cpf, String dataNascimento, String rua, String numero,String cep, String login, String senha) {
		Connection con = dao.conectar();
		 try {		 		 
			String query = String.format("insert into pessoa values(default, '%s', '%s','%s','%s','%s','%s','%s','%s','%s')",nome, sobrenome, cpf, dataNascimento, rua, numero, cep, login, senha);
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
			String query = "delete from pessoa where id ="+id;
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
	public ArrayList<Pessoa> listar() {
		Connection con = dao.conectar();
		ArrayList<Pessoa> pessoa = new ArrayList<Pessoa>();
		try {
			String query = "select * from pessoa";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				pessoa.add(criarObjeto(rs));
			}
					
			if (pessoa == null) return null;
			else return pessoa;		
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
	
	private Pessoa criarObjeto(ResultSet rs) {
		try {
			Pessoa pessoa = new Pessoa(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
			return pessoa;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
