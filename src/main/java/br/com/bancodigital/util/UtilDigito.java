package br.com.bancodigital.util;

public class UtilDigito {
    private UtilDigito() {}

    public static Integer calcularDigitoVerificadorMod11(String valor) {
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
