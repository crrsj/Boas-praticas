package br.com.hamburguer.excesoes;

public class PedidoNaoEncontrado extends RuntimeException{
    public PedidoNaoEncontrado(String mensagem) {
        super(mensagem);
    }
}
