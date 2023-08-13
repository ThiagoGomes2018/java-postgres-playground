package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.example.model.Estado;

public class EstadoDAO extends DAO{
    


    public EstadoDAO(Connection conn) {
        super(conn);
    }

    public List<Estado> listar() throws SQLException {
        
            var lista = new LinkedList<Estado>();
            var statement = conn.createStatement();
            var result = statement.executeQuery("select * from estado");
            while(result.next()){
                var estado = new Estado();
                estado.setId(result.getLong("id"));
                estado.setNome(result.getString("nome"));
                estado.setUf(result.getString("uf"));
                lista.add(estado);
            }
            return lista;    
    }

    public void localizar(String uf) {
        try{
            //var sql = "select * from estado where uf = '" + uf + "'"; //suscetível a SQL Injection
            var sql = "select * from estado where uf = ?";
            var statement = conn.prepareStatement(sql);
            //System.out.println(sql);
            statement.setString(1, uf);
            var result = statement.executeQuery();
            if(result.next()){
                System.out.printf("Id: %d Nome: %s UF: %s\n", result.getInt("id"), result.getString("nome"), result.getString("uf"));
            }
            System.out.println();
        } catch(SQLException e){
            System.err.println("Erro ao executar consulta SQL: " + e.getMessage());
        }        
    }

    public void alterar(Estado estado) {
        var sql = "update estado set nome = ?, uf = ?, where id = ?";
        try (var statement = conn.prepareStatement(sql);){
            statement.setString(1, estado.getNome());
            statement.setString(2, estado.getUf());
            statement.setLong(3, estado.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Não foi possível realizar a operação: " + e.getMessage());
        }
    }

    public void inserir(Estado estado){
        var sql = "insert into produto (nome, uf) values (?, ?)";
        try (var statement = conn.prepareStatement(sql)){
            statement.setString(1, estado.getNome());
            statement.setString(2, estado.getUf());
            
        } catch (SQLException e) {
            System.err.println("Não foi possível realizar a operação: " + e.getMessage());
        }
    }

    public void excluir(long id){
        var sql = "delete from estado where id = ?";
        try (var statement = conn.prepareStatement(sql)){
            statement.setLong(1, id);
        } catch (SQLException e) {
            System.err.println("Não foi possível realizar a operação: " + e.getMessage());
        }
    }
}
