package br.com.ccs.ejpa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Produto {

    @Id
    private long id;

    private String nome;

    private String descricao;

    private BigDecimal preco;
}
