package interfaces;

import java.sql.Connection;
import java.util.ArrayList;

import entidades.Fornecedor;
import entidades.Pessoa;
import entidades.Venda;
import entidades.Produto;

public interface IRepositorioPrincipal {
	public Connection conectar();
}
