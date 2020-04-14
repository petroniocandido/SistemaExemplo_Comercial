/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SistemaComercial.LogicaAplicacao;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

/**
 *
 * @author petronio
 */
@Entity
@DiscriminatorValue(value = "2")
public class PessoaJuridica extends Pessoa implements Serializable {

   @Column(nullable = false)
   private String cnpj;
   
   private String inscricaoEstadual;
   
   @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   private PessoaFisica representante;
   
   @Version
   private int versao;

    public PessoaJuridica() {
        super();
        this.cnpj = "";
        this.inscricaoEstadual = "";
        this.representante = null;
        this.versao = 1;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public PessoaFisica getRepresentante() {
        return representante;
    }

    public void setRepresentante(PessoaFisica representante) {
        this.representante = representante;
    }

    public int getVersao() {
        return versao;
    }

    public void setVersao(int versao) {
        this.versao = versao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.cnpj);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PessoaJuridica other = (PessoaJuridica) obj;
        if (!Objects.equals(this.cnpj, other.cnpj)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return cnpj;
    }
   
   
    
}
