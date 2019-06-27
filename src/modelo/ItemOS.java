/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author JOÃO VITOR
 */
public class ItemOS {

    private Produto produto;
    private OrdemServico os;

    /**
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * @return the os
     */
    public OrdemServico getOs() {
        return os;
    }

    /**
     * @param os the os to set
     */
    public void setOs(OrdemServico os) {
        this.os = os;
    }   
}