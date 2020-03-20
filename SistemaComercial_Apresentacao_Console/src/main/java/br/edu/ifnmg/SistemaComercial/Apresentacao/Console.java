/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SistemaComercial.Apresentacao;

import br.edu.ifnmg.SistemaComercial.LogicaAplicacao.Repositorios;
import br.edu.ifnmg.SistemaComercial.LogicaAplicacao.Usuario;
import br.edu.ifnmg.SistemaComercial.LogicaAplicacao.UsuarioRepositorio;

/**
 *
 * @author petronio
 */
public class Console {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        UsuarioRepositorio repo_usuarios  = Repositorios.getUsuarios();
        
        Usuario pc = new Usuario();
        
        pc.setLogin("petronio");
        pc.setSenha("123");
        
        if(repo_usuarios.Salvar(pc)){
            System.out.print("Funcionou");
        } else System.out.print("Deu erro!");
        
    }
    
}
