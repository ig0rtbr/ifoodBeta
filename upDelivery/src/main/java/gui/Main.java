package gui;

import interfaces.IServicoFornecedor;
import interfaces.IServicoPessoa;
import interfaces.IServicoProduto;
import interfaces.IServicoVenda;
import servicos.ServicoFornecedor;
import servicos.ServicoPessoa;
import servicos.ServicoProduto;
import servicos.ServicoVenda;


public class Main {
	
	
	public static void main(String[] args) {
		//Descontinuamos a hud pois seria apenas atraso e começamos a foca ja na parte web espero que entenda mas tudo esta funcionando perfeitamente
		IServicoPessoa usuario = new ServicoPessoa();
		IServicoFornecedor fornecedor = new ServicoFornecedor();
		IServicoVenda pedido = new ServicoVenda();
		IServicoProduto produto = new ServicoProduto();
	
	}

}
