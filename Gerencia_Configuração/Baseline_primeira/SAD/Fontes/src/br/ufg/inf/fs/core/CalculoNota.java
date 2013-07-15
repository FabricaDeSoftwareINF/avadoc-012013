/**
 * Sistema de Avaliação do Docente - SAD.
 */
package br.ufg.inf.fs.core;

import br.ufg.inf.fs.exception.NumeroNegativoException;

/**
 * Classe responsável em realizar cálculos das notas finais ou parciais dos
 * docentes que estão sob estágio probatório ou progressão horizontal.
 * 
 * @author Rogério Tristão Junior
 * @version 1.0
 * @since 1.0
 */
public final class CalculoNota {

	/** Peso do estágio probatório das atividades do docente. */
	public static final double PESO_N1_ESTAGIO = 0.6;

	/** Peso do estágio probatório da direção ou chefia de departamento. */
	public static final double PESO_N2_ESTAGIO = 0.2;

	/** Peso do estágio probatório da avaliação do corpo discente. */
	public static final double PESO_N3_ESTAGIO = 0.2;

	/** Peso da progressão horizontal das atividades do docente. */
	public static final double PESO_N1_PROGRESSAO = 0.7;

	/** Peso da progressão horizontal do corpo discente. */
	public static final double PESO_N2_PROGRESSAO = 0.3;

	/** Constante do cálculo da N1 para o MMC. */
	public static final int CONSTANTE_AVALIACAO = 10;

	/** Quantidade de meses em um ano letivo. */
	public static final int QUANTIDADE_MESES = 12;

	/** Regime de 20 horas do docente. */
	public static final int JORNADA_20_HORAS = 8;

	/** Regime de 40 horas ou dedicação exclusiva do docente. */
	public static final int JORNADA_40_HORAS_OU_DE = 16;

	/**
	 * Método que calcula a N1 do docente em estágio probatório.<br>
	 * 
	 * @param pontuacaoAtividades
	 *            contabilização das notas das atividades realizadas pelo
	 *            docente.
	 * @param quantidadeMesesEfetivos
	 *            total de meses em que o docente está efetivamente em
	 *            exercício.
	 * @param jornadaTrabalho
	 *            verdadeiro para jornada de trabalho de 20 horas ou falso para
	 *            jornada de trabalho em 40 horas ou dedicação exclusiva.
	 * @return retorna a nota N1 do docente.
	 * @throws NumeroNegativoException
	 *             exceção lançada caso o valor do número de meses em exercício
	 *             ou o resultado da contabilização das atividades seja
	 *             negativo.
	 */
	public static double calculaN1(final double pontuacaoAtividades,
			final int quantidadeMesesEfetivos, final boolean jornadaTrabalho)
			throws NumeroNegativoException {

		double temp = 0;

		/* Verificação para não ser inserido nenhum valor negativo */
		if ((quantidadeMesesEfetivos <= 0) || (pontuacaoAtividades < 0)) {
			throw new NumeroNegativoException();
		} else {
			if (jornadaTrabalho) {
				temp = ((QUANTIDADE_MESES * pontuacaoAtividades) / quantidadeMesesEfetivos)
						/ JORNADA_20_HORAS;
			} else {
				temp = ((QUANTIDADE_MESES * pontuacaoAtividades) / quantidadeMesesEfetivos)
						/ JORNADA_40_HORAS_OU_DE;
			}
		}

		return CONSTANTE_AVALIACAO >= temp ? temp : CONSTANTE_AVALIACAO;
	}

	/**
	 * Método que calcula a nota parcial do docente que está em estágio
	 * probatório.
	 * 
	 * @param pontuacaoAtividades
	 *            contabilização das notas das atividades realizadas pelo
	 *            docente.
	 * @param quantidadeMesesEfetivos
	 *            total de meses em que o docente está efetivamente em
	 *            exercício.
	 * @param jornadaTrabalho
	 *            verdadeiro para jornada de trabalho de 20 horas ou falso para
	 *            jornada de trabalho em 40 horas ou dedicação exclusiva.
	 * @param notaChefia
	 *            nota da diretoria ou chefia de departamento.
	 * @param notaCorpoDiscente
	 *            nota da avaliação do corpo discente.
	 * @return retorna a nota parcial do docente referido à um período.
	 * @throws NumeroNegativoException
	 *             exceção lançada caso o cálculo da N1 for negativo, a nota do
	 *             corpo discente ou a nota da chefia for negativa.
	 */
	public static double calculaNotaParcial(final int pontuacaoAtividades,
			final double notaChefia, final double notaCorpoDiscente)
			throws NumeroNegativoException {

		double notaParcial = 0;

		/* Verificação para não ser inserido nenhum valor negativo */
		if ((notaChefia < 0) || (notaCorpoDiscente < 0)) {
			throw new NumeroNegativoException();
		} else {
			notaParcial = (pontuacaoAtividades * PESO_N1_ESTAGIO)
					+ (notaChefia * PESO_N2_ESTAGIO)
					+ (notaCorpoDiscente * PESO_N3_ESTAGIO);
		}

		return notaParcial;
	}

	/**
	 * Construtor para evitar a instanciação dessa classe.
	 */
	private CalculoNota() {
	}

}
