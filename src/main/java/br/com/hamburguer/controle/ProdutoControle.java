package br.com.hamburguer.controle;


import br.com.hamburguer.dto.ProdutoDTO;
import br.com.hamburguer.repositorios.ProdutoRepository;
import br.com.hamburguer.servico.ProdutoServico;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoControle {

    private final ProdutoServico produtoServico;

    @PostMapping
    public ResponseEntity<ProdutoDTO>salvarProdutos(@RequestBody @Valid ProdutoDTO produtoDTO){
        var produto = produtoServico.salvarProduto(produtoDTO);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(produto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO>buscarProdutoPorId(@PathVariable Long id){
        return ResponseEntity.ok(produtoServico.buscarProdutoPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>>listarProdutos(){
        return ResponseEntity.ok(produtoServico.listarProdutos());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProdutoDTO>atualizarProduto(@PathVariable Long id, @RequestBody @Valid ProdutoDTO produtoDTO){
        return ResponseEntity.ok(produtoServico.atualizarProduto(id, produtoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>excluirProduto(@PathVariable Long id){
        produtoServico.excluirProduto(id);
        return ResponseEntity.noContent().build();
    }
}
