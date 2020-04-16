/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SistemaComercial.LogicaAplicacao;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 *
 * @author petronio
 */
@Entity
@Table(name = "pessoasfisicas")
@DiscriminatorValue(value = "0")
public class PessoaFisica extends Pessoa implements Serializable {
    
    @Column(length = 11, nullable=false, unique = true)
    private String cpf;
    
    private String rg;
    
    @Enumerated(EnumType.STRING)
    private Genero genero;
    
    @Version
    private long versao;

    public PessoaFisica() {
        super();
        this.setTipo(PessoaTipo.Fisica);
        this.cpf = "";
        this.rg = "";
        this.genero = Genero.Feminino;
        this.versao = 1;
    }

    public PessoaFisica(String nome, String cpf, String rg, Genero genero) {
        super();
        this.setTipo(PessoaTipo.Fisica);
        this.setNome(nome);
        this.cpf = cpf;
        this.rg = rg;
        this.genero = genero;
        this.versao = 1;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.cpf);
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
        final PessoaFisica other = (PessoaFisica) obj;
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return cpf;
    }
    
    
    
}
