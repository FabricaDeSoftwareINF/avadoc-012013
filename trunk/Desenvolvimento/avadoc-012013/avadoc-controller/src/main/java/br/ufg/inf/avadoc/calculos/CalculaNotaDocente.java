/**
 * Sistema de Avaliação do Docente - SAD.
 */
package br.ufg.inf.avadoc.calculos;

import java.util.List;

/**
 * Classe responsável em realizar cálculos das notas finais ou parciais dos
 * docentes que estão sob estágio probatório ou progressão horizontal.
 * 
 * @author Rogério Tristão Junior
 * @version 1.0
 * @since 1.0
 */
public final class CalculaNotaDocente {

	/**
	 * Classe interna a qual contém todos os cálculos para obtenção das notas
	 * do docente a qual está em estágio probatório.
	 * @author Rogério Tristão Junior
	 * @version 1.0
	 * @since 1.0
	 */
	public static class EstagioProbatorio {

		/**
		 * Calcula a nota N1 (nota das atividades) de um docente em um determinado
		 * período de atuação.
		 * @param pontosAtividades total de pontos das atividades realizadas pelo
		 * docente
		 * @param mesesEfetivos meses efetivos de atuação do docente
		 * @param jornadaTrabalho jornada de trabalho a qual o docente rege
		 * @return retorna a nota N1
		 * @throws ExcecaoNumeroNegativo exceção para caso os meses efetivos ou os
		 * pontos das atividades seja negativo
		 */
		public static Nota calculaN1(double pontosAtividades, int mesesEfetivos,
				EnumJornadaTrabalho jornadaTrabalho) throws ExcecaoNumeroNegativo {

			Nota nota = new Nota();

			nota.setQuantidadeMeses(mesesEfetivos);

			/* Verificação para não ser inserido nenhum valor negativo */
			if ((mesesEfetivos <= 0) || (pontosAtividades < 0)) {
				nota.setNota(0);
				throw new ExcecaoNumeroNegativo();
			} else {
				if (jornadaTrabalho.equals(EnumJornadaTrabalho.jornada20)) {
					nota.setNota(((QUANTIDADE_MESES * pontosAtividades) / mesesEfetivos)
							/ JORNADA_20_HORAS);
				} else {
					nota.setNota(((QUANTIDADE_MESES * pontosAtividades) / mesesEfetivos)
							/ JORNADA_40_HORAS_OU_DE);
				}

				nota.setNota(CONSTANTE_AVALIACAO >= nota.getNota() ? nota.getNota() : CONSTANTE_AVALIACAO);
			}

			return nota;
		}

		/**
		 * Calcula a nota final do docente com base em uma lista de notas parciais
		 * a qual o mesmo fora avaliado no decorrer de 36 meses, conforme a CONSUNI
		 * 21/2009 estabelece.
		 * @param notasNP lista de notas a ser calculada a média ponderada
		 * @return retorna a média ponderada
		 */
		public static double calculaNF(List<Nota> notasNP) {

			double total = 0;

			for (Nota nota : notasNP) {
				total = total + (nota.getNota() * nota.getQuantidadeMeses());
			}

			total = total / TEMPO_ESTAGIO;

			return total;
		}

		/**
		 * Calcula a nota parcial de um docente em estágio probatório dado um
		 * determinado período. Essa nota irá compor a Nota Final (NF) do docente
		 * quando terminar o período de 36 meses de atuação.
		 * @param N1 nota das atividades do docente
		 * @param notaChefia nota da diretoria ou chefia de gabinete
		 * @param notaDiscente nota do corpo discente
		 * @return retorna a nota parcial do docente referido à um período
		 * @throws ExcecaoNumeroNegativo exceção para caso a nota do corpo discente
		 * ou chefia de gabinete (ou diretoria) seja negativa
		 */
		public static Nota calculaNP(Nota N1, double notaChefia, double notaDiscente)
				throws ExcecaoNumeroNegativo {

			Nota notaParcial = new Nota();
			notaParcial.setQuantidadeMeses(N1.getQuantidadeMeses());

			/* Verificação para não ser calculado nenhum valor negativo */
			if ((notaChefia < 0) || (notaDiscente < 0)) {
				notaParcial.setNota(0);
				throw new ExcecaoNumeroNegativo();
			} else {
				notaParcial.setNota((N1.getNota() * PESO_N1_ESTAGIO)
						+ (notaChefia * PESO_N2_ESTAGIO)
						+ (notaDiscente * PESO_N3_ESTAGIO));
			}

			return notaParcial;
		}
	}

	/**
	 * Classe interna a qual contém todos os cálculos para obtenção das notas
	 * do docente a qual está em progressão horizontal.
	 * @author Rogério Tristão Junior
	 * @version 1.0
	 * @since 1.0
	 */
	public static class ProgressaoHorizontal {

	}

	/** Tempo de duração do estágio probatório. */
	public static final double TEMPO_ESTAGIO = 36;

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
	 * Construtor para evitar a instanciação dessa classe.
	 */
	private CalculaNotaDocente() {
	}

}