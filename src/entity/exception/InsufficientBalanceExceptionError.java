package entity.exception;

public class InsufficientBalanceExceptionError extends RuntimeException{

    public InsufficientBalanceExceptionError(){
        super();
    }
    public InsufficientBalanceExceptionError(String msg){
        super(msg);
    }
}
