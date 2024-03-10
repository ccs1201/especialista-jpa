package br.com.ccs.ejpa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue
    private long id;

    private String nome;

    @CreationTimestamp
    private LocalDateTime dataCadastro;
}
