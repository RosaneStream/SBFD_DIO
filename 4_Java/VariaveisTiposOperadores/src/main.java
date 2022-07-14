package one.digitalinnovation.basecamp;

public class Main {

    public static void main(String[] args) {

        // Calculadora
        System.out.println("Exerc√≠cio calculadora");
        Calculadora.soma(3, 6);
        Calculadora.subtracao(9, 1.8);
        Calculadora.multiplicacao(7, 8);
        Calculadora.divisao(5, 2.5);

        // Mensagem
        System.out.println("Exerc√≠cio mensagem");
        Mensagem.obterMensagem(9);
        Mensagem.obterMensagem(14);
        Mensagem.obterMensagem(1);

        // Empr√©stimo
        System.out.println("Exerc√≠cio empr√©stimo");
        Emprestimo.calcular(1000, Emprestimo.getDuasParcelas());
        Emprestimo.calcular(1000, Emprestimo.getTresParcelas());
        Emprestimo.calcular(1000, 5);


        // Retornos
        System.out.println("ExercÌcio retornos");

        double areaQuadrado = Quadrilatero.area(3);
        System.out.println("¡rea do quadrado:" + areaQuadrado);

        double areaRetangulo = Quadrilatero.area(5,5);
        System.out.println("¡rea do ret‚ngulo:" + areaRetangulo);

        double areaTrapezio = Quadrilatero.area(7,8,9);
        System.out.println("¡rea do trapÈzio:" + areaTrapezio);


}

}