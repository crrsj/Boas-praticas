package br.com.hamburguer.servico;

import br.com.hamburguer.dto.PedidoDTO;
import br.com.hamburguer.entidades.Pedido;
import br.com.hamburguer.excesoes.PedidoNaoEncontrado;
import br.com.hamburguer.excesoes.ProdutoNaoEncontrado;
import br.com.hamburguer.repositorios.PedidoRepository;
import br.com.hamburguer.repositorios.ProdutoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoServico {

    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public PedidoDTO salvarPedido(Long produtoId, PedidoDTO pedidoDTO){
        var produto = produtoRepository.findById(produtoId)
                .orElseThrow(()->new ProdutoNaoEncontrado("Produto não encontrado."));
        var pedido = modelMapper.map(pedidoDTO, Pedido.class);
        pedido.setProduto(produto);
        pedido.calcularTotais();
        var novoPedido = pedidoRepository.save(pedido);
     return modelMapper.map(novoPedido, PedidoDTO.class);

    }

    private Pedido buscarPedidoOuFalhar(Long id){
        return pedidoRepository.findById(id)
                .orElseThrow(()->new PedidoNaoEncontrado("Pedido não encontrado."));
    }

    public PedidoDTO buscarPedidoPorId(Long id) {
        var pedido = buscarPedidoOuFalhar(id);
        return modelMapper.map(pedido, PedidoDTO.class);
    }

    public List<PedidoDTO>listarPedidos(){
      return pedidoRepository.findAll().stream()
              .map(pedido -> modelMapper.map(pedido, PedidoDTO.class)).toList();
    }

    @Transactional
    public PedidoDTO atualizarPedido(Long id, PedidoDTO pedidoDTO){
       var pedido = buscarPedidoOuFalhar(id);
       modelMapper.map(pedidoDTO,pedido);
       pedido.setId(id);
       pedido.calcularTotais();
       var pedidoAtual = pedidoRepository.save(pedido);
       return modelMapper.map(pedidoAtual,PedidoDTO.class);
    }

    @Transactional
    public void excluirPedido(Long id){
        var pedido = buscarPedidoOuFalhar(id);
                pedidoRepository.delete(pedido);
    }

    @Transactional
    public void  cancelarPedido(Long id){
        var pedido = buscarPedidoOuFalhar(id);
        pedido.cancelarPedido();
        pedidoRepository.save(pedido);

    }

    @Transactional
    public void ativarPedido(Long id){
        var pedido = buscarPedidoOuFalhar(id);
        pedido.ativarPedido();
        pedidoRepository.save(pedido);
    }
}
