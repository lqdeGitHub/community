package life.lq.kingcommunity.exception;

public class CustomizeException extends  RuntimeException {
    private String message;

    public CustomizeException(String message) {
        this.message = message;
    }

    public CustomizeException(ICustomizeErrorCode erroeCode) {
        this.message = erroeCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
