package exception;

public class ExpressionMalFormeeException extends Exception {
 
    private static final long serialVersionUID = 1L;
 
    public ExpressionMalFormeeException() {
        super("Expression mal formée ... ");
    }
}
