package com.company;

public class Main {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("Scalco");
        Produto produto = new Produto(4.5, "Coxinha", 0);
        Compra c1 = new Compra (1,cliente,produto);
        System.out.println(c1.pegarInformacao());

        Compra c2 = new Compra(2, new Cliente("Roberto"), new Produto(4.5,"Café",1));
        System.out.println(c2.pegarInformacao());

    }
}
