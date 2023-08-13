package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*import java.sql.Statement;*/

import com.example.dao.DAO;
import com.example.dao.EstadoDAO;
import com.example.dao.ProdutoDAO;
import com.example.model.Marca;
import com.example.model.Produto;

public class AppBd {
    private static final String PASSWORD = "";
    private static final String USER_NAME = "gitpod";
    private static final String JDBC_URL = "jdbc:postgresql://localhost/postgres";

    public static void main(String[] args) {
        new AppBd();
    }

    public AppBd(){
        try(var conn = getConnection()){
            var estadoDAO = new EstadoDAO(conn);
            var listaEstados = estadoDAO.listar();
            for (var estado : listaEstados) {
                System.out.println(estado);
            }
            estadoDAO.localizar("TO");

            var marca = new Marca();
            marca.setId(1L);

            var produto = new Produto();
            produto.setId(205L);
            produto.setValor(90.0);
            produto.setMarca(marca);
            produto.setName("Produto Novo 1");
            
            var produtoDAO = new ProdutoDAO(conn);
            produtoDAO.inserir(produto);
            produtoDAO.excluir(203L);
            produtoDAO.alterar(produto);
            var dao = new DAO(conn);
            dao.listarDadosTabela("produto");
            
        }
        catch (SQLException e) {
            System.err.println("Não foi possível carregar o banco de dados" + e.getMessage());        
        }
    }    

    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_URL, USER_NAME, PASSWORD);
    }

    /*private void carregarDriverJDBC() {
        try {
            Class.forName("org.postgresql.Driver");              
        } catch (ClassNotFoundException e) {
            System.err.println("Não foi possível carregar a biblioteca para acesso ao banco de dados" + e.getMessage());
        }
    }*/
}
