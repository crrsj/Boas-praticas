package br.com.hamburguer.entidades;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "produtos")
@Getter
@Setter
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private Double preco;
    private String img;
    @OneToMany(mappedBy = "produto",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnoreProperties({"produto","pedidos"})
    private List<Pedido>pedidos = new ArrayList<>();
}
