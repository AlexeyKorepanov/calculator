package negative;

import body.Calculation;
import body.MathematicalSigns;
import body.Parsing;
import exceptions.DivisionByZero;
import exceptions.InvalidCharacter;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestCalculationNeg {

    @Before
    public void MathematicalSings(){
        MathematicalSigns.useMathematicalSignsWithPriority();
    }

    @Test
    public void testCalculateValue() throws DivisionByZero {
        assertThat(8.0, equalTo(MathematicalSigns.calculateValue(2,3,'+')));
    }

    @Test(expected = DivisionByZero.class)
    public void testCalculationByDivisionByZero() throws DivisionByZero, InvalidCharacter {
        MathematicalSigns.calculateValue(5,1,'/');
        Calculation.calculateFormulaRPN("5 3 + 5 4 -/");
        Calculation.calculateFormulaRPN("5 2 /");
    }

    @Test
    public void testCalculation() throws InvalidCharacter, DivisionByZero {
        String incomingString = "2 3 5 + *3 2 ^-3 1 0.5 -*+";
        double outputDouble = 9.5;
        assertThat(outputDouble, equalTo(Calculation.calculateFormulaRPN(incomingString)));
    }
    @Test
    public void testCalculationWithParsing() throws InvalidCharacter, DivisionByZero {
        String incomingString = "(1.5+3*0.5)^3";
        double outputDouble = 28.0;
        assertThat(outputDouble, equalTo(Calculation.calculateFormulaRPN(Parsing.getFormulaRPN(incomingString))));
    }

}
