package com.company;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class Teste {
    public static void main(String[] args) {
        Usuarios u1 = new Usuarios("Kariana", "karina@hotmail.com", "23.453.45-89", "29/12/1998");
        System.out.println("Usuário: " + u1.pegaDados());
        Debito d1 = new Debito(12345,5678,664,"Caixa","23/13/2016","10/24","Visa",2789);
        Carteiras c1 = new Carteiras("Karina",1234,d1, null);
        System.out.println("Débito: " + d1.pegaDados());
    }
}
