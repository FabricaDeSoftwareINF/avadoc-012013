/**
 * Sistema de Avaliação do Docente - SAD
 */
package br.ufg.inf.fs.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.ufg.inf.fs.exception.NumeroNegativoException;

/**
 * Teste de unidade que visa a verificação do cálculo das notas parciais e
 * totais do docente que está em estágio probatório e/ou progressão
 * horizontal. Todos os resultados esperados são frutos de um preenchimento
 * manual da planilha eletrônica desenvolvida pela CAD a qual foram simulados
 * vários valores.
 * @author Rogério Tristão Junior
 * @version 1.0
 * @since 1.0
 */
public final class TestCalculoNota {

    /** Variável para pontuação das atividades do docente. */
    private static final int ATIVIDADE_DOCENTE_1 = 100;

    /** Segunda variável para pontuação das atividades do docente. */
    private static final int ATIVIDADE_DOCENTE_2 = 50;

    /** Terceira variável para pontuação das atividades do docente. */
    private static final int ATIVIDADE_DOCENTE_3 = -50;

    /** Variável para quantidade de meses do docente. */
    private static final int MESES_DOCENTE_1 = 10;

    /** Segunda variável para quantidade de meses do docente. */
    private static final int MESES_DOCENTE_2 = 0;

    /** Terceira variável para quantidade de meses do docente. */
    private static final int MESES_DOCENTE_3 = -10;

    /** Nota negativa do corpo discente. */
    private static final int NOTA_DISCENTE_NEGATIVA = -10;

    /** Nota negativa da diretoria ou chefia de departamento. */
    private static final int NOTA_DIRETORIA_NEGATIVA = -10;

    @Test
    public void testCalculaN1() {

        double notaN1 = 0;

        /*
         * 100 pontos de atividades do docente, durante 12 meses de
         * exercício em uma jornada de 20 horas.
         */
        try {
            notaN1 = CalculoNota.calculaN1(ATIVIDADE_DOCENTE_1,
                    CalculoNota.QUANTIDADE_MESES, true);
        } catch (final NumeroNegativoException e) {
            e.printStackTrace();
        }
        assertEquals(10, notaN1, 0);

        /*
         * 100 pontos de atividades do docente, durante 12 meses de
         * exercício em uma jornada de 40 horas ou dedicação exclusiva.
         */
        try {
            notaN1 = CalculoNota.calculaN1(ATIVIDADE_DOCENTE_1,
                    CalculoNota.QUANTIDADE_MESES, false);
        } catch (final NumeroNegativoException e) {
            e.printStackTrace();
        }
        assertEquals(6.25, notaN1, 0);

        /*
         * 100 pontos de atividades do docente, durante 10 meses de
         * exercício em uma jornada de 20 horas.
         */
        try {
            notaN1 = CalculoNota.calculaN1(ATIVIDADE_DOCENTE_1,
                    MESES_DOCENTE_1, true);
        } catch (final NumeroNegativoException e) {
            e.printStackTrace();
        }
        assertEquals(10, notaN1, 0);

        /*
         * 50 pontos de atividades do docente, durante 12 meses de
         * exercício em uma jornada de 20 horas.
         */
        try {
            notaN1 = CalculoNota.calculaN1(ATIVIDADE_DOCENTE_2,
                    CalculoNota.QUANTIDADE_MESES, true);
        } catch (final NumeroNegativoException e) {
            e.printStackTrace();
        }
        assertEquals(6.25, notaN1, 0);

        /*
         * 100 pontos de atividades do docente, durante 10 meses de
         * exercício em uma jornada de 40 horas ou dedicação exclusiva.
         */
        try {
            notaN1 = CalculoNota.calculaN1(ATIVIDADE_DOCENTE_1,
                    MESES_DOCENTE_1, false);
        } catch (final NumeroNegativoException e) {
            e.printStackTrace();
        }
        assertEquals(7.5, notaN1, 0);

        /*
         * 50 pontos de atividades do docente, durante 12 meses de
         * exercício em uma jornada de 40 horas ou dedicação exclusiva.
         */
        try {
            notaN1 = CalculoNota.calculaN1(ATIVIDADE_DOCENTE_2,
                    CalculoNota.QUANTIDADE_MESES, false);
        } catch (final NumeroNegativoException e) {
            e.printStackTrace();
        }
        assertEquals(3.125, notaN1, 0);

        /*
         * 50 pontos de atividades do docente, durante 10 meses de
         * exercício em uma jornada de 20 horas.
         */
        try {
            notaN1 = CalculoNota.calculaN1(ATIVIDADE_DOCENTE_2,
                    MESES_DOCENTE_1, true);
        } catch (final NumeroNegativoException e) {
            e.printStackTrace();
        }
        assertEquals(7.5, notaN1, 0);

        /*
         * 50 pontos de atividades do docente, durante 10 meses de
         * exercício em uma jornada de 40 horas ou dedicação exclusiva.
         */
        try {
            notaN1 = CalculoNota.calculaN1(ATIVIDADE_DOCENTE_2,
                    MESES_DOCENTE_1, false);
        } catch (final NumeroNegativoException e) {
            e.printStackTrace();
        }
        assertEquals(3.75, notaN1, 0);

        /* Abaixo segue os casos que deverá lançar uma exceção. */

        /*
         * Quando a atividade do docente for negativa.
         */
        try {
            notaN1 = CalculoNota.calculaN1(ATIVIDADE_DOCENTE_3,
                    MESES_DOCENTE_1, false);
            assertTrue(false);
        } catch (final NumeroNegativoException e) {
            assertFalse(false);
        }

        /*
         * Quando a quantidade de meses for igual a 0.
         */
        try {
            notaN1 = CalculoNota.calculaN1(ATIVIDADE_DOCENTE_2,
                    MESES_DOCENTE_2, false);
            assertTrue(false);
        } catch (final NumeroNegativoException e) {
            assertFalse(false);
        }

        /*
         * Quando a quantidade de meses for negativa.
         */
        try {
            notaN1 = CalculoNota.calculaN1(ATIVIDADE_DOCENTE_2,
                    MESES_DOCENTE_3, false);
            assertTrue(false);
        } catch (final NumeroNegativoException e) {
            assertFalse(false);
        }

        /*
         * Quando a quantidade de meses for igual a 0 e a pontuação do docente
         * for negativa.
         */
        try {
            notaN1 = CalculoNota.calculaN1(ATIVIDADE_DOCENTE_3,
                    MESES_DOCENTE_2, false);
            assertTrue(false);
        } catch (final NumeroNegativoException e) {
            assertFalse(false);
        }

        /*
         * Quando a quantidade de meses for negativa e a pontuação do docente
         * for negativa.
         */
        try {
            notaN1 = CalculoNota.calculaN1(ATIVIDADE_DOCENTE_3,
                    MESES_DOCENTE_3, false);
            assertTrue(false);
        } catch (final NumeroNegativoException e) {
            assertFalse(false);
        }

    }

