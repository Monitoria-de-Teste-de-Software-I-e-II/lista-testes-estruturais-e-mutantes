package br.ufrn.dimap.services;

/**
 * Calcula o valor final de um pedido em uma loja virtual.
 *
 * <p>A regra aplica validacoes de entrada, desconto por volume, desconto por
 * cupom e acrescimo para pedidos de baixo valor. Esta classe foi projetada para
 * exercicios de teste de mutacao, pois contem comparacoes relacionais,
 * operadores logicos e operacoes aritmeticas.</p>
 */
public class CalculadoraDesconto {

    /**
     * Calcula o total final de um pedido.
     *
     * <p>O metodo valida se valor unitario e quantidade sao positivos. Em
     * seguida, calcula o total bruto e aplica as regras comerciais previstas
     * para desconto e acrescimo.</p>
     *
     * @param valorUnitario valor de uma unidade do produto
     * @param quantidade    quantidade de itens comprados
     * @param cupomValido   indica se ha um cupom promocional valido
     * @return valor final do pedido apos descontos ou acrescimos
     * @throws IllegalArgumentException se {@code valorUnitario} ou
     *                                  {@code quantidade} nao forem positivos
     */
    public double calcularTotal(double valorUnitario, int quantidade, boolean cupomValido) {
        if (valorUnitario <= 0 || quantidade <= 0) {
            throw new IllegalArgumentException("Valor unitario e quantidade devem ser positivos");
        }

        double total = valorUnitario * quantidade;

        if (total >= 200 && quantidade >= 3) {
            total = total * 0.90;
        }

        if (cupomValido && total > 100) {
            total = total - 15;
        }

        if (total < 50) {
            total = total + 10;
        }

        return total;
    }
}
