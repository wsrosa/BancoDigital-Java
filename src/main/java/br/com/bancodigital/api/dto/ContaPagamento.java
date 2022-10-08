package br.com.bancodigital.api.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ContaPoupanca extends Conta {
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta-Poupança ===");
        super.imprimirInfoComum();
    }
}
