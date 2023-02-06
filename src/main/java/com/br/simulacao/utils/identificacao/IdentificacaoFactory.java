package com.br.simulacao.utils.identificacao;

import com.br.simulacao.utils.identificacao.domain.model.Identificacao;
import com.br.simulacao.utils.identificacao.domain.model.IdentificacaoCNPJ;
import com.br.simulacao.utils.identificacao.domain.model.IdentificacaoCPF;
import com.br.simulacao.utils.identificacao.domain.model.TipoIdentificacao;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class IdentificacaoFactory {
    private static DecimalFormat formatadorDV;

    public static Identificacao getIdentificacao(final String identificacao) {
        final Map<TipoIdentificacao, Identificacao> mapa = new HashMap<TipoIdentificacao, Identificacao>();
        mapa.put(TipoIdentificacao.CPF, new IdentificacaoCPF(identificacao));
        mapa.put(TipoIdentificacao.CNPJ, new IdentificacaoCNPJ(identificacao));
        return mapa.get(getTipoIdentificacao(identificacao.length()));
    }
    public static TipoIdentificacao getTipoIdentificacao(final Integer tamanho) {
        final HashMap<Integer, TipoIdentificacao> mapa = new HashMap<Integer, TipoIdentificacao>();
        mapa.put(TipoIdentificacao.CNPJ.getTamanho(), TipoIdentificacao.CNPJ);
        mapa.put(TipoIdentificacao.CPF.getTamanho(), TipoIdentificacao.CPF);
        return mapa.get(tamanho);
    }

    public static String formatarDV(final Number dv) {
        return IdentificacaoFactory.formatadorDV.format(dv);
    }

    static {
        IdentificacaoFactory.formatadorDV = new DecimalFormat("00");
    }
}
