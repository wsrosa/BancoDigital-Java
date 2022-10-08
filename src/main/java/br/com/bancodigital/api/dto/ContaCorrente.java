package br.com.bancodigital.api.dto;

import br.com.bancodigital.enums.TiposDeContaEnum;
import lombok.EqualsAndHashCode;

/**
 * Classe da Conta-Corrente
 */
@EqualsAndHashCode(callSuper = false)
public class ContaCorrente extends Conta {
    public ContaCorrente(Cliente cliente) {
        super(cliente);
        this.setTipo(TiposDeContaEnum.CONTA_CORRENTE);
    }
}
