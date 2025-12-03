package br.com.leonardo.tp3.model;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class RegistroTempoTest {
    @Test
    void deveGarantirImutabilidadeAoAdicionarHoras() {
        // 1. ARRANGE: Estado Inicial
        BigDecimal valorHora = new BigDecimal("50.0");
        RegistroTempo registroOriginal = new RegistroTempo(5, valorHora);

        // 2. ACT: Tenta modificar
        RegistroTempo registroNovo = registroOriginal.adicionarHoras(3);

        // 3. ASSERT: Verificações
        // Verifica se o novo objeto tem o valor correto (5+3=8)
        assertEquals(8, registroNovo.getHorasTrabalhadas());

        // CRUCIAL: VERIFICA SE O OBJETO ORIGINAL PERMANECEU INTACTO
        // (DEVE CONTINUAR SENDO 5)
        assertEquals(5, registroOriginal.getHorasTrabalhadas());

        // Verifica se são objetos diferentes na memória
        // (NÃO É O MESMO PONTEIRO)
        assertNotSame(registroOriginal, registroNovo);

    }

    @Test
    void naoDevePermitirDadosInvalidos() {
        // Teste extra de validação (Item 2 do Exercício 3)
        assertThrows(IllegalArgumentException.class, () -> {
            new RegistroTempo(-5, BigDecimal.TEN);
        });
    }
}
