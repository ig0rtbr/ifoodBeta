package model;

import java.sql.Connection;
import java.sql.DriverManager;
import interfaces.IRepositorioPrincipal;

public class RepositorioPrincipal implements IRepositorioPrincipal{
	//Modulo de conexão
	//Parametros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/dbupdelivery?user=root";
	private String user = "root";
	private String password = "";
	
	//Metodo de conexão
	public Connection conectar(){ 
		Connection con = null;	
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		}catch(Exception e){
			System.out.println(e);
			return null;
		} 
	}
}
