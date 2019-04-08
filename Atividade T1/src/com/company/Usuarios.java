package com.company;

public class Usuarios {
    private String nome;
    private String email;
    private String cpf;
    private String nascimento;

    public Usuarios(String nome, String email, String cpf, String nascimento){
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.nascimento = nascimento;
    }

    public String pegaDados(){
        return "Nome: " + this.nome + "; Email: " + this.email + "; CPF: " + this.cpf + "; Nascimento: " + this.nascimento;
    }
}
