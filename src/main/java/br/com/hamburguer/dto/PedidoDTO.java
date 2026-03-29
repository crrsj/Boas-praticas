package br.com.hamburguer.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PedidoDTO {

    private Long id;
    private Integer qtd;
    private BigDecimal subtotal;
    private BigDecimal total;
    private boolean ativo;

}
