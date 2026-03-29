package br.com.hamburguer.controle;

import br.com.hamburguer.dto.PedidoDTO;
import br.com.hamburguer.servico.PedidoServico;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoControle {

    private final PedidoServico pedidoServico;

    @PostMapping("/{clienteId}")
    public ResponseEntity<PedidoDTO>salvarPedido(@PathVariable Long clienteId, @RequestBody @Valid PedidoDTO pedidoDTO){
        var pedido = pedidoServico.salvarPedido(clienteId, pedidoDTO);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(pedido.getId()).toUri();
        return ResponseEntity.created(uri).body(pedido);
    }

    @GetMapping
    public ResponseEntity<List<PedidoDTO>>listarPedidos(){
        return ResponseEntity.ok(pedidoServico.listarPedidos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO>buscarPedidoPorId(@PathVariable Long id){
        return ResponseEntity.ok(pedidoServico.buscarPedidoPorId(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PedidoDTO>atualizarPedido(@PathVariable Long id,@RequestBody @Valid PedidoDTO pedidoDTO){
        return ResponseEntity.ok(pedidoServico.atualizarPedido(id, pedidoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>excluirPedido(@PathVariable Long id){
        pedidoServico.excluirPedido(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/cancelar/{id}")
    public ResponseEntity<Void>cancelarPedido(@PathVariable Long id){
        pedidoServico.cancelarPedido(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/ativar/{id}")
    public ResponseEntity<Void>ativarPedido(@PathVariable Long id){
        pedidoServico.ativarPedido(id);
        return ResponseEntity.noContent().build();
    }
}
