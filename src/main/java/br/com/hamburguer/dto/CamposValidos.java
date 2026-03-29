package br.com.hamburguer.dto;

import org.springframework.validation.FieldError;

public record CamposValidos(String campo, String mensagem) {
    public CamposValidos(FieldError erros){
        this(erros.getField(),erros.getDefaultMessage());
    }
}
