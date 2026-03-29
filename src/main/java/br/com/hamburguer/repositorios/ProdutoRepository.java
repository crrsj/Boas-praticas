package br.com.hamburguer.repositorios;

import br.com.hamburguer.entidades.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
}
