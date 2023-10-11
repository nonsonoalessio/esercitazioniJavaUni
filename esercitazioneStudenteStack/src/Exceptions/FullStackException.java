package Exceptions;

@SuppressWarnings("FieldMayBeFinal")
public class FullStackException extends StackException {
    public FullStackException(){}

    public FullStackException(String message){
        super(message);
    }
}
