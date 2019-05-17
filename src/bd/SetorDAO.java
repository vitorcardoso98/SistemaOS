/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Setor;

/**
 *
 * @author JOÃO VITOR
 */
public class SetorDAO {

    private BD bd = new BD();
    private final String TABELA = "setor";
    
    public void salvar(Setor setor) throws SQLException{
        String COLUNAS = "nome, endereco, telefone, responsavel";
        String VALUES = "'" + setor.getNome() + "',"
                + "'" + setor.getEndereco() + "',"
                + "'" + setor.getTelefone() + "',"
                + "'" +  setor.getResponsavel() + "'";
            
        String sql = "INSERT INTO " + TABELA + "(" + COLUNAS + ") VALUES (" + VALUES + ")";
        bd.inserir(sql);
        bd.fecharConexao();
    }
    
    public ArrayList<Setor> listarSetores() {
        ArrayList<Setor> setores = new ArrayList<>();
        try {
            ResultSet rs = bd.consultar("SELECT * FROM setor");
            while (rs.next()) {
                Setor setor = new Setor();
                setor.setIdSetor(rs.getInt("idSetor"));
                setor.setNome(rs.getString("nome"));
                setor.setEndereco(rs.getString("endereco"));
                setor.setTelefone(rs.getString("telefone"));
                setor.setResponsavel(rs.getString("responsavel"));
                setores.add(setor);
            }
        } catch (SQLException ex) {

        }
        //bd.fecharConexao();
        return setores;
    }
    
    public Setor consultaPorSetor(int idSetor) throws SQLException {
        String WHERE = "idSetor = "+idSetor;
        ResultSet rs = bd.consultar("*", TABELA, WHERE);
        Setor setor = new Setor();
        if (rs.next()) {
            setor.setIdSetor(rs.getInt("idSetor"));
            setor.setNome(rs.getString("nome"));
            setor.setResponsavel(rs.getString("responsavel"));
            setor.setEndereco(rs.getString("endereco"));
            setor.setTelefone(rs.getString("telefone"));
        }
        return setor;
    }
    
    public void excluir(Setor setor) throws SQLException {
        String WHERE = String.valueOf(setor.getIdSetor());
        String sql = "DELETE FROM " + TABELA + " WHERE idSetor = " + WHERE;
        bd.excluir(sql);
    }
    
    public void editarSetor(Setor setor) throws SQLException {
        String SET = "nome= '"+ setor.getNome() +"',"
                + "endereco= '"+ setor.getEndereco() +"',"
                + "telefone= '"+ setor.getTelefone() +"',"
                + "responsavel= '"+ setor.getResponsavel() +"'";
        String WHERE = String.valueOf(setor.getIdSetor());
        String sql = "UPDATE " + TABELA + " SET " + SET + " WHERE idSetor = " + WHERE;
        bd.atualizar(sql);
    }
    
}
