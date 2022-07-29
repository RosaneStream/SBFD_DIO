package br.com.dio.dominio.base;

import br.com.dio.dominio.cadastro.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;


public class Bootcamp {
    private String nome;
    private String descricao;
    private final LocalDate dataInicial= LocalDate.now();
    private final LocalDate dataFinal = dataInicial.plusDays(45);
    private Set<Dev> devsInscritos = new HashSet<>();
    private Set<Conteudo> conteudos = new LinkedHashSet<>();
    private String diretorio;

    public Bootcamp(){
        try {

            Cadastro arquivo = new Cadastro();
            arquivo.setTabela("bootcamp.txt");
            this.setDiretorio(arquivo.criarTabela());
    
        } catch (Exception e) {
            System.out.println("Erro ao gerar cadastro Bootcamp!");
            
        }

    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public Set<Dev> getDevsInscritos() {
        return devsInscritos;
    }

    public void setDevsInscritos(Set<Dev> devsInscritos) {
        this.devsInscritos = devsInscritos;
    }

    public Set<Conteudo> getConteudos() {
        return conteudos;
    }

    public void setConteudos(Set<Conteudo> conteudos) {
        this.conteudos = conteudos;
    }

    public String getDiretorio() {
        return diretorio;
    }

    public void setDiretorio(String diretorio) {
        this.diretorio = diretorio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return Objects.equals(nome, bootcamp.nome) && Objects.equals(descricao, bootcamp.descricao) && Objects.equals(dataInicial, bootcamp.dataInicial) && Objects.equals(dataFinal, bootcamp.dataFinal) && Objects.equals(devsInscritos, bootcamp.devsInscritos) && Objects.equals(conteudos, bootcamp.conteudos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, descricao, dataInicial, dataFinal, devsInscritos, conteudos);
    }

    public void cadastrarBootcamp() {

        try {

            lerInput ui = new lerInput();
            String nome;
            String descricao;

            int op;

            do {
                nome = ui.getString("Nome do BootCamp: ");
                descricao  = ui.getString("Descricao sucinta: ");

                if (nome.equalsIgnoreCase(""))
                {
                    System.out.println("Informe o nome do Bootcamp!");
                    System.out.println();
                    op = ui.getInt("Deseja sair?  1 - Sim / 2 - Nao  ");
                    if (op == 1) return;
                }

            }while (nome.equalsIgnoreCase("") || nome.equalsIgnoreCase(""));
            
            setNome(nome);

            Cadastro cadastro = new Cadastro();

            if(cadastro.existirTexto(nome,diretorio)) {
                System.out.println("Bootcamp ja cadastrado!");
                return;
            }   
                setDescricao(descricao);
                
                String texto = this.getNome() + ";" + this.getDescricao()+";" + this.getDataInicial()+";" + this.getDataFinal();

                if (cadastro.gravarCadastro(diretorio, texto)) {
                    System.out.println("BootCamp cadastrado com sucesso!");
                } else {
                    System.out.println("Erro no cadastro!");
                }
                
        } catch (Exception e) {
            return;
        }
    }

    public void matricularDev() {

        try {

            lerInput ui = new lerInput();
            String nome;
        
            int op;

            do {
                nome = ui.getString("Matricula de desenvolvedor: ");
 
                if (nome.equalsIgnoreCase("")) {
                    System.out.println("Informe o nome do desenvolvedor!");
                    System.out.println();
                    op = ui.getInt("Deseja sair?  1 - Sim / 2 - Nao  ");
                    if (op == 1) return;
                }

            }while (nome.equalsIgnoreCase(""));
            
            setNome(nome);

            Cadastro cadastro = new Cadastro();

            if(cadastro.existirTexto(nome,getDiretorio())) {
                System.out.println("Desenvolvedor já está matriculado!");
                return;
            }   
                String texto = getNome();
               // *****************************
                devsInscritos.add(new Dev(texto));
                

                if (cadastro.gravarCadastro(getDiretorio(), texto)) {
                    System.out.println("Desenvolvedor cadastrado com sucesso!");
                } else {
                    System.out.println("Erro no cadastro!");
                }
                
        } catch (Exception e) {
            return;
        }
    }

}
