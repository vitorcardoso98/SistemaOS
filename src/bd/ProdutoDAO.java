/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Produto;

/**
 *
 * @author JOÃO VITOR
 */
public class ProdutoDAO {

    private BD bd = new BD();
    private final String TABELA = "produtos";

    public void salvar(Produto produto) throws SQLException {
        String COLUNAS = "nome, marca, numeroSerie, descricao, quantidade, preco";
        String VALUES = "'" + produto.getNome() + "',"
                + "'" + produto.getMarca() + "',"
                + "'" + produto.getNumeroSerie() + "',"
                + "'" + produto.getDescricao() + "',"
                + "'" + produto.getQuantidade() + "',"
                + "'" + produto.getPreco() + "'";

        String sql = "INSERT INTO " + TABELA + "(" + COLUNAS + ") VALUES (" + VALUES + ")";
        bd.inserir(sql);
        bd.fecharConexao();
    }

    public ArrayList<Produto> listarProdutos() {
        ArrayList<Produto> produtos = new ArrayList<>();
        try {
            ResultSet rs = bd.consultar("SELECT * FROM produtos");
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setCodigo(rs.getInt("codigo"));
                produto.setNome(rs.getString("nome"));
                produto.setMarca(rs.getString("marca"));
                produto.setNumeroSerie(rs.getString("numeroSerie"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setPreco(rs.getDouble("preco"));
                produtos.add(produto);
            }
        } catch (SQLException ex) {

        }
        //bd.fecharConexao();
        return produtos;
    }

    public Produto consultaPorProduto(int codigo) throws SQLException {
        String WHERE = "codigo = "+codigo;
        ResultSet rs = bd.consultar("*", TABELA, WHERE);
        Produto produto = new Produto();
        if (rs.next()) {
            produto.setCodigo(rs.getInt("codigo"));
            produto.setNome(rs.getString("nome"));
            produto.setMarca(rs.getString("marca"));
            produto.setNumeroSerie(rs.getString("numeroSerie"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setQuantidade(rs.getInt("quantidade"));
            produto.setPreco(rs.getDouble("preco"));
        }
        return produto;
    }

    public void excluir(Produto produto) throws SQLException {
        String WHERE = String.valueOf(produto.getCodigo());
        String sql = "DELETE FROM " + TABELA + " WHERE codigo = " + WHERE;
        bd.excluir(sql);
    }
    
    public void editarProduto(Produto produto) throws SQLException {
        String preco = String.valueOf(produto.getPreco());
        String quantidade = String.valueOf(produto.getQuantidade());
        String SET = "nome= '"+ produto.getNome() +"',"
                + "marca= '"+ produto.getMarca() +"',"
                + "preco= '"+ preco +"',"
                + "quantidade= '"+ quantidade +"',"
                + "descricao= '"+produto.getDescricao()+"',"
                + "numeroSerie= '"+produto.getNumeroSerie()+"'";
        String WHERE = String.valueOf(produto.getCodigo());
        String sql = "UPDATE " + TABELA + " SET " + SET + " WHERE codigo = " + WHERE;
        bd.atualizar(sql);
    }
}
