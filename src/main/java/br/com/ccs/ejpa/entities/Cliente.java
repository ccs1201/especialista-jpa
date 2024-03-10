package br.com.ccs.ejpa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente {
    @Id
    @EqualsAndHashCode.Include
    private long id;
    private String nome;

}
