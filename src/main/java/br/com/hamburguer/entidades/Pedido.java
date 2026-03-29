package br.com.hamburguer.entidades;


import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "pedidos")
@Getter
@Setter
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer qtd;
    private BigDecimal subtotal;
    private BigDecimal total;
    private boolean ativo;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public void calcularTotais() {
        this.subtotal = BigDecimal.ZERO;
        this.total = BigDecimal.ZERO;
        if (this.produto != null && this.produto.getPreco() != null && this.qtd != null) {
            BigDecimal precoUnitario = BigDecimal.valueOf(this.produto.getPreco());
            this.subtotal = precoUnitario.multiply(BigDecimal.valueOf(this.qtd));
            this.total = this.subtotal;
        }
    }

    public void cancelarPedido(){
        this.ativo = false;
    }

    public void ativarPedido(){
        this.ativo = true;
    }
}