package com.company.model;

public class Jogo {
    public int id;
    public String nome, genero, plataforma, lancamento;

    public Jogo(int id, String nome, String genero, String plataforma, String lancamento) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.plataforma = plataforma;
        this.lancamento = lancamento;
    }

    public Jogo(){}

    @Override
    public String toString() {
        return "Jogo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", plataforma='" + plataforma + '\'' +
                ", lancamento='" + lancamento + '\'' +
                '}';
    }

}

