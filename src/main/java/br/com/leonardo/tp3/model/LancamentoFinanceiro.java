package br.com.leonardo.tp3.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class LancamentoFinanceiro {
    private final String id;
    private final LocalDateTime dataHora;
    private final BigDecimal valor;
    private final String descricao;
    private final CategoriaDespesa categoriaDespesa;

    public LancamentoFinanceiro(BigDecimal valor, String descricao, CategoriaDespesa categoriaDespesa) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor deve ser positivo.");
        }
        this.id = UUID.randomUUID().toString();
        this.dataHora = LocalDateTime.now();
        this.valor = valor;
        this.descricao = descricao;
        this.categoriaDespesa = categoriaDespesa;
    }

    public String getId() { return id; }
    public LocalDateTime getDataHora() { return dataHora; }
    public BigDecimal getValor() { return valor; }
    public String getDescricao() { return descricao; }
    public CategoriaDespesa getCategoriaDespesa() { return categoriaDespesa; }
}
