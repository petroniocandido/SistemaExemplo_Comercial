/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SistemaComercial.Persistencia;

import br.edu.ifnmg.SistemaComercial.LogicaAplicacao.Usuario;
import br.edu.ifnmg.SistemaComercial.LogicaAplicacao.UsuarioRepositorio;
import java.util.List;

/**
 *
 * @author petronio
 */
public class UsuarioDAOFake 
        extends DataAccessObject<Usuario> 
        implements UsuarioRepositorio
{

    public UsuarioDAOFake() {
        super(Usuario.class);
    }
    
    @Override
    public boolean Salvar(Usuario u){
        System.out.println(u.getSenha());
        return true;
    }

    @Override
    public List<Usuario> Buscar(Usuario obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean autenticar(String login, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
