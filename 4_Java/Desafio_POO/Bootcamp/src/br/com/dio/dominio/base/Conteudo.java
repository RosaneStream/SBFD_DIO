package br.com.dio.dominio.base;

public abstract class Conteudo {

    protected static final double XP_PADRAO = 10;

    private String titulo;
    private String descricao;
    private String diretorio;
    String totalXP;

    public abstract double calcularXp();

    public Conteudo(){
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDiretorio() {
        return diretorio;
    }

    public void setDiretorio(String diretorio) {
        this.diretorio = diretorio;
    }

    public String getTotalXP() {
        Double xp = XP_PADRAO;
        return xp.toString();
    }

    public void setTotalXP(String totalXP) {
        this.totalXP = totalXP;
    }

}
