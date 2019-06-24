package com.company;

public class Cliente {
    private String cpf;
    private String nome;
    private String endereco;
    private String cep;
    private String email;


    public Cliente(String nome, String cpf, String endereco, String cep, String email){
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.cep = cep;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
