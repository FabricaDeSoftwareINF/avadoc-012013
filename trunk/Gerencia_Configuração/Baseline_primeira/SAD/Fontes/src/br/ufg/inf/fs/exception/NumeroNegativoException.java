/**
 * Sistema de Avalia��o do Docente - SAD
 */
package br.ufg.inf.fs.exception;

/**
 * Exce��o lan�ada caso algum n�mero negativo seja inserido no c�lculo das
 * notas parciais ou finais de est�gio probat�rio ou progress�o horizontal.
 * @see Exception
 * @author Rog�rio Trist�o Junior
 * @version 1.0
 * @since 1.0
 */
public final class NumeroNegativoException extends Exception {

    /** Serial da exce��o. */
    private static final long serialVersionUID = -3670949586266298144L;

    /**
     * Construtor para chamada ao construtor pai.
     */
    public NumeroNegativoException() {
        super("N�mero negativo n�o � suportado para esse tipo de c�lculo");
    }

}