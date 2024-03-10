package br.com.ccs.ejpa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "produto")
public class Produto {

    @Id
    @EqualsAndHashCode.Include
    private long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
}
