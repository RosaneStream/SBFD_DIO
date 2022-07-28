package br.com.dio.dominio.base;

import br.com.dio.dominio.cadastro.*;
import br.com.dio.dominio.caminho.GetPath;
import java.io.*;
import java.util.*;

public class Cliente {

	private String identificador;
	private String nome;
	private String diretorio;

	public Cliente(String identificador, String nome, String diretorio) {
			this.identificador = identificador;
			this.nome = nome;
			this.diretorio = diretorio;
	}

	public Cliente() {
			GetPath arquivo = new GetPath();
			arquivo.setTabela("cliente.txt");
			this.setDiretorio(arquivo.tabelaExiste());
	}

	public String getIdentificador() {
			return identificador;
	}

	public void setIdentificador(String identificador) {
			this.identificador = identificador;
	}

	public String getNome() {
			return nome;
	}

	public void setNome(String nome) {
			this.nome = nome;
	}

	public String getDiretorio() {
			return diretorio;
	}

	public void setDiretorio(String diretorio) {
			this.diretorio = diretorio;
	}

	public boolean inserirCliente() {

			try {
					// Fluxo de saida de um arquivo
					FileWriter fw = new FileWriter(getDiretorio(), true);
					BufferedWriter bw = new BufferedWriter(fw); // adiciono a um escritor de buffer
					bw.write(this.getIdentificador() + "-" + this.getNome());
					bw.newLine();
					bw.close();
					fw.close();
					return true;
			} catch (IOException e) {
					return false;
			}
	}
	public List<String> listarCliente() {

			List<String> nome = new ArrayList<>();
			try {

					File file = new File(getDiretorio());
					FileReader readerFile = new FileReader(file);
					BufferedReader item = new BufferedReader(readerFile);
					String text = item.readLine();
					while (text != null) {
							nome.add(text);
							text = item.readLine();
					}
					item.close();
					return nome;
			} catch (IOException e) {
					nome.add("");
					return nome;
			}
	}

	public boolean buscarArquivo() {

			try {
				//	Byte cont = 0;
					File file = new File(getDiretorio());
					FileReader readerFile = new FileReader(file);
					BufferedReader item = new BufferedReader(readerFile);
					String text = item.readLine();
					if (text != null) {
							item.close();
							return true;
					}
					item.close();
					return false;
			} catch (IOException e) {
					System.out.println("Arquivo não encontrado");
					return false;
			}
	}
	public void cadastrarCliente() {

		try {

				lerInput ui = new lerInput();
				String numeroCPF;
				String nomeCliente;
				String[] CPF;

				int op;
				Cliente cliente = new Cliente();
				consultarCadastro consulta = new consultarCadastro();
				List<String> clientes = cliente.listarCliente();

				if(!consulta.agenciaCadastrada()) return;

				do {
						op = 1;
						System.out.println();
						numeroCPF = ui.getString("Informe o numero do CPF: ");

						if (numeroCPF.equalsIgnoreCase("") || (!isNumeric(numeroCPF))) {
								op = 0;
								System.out.println("Informe um numero de CPF valido!");
						}else{
								if (clientes.size() > 0 ){
										for (String c : clientes)
										{
												CPF = c.split("-");
												if (CPF[0].equalsIgnoreCase(numeroCPF)) {
														System.out.println("Cliente ja Cadastrado!");
														op = ui.getInt("Deseja sair?  1 - Sim / 2 - Nao  " );
														if (op == 1){
																return;
														}else{
																op=0;
														}
												}else{
														op=1;
												}
										}
								}
						}

				}while (op==0);

				System.out.println("");
				do {
						System.out.println("Informe o nome do Cliente: ");
						nomeCliente =ui.getString("");
						if (nomeCliente.equalsIgnoreCase("")){
								System.out.println("Informe um nome de Cliente valido!");
						}
						System.out.println();
				}while (nomeCliente.equalsIgnoreCase(""));

				setIdentificador(numeroCPF);
				setNome(nomeCliente);

				if (inserirCliente()) {
						System.out.println("Cadastrado com sucesso!");
//						op = ui.getInt("Deseja cadastrar novo cliente? 1- Sim 2 - Nao");
	//					if (op == 1) {
		//						cliente.inserirCliente();
			//			}
				} else {
						System.out.println("Erro no cadastro!");
				}
		} catch (Exception e) {
				System.out.println(e);
		}
}

public static boolean isNumeric(String str) {
		return str != null && str.matches("[-+]?\\d*\\.?\\d+");
}


}
