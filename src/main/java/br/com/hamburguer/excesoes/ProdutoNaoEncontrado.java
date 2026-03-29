package br.com.hamburguer.excesoes;

public class ProdutoNaoEncontrado extends RuntimeException {
    public ProdutoNaoEncontrado(String mensagem) {
        super(mensagem);
    }
}
