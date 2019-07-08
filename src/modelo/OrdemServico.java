package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author JOÃO VITOR
 */
public class OrdemServico {

    private int codigo;
    //private Produto produto;
    private Setor setor;
    private Date dataEmissao;
    private String servico;
    private String situacao;
    private Double valorServico;
    private String descricao;
    private List<ItemOS> oss = new ArrayList<>();

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public Setor getSetor() {
        return setor;
    }

    /**
     * @param setor the setor to set
     */
    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    /**
     * @return the dataEmissao
     */
    public Date getDataEmissao() {
        return dataEmissao;
    }

    /**
     * @param dataEmissao the dataEmissao to set
     */
    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    /**
     * @return the servico
     */
    public String getServico() {
        return servico;
    }

    /**
     * @param servico the servico to set
     */
    public void setServico(String servico) {
        this.servico = servico;
    }

    /**
     * @return the situacao
     */
    public String getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    /**
     * @return the valorServico
     */
    public Double getValorServico() {
        return valorServico;
    }

    /**
     * @param valorServico the valorServico to set
     */
    public void setValorServico(Double valorServico) {
        this.valorServico = valorServico;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public void addItem(ItemOS itemOS) {
        oss.add(itemOS);
    }
    
    public List<ItemOS> getItens() {
        return oss;
    }
    
}
