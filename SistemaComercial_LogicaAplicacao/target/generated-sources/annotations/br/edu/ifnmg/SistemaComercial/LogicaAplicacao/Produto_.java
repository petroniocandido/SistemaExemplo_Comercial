package br.edu.ifnmg.SistemaComercial.LogicaAplicacao;

import br.edu.ifnmg.SistemaComercial.LogicaAplicacao.Usuario;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-04-28T12:03:46")
@StaticMetamodel(Produto.class)
public class Produto_ { 

    public static volatile SingularAttribute<Produto, Integer> estoque;
    public static volatile SingularAttribute<Produto, String> nome;
    public static volatile SingularAttribute<Produto, Usuario> usuario;
    public static volatile SingularAttribute<Produto, Long> id;
    public static volatile SingularAttribute<Produto, Long> version;
    public static volatile SingularAttribute<Produto, BigDecimal> valorUnitario;

}