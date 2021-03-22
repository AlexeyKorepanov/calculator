package positive;

import body.Calculation;
import body.MathematicalSigns;
import body.Parsing;
import exceptions.DivisionByZero;
import exceptions.InvalidCharacter;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestCalculation {

    @Before
    public void MathematicalSings(){
        MathematicalSigns.useMathematicalSignsWithPriority();
    }

    @Test
    public void testCalculateValue() throws DivisionByZero {
        assertThat(5.0, equalTo(MathematicalSigns.calculateValue(2,3,'+')));
        assertThat(5.0, equalTo(MathematicalSigns.calculateValue(10,5,'-')));
        assertThat(6.0, equalTo(MathematicalSigns.calculateValue(2,3,'*')));
        assertThat(2.0, equalTo(MathematicalSigns.calculateValue(6,3,'/')));
        assertThat(8.0, equalTo(MathematicalSigns.calculateValue(2,3,'^')));
    }

    @Test(expected = DivisionByZero.class)
    public void testCalculationByDivisionByZero() throws DivisionByZero, InvalidCharacter {
        MathematicalSigns.calculateValue(5,0,'/');
        Calculation.calculateFormulaRPN("5 3 + 5 5 -/");
        Calculation.calculateFormulaRPN("5 0 /");
    }

    @Test
    public void testCalculation() throws InvalidCharacter, DivisionByZero {
        String incomingString = "2 3 5 + *3 2 ^-3 1 0.5 -*+";
        double outputDouble = 8.5;
        assertThat(outputDouble, equalTo(Calculation.calculateFormulaRPN(incomingString)));
    }
    @Test
    public void testCalculationWithParsing() throws InvalidCharacter, DivisionByZero {
        String incomingString = "(1.5+3*0.5)^3";
        double outputDouble = 27.0;
        assertThat(outputDouble, equalTo(Calculation.calculateFormulaRPN(Parsing.getFormulaRPN(incomingString))));
    }
    @Test(expected = InvalidCharacter.class)
    public void testCalculationByException() throws InvalidCharacter, DivisionByZero {
        String invalidNumber = "1.3.5";
        String incompleteOperation = "35.5+";
        Calculation.calculateFormulaRPN(Parsing.getFormulaRPN(invalidNumber));
        Calculation.calculateFormulaRPN(Parsing.getFormulaRPN(incompleteOperation));

    }
}
