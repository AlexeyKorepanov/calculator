package body;

import exceptions.*;

public class Main {

    public static void main(String[] args) throws IncorrectFirstCharacter,
            DuplicateMathematicalSymbol, InvalidCharacter, DivisionByZero, EmptyString {
       MathematicalSigns.useMathematicalSignsWithPriority();
       Console.start();
       String example = Console.outConsole();
       Validation.checkingFormula(example);
       Double result = Calculation.calculateFormulaRPN(Parsing.getFormulaRPN(example));
       Console.finish(result);
    }
}
