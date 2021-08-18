package br.edu.ifnmg.SistemaComercial.LogicaAplicacao;

import br.edu.ifnmg.SistemaComercial.LogicaAplicacao.Genero;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-18T14:38:16")
@StaticMetamodel(PessoaFisica.class)
public class PessoaFisica_ extends Pessoa_ {

    public static volatile SingularAttribute<PessoaFisica, String> rg;
    public static volatile SingularAttribute<PessoaFisica, Genero> genero;
    public static volatile SingularAttribute<PessoaFisica, String> cpf;
    public static volatile SingularAttribute<PessoaFisica, Long> versao;

}