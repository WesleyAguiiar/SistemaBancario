package exceptions;

public class SaldoInsuficienteException extends RuntimeException {
    public SaldoInsuficienteException(String message) {
        super("\nErro: Saldo insuficiente. O seu saldo atual é de R$ " + message + "\n");
    }
}
