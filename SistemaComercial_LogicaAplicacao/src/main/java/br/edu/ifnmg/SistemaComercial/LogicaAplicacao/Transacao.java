/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SistemaComercial.LogicaAplicacao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author petronio
 */
@Entity
@Table(name = "transacoes")
public class Transacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoaid", nullable = false)
    private Pessoa pessoa;
    
    @Column(precision = 8, scale = 2)
    private BigDecimal valorTotal;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date datacriacao;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,
            mappedBy = "transacaoid")
    private List<TransacaoItem> itens;

    public Transacao() {
        this.id = 0L;
        this.pessoa = null;
        this.valorTotal = new BigDecimal("0.00");
        this.datacriacao = new Date();
        this.itens = new ArrayList<>();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getData() {
        return datacriacao;
    }

    public void setData(Date data) {
        this.datacriacao = data;
    }

    public List<TransacaoItem> getItens() {
        return itens;
    }

    public void setItens(List<TransacaoItem> itens) {
        this.itens = itens;
    }
    
    
    public void add(TransacaoItem item){
        this.itens.add(item);
        this.valorTotal = this.valorTotal.add(item.getValorUnitario());
    }
    
    public void remove(TransacaoItem item){
        if(this.itens.contains(item)){
            this.itens.remove(item);
            this.valorTotal = this.valorTotal.subtract(item.getValorUnitario());
        }
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transacao)) {
            return false;
        }
        Transacao other = (Transacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifnmg.SistemaComercial.LogicaAplicacao.Transacao[ id=" + id + " ]";
    }
    
}
