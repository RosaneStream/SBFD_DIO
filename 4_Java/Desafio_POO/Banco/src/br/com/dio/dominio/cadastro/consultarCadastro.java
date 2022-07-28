package br.com.dio.dominio.cadastro;

import br.com.dio.dominio.base.Conta;
import br.com.dio.dominio.base.Agencia;
import br.com.dio.dominio.base.Banco;
import br.com.dio.dominio.base.Cliente;

public class consultarCadastro {
    Banco banco = new Banco();
    Agencia agencia = new Agencia();
    Cliente cliente = new Cliente();
    Conta conta = new Conta();

    //Verificar se tem banco Cadastrado
    public boolean bancoCadastrado(){
        if (!banco.existirBanco()){
            System.out.println("Nenhum banco cadastrado. Cadastre ao menos um!");
            System.out.println();
            return false;
        }else{
            return true;
        }
    }
    //Verificar se tem agência Cadastrada
    public boolean agenciaCadastrada(){
        if(!agencia.existirAgencia()) {
            System.out.println("Nenhuma agencia cadastrada. Cadastre ao menos uma!");
            System.out.println();
            return false;
        }else{
            return true;
        }
    }

    public  boolean clienteCadastrado(){
        if(!cliente.buscarArquivo()) {
            System.out.println("Nenhum cliente cadastrado. Cadastre o primeiro!");
            System.out.println();
            return false;
        }else{
            return true;
        }
    }

    /*
    public boolean contasCadastradas(String operacao){
        int contador = conta.contarContas();
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
    }*/


}
