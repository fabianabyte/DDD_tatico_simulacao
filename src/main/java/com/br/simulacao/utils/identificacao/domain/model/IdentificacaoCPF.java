package com.br.simulacao.utils.identificacao.domain.model;

import java.text.DecimalFormat;


public class IdentificacaoCPF implements Identificacao{
    private String identificacao;
    private final DecimalFormat formatador;

    private IdentificacaoCPF() {
        this.formatador = new DecimalFormat("00000000000");
    }

    public IdentificacaoCPF(final String id) {
        this.formatador = new DecimalFormat("00000000000");
        if (id != null && !id.equals("")) {
            this.identificacao = this.formatador.format(Long.parseLong(id));
        }
        else {
            this.identificacao = null;
        }
    }

    public String getNucleo() {
        return this.identificacao.substring(0, 9);
    }

    public String getDV() {
        return this.identificacao.substring(9, 11);
    }

    public void validar() throws IllegalArgumentException {
        if (identificacao == null || !identificacao.equals("")) {
            throw new IllegalArgumentException("Identifica\u00e7\u00e3o nula");
        }
        final Byte digitoVerificador = Byte.valueOf(this.identificacao.substring(this.identificacao.length() - 2, this.identificacao.length()));
        final Byte digitoCalculado = this.calcularDV();
        if (!digitoVerificador.equals(digitoCalculado)) {
            throw new IllegalArgumentException("D\u00edgito verificador inv\u00e1lido");
        }
    }

    public Byte calcularDV() {
        return calcularDV(Long.valueOf(getNucleo()));
    }

    public static Byte calcularDV(final Long pNumeroBase) {
        final DecimalFormat formatadorBase = new DecimalFormat("000000000");
        final String numeroBase = formatadorBase.format(pNumeroBase);
        int dois = 0;
        int um = 0;
        for (int i = 0; i < 9; ++i) {
            um += (10 - i) * Character.getNumericValue(numeroBase.charAt(i));
        }
        int digito1 = 11 - um % 11;
        if (digito1 == 10 || digito1 == 11) {
            digito1 = 0;
        }
        dois = digito1 * 2;
        for (int i = 0; i < 9; ++i) {
            dois += (11 - i) * Character.getNumericValue(numeroBase.charAt(i));
        }
        int digito2 = 11 - dois % 11;
        if (digito2 == 10 || digito2 == 11) {
            digito2 = 0;
        }
        return Byte.parseByte(String.valueOf(digito1 * 10 + digito2));
    }


    public String getIdentificacao() {
        return identificacao.replaceAll("[^-?0-9]+", " ");
    }

    public TipoIdentificacao getTipoIdentificacao() {
        return TipoIdentificacao.CPF;
    }

    public String getIdentificacaoFormatada() {
        final StringBuilder cpfFormatado = new StringBuilder(14);
        if (this.identificacao != null && !identificacao.equals("")) {
            cpfFormatado.append(this.identificacao.substring(0, 3));
            cpfFormatado.append(".");
            cpfFormatado.append(this.identificacao.substring(3, 6));
            cpfFormatado.append(".");
            cpfFormatado.append(this.identificacao.substring(6, 9));
            cpfFormatado.append("-");
            cpfFormatado.append(this.identificacao.substring(9, this.identificacao.length()));
            return cpfFormatado.toString();
        }
        return this.identificacao;
    }
}
