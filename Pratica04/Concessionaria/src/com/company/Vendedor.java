package com.company;

public class Vendedor {
    private String nome;
    private double salarioBase;
    private double comissao;
    private Gerente gerente;


    public Vendedor(String nome, double salariobase, Gerente gerente){
        this.nome = nome;
        this.salarioBase = salariobase;
        this.gerente = gerente;
    }

    public double getComissao(double totalDeVendaDoMes) {
        this.comissao = totalDeVendaDoMes*0.05;
        return this.comissao;
    }

    public double getSalarioDoMes(){
        return this.comissao+this.salarioBase;
    }

    public double getSalarioBase(){
        return this.salarioBase;
    }

    public Gerente getGerente(){
        return gerente;
    }
}
