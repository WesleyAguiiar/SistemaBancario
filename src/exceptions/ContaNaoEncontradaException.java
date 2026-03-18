package exceptions;

public class ContaNaoEncontradaException extends RuntimeException {
    public ContaNaoEncontradaException(int numeroConta)
    {
        super("\nErro: A conta de nº " + numeroConta + " não foi encontrada!\n");
    }
}
