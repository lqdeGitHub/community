package life.lq.kingcommunity.exception;

public enum CustomizeErrorCode implements  ICustomizeErrorCode {

    QUSETION_NOT_FOUND("你找的问题去了外星球");
    private  String message;

    CustomizeErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
