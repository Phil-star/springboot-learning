package top.philxin.exception;

public class UnknownAccountException extends Exception {

    private String errorMsg;

    public UnknownAccountException(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
