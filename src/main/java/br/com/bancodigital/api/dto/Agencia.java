package br.com.bancodigital.api.dto;

import br.com.bancodigital.enums.AgenciaPadraoConsts;
import br.com.bancodigital.enums.TiposDeContaEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Formatter;

/**
 *  Classe Abstrata para Contas Bancárias
 */
@Data
@EqualsAndHashCode(callSuper = false)
public abstract class Conta implements IConta {

    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected int digito;
    protected Cliente cliente;

    protected TiposDeContaEnum tipo;
    protected double saldo;

    private Formatter formatterAgencia = new Formatter().format("%04d-%d");
    private Formatter formatterConta = new Formatter().format("%05d-%d");

    protected Conta(Cliente cliente) {
        this.agencia = AgenciaPadraoConsts.AGENCIA_PADRAO;
        this.numero = (SEQUENCIAL++) * 11;
        this.digito = this.calcularDigitoConta(this.numero);
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        this.saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public String getNumConta() {
        return formatterConta.toString();
    }

    public TiposDeContaEnum getTipo() {
        return tipo;
    }

    public void setTipo(TiposDeContaEnum tipo) {
        this.tipo = tipo;
    }

    public void imprimirExtrato() {
        System.out.printf("=== Extrato %s ===%n", this.tipo.getDescricao());
        imprimirInfoComum();
    }

    protected void imprimirInfoComum() {
        System.out.printf("Titular: %s%n", this.cliente.getNome());
        System.out.printf("Agência: %04d%n", this.agencia);
        System.out.printf("Número da Conta: %s%n", this.getNumConta());
        System.out.printf("Saldo: %.2f%n", this.saldo);
    }

    private int calcularDigitoConta(int numero) {
        return calcularDigitoVerificadorMod11(String.valueOf(numero));
    }

    private static Integer calcularDigitoVerificadorMod11(String valor) {
        int soma = 0;
        int peso = 2;

        // fazemos a multiplicação coluna por coluna agora
        for (int index = (valor.length() - 1); index > 0; index--) {

            soma = soma + (peso * Integer.parseInt(String.valueOf(valor.charAt(index))));
            peso = peso + 1;

            if (peso > 9) {
                peso = 2;
            }
        }

        // obtemos o resto da divisão da soma por onze
        int resto = soma % 11;
        return (resto < 2) ? 1 : 11 - resto;
    }
}
