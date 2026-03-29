package br.com.hamburguer.dto;

import br.com.hamburguer.entidades.Produto;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PedidoDTO {

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
    @NotNull(message = "Defina se o item está ativo ou inativo")
    private boolean ativo;
    private Produto produto;

}
