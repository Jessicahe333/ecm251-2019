package com.company;

public class ContaTesteDrive {
    public static void main(String[] args) {
        Conta c1,c2;
        c1 = new Conta();
        c2 = new Conta();
        c1.numero = 123;
        c2.numero = 771;
        c1.depositar(500.00);
        c1.transferirDinheiro(100.00,c2);
        c1.visualizarSaldo();
        c2.visualizarSaldo();
    }
}
