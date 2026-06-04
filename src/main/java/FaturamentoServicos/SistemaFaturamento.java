package FaturamentoServicos;

public class SistemaFaturamento {

    public static String regraFaturamento = "consumo * tarifa + taxa";

    public static double calcularFatura(double consumo, double tarifa, double taxa) {
        String expressao;

        expressao = regraFaturamento.replace("consumo", Double.toString(consumo));
        expressao = expressao.replace("tarifa", Double.toString(tarifa));
        expressao = expressao.replace("taxa", Double.toString(taxa));

        InterpretadorExpressao interpretador = new InterpretadorExpressoesAritmeticas(expressao);
        return interpretador.interpretar();
    }

}
