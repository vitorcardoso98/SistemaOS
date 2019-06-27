package bd;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.ItemOS;
import modelo.OrdemServico;
import modelo.Produto;
import modelo.Setor;

/**
 *
 * @author JOÃO VITOR
 */
public class OsDAO {

    private BD bd = new BD();
    private final String TABELA = "os";
    private final String TABELA1 = "item_os";

    public void salvar(OrdemServico os) throws SQLException {
        
        int codigoOS = 0;
        
        String COLUNAS = "dataEmissao, servico, valorServico, descricao";
        String VALUES = "'" + new Date(os.getDataEmissao().getTime()) + "',"
                + "'" + os.getServico() + "',"
                + "'" + os.getValorServico() + "',"
                + "'" + os.getDescricao() + "'";
        String sql = "INSERT INTO " + TABELA + "(" + COLUNAS + ") VALUES (" + VALUES + ")";
        ResultSet rs = bd.inserir(sql, "os");
        
        if (rs.next()) {
            codigoOS = rs.getInt(1);
        }
        
        for(ItemOS item: os.getItens()){
            String COLUNAS_IOS = "idOs, idProduto";
            String VALUES_IOS = "'"+codigoOS+"',"
                    +"'"+item.getProduto().getCodigo()+"'";
            String sql1 = "INSERT INTO " + TABELA1 + "(" + COLUNAS_IOS + ") VALUES (" + VALUES_IOS + ")";
            bd.inserir(sql1);
        }
        bd.fecharConexao();
    }
    
    public ArrayList<OrdemServico> listarOrdens() {
        ArrayList<OrdemServico> ordens = new ArrayList<>();
        try {
            ResultSet rs = bd.consultar("SELECT * FROM os");
            while (rs.next()) {
                OrdemServico os = new OrdemServico();
                os.setCodigo(rs.getInt("codigo"));
                os.setDataEmissao(rs.getDate("dataEmissao"));
                os.setServico(rs.getString("servico"));
                os.setSituacao(rs.getString("situacao"));
                os.setValorServico(rs.getDouble("valorServico"));
                os.setDescricao(rs.getString("descricao"));
                //Produto produto = new Produto();
                //produto.setCodigo(rs.getInt("codigoProduto"));
                //Setor setor = new Setor();
                //setor.setIdSetor(rs.getInt("idSetor"));
                //os.setProduto(produto);
                ordens.add(os);
            }
        } catch (SQLException ex) {

        }
        //bd.fecharConexao();
        return ordens;
    }
}
