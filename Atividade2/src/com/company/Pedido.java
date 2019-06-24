package com.company;

public class Pedido extends Cliente {

    public void Pedido(String cli, String carrinho){
    }

    static public void resumoPedido(){
        System.out.println("Seu carrinho possui os seguintes itens: " + Carrinho.retornarResumo());
    }
}
