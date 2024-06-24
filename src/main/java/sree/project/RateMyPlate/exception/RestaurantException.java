package sree.project.RateMyPlate.exception;



public class RestaurantException extends RuntimeException{
    private final ErrorCode errorCode;
    public RestaurantException(ErrorCode errorCode, String message){
        super(message);
        this.errorCode = errorCode;
    }
    public ErrorCode getErrorCode(){
        return errorCode;
    }
    public enum ErrorCode{
        DUPLICATE_RESTAURANT,
        RESTAURANT_NOT_FOUND,
        RESTAURANT_GENERAL_ERROR

    }

}
