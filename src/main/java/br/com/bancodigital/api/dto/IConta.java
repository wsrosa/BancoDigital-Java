package br.com.bancodigital.api.dto;

/**
 * Interface para Contas Bancárias
 */
public interface IConta {
    void sacar(double valor);

    void depositar(double valor);

    void transferir(double valor, IConta contaDestino);

    void imprimirExtrato();
}
