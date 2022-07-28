import br.com.dio.dominio.base.*;
import br.com.dio.dominio.cadastro.*;
import br.com.dio.dominio.operacao.*;


public class Main {
    public static void main(String[] args) {


        Integer opcao=0;
        lerInput ui = new lerInput();
        int cont = 10;
    do{
        System.out.println("Selecione:");
        System.out.println("1 - Cadastrar banco");
        System.out.println("2 - Cadastrar agencia");
        System.out.println("3 - Cadastrar cliente");
        System.out.println("4 - Cadastrar conta corrente");
        System.out.println("5 - Cadastrar conta poupança");
        System.out.println("6 - Realizar depósito");
        System.out.println("7 - Realizar saque");
        System.out.println("8 - Realizar transferencia");
        System.out.println("9 - Imprimir extrato");
        System.out.println("10 - Sair");

        try {
            do {
                opcao = ui.getInt("Digite a opcao: ");
                if (opcao > cont | opcao < 1) {
                    System.out.println("Opcao Invalida!");
                }
            } while (opcao > cont | opcao < 1);
        } catch (Exception e) {
            System.out.println("Opcao Invalida!");
        }

        try{
            switch (opcao) {

                case 1:
                    Banco banco = new Banco();
                    banco.cadastrarBanco();
                    break;
                case 2:
                    Agencia agencia = new Agencia();
                    agencia.cadastrarAgencia();
                    break;
                case 3:
                    Cliente cliente = new Cliente();
                    cliente.cadastrarCliente();
                    break;
                case 4:
                    ContaCorrente contac = new ContaCorrente();
                    contac.cadastrarConta();
                    break;
                case 5:
                    ContaPoupanca contap = new ContaPoupanca();
                    contap.cadastrarConta();
                    break;
                case 6:
                    Operation deposito = new Operation();
                    deposito.realizarOperacao("d");
                    break;
                case 7:
                    Operation saque = new Operation();
                    saque.realizarOperacao("s");
                    break;
                case 8:
                    Operation transfere = new Operation();
                    transfere.realizarOperacao("t");
                    break;
                case 9:
                    Operation op = new Operation();
                    op.imprimirExtratoConta();
                    break;
                default:
                    System.out.println("Operacao finalizada!");
                    break;
            }           

        } catch (Exception e) {
            System.out.println("Erro na opção selecionada!");
            break;
        }
     
    }
        while(opcao<10);
    }
}