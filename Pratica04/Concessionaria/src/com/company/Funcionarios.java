package com.company;

public class Funcionarios {
    private String nome;
    private double salarioBase;
    private double comissao;

    //private static double totalDeVendaDoMes;

    public Funcionarios(String nome, double salariobase){
        this.nome = nome;
        this.salarioBase = salariobase;
    }

    public double getComissao(double totalDeVendaDoMes) {
        this.comissao = totalDeVendaDoMes*0.05;
        return this.comissao;
    }

    public double getSalarioDoMes(){
        return this.comissao+this.salarioBase;
    }
}
