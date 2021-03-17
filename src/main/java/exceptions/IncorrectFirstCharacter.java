package exceptions;

public class IncorrectFirstCharacter extends Throwable {
    public IncorrectFirstCharacter(String massage) {
        super(massage);
    }
}
