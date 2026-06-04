package FaturamentoServicos;

public class ContaServico {

    private double consumoMensal;
    private double tarifaBase;
    private double taxaFixa;

    public double getConsumoMensal() {
        return consumoMensal;
    }

    public void setConsumoMensal(double consumoMensal) {
        this.consumoMensal = consumoMensal;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }

    public void setTarifaBase(double tarifaBase) {
        this.tarifaBase = tarifaBase;
    }

    public double getTaxaFixa() {
        return taxaFixa;
    }

    public void setTaxaFixa(double taxaFixa) {
        this.taxaFixa = taxaFixa;
    }

    public double calcularValorFatura() {
        return SistemaFaturamento.calcularFatura(this.consumoMensal, this.tarifaBase, this.taxaFixa);
    }

}
