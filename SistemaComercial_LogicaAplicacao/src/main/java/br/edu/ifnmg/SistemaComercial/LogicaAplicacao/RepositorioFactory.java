/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SistemaComercial.LogicaAplicacao;

import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author petronio
 */
public class RepositorioFactory {
    
    private static Properties propriedades = new Properties();
    
    private static UsuarioRepositorio usuario;
    private static PessoaFisicaRepositorio pessoafisica;
    private static PessoaJuridicaRepositorio pessoajuridica;
    private static ProdutoRepositorio produto;
    private static TransacaoRepositorio transacao;
    
    static {
        FileReader leitorArquivo = null;
        
        try {
            
            File arquivoPropriedades = new File("config.properties");
            leitorArquivo = new FileReader(arquivoPropriedades);    
            propriedades.load(leitorArquivo);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Console.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Console.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                leitorArquivo.close();
            } catch (IOException ex) {
                Logger.getLogger(Console.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private static Object getInstancia(String nomeclasse){
        try {
            Class classe = Class.forName(nomeclasse);
            Object instancia = classe.getDeclaredConstructor().newInstance();
            
            return instancia;
            
        } catch(ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex){
            Logger.getLogger(Console.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static UsuarioRepositorio getUsuarioRepositorio() {
        if(usuario == null){
            String nomeclasse = propriedades.getProperty("UsuarioRepositorio");
            usuario = (UsuarioRepositorio) getInstancia(nomeclasse);
        }
        return usuario;
    }
    
    public static PessoaFisicaRepositorio getPessoaFisicaRepositorio() {
        if(pessoafisica == null){
            String nomeclasse = propriedades.getProperty("PessoaFisicaRepositorio");
            pessoafisica = (PessoaFisicaRepositorio) getInstancia(nomeclasse);
        }
        return pessoafisica;
    }
    
    public static PessoaJuridicaRepositorio getPessoaJuridicaRepositorio() {
        if(pessoajuridica == null){
            String nomeclasse = propriedades.getProperty("PessoaJuridicaRepositorio");
            pessoajuridica = (PessoaJuridicaRepositorio) getInstancia(nomeclasse);
        }
        return pessoajuridica;
    }
    
    public static ProdutoRepositorio getProdutoRepositorio() {
        if(produto == null){
            String nomeclasse = propriedades.getProperty("ProdutoRepositorio");
            produto = (ProdutoRepositorio) getInstancia(nomeclasse);
        }
        return produto;
    }
    
    public static TransacaoRepositorio getTransacaoRepositorio() {
        if(transacao == null){
            String nomeclasse = propriedades.getProperty("TransacaoRepositorio");
            transacao = (TransacaoRepositorio) getInstancia(nomeclasse);
        }
        return transacao;
    }
    
}
