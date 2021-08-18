package br.edu.ifnmg.SistemaComercial.LogicaAplicacao;

import br.edu.ifnmg.SistemaComercial.LogicaAplicacao.Pessoa;
import br.edu.ifnmg.SistemaComercial.LogicaAplicacao.TransacaoItem;
import br.edu.ifnmg.SistemaComercial.LogicaAplicacao.TransacaoTipo;
import br.edu.ifnmg.SistemaComercial.LogicaAplicacao.Usuario;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-18T14:38:16")
@StaticMetamodel(Transacao.class)
public class Transacao_ { 

    public static volatile ListAttribute<Transacao, TransacaoItem> itens;
    public static volatile SingularAttribute<Transacao, TransacaoTipo> tipo;
    public static volatile SingularAttribute<Transacao, Pessoa> pessoa;
    public static volatile SingularAttribute<Transacao, BigDecimal> valorTotal;
    public static volatile SingularAttribute<Transacao, Usuario> usuario;
    public static volatile SingularAttribute<Transacao, Long> id;
    public static volatile SingularAttribute<Transacao, Date> criacao;
    public static volatile SingularAttribute<Transacao, Long> version;

}