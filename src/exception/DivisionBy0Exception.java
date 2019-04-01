package exception;


public class DivisionBy0Exception extends Exception {
 
    private static final long serialVersionUID = 1L;
 
    public DivisionBy0Exception() {
        super("Division By 0... ");
    }
}