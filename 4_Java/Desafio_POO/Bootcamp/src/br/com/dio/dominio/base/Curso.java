package br.com.dio.dominio.base;

import br.com.dio.dominio.cadastro.*;

public class Curso extends Conteudo{

    private int cargaHoraria;
    
    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }

    public Curso() {
        Cadastro arquivo = new Cadastro();
        arquivo.setTabela("curso.txt");
        this.setDiretorio(arquivo.criarTabela());
    }


    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", cargaHoraria=" + cargaHoraria +
                '}';
    }

    public void cadastrarCurso() {

        try {

            lerInput ui = new lerInput();
            String titulo;
            String descricao;

            int op;

            do {
                titulo = ui.getString("Nome do curso: ");
                descricao  = ui.getString("Descricao sucinta: ");
                cargaHoraria = ui.getInt("Carga horaria: ");

                if (titulo.equalsIgnoreCase("")) {
                    System.out.println("Informe o nome do Conteudo!");
                    System.out.println();
                    op = ui.getInt("Deseja sair?  1 - Sim / 2 - Nao  ");
                    if (op == 1) return;
                }

            }while (titulo.equalsIgnoreCase(""));
            
            setTitulo(titulo);

            Cadastro cadastro = new Cadastro();

            if(cadastro.existirTexto(titulo,getDiretorio())) {
                System.out.println("Curso já existe no cadastro!");
                return;
            }   
                setDescricao(descricao);
                
                String texto = getTitulo()+";" +getDescricao() + ";" + getCargaHoraria() ;

                if (cadastro.gravarCadastro(getDiretorio(), texto)) {
                    System.out.println("Curso cadastrado com sucesso!");
                } else {
                    System.out.println("Erro no cadastro!");
                }
                
        } catch (Exception e) {
            return;
        }
    }

}
