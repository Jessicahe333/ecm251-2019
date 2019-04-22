package com.company;

public class Main {
    static void mostrarDados(Membro membro){
        System.out.println(membro.getDados());
    }

    public static void main(String[] args) {
	Aluno a1 = new Aluno("Karina", "235","17.00709-7");
	Graduado g1 = new Graduado("Haha","149.158.155-99","Alimento");
	Funcionario f1 = new Funcionario("Murilo","2");
	Professor p1 = new Professor("Roberto","4","Computação");
	mostrarDados(a1);
	mostrarDados(g1);
    }
}
