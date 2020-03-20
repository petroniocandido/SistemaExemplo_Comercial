/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SistemaComercial.Persistencia;

import br.edu.ifnmg.SistemaComercial.LogicaAplicacao.Repositorio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author petronio
 */
public class DataAccessObject<T> implements Repositorio<T> {
    
    // Tipo da Entidade
    private Class tipo;
    
    // Gerenciador de Entidades
    private EntityManager manager;
    
    public DataAccessObject(Class tipo){
        var factory = Persistence.createEntityManagerFactory("UP");
        this.manager = factory.createEntityManager();
        this.tipo = tipo;
    }

    @Override
    public boolean Salvar(T obj) {
        // Pega uma transação com o manager
        EntityTransaction transacao = this.manager.getTransaction();
        try {
            // Iniciar a transação
            transacao.begin();
            
            // Persistir o objeto
            obj = this.manager.merge(obj);
            
            // Confirma a transação
            transacao.commit();
            
            return true;
            
        } catch(Exception ex){
            
            // Cancela a transação
            transacao.rollback();
            
            return false;
        }
    }

    @Override
    public boolean Apagar(T obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T Abrir(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> Buscar(T filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
