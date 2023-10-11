package Exceptions;

@SuppressWarnings("FieldMayBeFinal")
public class StackException extends Exception {
    public StackException(){}

    public StackException(String message){
        super(message);
    }
}
