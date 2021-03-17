import exceptions.DivisionByZero;

import java.util.Stack;

public class Calculation {

    public static Double calculateFormulaRPN (String formulaRPN) throws DivisionByZero {
        Stack<Double> answer = new Stack<>();
        String digit = "";

        for (int i = 0 ; i < formulaRPN.length(); i++) {
            if(Character.isDigit(formulaRPN.charAt(i))){
                while (Character.isDigit(formulaRPN.charAt(i)) || formulaRPN.charAt(i) == '.'){
                    digit += formulaRPN.charAt(i);
                    i++;
                }
                answer.push(Double.parseDouble(digit));
                digit = "";
                i--;
                continue;
            }
            if(formulaRPN.charAt(i) == ' ') continue;

            double secondNumber = answer.pop(), firstNumber = answer.pop();
            answer.push(MathematicalSigns.calculateValue(firstNumber, secondNumber, formulaRPN.charAt(i)));
        }
        return answer.pop() ;
    }

}
