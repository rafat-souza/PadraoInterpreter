package Testes;

import FaturamentoServicos.ContaServico;
import FaturamentoServicos.SistemaFaturamento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContaServicoTest {

    @Test
    void deveCalcularFaturaComValoresPadrao() {
        ContaServico conta = new ContaServico();
        conta.setConsumoMensal(150.0);
        conta.setTarifaBase(0.8);
        conta.setTaxaFixa(20.0);

        assertEquals(140.0, conta.calcularValorFatura());
    }

    @Test
    void deveCalcularFaturaComConsumoZero() {
        ContaServico conta = new ContaServico();
        conta.setConsumoMensal(0.0);
        conta.setTarifaBase(0.8);
        conta.setTaxaFixa(20.0);

        assertEquals(20.0, conta.calcularValorFatura());
    }

    @Test
    void deveCalcularFaturaSemTaxaFixa() {
        ContaServico conta = new ContaServico();
        conta.setConsumoMensal(100.0);
        conta.setTarifaBase(0.5);
        conta.setTaxaFixa(0.0);

        assertEquals(50.0, conta.calcularValorFatura());
    }

    @Test
    void deveCalcularFaturaComRegraAlterada() {
        ContaServico conta = new ContaServico();
        conta.setConsumoMensal(100.0);
        conta.setTarifaBase(1.5);
        conta.setTaxaFixa(15.0);

        SistemaFaturamento.regraFaturamento = "consumo * tarifa - taxa";

        assertEquals(135.0, conta.calcularValorFatura());

        SistemaFaturamento.regraFaturamento = "consumo * tarifa + taxa";
    }

}
