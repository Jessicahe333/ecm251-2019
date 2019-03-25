package com.company;

public class Cliente {
    private String nome;
    private String endereco;
    private  String cpf;
    private int idade;

    public void mudarCPF(String cpf){
        if (validarCPF(cpf))  {
            this.cpf = cpf;
        }   else{
            System.out.println("Não foi possível alterar o CPF.");
        }
    }

    private boolean validarCPF(String cpf){
        //série de regras aqui, falha caso não seja válido.
        return false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String CPF) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
