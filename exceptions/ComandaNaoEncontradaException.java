package exceptions;

public class ComandaNaoEncontradaException extends Exception {
    public ComandaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}