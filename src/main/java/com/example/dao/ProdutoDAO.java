package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.example.model.Produto;

public class ProdutoDAO extends DAO{

    public ProdutoDAO(Connection conn) {
        super(conn);
    }

    public void excluir(long id) {
        var sql = "delete from produto where id = ?";
        try {
            var statement = conn.prepareStatement(sql);
            statement.setLong(1, id);
            if (statement.executeUpdate() == 1)
                System.out.println("Produto excluído com sucesso");
            else
                System.out.println("O produto não foi localizado");
        } catch (SQLException e) {
            System.err.println("Não foi possível realizar a operação: " + e.getMessage());
        }
    }

    public void alterar(Produto produto) {
        var sql = "update produto set nome = ?, marca_id = ?, valor =? where id = ?";
        try (var statement = conn.prepareStatement(sql);){
            statement.setString(1, produto.getName());
            statement.setLong(2, produto.getMarca().getId());
            statement.setDouble(3, produto.getValor());
            statement.setLong(4, produto.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Não foi possível realizar a operação: " + e.getMessage());
        }
    }

    public void inserir(Produto produto) {
        var sql = "insert into produto (nome, marca_id, valor) values (?, ?, ?)";
        try (var statement = conn.prepareStatement(sql);){
            statement.setString(1, produto.getName());
            statement.setLong(2, produto.getMarca().getId());
            statement.setDouble(3, produto.getValor());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Não foi possível realizar a operação: " + e.getMessage());
        }
    }

    public void listar() {
        try{
            var statement = conn.createStatement();
            var result = statement.executeQuery("select * from produto");
            while(result.next()){
                System.out.printf("Id: %d Nome: %s ID Marca: %s Valor: %s\n", result.getInt("id"), result.getString("nome"), result.getInt("marca_id"), result.getDouble("valor"));
            }
            System.out.println();
        } catch (SQLException e) {
            System.err.println("Não foi possível executar a consulta ao banco: " + e.getMessage());
        }
    }

    public void localizar(String nome) {
        try{
            //var sql = "select * from estado where uf = '" + uf + "'"; //suscetível a SQL Injection
            var sql = "select * from estado where nome = ?";
            var statement = conn.prepareStatement(sql);
            //System.out.println(sql);
            statement.setString(1, nome);
            var result = statement.executeQuery();
            if(result.next()){
                System.out.printf("Id: %d Nome: %s ID Marca: %s Valor: %s\n", result.getInt("id"), result.getString("nome"), result.getInt("marca_id"), result.getDouble("valor"));
            }
            System.out.println();
        } catch(SQLException e){
            System.err.println("Erro ao executar consulta SQL: " + e.getMessage());
        }        
    }
}
