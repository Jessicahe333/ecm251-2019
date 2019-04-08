package com.company;

public class Credito {
    public static int idCartaoTotal = 1;

    private int idCartao;
    private String label;
    private String emissorCartao;     //O banco do cartão
    private String dataEmissão;
    private String validade;
    private int ccv;        // Código de segurança do cartão
    private int senha;       //Senha do cartão
    private int numeroCartao;
    private int numeroConta;
    private double taxaConversaoDolar = 3.87;

    public Credito(int numeroCartao, int numeroConta, int ccv, String emissorCartao, String dataEmissão, String validade, String label, int senha){
        this.numeroCartao = numeroCartao;
        this.numeroConta = numeroConta;
        this.ccv = ccv;
        this.emissorCartao = emissorCartao;
        this.dataEmissão = dataEmissão;
        this.validade = validade;
        this.label = label;
        this.senha = senha;
        this.idCartao = Credito.idCartaoTotal;
        Credito.idCartaoTotal ++;
    }

    public String pegaDados(){
        return "Id do Cartão: " + this.idCartao + "; Número do Cartão: " + this.numeroCartao + "; Número da Conta: " + this.numeroConta + "; CCV: " + this.ccv + "; Emissor do Cartão: " + this.emissorCartao + "; Data de Emissão: " + this.dataEmissão + "; Validade: " + this.validade + "; Label: " + this.label + "; Senha: " + this.senha;
    }
}
