/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SistemaComercial.Persistencia;

import br.edu.ifnmg.SistemaComercial.LogicaAplicacao.Usuario;
import br.edu.ifnmg.SistemaComercial.LogicaAplicacao.UsuarioRepositorio;

/**
 *
 * @author petronio
 */
public class UsuarioDAO extends DataAccessObject<Usuario> implements UsuarioRepositorio {

    public UsuarioDAO(){
        super(Usuario.class);
    }
    
    @Override
    public boolean login(String usuario, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
