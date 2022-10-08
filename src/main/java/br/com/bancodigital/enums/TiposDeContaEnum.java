package br.com.bancodigital.enums;

public enum TiposDeContaEnum {
    CONTA_CORRENTE  (1, "Conta-Corrente"),
    CONTA_POUPANCA  (2, "Conta-Poupança"),
    CONTA_PAGAMENTO (3, "Conta-Pagamento");

    private final int id;
    private final String descricao;

    TiposDeContaEnum(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return this.id;
    }

    public String getDescricao() {
        return this.descricao;
    }
}
