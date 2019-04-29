package com.company;

public class Teste {
    public static void main(String[] args) {
        Animal[] Animais = new Animal[3];
        Animais[0] = new Lobo();
        Animais[0].comer();
        //Animais[0].comer();  //Da Justa Causa! Não Fazer!
        // Animais[4].comer();   //Erro Lógica! Passa o tamanho do vetor!
        Animais[1] = new Lobo();
        Animais[2] = new Lobo();
        //for(int i = 0; i< Animais.length ;i++)  {
           // Animais[i].comer();
        //}
        for(Animal animais: Animais){
            animais.comer();
        }

    }
}
