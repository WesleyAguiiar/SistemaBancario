package exceptions;

public class ContaNaoEncontradaException extends RuntimeException {

    /**

     Os conceitos de exceptions ainda estão em fase de aprendizado,
     em breve irei implementar excessões personalizadas.

    **/
    public ContaNaoEncontradaException(String message)
    {
        super("A conta: " + message + " não foi encontrada!");
    }
}
