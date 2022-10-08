package br.com.bancodigital.api.dto;

import br.com.bancodigital.enums.TiposDeContaEnum;
import lombok.EqualsAndHashCode;

/**
 * Classe da Conta-Poupança
 */
@EqualsAndHashCode(callSuper = false)
public class ContaPoupanca extends Conta {
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
        this.setTipo(TiposDeContaEnum.CONTA_POUPANCA);
    }
}
