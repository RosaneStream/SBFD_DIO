package br.com.dio.dominio.base;

import java.util.*;

import br.com.dio.dominio.cadastro.*;


public class Dev {

    private String nome;
    private String diretorio;

    public Dev(){
        Cadastro arquivo = new Cadastro();
        arquivo.setTabela("dev.txt");
        this.setDiretorio(arquivo.criarTabela());
    }
    
    public Dev(String nome){}

    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if(conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

    public double calcularTotalXp() {
        Iterator<Conteudo> iterator = this.conteudosConcluidos.iterator();
        double soma = 0;
        while(iterator.hasNext()){
            double next = iterator.next().calcularXp();
            soma += next;
        }
        return soma;

        /*return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();*/
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
    
    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }

    public void cadastrarDev() {

        try {

            lerInput ui = new lerInput();
            String nome;
        
            int op;

            do {
                nome = ui.getString("Nome do desenvolvedor: ");
 
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
                System.out.println("Desenvolvedor já existe no cadastro!");
                return;
            }   
                String texto = getNome();

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
