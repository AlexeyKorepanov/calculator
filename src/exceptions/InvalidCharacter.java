package exceptions;

public class InvalidCharacter extends Throwable {
    public InvalidCharacter(String massage) {
        super(massage);
    }
}
