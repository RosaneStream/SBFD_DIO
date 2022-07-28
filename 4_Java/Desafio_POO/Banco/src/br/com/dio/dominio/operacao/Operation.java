package br.com.dio.dominio.operacao;

import br.com.dio.dominio.cadastro.*;
import br.com.dio.dominio.base.*;
import br.com.dio.dominio.caminho.GetPath;

import java.io.*;

//import javax.lang.model.util.ElementScanner6;
public class Operation {

    private String agencia;
    private String conta;

    private Double valor;
    private String operacao;

    private String diretorio;

    //public Operation(){}

    public Operation() {
        GetPath arquivo = new GetPath();
        arquivo.setTabela("operacao.txt");
        this.setDiretorio(arquivo.tabelaExiste());
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public String getDiretorio() {
        return diretorio;
    }

    public void setDiretorio(String diretorio) {
        this.diretorio = diretorio;
    }

    public boolean gravarOperacao() {
        try {
            FileWriter fw = new FileWriter(getDiretorio(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(this.getAgencia() + "-" + this.getConta() + "-" +
                    this.getValor() + "-" + this.getOperacao());
            bw.newLine();
            bw.close();
            fw.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean verificarSaldo(String agencia, String conta, Double valor) {
        try {

            String[] saldo;
            double saldoTotal = 0;
            File file = new File(getDiretorio());
            FileReader readerFile = new FileReader(file);
            BufferedReader item = new BufferedReader(readerFile);
            String text = item.readLine();
            while (text != null) {
                saldo = text.split("-");
                if (saldo[0].equalsIgnoreCase(agencia) && saldo[1].equalsIgnoreCase(conta)) {
                    if (saldo[3].equalsIgnoreCase("d")) {
                        saldoTotal += Double.parseDouble(saldo[2]);
                    } else if (saldo[3].equalsIgnoreCase("s") || saldo[3].equalsIgnoreCase("t")) {
                        saldoTotal -= Double.parseDouble(saldo[2]);
                    }
                }
                text = item.readLine();
            }
            item.close();
            if(saldoTotal >= valor) return true;
            return false;

        } catch (IOException e) {
            System.out.println("Arquivo não encontrado");
            return false;
        }
    }

    public void imprimirExtrato(String agencia, String conta) {
        try {
            String[] saldo;
            double saldoTotal = 0;
            File file = new File(getDiretorio());
            FileReader readerFile = new FileReader(file);
            BufferedReader item = new BufferedReader(readerFile);
            String text = item.readLine();
            while (text != null) {
                saldo = text.split("-");
                if (saldo[0].equalsIgnoreCase(agencia) && saldo[1].equalsIgnoreCase(conta)) {
                    if (saldo[3].equalsIgnoreCase("d")) {
                        saldoTotal += Double.parseDouble(saldo[2]);
                        System.out.println("Deposito na conta no valor de " + String.format("%.2f", Double.parseDouble(saldo[2])));
                    } else if (saldo[3].equalsIgnoreCase("s")) {
                        saldoTotal -= Double.parseDouble(saldo[2]);
                        System.out.println("Saque na conta no valor de " + String.format("%.2f", Double.parseDouble(saldo[2])));
                    } else if (saldo[3].equalsIgnoreCase("t")) {
                        saldoTotal -= Double.parseDouble(saldo[2]);
                        System.out.println("Transferencia da conta no valor de " + String.format("%.2f", Double.parseDouble(saldo[2])));
                    }
                }
                text = item.readLine();
            }
            item.close();
            System.out.println();
            System.out.println("Saldo na conta de " + String.format("%.2f",saldoTotal));
            System.out.println();
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado");
        }
    }

    public void realizarOperacao(String operacao) {
        lerInput ui = new lerInput();
        String numeroDaAgenciaOrigem;
        String numeroDaContaOrigem;
        Double valorOrigem;
        String numeroDaAgenciaDestino = null;
        String numeroDaContaDestino = null;
        consultarCadastro consulta = new consultarCadastro();

        int op;
        Conta contatp;

        System.out.println("Entre com o tipo da conta:");
        op = ui.getInt("1 - Conta Corrente / 2 - Conta Poupança: ");
       
        if (op == 1) {
            contatp = new ContaCorrente();
        }
        else{    
            contatp = new ContaPoupanca();}

            //Verificar se tem agência Cadastrada
        if (!consulta.agenciaCadastrada()) return;
        //Verificar se tem cliente Cadastrado
        if(!consulta.clienteCadastrado()) return;
        if (!contatp.contasCadastradas(operacao)) return;

        // Pesquisa se a agencia conta existe
        do {
            System.out.println("Informe o numero da Agencia:");
            numeroDaAgenciaOrigem = ui.getString("");

            System.out.println("Informe o numero da Conta:");
            numeroDaContaOrigem = ui.getString("");

            if (numeroDaAgenciaOrigem.equalsIgnoreCase("") | numeroDaContaOrigem.equalsIgnoreCase("")){
                System.out.println("Informe numero de agencia ou conta valido");
                op = ui.getInt("Deseja sair?  1 - Sim / 2 - Nao  ");
                if (op == 1) return;
            }else {
                if (!contatp.contaExiste(numeroDaAgenciaOrigem, numeroDaContaOrigem)) {
                    System.out.println("Agencia/Conta nao encontrado!");
                    numeroDaAgenciaOrigem = "";
                    op = ui.getInt("Deseja sair?  1 - Sim / 2 - Nao  ");
                    if (op == 1) return;
                }
            }

        } while (numeroDaAgenciaOrigem.equalsIgnoreCase(""));

        if (operacao.equalsIgnoreCase("t")){
            do {

                System.out.println("Informe o numero da Agencia Destino:");
                numeroDaAgenciaDestino = ui.getString("");

                System.out.println("Informe o numero da Conta Destino:");
                numeroDaContaDestino = ui.getString("");

                if (numeroDaAgenciaDestino.equalsIgnoreCase("") | numeroDaContaDestino.equalsIgnoreCase("")){
                    System.out.println("Informe numero de agencia ou conta valido");
                    op = ui.getInt("Deseja sair?  1 - Sim / 2 - Nao: ");
                    if (op == 1) return;
                }else {
                    if (!contatp.contaExiste(numeroDaAgenciaDestino, numeroDaContaDestino)) {
                        System.out.println("Agencia/Conta de Destino nao encontrado!");
                        numeroDaAgenciaDestino = "";
                        op = ui.getInt("Deseja sair?  1 - Sim / 2 - Nao: ");
                        if (op == 1) return;
                    }
                }

            } while (numeroDaAgenciaDestino.equalsIgnoreCase(""));
        }

        do {
            valorOrigem = ui.getDouble("Informe o valor da operacao:");
            if (valorOrigem == 0d) {
                System.out.println("Informe valor valido!");
                op = ui.getInt("Deseja sair?  1 - Sim / 2 - Nao  ");
                if (op == 1) return;
            }
        }while (valorOrigem==0d);

        if (operacao.equalsIgnoreCase("d")) {
            realizarDeposito(numeroDaAgenciaOrigem, numeroDaContaOrigem, valorOrigem);
        } else if (operacao.equalsIgnoreCase("s")) {
            realizarSaque(numeroDaAgenciaOrigem, numeroDaContaOrigem, valorOrigem);
        } else if (operacao.equalsIgnoreCase("t")) {
            realizarTransferencia(numeroDaAgenciaOrigem, numeroDaContaOrigem, numeroDaAgenciaDestino, numeroDaContaDestino, valorOrigem);
        }
    }

    private void realizarDeposito(String agencia, String conta, Double valor) {
       // Operation deposito = new Operation();
        setAgencia(agencia);
        setConta(conta);
        setValor(valor);
        setOperacao("d");

        if (gravarOperacao()) {
            System.out.println("Cadastrado com sucesso!");
            
        } else {
            System.out.println("Erro no cadastro!");
        }
    }

    private void realizarSaque(String agencia, String conta, Double valor) {
         //Operation saque = new Operation();

        //Verificar se tem Saldo Suficiente
        if (verificarSaldo(agencia, conta, valor)) {
            setAgencia(agencia);
            setConta(conta);
            setValor(valor);
            setOperacao("s");
            if (gravarOperacao()) {
                System.out.println("Saque realizado com sucesso!");
                
            }
        }else{
            System.out.println("Saldo Insuficiente!");
        }
    }

    private void realizarTransferencia(String agenciaOrigem, String contaOrigem,
                                              String agenciaDestino, String contaDestino,  Double valor){                                               
        //Operation operacao = new Operation();

        if (contaOrigem.equalsIgnoreCase(contaDestino)) {
            System.out.println("As contas são iguais!");
            System.out.println("Informe uma conta diferente!");
            
        }
        if (verificarSaldo(agenciaOrigem, contaOrigem, valor)) {
             //na transferencia precisa sacar de uma conta para transferir para outra
            //saque
            setAgencia(agenciaOrigem);
            setConta(contaOrigem);
            setValor(valor);
            setOperacao("s");
            gravarOperacao();

            //Operação de depósito
            setAgencia(agenciaDestino);
            setConta(contaDestino);
            setValor(valor);
            setOperacao("d");
    
            if (gravarOperacao()) {
                System.out.println("Operacao realizada com sucesso!");
            }
        }else{
            System.out.println("Saldo Insuficiente!");
            
        }
    }

    public void imprimirExtratoConta() {
        lerInput ui = new lerInput();
        String numeroDaAgenciaOrigem;
        String numeroDaContaOrigem;
        
        int op;
        Conta contatp;

        consultarCadastro consulta = new consultarCadastro();

        System.out.println("Entre com o tipo da conta:");
        op = ui.getInt("1 - Conta Corrente / 2 - Conta Poupança: ");
       
        if (op == 1) {
            contatp = new ContaCorrente();
        }
        else{    
            contatp = new ContaPoupanca();}

        //Verificar se tem agência Cadastrada
        if (!consulta.agenciaCadastrada()) return;
        //Verificar se tem cliente Cadastrado
        if(!consulta.clienteCadastrado()) return;
        if (!contatp.contasCadastradas(operacao)) return;

        // Pequisa se o cliente tem conta
        System.out.println("Informe o numero da Agencia:");
        numeroDaAgenciaOrigem = ui.getString("");

        System.out.println("Informe o numero da Conta:");
        numeroDaContaOrigem = ui.getString("");

        if (!contatp.contaExiste(numeroDaAgenciaOrigem, numeroDaContaOrigem)) {
            System.out.println("Agencia/Conta nao encontrada!");
             return;
        } 

        imprimirExtrato(numeroDaAgenciaOrigem, numeroDaContaOrigem);
    }

    public void imprimirExtratoCliente() {

        lerInput ui = new lerInput();
        int op;
        Conta contatp;
        String sair;

        String numeroDaAgenciaOrigem;
        String numeroDaContaOrigem;

        System.out.println("Entre com o tipo da conta:");
        op = ui.getInt("1 - Conta Corrente / 2 - Conta Poupança: ");
       
        if (op == 1) {
            contatp = new ContaCorrente();
        }
        else{    
            contatp = new ContaPoupanca();}

        consultarCadastro consulta = new consultarCadastro();

        //Verificar se tem agência Cadastrada
        if(consulta.agenciaCadastrada()) return;
        //Verificar se tem cliente Cadastrado
        if(consulta.clienteCadastrado()) return;

        // Pequisa se o cliente tem conta
        System.out.println("Informe o numero da Agencia:");
        numeroDaAgenciaOrigem = ui.getString("");

        System.out.println("Informe o numero da Conta:");
        numeroDaContaOrigem = ui.getString("");

        if (!contatp.contaExiste(numeroDaAgenciaOrigem, numeroDaContaOrigem)) {
            System.out.println("Agencia/Conta nao encontrada!");
             return;
        } 

        imprimirExtrato(numeroDaAgenciaOrigem, numeroDaContaOrigem);

        sair = ui.getString("Aperte qualquer tecla para sair");
        System.out.println(sair);
    }


}
