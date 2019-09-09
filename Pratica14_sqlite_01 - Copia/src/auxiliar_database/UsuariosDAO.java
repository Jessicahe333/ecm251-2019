package auxiliar_database;

import model.Usuario;
import utilities.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuariosDAO {
    private Connection connection;

    // Criar a tebela pelo código, não utiliza o arquivo de banco de dados tem criado.
    public UsuariosDAO(String myConnection){
        try {
            connection = DriverManager.getConnection(myConnection);

            connection.setAutoCommit(false);

        } catch (SQLException e) {
            e.printStackTrace();
            connection = null;
        }
    }

    public boolean insertUsuario(Usuario user){
        PreparedStatement comandoSQL;
        try {
            comandoSQL = connection.prepareStatement(Constants.getInsert(Constants.TABELA_USUARIO, 4));
            comandoSQL.setString(2,user.nome);
            comandoSQL.setString(3,user.email);
            comandoSQL.setString(4,user.senha);
            comandoSQL.setNull(1,Types.INTEGER);
            comandoSQL.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (NullPointerException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Usuario> getALLUsuario(){
        List<Usuario> users = new ArrayList<>();

        try {
            Statement comandosql = connection.createStatement();
            ResultSet rs = comandosql.executeQuery(Constants.selectAll(Constants.TABELA_USUARIO));
            while (rs.next()){
                Usuario user = new Usuario(
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha"));
                user.id = rs.getInt("id");
                users.add(user);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return users;

    }
}
