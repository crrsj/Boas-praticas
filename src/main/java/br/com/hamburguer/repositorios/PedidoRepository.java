package br.com.hamburguer.repositorios;

import br.com.hamburguer.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {
}
