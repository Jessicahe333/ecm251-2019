package utilities;

import model.Usuario;

public class Constants {
    public static final String URL_MEU_BANCO = "jdbc:sqlite:MeuBanco.db";
    public static final int ID_NULO = -1;
    public static final String TABELA_PRODUTOS = "produtos";
    public static final String TABELA_VENDAS = "vendas";
    public static final String getInsert(String table, int paramsCount){
        String sqlInsert = "INSERT INTO "+ table + " VALUES (";
        for (int i = 0; i < paramsCount-1; i++) {
            sqlInsert += "?,";
        }
        sqlInsert += "?);";
        return sqlInsert;
    }
    public static final String selectAll(String table) {
        return "SELECT * FROM " + table + ";";
    }
    public static final String selectId(String table, int id){
        return "SELECT * FROM "+table+" WHERE id="+id+";";
    }
    public static final String selectCategoria(String table, String categoria){
        return ("SELECT * FROM " + table +" WHERE categoria LIKE '%" + categoria + "%';");
    }
    public static final String TABELA_USUARIO = "usuarios";
    public static final String updateUserById(String table, Usuario user){
        return "UPDATE "+ table + " SET nome=\"" + user.nome + "\"," +
                "email=\"" + user.email + "\"," +
                "senha=\"" + user.senha + "\" WHERE id=" + user.id+";";
    }

    public static final String deleteUserById(String table, int id){
        return "DELETE FROM "+ table + " WHERE id=" + id+";";
    }
    public static final String selectSenha(String table, String nome, String senha){
        return "SELECT * FROM "+table+" WHERE nome =" + "'" +nome + "'" +"AND senha =" +"'" + senha+ "'" +";";
    }

}