/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SistemaComercial.Apresentacao;

import br.edu.ifnmg.SistemaComercial.LogicaAplicacao.Genero;
import br.edu.ifnmg.SistemaComercial.LogicaAplicacao.PessoaFisica;
import br.edu.ifnmg.SistemaComercial.LogicaAplicacao.PessoaFisicaRepositorio;
import br.edu.ifnmg.SistemaComercial.LogicaAplicacao.PessoaJuridica;
import br.edu.ifnmg.SistemaComercial.LogicaAplicacao.PessoaJuridicaRepositorio;
import br.edu.ifnmg.SistemaComercial.LogicaAplicacao.Produto;
import br.edu.ifnmg.SistemaComercial.LogicaAplicacao.ProdutoRepositorio;
import br.edu.ifnmg.SistemaComercial.LogicaAplicacao.RepositorioFactory;
import br.edu.ifnmg.SistemaComercial.LogicaAplicacao.Transacao;
import br.edu.ifnmg.SistemaComercial.LogicaAplicacao.TransacaoItem;
import br.edu.ifnmg.SistemaComercial.LogicaAplicacao.TransacaoRepositorio;
import br.edu.ifnmg.SistemaComercial.LogicaAplicacao.TransacaoTipo;
import br.edu.ifnmg.SistemaComercial.LogicaAplicacao.Usuario;
import br.edu.ifnmg.SistemaComercial.LogicaAplicacao.UsuarioRepositorio;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author petronio
 */
public class Console {

    /**
     * @param args the command line arguments
     */
    
    public static void criarBase(){
        UsuarioRepositorio repou = RepositorioFactory.getUsuarioRepositorio();
        repou.Salvar(new Usuario("caixa", "123"));
        repou.Salvar(new Usuario("gerente", "123"));
        
        PessoaFisicaRepositorio repof = RepositorioFactory.getPessoaFisicaRepositorio();
        repof.Salvar(new PessoaFisica("João","11111111111", "10123456",Genero.Masculino));
        repof.Salvar(new PessoaFisica("Maria","11111111112", "10123457",Genero.Feminino));
        repof.Salvar(new PessoaFisica("José","11111111113", "10123458",Genero.Masculino));
        repof.Salvar(new PessoaFisica("Ana","11111111114", "10123459",Genero.Feminino));
        
        PessoaJuridicaRepositorio repoj = RepositorioFactory.getPessoaJuridicaRepositorio();
        repoj.Salvar(new PessoaJuridica("Padaria", "111111111", "00001111000"));
        repoj.Salvar(new PessoaJuridica("Confeitaria", "111111112", "00001111001"));
        repoj.Salvar(new PessoaJuridica("Mercearia", "111111113", "00001111002"));
        
        ProdutoRepositorio repop = RepositorioFactory.getProdutoRepositorio();
        repop.Salvar(new Produto("Farinha de Trigo", "5.00", 10));
        repop.Salvar(new Produto("Açúcar", "3.50", 10));
        repop.Salvar(new Produto("Sal", "1.50", 10));
        repop.Salvar(new Produto("Leite", "3.50", 10));
        
        var user1 = repou.Abrir(1L);
        var user2 = repou.Abrir(2L);
        
        var pf1 = repof.Abrir(1L);
        var pf2 = repof.Abrir(2L);
        
        var pj1 = repoj.Abrir(5L);
        var pj2 = repoj.Abrir(6L);
        
        var prod1 = repop.Abrir(1L);
        var prod2 = repop.Abrir(2L);
        var prod3 = repop.Abrir(3L);
        var prod4 = repop.Abrir(4L);
        
        TransacaoRepositorio repot = RepositorioFactory.getTransacaoRepositorio();
        
        Transacao t1 = new Transacao(pf1, TransacaoTipo.Venda, user1);
        t1.add(new TransacaoItem(prod1, 1));
        t1.add(new TransacaoItem(prod3, 1));
        
        repot.Salvar(t1);
        
        Transacao t2 = new Transacao(pf2, TransacaoTipo.Venda, user2);
        t2.add(new TransacaoItem(prod2, 1));
        t2.add(new TransacaoItem(prod4, 1));
        
        repot.Salvar(t2);
        
        Transacao t3 = new Transacao(pj1, TransacaoTipo.Compra, user1);
        t3.add(new TransacaoItem(prod1, 4));
        t3.add(new TransacaoItem(prod3, 5));
        
        repot.Salvar(t3);
        
        Transacao t4 = new Transacao(pj2, TransacaoTipo.Compra, user2);
        t4.add(new TransacaoItem(prod2, 10));
        t4.add(new TransacaoItem(prod4, 10));
        
        repot.Salvar(t4);
    }
    
    public static void main(String[] args) {
        File arquivoPropriedades = new File("Relatorios/teste.txt");
        FileReader leitorArquivo;
        try { 
            leitorArquivo = new FileReader(arquivoPropriedades);
            System.out.println(leitorArquivo.toString());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Console.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //String.class.getResourceAsStream("newfile")

        //criarBase();
        /*
        UsuarioRepositorio repo = RepositorioFactory.getUsuarioRepositorio();
        
        Usuario uw = new Usuario();
        uw.setLogin("caixa");
        uw.setSenha("123");
        
        repo.Salvar(uw);
        */
        //System.out.println(repo.autenticar("caixa", "1234"));
        
        /*
        for(Usuario u : repo.Buscar(uw))
            System.out.println(u);
       */
    
    }
    
}
