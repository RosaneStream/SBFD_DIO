package br.com.dio.dominio.base;

import br.com.dio.dominio.caminho.GetPath;
import br.com.dio.dominio.cadastro.lerInput;
import br.com.dio.dominio.cadastro.consultarCadastro;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Agencia {
    private String numeroAgencia;
    private String nomeAgencia;
    private String diretorio;

    public Agencia(String numeroAgencia, String nomeAgencia, String diretorio ) {
        this.numeroAgencia = numeroAgencia;
        this.nomeAgencia = nomeAgencia;
        this.diretorio = diretorio;
    }

    public Agencia() {
        GetPath arquivo = new GetPath();
        arquivo.setTabela("agencia.txt");
        this.setDiretorio(arquivo.tabelaExiste());
    }

    public String getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(String numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public String getNomeAgencia() {
        return nomeAgencia;
    }

    public void setNomeAgencia(String nomeAgencia) {
        this.nomeAgencia = nomeAgencia;
    }

    public String getDiretorio() {
        return diretorio;
    }

    public void setDiretorio(String diretorio) {
        this.diretorio = diretorio;
    }
    public boolean gravarAgencia() {

        try {
            FileWriter fw = new FileWriter(getDiretorio(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write( this.getNumeroAgencia() + "-" + this.getNomeAgencia());
            bw.newLine();
            bw.close();
            fw.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    public List<String> listarAgencias() {

        try {

            File file = new File(getDiretorio());
            FileReader readerFile = new FileReader(file);
            BufferedReader item = new BufferedReader(readerFile);

            List<String> nomeAgencias = new ArrayList<>();

            System.out.println("--------------------------------------------------------");
            System.out.println("Agencia(s) Cadastrada(s):");
            System.out.println("--------------------------------------------------------");

            String text = item.readLine();
            while (text != null) {
                nomeAgencias.add(text);
                System.out.println(text);
                text = item.readLine();
            }
            System.out.println("--------------------------------------------------------");
            item.close();
            return nomeAgencias;
        } catch (IOException e) {
            //System.out.println("Arquivo não encontrado");
            return null;
        }
    }
    public boolean agenciaExiste() {

        try {

            String[] dataAgencias;
            File file = new File(getDiretorio());
            FileReader readerFile = new FileReader(file);
            BufferedReader item = new BufferedReader(readerFile);
            String text = item.readLine();

            while (text != null) {
                dataAgencias = text.split("-");
                if (dataAgencias[0].equalsIgnoreCase(getNumeroAgencia())){
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

    public boolean existirAgencia() {

        try {

            File file = new File(getDiretorio());
            FileReader readerFile = new FileReader(file);
            BufferedReader item = new BufferedReader(readerFile);
            
            String text = item.readLine();
            if  (text != null) {
                item.close();
                return true;
            }
            item.close();
            return false;
        } catch (IOException e) {
            System.out.println("Cadastro de agência não encontrado");
            return false;
        }
    }

    public void cadastrarAgencia() {

        try {

            lerInput ui = new lerInput();
            int op;

            String numeroAgencia;
            String nomeAgencia;
            
            consultarCadastro consulta = new consultarCadastro();

            if(!consulta.bancoCadastrado()) return;

            do {
                do {

                   System.out.println();
                   System.out.println("Informe o numero da Agencia: ");
                   numeroAgencia =ui.getString("");
                   System.out.println();

                   System.out.println("Informe o nome da Agencia: ");
                   nomeAgencia =ui.getString("");
                   System.out.println();

                    if (numeroAgencia.equalsIgnoreCase("") || nomeAgencia.equalsIgnoreCase("")){
                        System.out.println("Informe o Numero/Nome da Agencia!");
                        System.out.println();
                    }

                } while (numeroAgencia.equalsIgnoreCase("") || nomeAgencia.equalsIgnoreCase(""));

                setNumeroAgencia(numeroAgencia);
                setNomeAgencia(nomeAgencia);

                if (agenciaExiste()){
                    System.out.println("Agencia Cadastrada. Informe outro numero!");
                    op =0;
                }else{
                    op=1;
                }
            }while(op == 0);

            if (gravarAgencia()) {
                System.out.println("Agencia cadastrada com sucesso!");
                //op = ui.getInt("Deseja cadastrar nova Agencia? 1- Sim 2 - Nao");
                //if (op == 1) {//recursivo
                  //  cadastrarAgencia();
                //}
            } else {
                System.out.println("Erro no cadastro!");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
