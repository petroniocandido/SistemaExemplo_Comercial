/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SistemaComercial.Persistencia;

import br.edu.ifnmg.SistemaComercial.LogicaAplicacao.PessoaFisica;
import br.edu.ifnmg.SistemaComercial.LogicaAplicacao.PessoaFisicaRepositorio;
import java.util.Hashtable;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author petronio
 */
public class PessoaFisicaDAO 
        extends DataAccessObject<PessoaFisica>
        implements PessoaFisicaRepositorio
{

    public PessoaFisicaDAO() {
        super(PessoaFisica.class);
    }
    
    @Override
    public List<PessoaFisica> Buscar(PessoaFisica obj) {
        String jpql = "select pf from PessoaFisica pf";
        String filtros = "";
        Hashtable<String, Object> parametros = new Hashtable<>();
        
        if(obj != null){
        
            if(obj.getNome().length() > 0){
                filtros += "pf.nome like :nome";
                parametros.put("nome", obj.getNome() + "%");
            }

            if(obj.getGenero() != null){
                if(filtros.length() > 0) filtros += " and ";
                filtros += "pf.genero = :genero";
                parametros.put("genero", obj.getGenero());
            }

            if(obj.getRg()!= null){
                if(filtros.length() > 0) filtros += " and ";
                filtros += "pf.rg like :rg";
                parametros.put("rg", obj.getRg() + "%");
            }
        
        }
        
        if(filtros.length() > 0)
            jpql = jpql + " where " + filtros;
        
        Query consulta = this.manager.createQuery(jpql);
        
        for(String chave : parametros.keySet())
            consulta.setParameter(chave, parametros.get(chave));
        
        return consulta.getResultList();
    }

    @Override
    public PessoaFisica AbrirPorCPF(String cpf) {
        Query consulta = this.manager.createQuery("select pf from PessoaFisica pf where pf.cpf =:parametro");
        consulta.setParameter("parametro", cpf);
        return (PessoaFisica) consulta.getSingleResult();
    }
    
}
