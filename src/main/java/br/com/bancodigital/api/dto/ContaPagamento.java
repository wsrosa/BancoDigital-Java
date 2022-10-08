package br.com.bancodigital.api.dto;

import br.com.bancodigital.enums.TiposDeContaEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Classe da Conta de Pagamento
 */
@EqualsAndHashCode(callSuper = false)
public class ContaPagamento extends Conta {
    public ContaPagamento(Cliente cliente) {
        super(cliente);
        this.setTipo(TiposDeContaEnum.CONTA_PAGAMENTO);
    }
}
