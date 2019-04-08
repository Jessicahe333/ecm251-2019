package com.company;

public class Carteiras {
    private int idCarteira;
    private String nomeCarteira;
    private int senhaAcesso; //A senha somente é números.
    private Debito debito;
    private Credito credito;
    private int senhaPagar;

    public static int TotalDeCarteiras = 1;

    public Carteiras(String nomeCarteira, int senhaAcesso, Debito debito, Credito credito ){
        this.idCarteira = Carteiras.TotalDeCarteiras;
        Carteiras.TotalDeCarteiras ++;
        this.nomeCarteira = nomeCarteira;
        this.senhaAcesso = senhaAcesso;
        this.debito = debito;
        this.credito = credito;
    }

    public String pegaDados(){
        return "Id do Cartão: " + this.idCarteira + "; Nome do Cartão: " + this.nomeCarteira + "; Senha de acesso: " + this.senhaAcesso + "; Cartão de débito:" + this.debito.pegaDados() + "; Cartão de crédito:" + this.credito.pegaDados();
    }

    public void inserirSenha(int senhaPagar){   //Pagamento somente ser realizado com cartão débito.
        this.senhaPagar = senhaPagar;
    }

    public int getSenhaPagar() {
        return senhaPagar;
    }

    public boolean permitirPagamento(Debito debito){
        if(debito.getSenha() == this.getSenhaPagar()){
            return true;
        }
        else{
            return false;
        }
    }

    public void pagar(double valor, Debito debito, int senhaPagar){   //Pagamento somente pode ser realizado com cartão débito
        this.senhaPagar = senhaPagar;
        if(this.permitirPagamento(debito)){
            System.out.println("Pagamento realizado no valor de R$" + valor + " do cartão débito" + debito.getNumeroConta()".");
        }
        else{
            System.out.println("Pagamento recusado.");
        }
    }
}
