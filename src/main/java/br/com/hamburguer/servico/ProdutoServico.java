package br.com.hamburguer.servico;

import br.com.hamburguer.dto.ProdutoDTO;
import br.com.hamburguer.entidades.Produto;
import br.com.hamburguer.excesoes.ProdutoNaoEncontrado;
import br.com.hamburguer.repositorios.ProdutoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoServico {

    private final ProdutoRepository produtoRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public ProdutoDTO salvarProduto(ProdutoDTO produtoDTO){
    var produto = modelMapper.map(produtoDTO, Produto.class);
    var novoProduto = produtoRepository.save(produto);
    return modelMapper.map(novoProduto, ProdutoDTO.class);

    }

    private Produto buscarProdutoOuFalhar(Long id){
        return produtoRepository.findById(id).orElseThrow(()->new ProdutoNaoEncontrado("Produto não encontrado com o id: " + id));
    }

    public List<ProdutoDTO>listarProdutos(){
        return produtoRepository.findAll().stream()
                .map(produto -> modelMapper.map(produto, ProdutoDTO.class)).toList();

    }

    public ProdutoDTO buscarProdutoPorId(Long id) {
        var produto = buscarProdutoOuFalhar(id);
        return modelMapper.map(produto, ProdutoDTO.class);
    }

    @Transactional
    public ProdutoDTO atualizarProduto(Long id, ProdutoDTO produtoDTO){
        var produto = buscarProdutoOuFalhar(id);
        modelMapper.map(produtoDTO,produto);
        produto.setId(id);
        var prodAtualizado = produtoRepository.save(produto);
        return modelMapper.map(prodAtualizado, ProdutoDTO.class);
    }

    @Transactional
    public void excluirProduto(Long id){
        var produto = buscarProdutoOuFalhar(id);
        produtoRepository.delete(produto);
    }


}
