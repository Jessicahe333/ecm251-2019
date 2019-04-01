package com.company;

public class FucionariosTeste {
    public static void main(String[] args){
        Funcionarios f1 = new Funcionarios("Karina", 2000.00);
        System.out.println("Comissão: R$" + f1.getComissao(10000.00));
        System.out.println("Salário do mês: R$" + f1.getSalarioDoMes());
    }
}