    @Test
    public void testCalculaNotaParcial() {

        double notaParcial = 0;

        /* Para nota da chefia e corpo discente igual a 10. */

        try {
            notaParcial = CalculoNota.calculaNotaParcial(10, 10, 10);
        } catch (final NumeroNegativoException e) {
            e.printStackTrace();
        }
        assertEquals(10, notaParcial, 0);

        try {
            notaParcial = CalculoNota.calculaNotaParcial(5, 10, 10);
        } catch (final NumeroNegativoException e) {
            e.printStackTrace();
        }
        assertEquals(7, notaParcial, 0);

        try {
            notaParcial = CalculoNota.calculaNotaParcial(0, 10, 10);
        } catch (final NumeroNegativoException e2) {
            e2.printStackTrace();
        }
        assertEquals(4, notaParcial, 0);

        /* Para nota da chefia igual a 10 e discente igual a 5 */

        try {
            notaParcial = CalculoNota.calculaNotaParcial(10, 10, 5);
        } catch (final NumeroNegativoException e) {
            e.printStackTrace();
        }
        assertEquals(9, notaParcial, 0);

        try {
            notaParcial = CalculoNota.calculaNotaParcial(5, 10, 5);
        } catch (final NumeroNegativoException e) {
            e.printStackTrace();
        }
        assertEquals(6, notaParcial, 0);

        try {
            notaParcial = CalculoNota.calculaNotaParcial(0, 10, 5);
        } catch (final NumeroNegativoException e2) {
            e2.printStackTrace();
        }
        assertEquals(3, notaParcial, 0);

        /* Para nota da chefia igual a 10 e discente igual a 0 */

        try {
            notaParcial = CalculoNota.calculaNotaParcial(10, 10, 0);
        } catch (final NumeroNegativoException e) {
            e.printStackTrace();
        }
        assertEquals(8, notaParcial, 0);

        try {
            notaParcial = CalculoNota.calculaNotaParcial(5, 10, 0);
        } catch (final NumeroNegativoException e) {
            e.printStackTrace();
        }
        assertEquals(5, notaParcial, 0);

        try {
            notaParcial = CalculoNota.calculaNotaParcial(0, 10, 0);
        } catch (final NumeroNegativoException e2) {
            e2.printStackTrace();
        }
        assertEquals(2, notaParcial, 0);

        /* Para nota da chefia igual a 5 e discente igual a 10 */

        try {
            notaParcial = CalculoNota.calculaNotaParcial(10, 5, 10);
        } catch (final NumeroNegativoException e) {
            e.printStackTrace();
        }
        assertEquals(9, notaParcial, 0);

        try {
            notaParcial = CalculoNota.calculaNotaParcial(5, 5, 10);
        } catch (final NumeroNegativoException e) {
            e.printStackTrace();
        }
        assertEquals(6, notaParcial, 0);

        try {
            notaParcial = CalculoNota.calculaNotaParcial(0, 5, 10);
        } catch (final NumeroNegativoException e2) {
            e2.printStackTrace();
        }
        assertEquals(3, notaParcial, 0);

        /* Para nota da chefia igual a 5 e discente igual a 5 */

        try {
            notaParcial = CalculoNota.calculaNotaParcial(10, 5, 5);
        } catch (final NumeroNegativoException e) {
            e.printStackTrace();
        }
        assertEquals(8, notaParcial, 0);

        try {
            notaParcial = CalculoNota.calculaNotaParcial(5, 5, 5);
        } catch (final NumeroNegativoException e) {
            e.printStackTrace();
        }
        assertEquals(5, notaParcial, 0);

        try {
            notaParcial = CalculoNota.calculaNotaParcial(0, 5, 5);
        } catch (final NumeroNegativoException e2) {
            e2.printStackTrace();
        }
        assertEquals(2, notaParcial, 0);

        /* Para nota da chefia igual a 5 e discente igual a 0 */

        try {
            notaParcial = CalculoNota.calculaNotaParcial(10, 5, 0);
        } catch (final NumeroNegativoException e) {
            e.printStackTrace();
        }
        assertEquals(7, notaParcial, 0);

        try {
            notaParcial = CalculoNota.calculaNotaParcial(5, 5, 0);
        } catch (final NumeroNegativoException e) {
            e.printStackTrace();
        }
        assertEquals(4, notaParcial, 0);

        try {
            notaParcial = CalculoNota.calculaNotaParcial(0, 5, 0);
        } catch (final NumeroNegativoException e2) {
            e2.printStackTrace();
        }
        assertEquals(1, notaParcial, 0);

        /* Para nota da chefia igual a 0 e discente igual a 0 */

        try {
            notaParcial = CalculoNota.calculaNotaParcial(10, 0, 0);
        } catch (final NumeroNegativoException e) {
            e.printStackTrace();
        }
        assertEquals(6, notaParcial, 0);

        try {
            notaParcial = CalculoNota.calculaNotaParcial(5, 0, 0);
        } catch (final NumeroNegativoException e) {
            e.printStackTrace();
        }
        assertEquals(3, notaParcial, 0);

        try {
            notaParcial = CalculoNota.calculaNotaParcial(0, 0, 0);
        } catch (final NumeroNegativoException e2) {
            e2.printStackTrace();
        }
        assertEquals(0, notaParcial, 0);

        /* Para nota da chefia igual a 5 e discente igual a 0 */

        try {
            notaParcial = CalculoNota.calculaNotaParcial(10, 5, 0);
        } catch (final NumeroNegativoException e) {
            e.printStackTrace();
        }
        assertEquals(7, notaParcial, 0);

        try {
            notaParcial = CalculoNota.calculaNotaParcial(5, 5, 0);
        } catch (final NumeroNegativoException e) {
            e.printStackTrace();
        }
        assertEquals(4, notaParcial, 0);

        try {
            notaParcial = CalculoNota.calculaNotaParcial(0, 5, 0);
        } catch (final NumeroNegativoException e2) {
            e2.printStackTrace();
        }
        assertEquals(1, notaParcial, 0);

        /* Para nota da chefia igual a 10 e discente igual a 0 */

        try {
            notaParcial = CalculoNota.calculaNotaParcial(10, 10, 0);
        } catch (final NumeroNegativoException e) {
            e.printStackTrace();
        }
        assertEquals(8, notaParcial, 0);

        try {
            notaParcial = CalculoNota.calculaNotaParcial(5, 10, 0);
        } catch (final NumeroNegativoException e) {
            e.printStackTrace();
        }
        assertEquals(5, notaParcial, 0);

        try {
            notaParcial = CalculoNota.calculaNotaParcial(0, 10, 0);
        } catch (final NumeroNegativoException e2) {
            e2.printStackTrace();
        }
        assertEquals(2, notaParcial, 0);

        /* Abaixo segue os casos que deverá lançar uma exceção. */

        try {
            notaParcial = CalculoNota.calculaNotaParcial(10, 10,
                    NOTA_DISCENTE_NEGATIVA);
            assertTrue(false);
        } catch (final NumeroNegativoException e2) {
            assertFalse(false);
        }

        try {
            notaParcial = CalculoNota.calculaNotaParcial(10,
                    NOTA_DIRETORIA_NEGATIVA, 10);
            assertTrue(false);
        } catch (final NumeroNegativoException e2) {
            assertFalse(false);
        }

        try {
            notaParcial = CalculoNota.calculaNotaParcial(10,
                    NOTA_DIRETORIA_NEGATIVA, NOTA_DISCENTE_NEGATIVA);
            assertTrue(false);
        } catch (final NumeroNegativoException e2) {
            assertFalse(false);
        }

        try {
            notaParcial = CalculoNota.calculaNotaParcial(10, 0,
                    NOTA_DISCENTE_NEGATIVA);
            assertTrue(false);
        } catch (final NumeroNegativoException e2) {
            assertFalse(false);
        }

        try {
            notaParcial = CalculoNota.calculaNotaParcial(10,
                    NOTA_DIRETORIA_NEGATIVA, 0);
            assertTrue(false);
        } catch (final NumeroNegativoException e2) {
            assertFalse(false);
        }
    }

}
