package br.com.bancodigital.api.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Classe do Banco
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Banco {
    private String nome;

    public Banco(String nome) {
        this.nome = nome;
    }
}
