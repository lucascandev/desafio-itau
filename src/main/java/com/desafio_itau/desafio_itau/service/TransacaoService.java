package com.desafio_itau.desafio_itau.service;

import com.desafio_itau.desafio_itau.model.Estatistica;
import com.desafio_itau.desafio_itau.model.Transacao;
import org.springframework.stereotype.Service;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransacaoService {

    private List<Transacao> transacoes = new ArrayList<>();

    public boolean adicionarTransacao(Transacao transacao) {
        OffsetDateTime agora = OffsetDateTime.now();

        if (transacao.getDataHora().isAfter(agora) || transacao.getValor() < 0) {
            return false;
        }

        transacoes.add(transacao);
        return true;
    }

    public void limparTransacoes() {
        transacoes.clear();
    }

    public Estatistica calcularEstatisticas() {
        OffsetDateTime agora = OffsetDateTime.now();
        OffsetDateTime sessentaSegundosAtras = agora.minusSeconds(60);

        List<Transacao> transacoesRecentes = transacoes.stream()
                .filter(t -> t.getDataHora().isAfter(sessentaSegundosAtras) && t.getDataHora().isBefore(agora)) //correção aqui.
                .collect(Collectors.toList());

        if (transacoesRecentes.isEmpty()) {
            return new Estatistica(0, 0, 0, 0, 0);
        }

        DoubleSummaryStatistics stats = transacoesRecentes.stream()
                .mapToDouble(Transacao::getValor)
                .summaryStatistics();

        return new Estatistica(stats.getCount(), stats.getSum(), stats.getAverage(), stats.getMin(), stats.getMax());
    }
}