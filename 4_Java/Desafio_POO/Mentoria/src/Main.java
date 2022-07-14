import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

//import java.time.*;
//import java.time.format.DateTimeFormatter;
import java.util.*;
import java.text.*;

public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) {

        /*fazer a repetição para cadastrar cursos*/
        Curso curso1 = new Curso();
        curso1.setTitulo("Java");
        curso1.setDescricao("Programação orientada a objetos com Java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("JavaScript");
        curso2.setDescricao("Introdução ao JavaScript");
        curso2.setCargaHoraria(4);

        //repetição para cadastrar mentoria
        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de java");
        mentoria.setDescricao("Mentoria sobre Programação OO com Java");

        Locale localAtual = Locale.getDefault();
        Date dataAtual = new Date();
        DateFormat hoje = DateFormat.getDateInstance(DateFormat.MEDIUM, localAtual);

        mentoria.setData(hoje.format(dataAtual));

        /*System.out.println(curso1);
        System.out.println(curso2);
        System.out.println(mentoria);*/

        /*repetição para cadastrar bootcamp */
        Bootcamp bootcamp = new Bootcamp();

        //bootcamp.cadastrar();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        /*repetição para cadastrar dev */
        Dev devRosane = new Dev();
        devRosane.setNome("Rosane");
        devRosane.inscreverBootcamp(bootcamp);
        System.out.println("Rosane está inscrita em: "  + devRosane.getConteudosInscritos());
        devRosane.progredir();
        devRosane.progredir();
        System.out.println("-");
        System.out.println(devRosane.getNome() +" está inscrita em: " + devRosane.getConteudosInscritos());
        System.out.println("Rosane concluiu: " + devRosane.getConteudosConcluidos());
        System.out.println("XPs da Rosane:" + devRosane.calcularTotalXp());

        System.out.println("-------");

        Dev devJoao = new Dev();
        devJoao.setNome("Joao");
        devJoao.inscreverBootcamp(bootcamp);
        System.out.println("João está inscrito em: " + devJoao.getConteudosInscritos());
        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();
        System.out.println("-");
        System.out.println("João está inscrito em: " + devJoao.getConteudosInscritos());
        System.out.println("João concluiu: " + devJoao.getConteudosConcluidos());
        System.out.println("XPs do João:" + devJoao.calcularTotalXp());

    }

}
