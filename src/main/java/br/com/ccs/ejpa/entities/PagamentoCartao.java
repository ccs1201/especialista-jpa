package br.com.ccs.ejpa.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "pagamento_cartao")
public class PagamentoCartao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;
    @Column(name = "pedido_id")
    private long pedidoId;
    @Column(name = "status_pagamento")
    private StatusPagamento statusPagamento;
    @Column(name = "numero_cartao")
    private String numeroCartao;
}
