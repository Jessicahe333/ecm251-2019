package com.company.model;
import com.company.utilities.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimaisDAO {
    private Connection connection;

    //Singleton
    private static AnimaisDAO instance = null;
    public static AnimaisDAO getInstance(){
        if (instance == null){
            instance = new AnimaisDAO();
        }
        return instance;
    }

    private AnimaisDAO(){
        try{
            connection = DriverManager.getConnection(Constants.kUrlBanco);
        }  catch (SQLException e){
            e.printStackTrace();
        }
    }
    private final String kTableName = "animais";
    private final String kSelectAllSql = "SELECT * from" + kTableName + ";";
    private final String selectName(String nome){
        return "SELECT * from " + kTableName + "WHERE 'nome'= " + nome + ";";
    }
    private final String kInsertAnimal = "INSERT INTO "+ kTableName + " VALUES (?,?,?,?,?,?,?);";
    private final String kDeletaAnimal(Animal a){
        return "DELETE FROM " + kTableName + " WHERE id=" + a.getId() + ";";
    }
    private final String kUpdateAnimal (Animal animal) {
        return "UPDATE " + kTableName + " SET nome=\"" + animal.nome + "\", " + "lat=" + animal.lat + "," + "lon=" + animal.lon + ",altura=" + animal.altura + ",peso=" + animal.peso + ",tipo=\"" + animal.tipo + "\" WHERE Id=" + animal.getId() + ";";
    }

    public Animal getAnimal(String nome){
        Animal MyAnimal = null;
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(selectName(nome));
            while (rs.next()){
                Animal animal = new Animal(rs.getInt("id"));
                animal.nome = rs.getString("nome");
                animal.lat = rs.getDouble("lat");
                animal.lon = rs.getDouble("lon");
                animal.altura = rs.getDouble("altura");
                animal.tipo = rs.getString("tipo");
                animal.peso = rs.getDouble("peso");
                MyAnimal = animal;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return MyAnimal;
    }
    public List<Animal> getAll(){
        List<Animal> animais = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(kSelectAllSql);
            while (rs.next()){
                Animal animal = new Animal(rs.getInt("id"));
                animal.nome = rs.getString("nome");
                animal.lat = rs.getDouble("lat");
                animal.lon = rs.getDouble("lon");
                animal.altura = rs.getDouble("altura");
                animal.tipo = rs.getString("tipo");
                animal.peso = rs.getDouble("peso");
                animais.add(animal);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return animais;
    }
    public boolean insertAnimal(Animal animal){
        PreparedStatement comandoSQL;
        try {
            comandoSQL = connection.prepareStatement(kInsertAnimal);
            comandoSQL.setNull(1, Types.INTEGER);
            comandoSQL.setString(2, animal.nome);
            comandoSQL.setDouble(3, animal.lat);
            comandoSQL.setDouble(4, animal.lon);
            comandoSQL.setDouble(5, animal.altura);
            comandoSQL.setDouble(6, animal.peso);
            comandoSQL.setString(7, animal.tipo);
            comandoSQL.executeUpdate();
            connection.commit();
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
    public boolean updataAnimal(Animal animal){
        try {
            Statement comandoSql = connection.createStatement();
            comandoSql.executeUpdate(kUpdateAnimal(animal));
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean deleteAnimal(String nome){
        try {
            Animal animal = getAnimal(nome);
            Statement comandoSql = connection.createStatement();
            comandoSql.executeUpdate(kDeletaAnimal(animal));
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}


