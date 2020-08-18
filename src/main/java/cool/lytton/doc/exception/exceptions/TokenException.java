package cool.lytton.doc.exception.exceptions;

public class TokenException extends RuntimeException {
    private String msg;

    public TokenException() {
        super();
    }

    public TokenException(String msg) {
        super(msg);
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        return msg;
    }



}
