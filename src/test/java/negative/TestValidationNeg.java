package negative;

import body.MathematicalSigns;
import body.Validation;
import exceptions.DuplicateMathematicalSymbol;
import exceptions.EmptyString;
import exceptions.IncorrectFirstCharacter;
import exceptions.InvalidCharacter;
import org.junit.Before;
import org.junit.Test;

public class TestValidationNeg {

    @Before
    public void MathematicalSings(){
        MathematicalSigns.useMathematicalSignsWithPriority();
    }

    @Test(expected = EmptyString.class)
    public void testCheckingFormulaByEmptyString() throws EmptyString, InvalidCharacter,
            DuplicateMathematicalSymbol, IncorrectFirstCharacter {
        Validation.checkingFormula(" ");
    }

    @Test(expected = DuplicateMathematicalSymbol.class)
    public void testCheckingFormulaByDuplicateSymbol() throws EmptyString, InvalidCharacter,
            DuplicateMathematicalSymbol, IncorrectFirstCharacter {
        Validation.checkingFormula("1+3-(2+6)+3");
        Validation.checkingFormula("1+3-(2+6)*8");
    }

    @Test(expected = IncorrectFirstCharacter.class)
    public void testCheckingFormulaByIncorrectFirstCharacter() throws EmptyString, InvalidCharacter,
            DuplicateMathematicalSymbol, IncorrectFirstCharacter {
        Validation.checkingFormula("(-5)+6*8");
        Validation.checkingFormula("5+6*8");
    }

    @Test(expected = InvalidCharacter.class)
    public void testCheckingFormulaByInvalidCharacter() throws EmptyString, InvalidCharacter,
            DuplicateMathematicalSymbol, IncorrectFirstCharacter {
        Validation.checkingFormula("5+6-8");
    }
}
