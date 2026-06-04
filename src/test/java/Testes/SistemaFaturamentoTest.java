package Testes;

import FaturamentoServicos.SistemaFaturamento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class SistemaFaturamentoTest {

    @Test
    void deveCalcularFaturaComExpressaoSoma() {
        SistemaFaturamento.regraFaturamento = "consumo + taxa";
        assertEquals(120.0, SistemaFaturamento.calcularFatura(100.0, 0.0, 20.0));
    }

    @Test
    void deveCalcularFaturaComExpressaoSubtracao() {
        SistemaFaturamento.regraFaturamento = "consumo * tarifa - taxa";
        assertEquals(140.0, SistemaFaturamento.calcularFatura(100.0, 1.5, 10.0));
    }

    @Test
    void deveCalcularFaturaComExpressaoDivisao() {
        SistemaFaturamento.regraFaturamento = "consumo / taxa";
        assertEquals(50.0, SistemaFaturamento.calcularFatura(100.0, 0.0, 2.0));
    }

    @Test
    void deveCalcularFaturaComExpressaoCombinada() {
        SistemaFaturamento.regraFaturamento = "consumo / 2 * tarifa + 10 - taxa";
        assertEquals(155.0, SistemaFaturamento.calcularFatura(100.0, 3.0, 5.0));
    }

    @Test
    void deveRetornarExcecaoElementoInvalido() {
        SistemaFaturamento.regraFaturamento = "consumo ^ tarifa";
        try {
            SistemaFaturamento.calcularFatura(100.0, 2.0, 10.0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Expressão com elemento inválido", e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoInvalidaPorFaltaDeElemento() {
        SistemaFaturamento.regraFaturamento = "consumo +";
        try {
            SistemaFaturamento.calcularFatura(100.0, 0.0, 0.0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Expressão inválida", e.getMessage());
        }
    }

}
