import exceptions.DivisionByZero;
import exceptions.InvalidCharacter;

import java.util.Stack;

public class Calculation {

    public static Double calculateFormulaRPN (String formulaRPN) throws DivisionByZero, InvalidCharacter {
        Stack<Double> answer = new Stack<>();
        StringBuilder digit = new StringBuilder();

        for (int i = 0 ; i < formulaRPN.length(); i++) {
            if(Character.isDigit(formulaRPN.charAt(i))){
                try{ while (Character.isDigit(formulaRPN.charAt(i)) || formulaRPN.charAt(i) == '.') {
                    digit.append(formulaRPN.charAt(i));
                    i++;
                }
                   } catch (Exception e){
                       try {
                           return Double.parseDouble(digit.toString());
                       } catch (Exception exceptionNumber){
                           throw new InvalidCharacter("Неверная запись числа");
                       }
                   }
                answer.push(Double.parseDouble(digit.toString()));
                digit = new StringBuilder();
                i--;
                continue;
            }

            if(formulaRPN.charAt(i) == ' ') continue;

            try {
                double secondNumber = answer.pop(), firstNumber = answer.pop();
                answer.push(MathematicalSigns.calculateValue(firstNumber, secondNumber, formulaRPN.charAt(i)));
            } catch (Exception insufficientData){
                throw new InvalidCharacter("Недостаточно данных для вычисления") ;
            }

        }
        return answer.pop() ;
    }

}
