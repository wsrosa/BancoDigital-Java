package br.com.bancodigital.api.dto;

import br.com.bancodigital.enums.AgenciaPadraoConsts;
import br.com.bancodigital.enums.TiposDeContaEnum;
import br.com.bancodigital.util.UtilDigito;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Formatter;

/**
 *  Classe das Agencias Bancárias
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Agencia {

    private int numero;
    private int digito;

    private String nome;

    public Agencia() {
        this.numero = AgenciaPadraoConsts.AGENCIA_PADRAO;
        this.digito = this.calcularDigito(this.numero);
        this.nome = "Centro";
    }

    public Agencia(String nome) {
        this.numero = AgenciaPadraoConsts.AGENCIA_PADRAO;
        this.digito = this.calcularDigito(this.numero);
        this.nome = nome;
    }

    public String getNumAgencia() {
        String numAgencia = String.format("%04d-%d", numero, digito);
        return numAgencia;
    }

    @Override
    public String toString() {
        return "Agência: " + getNumAgencia() +
                (nome.isEmpty() ? "" : " - " + getNome());
    }

    private int calcularDigito(int numero) {
        return UtilDigito.calcularDigitoVerificadorMod11(String.valueOf(numero));
    }
}
