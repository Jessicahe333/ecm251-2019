package com.company;

public class Gerente {
    private String nome;
    private double salarioBase;
    private double comissao;

    public Gerente(String nome, double salarioBase){
        this.nome = nome;
        this.salarioBase = salarioBase;
    }

    public double getComissao(double totalDeVendaDoMes) {
        this.comissao = (totalDeVendaDoMes*0.1+this.salarioBase*0.5);
        return this.comissao;
    }

    public double getSalarioBase(){
        return this.salarioBase;
    }

    public double getSalarioDoMes(){
        return this.comissao+this.salarioBase;
    }

    public boolean aumentaSalarioBaseVendedor(Vendedor vendedor){
        if (vendedor.getGerente().equals(this)) {
            return true;
        }
        else {
            return false;
        }
    }
}
