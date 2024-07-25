/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.primeiroProjeto.modelo.dominio;

import java.math.BigDecimal;

/**
 *
 * @author Leonardo Wolff
 */
public class VendaItem {
    private RegistroVenda registroVenda;
    private Produto produto;
    private Integer quantidade;
    private BigDecimal total;
    private BigDecimal descontoProduto;

    public VendaItem() {
    }

    public VendaItem(RegistroVenda registroVenda, Produto produto, Integer quantidade, BigDecimal total, BigDecimal descontoProduto) {
        this.registroVenda = registroVenda;
        this.produto = produto;
        this.quantidade = quantidade;
        this.total = total;
        this.descontoProduto = descontoProduto;
    }

    public RegistroVenda getRegistroVenda() {
        return registroVenda;
    }

    public void setRegistroVenda(RegistroVenda registroVenda) {
        this.registroVenda = registroVenda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getDescontoProduto() {
        return descontoProduto;
    }

    public void setDescontoProduto(BigDecimal descontoProduto) {
        this.descontoProduto = descontoProduto;
    }
    
}
