package bd;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    public void salvar(OrdemServico os) throws SQLException {
        String COLUNAS = "dataEmissao, servico, valorServico, descricao, codigoProduto, idSetor";
        String VALUES = "'" + new Date(os.getDataEmissao().getTime()) + "',"
                + "'" + os.getServico() + "',"
                + "'" + os.getValorServico() + "',"
                + "'" + os.getDescricao() + "',"
                + "'" + os.getProduto().getCodigo() + "',"
                + "'" + os.getSetor().getIdSetor() + "'";
        String sql = "INSERT INTO " + TABELA + "(" + COLUNAS + ") VALUES (" + VALUES + ")";
        bd.inserir(sql);
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
                Produto produto = new Produto();
                produto.setCodigo(rs.getInt("codigoProduto"));
                Setor setor = new Setor();
                setor.setIdSetor(rs.getInt("idSetor"));
                os.setProduto(produto);
                ordens.add(os);
            }
        } catch (SQLException ex) {

        }
        //bd.fecharConexao();
        return ordens;
    }
}
