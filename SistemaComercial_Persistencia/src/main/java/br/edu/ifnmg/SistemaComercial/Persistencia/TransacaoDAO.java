/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SistemaComercial.Persistencia;

import br.edu.ifnmg.SistemaComercial.LogicaAplicacao.Transacao;
import br.edu.ifnmg.SistemaComercial.LogicaAplicacao.TransacaoRepositorio;
import java.util.List;

/**
 *
 * @author petronio
 */
public class TransacaoDAO 
        extends DataAccessObject<Transacao>
        implements TransacaoRepositorio
{

    public TransacaoDAO() {
        super(Transacao.class);
    }
    
    @Override
    public List<Transacao> Buscar(Transacao obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
