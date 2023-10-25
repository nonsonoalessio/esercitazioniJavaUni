package Exceptions;

@SuppressWarnings("FieldMayBeFinal")
public class EmptyStackException extends StackException {
    public EmptyStackException(){}

    public EmptyStackException(String message){
        super(message);
    }
}
