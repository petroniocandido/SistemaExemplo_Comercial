package br.edu.ifnmg.SistemaComercial.LogicaAplicacao;

import br.edu.ifnmg.SistemaComercial.LogicaAplicacao.PessoaFisica;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-28T12:03:46")
@StaticMetamodel(PessoaJuridica.class)
public class PessoaJuridica_ extends Pessoa_ {

    public static volatile SingularAttribute<PessoaJuridica, PessoaFisica> representante;
    public static volatile SingularAttribute<PessoaJuridica, String> inscricaoEstadual;
    public static volatile SingularAttribute<PessoaJuridica, String> cnpj;
    public static volatile SingularAttribute<PessoaJuridica, Integer> versao;

}