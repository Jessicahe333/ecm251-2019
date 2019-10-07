package model;

import utilities.Constants;
public class Produto {
    public int id, quantidade;
    public String nome, fabricante, categoria;
    public double preco;

    public Produto( String nome, double preco, int quantidade, String fabricante, String categoria) {

        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.fabricante = fabricante;
        this.categoria =  categoria;
        this.id = Constants.ID_NULO;
    }

    public Produto(){}

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco='" + preco + '\'' +
                ", fabricante='" + fabricante + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }

}
