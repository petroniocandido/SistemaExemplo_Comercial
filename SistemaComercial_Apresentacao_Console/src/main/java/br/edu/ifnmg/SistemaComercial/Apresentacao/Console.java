/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SistemaComercial.Apresentacao;

import br.edu.ifnmg.SistemaComercial.LogicaAplicacao.Pessoa;
import br.edu.ifnmg.SistemaComercial.LogicaAplicacao.Produto;
import br.edu.ifnmg.SistemaComercial.Persistencia.PessoaDAO;
import br.edu.ifnmg.SistemaComercial.Persistencia.ProdutoDAO;

/**
 *
 * @author petronio
 */
public class Console {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        PessoaDAO repope = new PessoaDAO();
        ProdutoDAO repopr = new ProdutoDAO();
        //TransacaoDAO repot = new TransacaoDAO();
        
        Produto pr = new Produto();
        
        pr.setNome("produto");
        
        repopr.Salvar(pr);
        
        Pessoa p = new Pessoa();
        
        p.setNome("Pet");
        
        repope.Salvar(p);
        
        /*
        Transacao t = new Transacao();
        
        t.setPessoa(p);
        
        TransacaoItem i = new TransacaoItem();
        
        i.setProduto(pr);
        
        t.add(i);
        
        System.out.println(repot.Salvar(t));
        */
        
    }
    
}
