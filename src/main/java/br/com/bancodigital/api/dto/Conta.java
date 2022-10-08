package br.com.bancodigital.api.dto;

import br.com.bancodigital.enums.TiposDeContaEnum;
import br.com.bancodigital.util.UtilDigito;
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

    protected Agencia agencia;
    protected int numero;
    protected int digito;
    protected Cliente cliente;

    protected TiposDeContaEnum tipo;
    protected double saldo;

    private Formatter formatterConta = new Formatter();

    protected Conta(Cliente cliente) {
        this.numero = (SEQUENCIAL++) * 11;
        this.digito = this.calcularDigito(this.numero);
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

    public String getNumConta() {
        return formatterConta.format("%05d-%d", numero, digito).toString();
    }

    public void imprimirExtrato() {
        System.out.printf("=== Extrato %s ===%n", this.tipo.getDescricao());
        imprimirInfoComum();
    }

    protected void imprimirInfoComum() {
        System.out.printf("Titular: %s%n", this.cliente.getNome());
        System.out.println(this.agencia.toString());
        System.out.printf("Número da Conta: %s%n", this.getNumConta());
        System.out.printf("Saldo: %.2f%n", this.saldo);
    }

    private int calcularDigito(int numero) {
        return UtilDigito.calcularDigitoVerificadorMod11(String.valueOf(numero));
    }
}
