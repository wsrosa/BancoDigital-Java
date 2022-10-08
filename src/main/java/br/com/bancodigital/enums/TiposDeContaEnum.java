package br.com.bancodigital.enums;

import java.io.Serializable;

public class EnumTiposDeConta {
    public enum AccountTypeEnum implements Serializable {
        CONTA_CORRENTE  (1, "Conta-Corrente"),
        CONTA_POUPANCA  (2, "Conta-Poupança"),
        CONTA_PAGAMENTO (3, "Conta-Pagamento");

        private final Integer id;
        private final String description;

        private AccountTypeEnum(Integer id, String description) {
            this.id = id;
            this.description = description;
        }

        public Integer getId() {
            return this.id;
        }

        public String getDescription() {
            return this.description;
        }
}
