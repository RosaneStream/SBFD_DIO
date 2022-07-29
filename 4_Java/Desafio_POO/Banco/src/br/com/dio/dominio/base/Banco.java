package br.com.dio.dominio.base;

import br.com.dio.dominio.caminho.GetPath;
import br.com.dio.dominio.cadastro.*;

import java.io.*;
//import java.util.ArrayList;
//import java.util.List;

public class Banco {

    public String nome;
    private String idBanco;
    private String diretorio;

    public Banco(String idBanco, String nome, String diretorio) {
        this.idBanco = idBanco;
        this.nome = nome;
        this.diretorio = diretorio;
    }

    public Banco(){
        GetPath arquivo = new GetPath();
        arquivo.setTabela("banco.txt");
        this.setDiretorio(arquivo.tabelaExiste());
    }

    public String getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(String idBanco) {
        this.idBanco = idBanco;
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

    public boolean existirBanco() {

        try {

            File file = new File(getDiretorio());
            FileReader readFile = new FileReader(file);
            BufferedReader item = new BufferedReader(readFile);
            String text = item.readLine();
            if (text != null){
			    item.close();
                return true;
            }
            item.close();
            return false;
        } catch (IOException e) {
            return false;
        }
    }

		
    public boolean gravarBanco() {
        try {
            // Fluxo de saida de um arquivo
            FileWriter fw = new FileWriter(getDiretorio(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(this.getIdBanco() + "-" + this.getNome());
            bw.newLine();
            bw.close();
            fw.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public void cadastrarBanco() {

        try {

            lerInput ui = new lerInput();
            String id;
            String nome;
            String op;

            if (existirBanco()) {

                do {
                    id = ui.getString("Informe o numero do Banco: ");
                    nome  = ui.getString("Informe o nome do Banco: ");

                    if (id.equalsIgnoreCase("") || nome.equalsIgnoreCase("")){
                        System.out.println("Informe o Numero/Nome do Banco!");
                        System.out.println();
                        op = ui.getString("Deseja sair?  1 - Sim / 2 - Nao  ");
                        if (Integer.parseInt(op) == 1) return;
                    }

                }while (id.equalsIgnoreCase("") || nome.equalsIgnoreCase(""));

                setIdBanco(id);
                setNome(nome);

                if (gravarBanco()) {
                    System.out.println("Banco cadastrado com sucesso!");
                } else {
                    System.out.println("Erro no cadastro!");
                }
            }else{
                System.out.println("Banco ja cadastrado!");
            }
        } catch (Exception e) {
            //return false;
        }
    }
}
