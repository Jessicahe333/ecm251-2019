package com.company;

public class Produto {
    private double preco;
    private String nome;
    private int id;

    public Produto(double preco, String nome, int id){
        this.preco = preco;
        this.nome = nome;
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }


    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

}

