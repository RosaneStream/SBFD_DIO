package br.com.dio.dominio.base;

import br.com.dio.dominio.caminho.GetPath;

public class ContaPoupanca extends Conta {

	public ContaPoupanca() {
		super();
		GetPath arquivo = new GetPath();
		arquivo.setTabela("contaPoupanca.txt");
		this.setDiretorio(arquivo.tabelaExiste());
	}
	
	@Override
	public void confirmarCadastro(){
		if (inserirConta()) {
			System.out.println("Conta poupança cadastrada com sucesso!");
			System.out.println("Numero: "+ getNumero());
			System.out.println("Agencia: "+ getAgencia());

	} else {
			System.out.println("Erro no cadastro!");
	}
	}
	/*@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Poupança ===");
		super.imprimirInfosComuns();
	}*/
}
