package body;

import exceptions.InvalidCharacter;

import java.util.Stack;

public class Parsing {

    public static String getFormulaRPN (String enteredExample) throws InvalidCharacter {
        String example = enteredExample.replace("(-", "(0-");
        StringBuilder formulaRPN = new StringBuilder();
        Stack<Character> temporaryStorage = new Stack<>();

        for (char symbol : example.toCharArray() ) {

            if(Character.isDigit(symbol) || symbol == '.'){
                formulaRPN.append(symbol);
                continue;
            }

            if(MathematicalSigns.useSigns.containsKey(symbol)){
                formulaRPN.append(" ");
            }

            if(!temporaryStorage.empty()){
                if(symbol == '('){
                    temporaryStorage.push(symbol);
                    continue;
                }
                if(symbol == ')'){
                   try {
                       while (temporaryStorage.peek() != '('){
                           formulaRPN.append(temporaryStorage.pop());
                       }
                   } catch (Exception e){
                       throw new InvalidCharacter("Лишняя закрывающая скобка.");
                   }
                    temporaryStorage.pop();
                    continue;
                }

                if (MathematicalSigns.getPriority(symbol) <= MathematicalSigns.getPriority(temporaryStorage.peek())) {
                    while (!temporaryStorage.empty()
                            && MathematicalSigns.getPriority(temporaryStorage.peek()) >= MathematicalSigns.getPriority(symbol)) {
                        formulaRPN.append(temporaryStorage.pop());
                    }
                }
                temporaryStorage.push(symbol);
                continue;
            }
            temporaryStorage.push(symbol);
        }
        while (!temporaryStorage.empty()){
            formulaRPN.append(temporaryStorage.pop());
        }
       // System.out.println(formulaRPN.toString());
        return formulaRPN.toString();
    }

}
