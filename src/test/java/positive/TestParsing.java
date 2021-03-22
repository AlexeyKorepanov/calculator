package positive;

import body.MathematicalSigns;
import body.Parsing;
import exceptions.InvalidCharacter;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestParsing {

    @Before
    public void MathematicalSings(){
        MathematicalSigns.useMathematicalSignsWithPriority();
    }

    @Test
    public void testGetFormulaRPN() throws InvalidCharacter {
        String incomingString = "5*(2+3)-2";
        String outputString = "5  2 3 + *2-";
        assertThat(outputString,equalTo(Parsing.getFormulaRPN(incomingString))) ;
        assertThat("5 2 -3+", equalTo(Parsing.getFormulaRPN("5-2+3")));
    }

    @Test(expected = InvalidCharacter.class)
    public void testGetFormulaRPN_Exception() throws InvalidCharacter {
        Parsing.getFormulaRPN("2+3-(2+1))");
    }
}
