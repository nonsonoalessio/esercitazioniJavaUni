package groupxx;

public class BadArgumentsForSensorTypeException extends RuntimeException {
    public BadArgumentsForSensorTypeException(){
        super();
    }
    public BadArgumentsForSensorTypeException(String errorMessage){
        super(errorMessage);
    }

}
