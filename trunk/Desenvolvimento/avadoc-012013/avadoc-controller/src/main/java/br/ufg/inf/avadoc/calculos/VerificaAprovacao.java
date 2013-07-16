package br.ufg.inf.avadoc.calculos;

/**
 * Classe a qual verifica a aprovacao de um docente.
 * @author Rogerio Tristão Junior
 *
 */
public final class VerificaAprovacao {

    /**
     * Verifica a aprovação de um docente em estágio probatório.
     * @author Rogerio Tristão Junior
     *
     */
    public static final class EstagioProbatorio {

        public static final double MEDIA_GLOBAL = 7.5;

        public static final double MEDIA_N2 = 5.0;

        public static final double MEDIA_N3 = 5.0;

        /**
         * Verifica a aprovação do docente a qual está em estágio probatório
         * conforme a CONSUNI 21/2009.
         * @param notaFinal nota final do docente ao longo de 36 meses.
         * @param jornadaTrabalho especifica qual a jornada de trabalho do
         * docente
         * @param cargoDirecao flag para verificar se o docente ocupa cargo de
         * direção/administrativa
         * @param participaPrograma flag para verificar se o docente realizou
         * as atividades da PROGRAD e PRODIRH, Art. 8° da CONSUNI 21/2009.
         * @param mediaN2 média das notas da chefia de gabinete ou da diretoria
         * no decorrer de 36 meses
         * @param mediaN3 média das notas do corpo discente no decorrer de 36
         * meses
         * @param mediaAtvIntelectual média das notas das atividades
         * intelecutais produzidas
         * @param mediaAtvEnsino médida média das notas das atividades de ensino
         * realizadas
         * @return verdadeiro para aprovado e falso para reprovado
         */
        public static boolean verificaAprovacao(Nota notaFinal, EnumJornadaTrabalho jornadaTrabalho,
                boolean cargoDirecao, boolean participaPrograma, double mediaN2, double mediaN3,
                double mediaAtvIntelectual, double mediaAtvEnsino) {

            boolean exigenciaI = verificaExigenciaI(mediaAtvEnsino, cargoDirecao);
            boolean exigenciaII = verificaExigenciaII(mediaAtvIntelectual, jornadaTrabalho, mediaAtvEnsino);
            boolean exigenciaIII = verificaExigenciaIII(mediaN2, mediaN3);
            boolean exigenciaIV = verificaExigenciaIV(participaPrograma);
            boolean exigenciaV = verificaExigenciaV(notaFinal);

            return exigenciaI && exigenciaII && exigenciaIII && exigenciaIV
                    && exigenciaV;

        }

        /**
         * Método que verifica a exigência do Art. 16 do CONSUNI 21/2009 no item
         * I Atividades de Ensino.
         * @param mediaAtvEns média aritmética de pontos (E) no item I
         * Atividades de Ensino
         * @param ocupaCargoDirecao flag que verifica se o docente ocupa cargo
         * na direção. Se for verdadeiro, a regra será desconsiderada, senão
         * será considerada
         * @return verdadeiro (aprovado) caso a média seja igual ou maior que
         * 80.0 no item I Atividades de Ensino, caso contrário será falso
         * (reprovado)
         */
        private static boolean verificaExigenciaI(final double mediaAtvEns,
                final boolean ocupaCargoDirecao) {
            if (ocupaCargoDirecao) {
                return true;
            } else {
                if(mediaAtvEns >= 80.0) {
                    return true;
                } else {
                    return false;
                }
            }
        }

        /**
         * Método que verifica a média aritmética de pontos por ano sobre os
         * itens II-1, II-2 e II-3 (Produção Intelectual) e V-1
         * (Outras Atividades).
         * @param mediaProdIntel média aritmética de pontos nos
         * itens II-1, II-2 e II-3 (Produção Intelectual) e V-1
         * (Outras Atividades)
         * @param jornadaTrabalho flag que verifica se o docente é de regime 40
         * horas ou Dedicação exclusiva, se for verdadeiro, a regra se aplica,
         * caso contrário o mesmo é de regime de 20 horas e tal regra não será
         * aplicada
         * @param mediaAtvEns valor da média nota do item I em
         * atividades de ensino
         * @return verdadeiro (aprovado) para caso a média seja igual ou maior
         * que 20 por ano, caso contrário será falso (reprovado)
         */
        private static boolean verificaExigenciaII(final double mediaProdIntel,
                final EnumJornadaTrabalho jornadaTrabalho,
                final double mediaAtvEns) {
            if (jornadaTrabalho.equals(EnumJornadaTrabalho.jornada20)) {
                return true;
            } else {
                if (mediaAtvEns >= 160) {
                    return true;
                } else {
                    double mediaRequerida = (40 - (mediaAtvEns / 4));
                    if (mediaProdIntel >= mediaRequerida) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }

        /**
         * Método que verifica a média final das avaliações de chefia e corpo
         * discente.
         * @param mediaN2 média final da nota da diretoria ou chefia de
         * gabinete
         * @param mediaN3 média final da nota do corpo discente
         * @return verdadeiro (aprovado) para caso a ambas as médias sejam
         * maiores ou iguais a 5.0, caso contrário será falso (reprovado)
         */
        private static boolean verificaExigenciaIII(final double mediaN2,
                final double mediaN3) {
            return (mediaN2 >= MEDIA_N2) && (mediaN3 >= MEDIA_N3);
        }

        /**
         * Método que verifica se o docente participou do programa de
         * atividades de responsabilidade da PROGRAD e PRODIRH, Art. 8°
         * da CONSUNI 21/2009.
         * @param partPrograma flag que armazena se o docente participou
         * ou não dos programas
         * @return verdadeiro (aprovado) para caso tenha participado ou falso
         * (reprovado) para caso não tenha participado
         */
        private static boolean verificaExigenciaIV(final boolean partPrograma) {
            if (partPrograma) {
                return partPrograma;
            } else {
                return partPrograma;
            }
        }

        /**
         * Método que verifica a nota global do docente no período de 36 meses,
         * de acordo com a CONSUNI 21/2009.
         * @param notaFinal nota global do docente.
         * @return verdadeiro (aprovado) para caso essa média seja maior ou
         * igual a 7.5, caso contrário será falso (reprovado)
         */
        private static boolean verificaExigenciaV(final Nota notaFinal) {
            return notaFinal.getNota() >= MEDIA_GLOBAL;
        }

    }

}
