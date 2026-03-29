package br.com.hamburguer.excesoes;

import br.com.hamburguer.dto.CamposValidos;
import br.com.hamburguer.dto.MensagemDeErro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExcessoesGlobais {

    @ExceptionHandler(ProdutoNaoEncontrado.class)
    public ResponseEntity<MensagemDeErro> produtoNaoEncontrado() {
        var erros = new MensagemDeErro(HttpStatus.NOT_FOUND, "Produto não encontrado.");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erros);
    }


    @ExceptionHandler(PedidoNaoEncontrado.class)
    public ResponseEntity<MensagemDeErro> pedidoNaoEncontrado() {
        var erros = new MensagemDeErro(HttpStatus.NOT_FOUND, "Pedido não encontrado.");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erros);

    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?>validandoCampos(MethodArgumentNotValidException ex){
        var erros = ex.getFieldErrors();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros.stream().map(CamposValidos::new).toList());
    }
}