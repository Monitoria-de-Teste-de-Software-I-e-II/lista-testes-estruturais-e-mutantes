package br.ufrn.dimap.services;

/**
 * Define a politica de prazo de emprestimo de livros de uma biblioteca
 * universitaria.
 *
 * <p>A regra considera o tipo de usuario, a quantidade de livros ja
 * emprestados e a existencia de atraso anterior. Esta classe foi projetada
 * para exercicios de cobertura estrutural, pois contem decisoes simples,
 * decisoes encadeadas e condicoes compostas.</p>
 */
public class PoliticaEmprestimo {

    /**
     * Calcula a quantidade de dias de emprestimo permitida para um usuario.
     *
     * <p>Tipos reconhecidos recebem prazos especificos: professores possuem
     * prazo maior e alunos possuem prazo intermediario. Tipos nao reconhecidos
     * mantem o prazo padrao. Usuarios com dados invalidos nao recebem prazo de
     * emprestimo.</p>
     *
     * @param tipoUsuario tipo informado para o usuario, como {@code PROFESSOR}
     *                    ou {@code ALUNO}
     * @param livrosEmprestados quantidade de livros atualmente emprestados
     * @param possuiAtraso indica se o usuario possui historico de atraso
     * @return quantidade de dias permitida para o emprestimo
     */
    public int calcularDiasEmprestimo(String tipoUsuario, int livrosEmprestados, boolean possuiAtraso) {
        int dias = 7;

        if (tipoUsuario == null || tipoUsuario.isBlank()) {
            return 0;
        }

        if (tipoUsuario.equalsIgnoreCase("PROFESSOR")) {
            dias = 21;
        } else if (tipoUsuario.equalsIgnoreCase("ALUNO")) {
            dias = 14;
        }

        if (possuiAtraso && livrosEmprestados > 3) {
            dias = dias - 5;
        }

        if (livrosEmprestados >= 5) {
            dias = dias - 2;
        }

        return Math.max(dias, 1);
    }
}
