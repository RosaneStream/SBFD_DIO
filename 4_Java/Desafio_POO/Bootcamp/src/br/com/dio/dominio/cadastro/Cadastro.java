package br.com.dio.dominio.cadastro;

import java.io.*;
import java.nio.file.*;

public class Cadastro {

    private String tabela;

    public String getTabela() {
        return tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    public Cadastro(){   
        

    }

    //verifica se o conteudo contém o texto na primeira coluna
    public boolean existirTexto(String busca, String diretorio) {
    try {

        String[] conteudo;
        File file = new File(diretorio);
        FileReader readerFile = new FileReader(file);
        BufferedReader item = new BufferedReader(readerFile);
        String text = item.readLine();

        while (text != null) {
            conteudo = text.split(";");
            if (conteudo[0].equalsIgnoreCase(busca)){
                item.close();
                return true;
            }
            text = item.readLine();
        }

        item.close();

        return false;
    } catch (IOException e) {
        System.out.println("Arquivo não encontrado");
        return false;
    }
}

public boolean gravarCadastro(String diretorio, String texto) {
    try {
        // Fluxo de saida de um arquivo
        FileWriter fw = new FileWriter(diretorio, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(texto);
        bw.newLine();
        bw.close();
        fw.close();
        return true;
    } catch (IOException e) {
        return false;
    }
}

public String criarTabela(){

    
    Path path = Paths.get(this.tabela);
    Path nomeDiretorio = Paths.get("");
    String diretorio =  nomeDiretorio.toAbsolutePath().toString();

    if (path.toFile().isFile()){
        diretorio += "/" + this.tabela;
        return diretorio;
    }else{
        File arquivo = new File(diretorio, this.tabela);
        try {
            arquivo.createNewFile();
            diretorio += "/" + this.tabela;
            return diretorio;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


}
