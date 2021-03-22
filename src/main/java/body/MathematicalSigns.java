package body;

import exceptions.DivisionByZero;


import java.util.HashMap;

public class MathematicalSigns {

    public static HashMap<Character,Integer> useSigns = new HashMap<>();

    public static void useMathematicalSignsWithPriority(){
        useSigns.put('.', -1);
        useSigns.put('(', -1);
        useSigns.put(')', -1);
        useSigns.put('-', 1);
        useSigns.put('+', 1);
        useSigns.put('*', 2);
        useSigns.put('/', 2);
        useSigns.put('^', 3); //добавление нового знака
    }

    public static Integer getPriority(char sign){
        return useSigns.get(sign);
    }

    public static Double calculateValue (double firstNumber, double secondNumber, char signs) throws DivisionByZero {
        double resultValue = 0.;
        if(signs == '-') resultValue = firstNumber - secondNumber ;
        if(signs == '+') resultValue = firstNumber + secondNumber ;
        if(signs == '*') resultValue = firstNumber * secondNumber ;
        if(signs == '/'){
            if(secondNumber != 0)resultValue = firstNumber / secondNumber ;
            else throw new DivisionByZero("Не допустимое выражение (деление на ноль).");
        }
        if(signs == '^') resultValue = Math.pow(firstNumber,secondNumber) ; // добавление нового знака
        return resultValue;
    }
}
