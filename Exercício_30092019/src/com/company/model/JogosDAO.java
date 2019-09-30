package com.company.model;

import com.company.utilities.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JogosDAO {
    private Connection connection;

    //Singleton
    private static JogosDAO instance = null;
    public static JogosDAO getInstance(){
        if (instance == null){
            instance = new JogosDAO();
        }
        return instance;
    }

    private JogosDAO(){
        try{
            connection = DriverManager.getConnection(Constants.kUrlBanco);
            //connection.setAutoCommit(false);
        }  catch (SQLException e){
            e.printStackTrace();
        }
    }

    private final String kTableName = "Jogos";
    private final String kSelectAllSql = "SELECT * FROM " + kTableName + ";";
    private final String selectName(String nome){
        return "SELECT * from " + kTableName + "WHERE 'nome'= " + nome + ";";
    }
    private final String kInsertJogo = "INSERT INTO "+ kTableName + " VALUES (null,?,?,?,?);";
    private final String kDeletaJogo(int id){
        return "DELETE FROM " + kTableName + " WHERE id=" + id + ";";
    }
    private final String kUpdateJogo (Jogo jogo) {
        return "UPDATE " + kTableName + " SET nome=\"" + jogo.nome + "\"," + "genero=\"" + jogo.genero + "\"," + "plataforma=\"" + jogo.plataforma + "\"," + "lancamento=\"" + jogo.lancamento + "\" WHERE id=" + jogo.id + ";";
    }

    public List<Jogo> getAll() {
        List<Jogo> jogos = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(kSelectAllSql);
            while (rs.next()) {
                Jogo jogo = new Jogo(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("genero"),
                        rs.getString("plataforma"),
                        rs.getString("lancamento")
                        );
                jogos.add(jogo);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return jogos;
    }
        public boolean insertJogo(Jogo jogo){
            PreparedStatement comandoSQL;
            try {
                comandoSQL = connection.prepareStatement(kInsertJogo);
                comandoSQL.setString(1, jogo.nome);
                comandoSQL.setString(2, jogo.genero);
                comandoSQL.setString(3, jogo.plataforma);
                comandoSQL.setString(4, jogo.lancamento);
                comandoSQL.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            } catch (NullPointerException e){
                e.printStackTrace();
                return false;
            } catch (Exception e){
                e.printStackTrace();
                return false;
            }
            return true;
        }

    public List<Jogo> getAllByName(String nome) {
        List<Jogo> jogos = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Jogos WHERE nome LIKE '%" + nome + "%';");
            while (rs.next()) {
                Jogo jogo = new Jogo(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("genero"),
                        rs.getString("plataforma"),
                        rs.getString("lancamento")
                );
                jogos.add(jogo);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return jogos;
    }

    public List<Jogo> getAllByPlataforma(String plataforma) {
        List<Jogo> jogos = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Jogos WHERE plataforma LIKE '%" + plataforma + "%';");
            while (rs.next()) {
                Jogo jogo = new Jogo(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("genero"),
                        rs.getString("plataforma"),
                        rs.getString("lancamento")
                );
                jogos.add(jogo);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }                                                      
        return jogos;
    }

    public List<Jogo> getAllByGenero(String genero) {
        List<Jogo> jogos = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Jogos WHERE genero LIKE '%" + genero + "%';");
            while (rs.next()) {
                Jogo jogo = new Jogo(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("genero"),
                        rs.getString("plataforma"),
                        rs.getString("lancamento")
                );
                jogos.add(jogo);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return jogos;
    }

    public boolean updateJogo(Jogo jogo) {
        try {
            Statement comandoSql = connection.createStatement();
            comandoSql.executeUpdate(kUpdateJogo(jogo));
            //connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void deletById(int id) {
        try {
            Statement comandoSql = connection.createStatement();
            comandoSql.executeUpdate(kDeletaJogo(id));
            //connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
