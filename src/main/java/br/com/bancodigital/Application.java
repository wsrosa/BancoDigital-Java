package br.com.bancodigital;

import br.com.bancodigital.api.dto.*;

public class Application {
    public static void main(String[] args) {
        Banco banco = new Banco("Banco Digital");

        Agencia agencia = new Agencia("Jardim Digital");

        Cliente cliente = new Cliente("Wilson Rosa");

        Conta cc = new ContaCorrente(cliente);
        cc.setAgencia(agencia);
        cc.depositar(500.00);

        Conta poup = new ContaPoupanca(cliente);
        poup.setAgencia(agencia);

        Conta pag = new ContaPagamento(cliente);
        pag.setAgencia(agencia);

        cc.transferir(100, poup);
        cc.transferir(50, pag);

        cc.imprimirExtrato();
        poup.imprimirExtrato();
        pag.imprimirExtrato();
    }
}