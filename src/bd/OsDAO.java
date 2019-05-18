package bd;

import java.sql.Date;
import java.sql.SQLException;
import modelo.OrdemServico;

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
}
