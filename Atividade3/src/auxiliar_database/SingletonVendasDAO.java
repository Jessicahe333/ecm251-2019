package auxiliar_database;

import model.Usuario;
import model.Venda;
import utilities.Constants;

import java.sql.*;

public class SingletonVendasDAO {
    private Connection connection;
    private static SingletonVendasDAO instance = null;
    public static SingletonVendasDAO getInstance(){
        if(instance == null)
            instance = new SingletonVendasDAO(Constants.URL_MEU_BANCO);
        return instance;
    }
    private SingletonVendasDAO(String myConnection){
        try {
            connection = DriverManager.getConnection(myConnection);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
            connection = null;
        }
    }
    public boolean insertVenda(Venda venda){
        PreparedStatement comandoSQL;
        try {
            comandoSQL = connection.prepareStatement(Constants.getInsert(Constants.TABELA_VENDAS, 3));
            comandoSQL.setString(2, );
            comandoSQL.setString(3, user.email);
            comandoSQL.setString(4, user.senha);
            comandoSQL.setNull(1, Types.INTEGER);
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

}
