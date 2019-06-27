/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author JOÃO VITOR
 */
public class BD {

    private Statement stmt;
    private ResultSet rs;
    Connection conexao = new Conexao().getConnection();

    public ResultSet executar(String sql, int tipo) throws SQLException {
        
        stmt = conexao.createStatement();
        rs = null;
        if (tipo == 1) {
            stmt.executeUpdate(sql);
        } else {
            rs = stmt.executeQuery(sql);
        }
        return rs;
    }
    
    private ResultSet executar(String sql, int tipo, String op) throws SQLException {
        stmt = conexao.createStatement();
        stmt = conexao.createStatement();
        rs = null;
        
        if (op.equals("os")) {
           stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
           rs = stmt.getGeneratedKeys();
        } 
        return rs;
    }
    
    public void inserir(String sql) throws SQLException{
        System.out.println(sql);
        executar(sql, 1);
    }
    
    public ResultSet inserir(String sql, String op) throws SQLException{
        System.out.println(sql);
        executar(sql, 1, op);
        return rs;
    }
    
    public ResultSet consultar(String SQL) throws SQLException {
        executar(SQL, 0);
        return rs;
    }
    
    public ResultSet consultar(String SELECT, String FROM, String WHERE) throws SQLException {
        String tmp;
        if (WHERE.equals("")) {
            tmp = "SELECT " + SELECT + " FROM " + FROM;
        } else {
            tmp = "SELECT " + SELECT + " FROM " + FROM + " WHERE " + WHERE;
        }
        System.out.println(tmp);
        executar(tmp, 0);
        return rs;
    }
    
    public void excluir(String sql) throws SQLException{
        System.out.println(sql);
        executar(sql, 1);
    }
    
    public void atualizar(String sql) throws SQLException{
        System.out.println(sql);
        executar(sql, 1);
    }
    
    public void fecharConexao(){
        try{
           stmt.close();
           conexao.close(); 
        }catch(Exception e){
           e.printStackTrace();
        } 
    }
}
