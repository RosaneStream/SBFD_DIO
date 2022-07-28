package br.com.dio.dominio.base;

import br.com.dio.dominio.caminho.GetPath;

//import java.io.*;

public class ContaCorrente extends Conta {

	public ContaCorrente() {
		super();
		GetPath arquivo = new GetPath();
		arquivo.setTabela("contaCorrente.txt");
		this.setDiretorio(arquivo.tabelaExiste());
	}

	@Override
	public void confirmarCadastro(){
		if (inserirConta()) {
			System.out.println("Conta corrente cadastrada com sucesso!");
			System.out.println("Numero: "+ getNumero());
			System.out.println("Agencia: "+ getAgencia());

	} else {
			System.out.println("Erro no cadastro!");
	}
	}
/*	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Corrente ===");
		super.imprimirInfosComuns();
	}
	 */
}
