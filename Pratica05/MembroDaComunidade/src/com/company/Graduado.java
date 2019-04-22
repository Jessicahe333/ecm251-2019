package com.company;

public class Graduado extends Membro {
    private String curso;

    public Graduado(String nome, String cpf, String curso){
        super(nome,cpf);
        this.curso = curso;
    }

    @Override
    public String getDados() {
        return super.getDados() + '\t' + curso;
    }
}
