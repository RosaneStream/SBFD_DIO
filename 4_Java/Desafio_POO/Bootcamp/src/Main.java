import br.com.dio.dominio.base.*;
import br.com.dio.dominio.cadastro.*;

public class Main {
    public static void main(String[] args) {


        Integer opcao=0;
        lerInput ui = new lerInput();
        int cont = 8;
    do{
        System.out.println("Selecione:");
        System.out.println("1 - Cadastrar Bootcamp");
        System.out.println("2 - Cadastrar curso");
        System.out.println("3 - Cadastrar desenvolvedor");
        System.out.println("4 - Cadastrar mentoria");
        System.out.println("5 - Matricular desenvolvedor");
        System.out.println("6 - Finalizar mentoria");
        System.out.println("7 - Finalizar curso");
        
        System.out.println("8 - Sair");

        try {
            do {
                opcao = ui.getInt("Digite a opcao: ");
                if (opcao > cont | opcao < 1) {
                    System.out.println("Opção Invalida!");
                }
            } while (opcao > cont | opcao < 1);
        } catch (Exception e) {
            System.out.println("Opção Invalida!");
        }

        try{
            switch (opcao) {
                case 1:
                    Bootcamp bc = new Bootcamp();
                    bc.cadastrarBootcamp();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                    
                default:
                    System.out.println("Operação finalizada!");
                    break;
            }           

        } catch (Exception e) {
            System.out.println("Erro na opção selecionada!");
            break;
        }
     
    }
        while(opcao<5);
    }
}