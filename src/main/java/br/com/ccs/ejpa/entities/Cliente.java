package br.com.ccs.ejpa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
public class Cliente {
    @Id
    private long id;
    private String nome;
    private SexoCliente sexo;

}
