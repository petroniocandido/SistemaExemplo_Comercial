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
public abstract class DataAccessObject<T> implements Repositorio<T> {
    
    private EntityManager manager;
    private Class type;
    
    public DataAccessObject(Class type){
        var factory = Persistence.createEntityManagerFactory("UP");
        this.manager = factory.createEntityManager();
        this.type = type;
    }

    @Override
    public boolean Salvar(T obj) {
        EntityTransaction transacao = this.manager.getTransaction();
        try {
            transacao.begin();
            
            this.manager.persist(obj);
            
            transacao.commit();
            
            return true;
            
        } catch(Exception ex){
            transacao.rollback();
            
            return false;
        }
        
    }

    @Override
    public boolean Apagar(T obj) {
        EntityTransaction transacao = this.manager.getTransaction();
        try {
            transacao.begin();
            
            this.manager.remove(obj);
            
            transacao.commit();
            
            return true;
            
        } catch(Exception ex){
            transacao.rollback();
            
            return false;
        }
    }

    @Override
    public T Abrir(Long id) {
        try {
            
            T obj = (T)this.manager.find(this.type, id);
            
            return obj;
            
        } catch(Exception ex){
            return null;
        }
    }

    public abstract List<T> Buscar(T obj);
}
