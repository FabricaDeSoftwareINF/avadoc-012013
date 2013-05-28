/**
 * Sistema de Avaliação do Docente - SAD
 */
package br.ufg.inf.fs.exception;

/**
 * Exceção lançada caso algum número negativo seja inserido no cálculo das
 * notas parciais ou finais de estágio probatório ou progressão horizontal.
 * @see Exception
 * @author Rogério Tristão Junior
 * @version 1.0
 * @since 1.0
 */
public final class NumeroNegativoException extends Exception {

    /** Serial da exceção. */
    private static final long serialVersionUID = -3670949586266298144L;

    /**
     * Construtor para chamada ao construtor pai.
     */
    public NumeroNegativoException() {
        super("Número negativo não é suportado para esse tipo de cálculo");
    }

}