/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SistemaComercial.LogicaAplicacao;

/**
 *
 * @author petronio
 */
public interface PessoaFisicaRepositorio extends Repositorio<PessoaFisica> {
    public PessoaFisica AbrirPorCPF(String cpf);
}
