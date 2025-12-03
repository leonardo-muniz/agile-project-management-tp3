package br.com.leonardo.tp3.model;

import java.math.BigDecimal;
import java.util.UUID;

public class RegistroTempo {
    private final String id;
    private final int horasTrabalhadas;
    private final BigDecimal valorPorHora;

    public RegistroTempo(int horasTrabalhadas, BigDecimal valorPorHora) {
        if (horasTrabalhadas <= 0) {
            throw new IllegalArgumentException("As horas trabalhadas devem ser maiores que zero.");
        }
        if (valorPorHora.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("O valor por hora não pode ser negativo.");
        }
        this.id = UUID.randomUUID().toString();
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorPorHora = valorPorHora;
    }

    private RegistroTempo(String id, int horasTrabalhadas, BigDecimal valorPorHora) {
        this.id = id;
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorPorHora = valorPorHora;
    }

    public String getId() { return id; }
    public int getHorasTrabalhadas() { return horasTrabalhadas; }
    public BigDecimal getValorPorHora() { return valorPorHora; }

    public RegistroTempo adicionarHoras(int horasExtras) {
        if (horasExtras <= 0) {
            throw new IllegalArgumentException("Horas extras devem ser positivas.");
        }
        // Retorna um NOVO objeto com a soma das horas, mantendo o ID e o valor originais
        return new RegistroTempo(this.id, this.horasTrabalhadas + horasExtras, this.valorPorHora);
    }

    public BigDecimal calcularCustoTotal() {
        return valorPorHora.multiply(new BigDecimal(horasTrabalhadas));
    }
}
