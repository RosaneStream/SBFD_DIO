package br.com.dio.dominio.cadastro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.text.DecimalFormatSymbols;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;

public class lerInput {

    /**
     * testando a classe 
     *
     * @param args nome do arquivo � opcional
     */
    public static void main(String[] args) {
        lerInput ui = (args.length == 0) ? new lerInput() : new lerInput(args[0]);

        do {
            System.out.println("Nome " + ui.getString("Digite o nome: "));
            System.out.println("Idade " + ui.getInt("Digite a idade: "));
            System.out.println("Salario " + ui.getDouble("Digite o salario: "));
        } while (ui.isYes("Deseja digitar novamente?"));
        ui.setlogging(false);
        if (args.length == 0) {
            if (ui.isYes("Deseja salvar? ")) //  ui.writeInputToFile(ui.getString("Please enter filename: "));
            {
                ui.writeInputToFile();
            }
        }
    }

    private final BufferedReader br;
    private boolean echoInput = false;   // echo input se estiver lendo de um arquivo
    private boolean logInput = true;     // copiar inputs num arquivo log
    
    private List<String> lerInput = new LinkedList<>();

    /**
     * Default constructor, user input will be taken from System.in
     */
    public lerInput() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Constructor, user input will be taken from a file
     * <BR> (Intended for running repeatable test cases)
     *
     * @param filename a file to read from or write to
     * @throws RuntimeException an unrecoverable error occurred
     */
    public lerInput(String nomeArquivo) {
        File file = new File(nomeArquivo);
        System.out.println("Reading from file " + file.getAbsolutePath());
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        echoInput = true;
    }

    public String getString(String prompt) {
        System.out.print(prompt);
        String resposta;
        try {
            resposta = br.readLine();
            if (logInput) {
                lerInput.add(resposta); // logInput input
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        if (resposta == null) {
            throw new RuntimeException("Input finalizado!");
        }
        if (echoInput) {
            System.out.println(resposta);
        }
        return resposta;
    }

    public int getInt(String prompt) {
        int tentativa = 0;
        while (tentativa++ < 3) {  // 3 tentativas
            String input = getString(prompt);
            input = input.trim(); // retirar espa�os
            input = removeThousandsSeparators(input);
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Inteiro invalido! Digite novamente.");
            }
        }
        throw new RuntimeException("3 tentativas finalizadas!");
    }

    public double getDouble(String prompt) {
        int tentativa = 0;
        while (tentativa ++ < 3) {  // 3 tentativas
            String input = getString(prompt);
            input = input.trim(); // retirar espa�os
            input = removeThousandsSeparators(input);
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Valor invalido. Tente novamente.");
            }
        }
        throw new RuntimeException("3 tentativas finalizadas!");
    }

    public boolean isYes(String prompt) {
        int tentativa = 0;
        while (tentativa ++ < 3) {
            String input = getString(prompt).toLowerCase().trim();
            if (input.equals("y") || input.equals("yes") || input.equals("sim") || input.equals("s")) {
                return true;
            }
            if (input.equals("n") || input.equals("no") || input.equals("nao")) {
                return false;
            }
            System.out.println("Erro! Entre com Y ou N.");
        }
        throw new RuntimeException("3 tentativas finalizadas!");

    }

    // remove separadores antes de realizar as conversoes
    private static final char G_S = DecimalFormatSymbols.getInstance().getGroupingSeparator();
    private static final char D_S = DecimalFormatSymbols.getInstance().getDecimalSeparator();
    private static final Pattern S_P = Pattern.compile("(\\d)" + G_S + "(\\d\\d\\d)");

    private String removeThousandsSeparators(String s) {
        int decimalIndex = s.indexOf(D_S);
        if (decimalIndex != -1) {
            return removeThousandsSeparators(s.substring(0, decimalIndex)) + s.substring(decimalIndex);
        }

        String str = S_P.matcher(s).replaceAll("$1$2");
        if (s.equals(str)) {
            return str; // no match.
        }
        return removeThousandsSeparators(str); // match.  But is it the only match?  Send it through again.
    }

    public void setlogging(boolean on) {
        logInput = on;
    }

    public void writeInputToFile(String fileName) {
        writeInputToFile(new File(fileName));
    }

    public void writeInputToFile() {
        JFileChooser fc = new JFileChooser();
        int returnCode = fc.showSaveDialog(null);
        if (returnCode == JFileChooser.APPROVE_OPTION) {
            writeInputToFile(fc.getSelectedFile());
        }
    }

    private void writeInputToFile(File file) {
        System.out.println("Writing input to file " + file.getAbsolutePath());
        try {
            Files.write(file.toPath(), lerInput); // Java 8
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }

    }


}
