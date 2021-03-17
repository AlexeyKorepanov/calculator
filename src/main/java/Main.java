import exceptions.DivisionByZero;
import exceptions.DuplicateMathematicalSymbol;
import exceptions.IncorrectFirstCharacter;
import exceptions.InvalidCharacter;

public class Main {

    public static void main(String[] args) throws IncorrectFirstCharacter, DuplicateMathematicalSymbol, InvalidCharacter, DivisionByZero {
       MathematicalSigns.useMathematicalSignsWithPriority();
       Console.start();
       String example = Console.outConsole();
       Validation.checkingFormula(example);
       Double result = Calculation.calculateFormulaRPN(Parsing.getFormulaRPN(example));
       Console.finish(result);

    }
}
