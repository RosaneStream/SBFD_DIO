package br.com.dio.dominio.base;
import br.com.dio.dominio.cadastro.*;

//import java.time.LocalDate;

public class Mentoria extends Conteudo{

    private String data;
    private String hora;
   

    public Mentoria() {
        Cadastro arquivo = new Cadastro();
        arquivo.setTabela("mentoria.txt");
        this.setDiretorio(arquivo.criarTabela());
    }

    @Override
    public double calcularXp() {
        return XP_PADRAO + 20;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    @Override
    public String toString() {
        return "Mentoria{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", data=" + data +
                '}';
    }

    public void cadastrarMentoria() {
        String titulo;
        String data;
        String hora;

        try {

            lerInput ui = new lerInput();
        
            int op;

            do {
                titulo = ui.getString("Titulo da mentoria: ");
                data = ui.getString("Data: ");
                hora = ui.getString("Hora: ");
 
                if (titulo.equalsIgnoreCase("")) {
                    System.out.println("Informe titulo da mentoria!");
                    System.out.println();
                    op = ui.getInt("Deseja sair?  1 - Sim / 2 - Nao  ");
                    if (op == 1) return;
                }

            }while (titulo.equalsIgnoreCase(""));
            
            setTitulo(titulo);

            Cadastro cadastro = new Cadastro();

            if(cadastro.existirTexto(titulo,getDiretorio())) {
                System.out.println("Mentoria já existe no cadastro!");
                return;
            }   
                setTitulo(titulo);
                setData(data);
                setHora(hora);
                
                String texto = getTitulo()+";"+getData()+";"+getHora()+";"+getTotalXP();

                if (cadastro.gravarCadastro(getDiretorio(), texto)) {
                    System.out.println("Mentoria cadastrada com sucesso!");
                } else {
                    System.out.println("Erro no cadastro!");
                }
                
        } catch (Exception e) {
            return;
        }
    }

}
