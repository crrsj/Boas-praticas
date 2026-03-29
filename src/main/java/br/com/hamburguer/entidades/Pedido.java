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
    @NotNull(message = "O preço não pode ser nulo")
    @Positive(message = "O preço deve ser maior que zero")
    @Digits(integer = 8, fraction = 2, message = "O preço deve ter no máximo 8 dígitos e 2 casas decimais")
    private BigDecimal subtotal;
    @NotNull(message = "O preço não pode ser nulo")
    @Positive(message = "O preço deve ser maior que zero")
    @Digits(integer = 8, fraction = 2, message = "O preço deve ter no máximo 8 dígitos e 2 casas decimais")
    private BigDecimal total;
    private boolean ativo;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public void calcularTotais() {
        if (this.produto != null && this.qtd != null) {
            BigDecimal preco = BigDecimal.valueOf(this.produto.getPreco());
            this.subtotal = preco.multiply(BigDecimal.valueOf(this.qtd));
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