package br.com.hamburguer.dto;


import br.com.hamburguer.entidades.Pedido;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ProdutoDTO {
    private Long id;
    @NotBlank(message = "não pode estar em branco!")
    private String nome;
    @NotBlank(message = "não pode estar em branco!")
    private String descricao;
    @NotNull(message = "O preço não pode ser nulo")
    @Positive(message = "O preço deve ser maior que zero")
    @Digits(integer = 8, fraction = 2, message = "O preço deve ter no máximo 8 dígitos e 2 casas decimais")
    private BigDecimal preco;
    @NotBlank(message = "não pode estar em branco!")
    private String img;
    private List<Pedido> pedidos = new ArrayList<>();

}
