package model;

public class Venda {
    String usuario;
    int codigo,quantidadeVendida;

    public Venda(String usuario, int codigo, int quantidadeVendida ){
        this.usuario = usuario;
        this.codigo = codigo;
        this.quantidadeVendida = quantidadeVendida;
    }
    public Venda(){}

    @Override
    public String toString() {
        return "Venda{" +
                "usuario=" + usuario +
                ", cadigo='" + codigo + '\'' +
                ", quantidadeVendida='" + quantidadeVendida + '\'' +
                '}';
    }
}
