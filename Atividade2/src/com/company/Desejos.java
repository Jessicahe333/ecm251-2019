package com.company;

import java.util.ArrayList;

public class Desejos{
    ArrayList<Produto> list = new ArrayList<Produto>();

    public boolean adicionarALista(Produto p) {
        list.set(0, p);
    }

    static public void retornarResumo(Desejos list) {
        System.out.println(list);
    }

    public void removerUltimoDaLista(){

    }

    public void getRestantes(){
        int restante = 0;
        for (int i=0; i<12; i++){
            if (null != ArrayList[i]){
            }
            else{
                restante++;
            }
        }
    }
}
