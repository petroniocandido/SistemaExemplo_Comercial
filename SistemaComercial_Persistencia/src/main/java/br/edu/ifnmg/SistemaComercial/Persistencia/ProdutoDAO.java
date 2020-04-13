/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SistemaComercial.Persistencia;

import br.edu.ifnmg.SistemaComercial.LogicaAplicacao.Produto;
import br.edu.ifnmg.SistemaComercial.LogicaAplicacao.ProdutoRepositorio;
import java.util.List;

/**
 *
 * @author petronio
 */
public class ProdutoDAO
        extends DataAccessObject<Produto>
        implements ProdutoRepositorio
{

    public ProdutoDAO() {
        super(Produto.class);
    }
    
    

    @Override
    public List<Produto> Buscar(Produto obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
