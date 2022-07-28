package br.com.dio.dominio.base;

import br.com.dio.dominio.cadastro.*;
import java.util.List;
import java.util.Random;

import java.io.*;
//import java.util.*;

public class Conta {
    private String nome;
    private String agencia;
    private String numero;
//    private String tipoConta;
    private String diretorio;

    public Conta(String nome, String agencia, String numero, String tipoConta, String diretorio) {
        this.nome = nome;
        this.agencia = agencia;
        this.numero = numero;
  //      this.tipoConta = tipoConta;
        this.diretorio = diretorio;
    }

    public Conta(){};
      
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDiretorio() {
        return diretorio;
    }

    public void setDiretorio(String diretorio) {
        this.diretorio = diretorio;
    }

    public void confirmarCadastro(){}

    public boolean inserirConta() {

        try {
            // Fluxo de saida de um arquivo
            FileWriter fw = new FileWriter(getDiretorio(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(this.getNome() + "-" + this.getAgencia() + "-" +
                     "-" + this.getNumero());
            bw.newLine();
            bw.close();
            fw.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public Byte contarContas() {

        try {
            Byte cont = 0;
            File file = new File(getDiretorio());
            FileReader readerFile = new FileReader(file);
            BufferedReader item = new BufferedReader(readerFile);
            String text = item.readLine();
            while (text != null) {
                cont++;
                if (cont ==2){
					item.close();
                    return cont;
                }
                text = item.readLine();
            }
            item.close();
            return cont;
        } catch (IOException e) {
            System.out.println("Arquivo de contas não encontrado");
            return 0;
        }
    }
      public boolean contaExiste(String agencia, String conta) {

        try {

            String[] contas;
            File file = new File(getDiretorio());
            FileReader readerFile = new FileReader(file);
            BufferedReader item = new BufferedReader(readerFile);

            //List<String> nome = new ArrayList<>();
            String text = item.readLine();
            while (text != null) {
                contas = text.split("-");
                if (contas[1].equalsIgnoreCase(agencia) && contas[3].equalsIgnoreCase(conta)){
				   item.close();
                    return true;
                }
               text = item.readLine();
            }
            item.close();
            return false;

        } catch (IOException e) {
            System.out.println("Arquivo de contas não encontrado!");
            return false;
        }
    }

    public void cadastrarConta() {

        lerInput ui = new lerInput();
        List<String> agencias;

        String numeroDoCPF;
        String numeroDaAgencia;
        String numeroDaConta="";
        String op;

        Agencia agencia = new Agencia();
        agencias = agencia.listarAgencias();

        consultarCadastro consulta = new consultarCadastro();
        //Verificar se tem agência Cadastrada
        if(!consulta.agenciaCadastrada()) return;
        //Verificar se tem cliente cadastrado
        if(!consulta.clienteCadastrado()) return;

        //Pesquisa se o Cliente está cadastrado
        do {
            System.out.println("Informe o número de CPF do Cliente:");
            numeroDoCPF = ui.getString("");
            if (numeroDoCPF.equalsIgnoreCase("")){
                System.out.println("Informe um numero de CPF valido!");
            }else {
                if (listarClienteBanco(numeroDoCPF) == 0) {
                    System.out.println("Cliente não encontrado!");
                    numeroDoCPF = "";
                    op = ui.getString("Deseja sair?  1 - Sim / 2 - Nao  ");
                    if (Integer.parseInt(op) == 1) return;
                }

            }
       } while(numeroDoCPF.equalsIgnoreCase(""));
       
        do {

            System.out.println("Informe uma Agência:");
            numeroDaAgencia = ui.getString("");

            if (numeroDaAgencia.equalsIgnoreCase("")){
                System.out.println("Informe uma agencia valida!");
                op = ui.getString("Deseja sair?  1 - Sim / 2 - Nao  ");
                if (Integer.parseInt(op) == 1) return;

            }else {
                if (escolherAgencia(agencias, numeroDaAgencia) == null) {
                    System.out.println("Agência não encontrada!");
                    numeroDaAgencia = "";
                    op = ui.getString("Deseja sair?  1 - Sim / 2 - Nao  ");
                    if (Integer.parseInt(op) == 1) return;
                }

            }

        } while(numeroDaAgencia.equalsIgnoreCase(""));

        Random random = new Random();
        while (numeroDaConta.length() <= 5){
            numeroDaConta += random.nextInt(9);
        }
        setNome(numeroDoCPF);
        setAgencia(numeroDaAgencia);
        setNumero(numeroDaConta);

        confirmarCadastro();
    }
    private static int listarClienteBanco(String CPF) {

        String[] dadosCliente;
        String nomedoCliente = null;
        
        Cliente cliente = new Cliente();
        List<String> listaCliente = cliente.listarCliente();
        try {

            for (String customer : listaCliente) {
                dadosCliente = customer.split("-");
                if (nomedoCliente == null) {
                    if(dadosCliente[0].equalsIgnoreCase(CPF)){
                        nomedoCliente = dadosCliente[1];
                        System.out.println("Nome do Cliente:");
                        System.out.println("----------------------------------");
                        System.out.println(nomedoCliente);
                        return 1;
                    }
                }
            }
            return 0;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }
    /*private static List<String> listarAgencias(){
        Agencia agencia = new Agencia();
        return agencia.listarAgencias();
    }*/
    private static String escolherAgencia( List<String> agencia, String numeroAgencia){

        String[] dadosCliente;
        try {

            for (String customer : agencia) {
                dadosCliente = customer.split("-");
                if (dadosCliente[0].equalsIgnoreCase(numeroAgencia)){
                    System.out.println("Agencia Escolhida:");
                    System.out.println("----------------------------------");
                    System.out.println(customer);
                    return customer;
                }
            }

        } catch (Exception e) {
            return null;
        }
        return null;
    }

    public boolean contasCadastradas(String operacao){
        int contador = contarContas();
        if (contador<1)
        {
            System.out.println("Cadastre uma conta para realizar a operação!");
            System.out.println();
            return false;

        } else if ((contador < 2) && (operacao == "t")) {
            System.out.println("Cadastre 2 contas para realizar a operação!");
            System.out.println();
            return false;
        }  else{
                return true;
            }
    }

}