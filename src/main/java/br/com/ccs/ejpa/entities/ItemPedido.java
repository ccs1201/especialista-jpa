package br.com.ccs.ejpa.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "item_pedido")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "pedido_id")
    private long pedidoId;
    @Column(name = "produto_id")
    private long produtoId;
    private int quantidade;
    @Column(name = "preco_produto")
    private BigDecimal precoProduto;
}
