package br.com.ccs.ejpa.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "cliente")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
public class Cliente {
    @Id
    private long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private SexoCliente sexo;
}
