package auxiliar_database;

import model.Produto;
import utilities.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SingletonProdutosDAO {
    private Connection connection;
    private static SingletonProdutosDAO instance = null;
    public static SingletonProdutosDAO getInstance(){
        if(instance == null)
            instance = new SingletonProdutosDAO(Constants.URL_MEU_BANCO);
        return instance;
    }
    private SingletonProdutosDAO(String myConnection){
        try {
            connection = DriverManager.getConnection(myConnection);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
            connection = null;
        }
    }
    public boolean insertProduto(Produto produto){
        PreparedStatement comandoSQL;
        try {
            comandoSQL = connection.prepareStatement(Constants.getInsert(Constants.TABELA_PRODUTOS, 6));
            comandoSQL.setString(2, produto.nome);
            comandoSQL.setDouble(3, produto.preco);
            comandoSQL.setInt(4, produto.quantidade);
            comandoSQL.setString(5, produto.fabricante);
            comandoSQL.setString(6, produto.categoria);
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
    public List<Produto> getAllProduto(){
        List<Produto> produtos = new ArrayList<>();

        try {
            Statement comandoSql = connection.createStatement();
            ResultSet rs = comandoSql.executeQuery(Constants.selectAll(Constants.TABELA_PRODUTOS));
            while(rs.next()){
                Produto produto = new Produto(
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getInt("quantidade"),
                        rs.getString("fabricante"),
                        rs.getString("categoria")
                );
                produto.id = rs.getInt("id");
                produtos.add(produto);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return produtos;
    }
    public Produto getProduto(int id){
        Produto produto = null;
        try {
            Statement comandoSql = connection.createStatement();
            ResultSet rs = comandoSql.executeQuery(Constants.selectId(Constants.TABELA_PRODUTOS, id));
            while(rs.next()){
                produto = new Produto(
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getInt("quantidade"),
                        rs.getString("fabricante"),
                        rs.getString("categoria")
                );
                produto.id = rs.getInt("id");
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return produto;
    }
    public List<Produto> getAllProdutosByCategoria(String categoria){
        List<Produto> resultados = new ArrayList<>();
        try {
            Statement comandoSql = connection.createStatement();
            ResultSet rs = comandoSql.executeQuery(Constants.selectCategoria(Constants.TABELA_PRODUTOS,categoria));
            while (rs.next()) {
                Produto produto = new Produto(
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getInt("quantidade"),
                        rs.getString("fabricante"),
                        rs.getString("categoria")
                );
                produto.id = rs.getInt("id");
                resultados.add(produto);
            }
        }
        catch (Exception e){
            System.out.println("Algo deu errado!");
        }
        return resultados;
    }
}
