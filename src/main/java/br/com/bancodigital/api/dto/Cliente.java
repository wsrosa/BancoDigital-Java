package br.com.bancodigital.api.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Cliente {
    private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }
}
