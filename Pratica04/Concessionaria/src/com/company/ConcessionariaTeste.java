package com.company;

public class ConcessionariaTeste {
    public static void main(String[] args) {
        Gerente g1 = new Gerente("Luisa",7000.);
        Vendedor v1 = new Vendedor("Karina", 3000, g1);

        System.out.println("Vendedor: ");
        System.out.println("Comissão: R$" + v1.getComissao(10000));
        System.out.println("Gerente: ");
        System.out.println("Comissão: R$" + g1.getComissao(10000));
        if(g1.aumentaSalarioBaseVendedor(v1)){
            System.out.println("Pode dar aumento!");
        }
        else{
            System.out.println("Não pode aumentar!");
        }
    }
}
