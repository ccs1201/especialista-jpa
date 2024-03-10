package br.com.ccs.ejpa.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime dataPedido;
    private LocalDateTime dataConclusao;
    @Column(name = "cliente_id")
    private long clienteId;
    @Column(name = "nota_fiscal_id")
    private long NotaFiscalId;
    @Column(name = "status_pedido_id")
    @Enumerated(EnumType.STRING)
    private StatusPedido statusPedido;
    private BigDecimal total;
    @Embedded
    private Endereco enderecoEntrega;
}
