package br.com.dio.dominio.caminho;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;


public class GetPath {

    private String tabela;

    public GetPath(String tabela) {
      this.tabela =tabela;
   }

    public GetPath() {
    }

    public String getTabela() {
        return tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    public String tabelaExiste(){

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
