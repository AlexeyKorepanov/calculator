import java.util.Stack;

public class Parsing {

    public static String getFormulaRPN (String enteredExample){
        String example = enteredExample.replace("(-", "(0-");
        String formulaRPN = "";
        Stack<Character> temporaryStorage = new Stack<>();

        for (char symbol : example.toCharArray() ) {

            if(Character.isDigit(symbol) || symbol == '.'){
                formulaRPN += symbol;
                continue;
            }

            if(MathematicalSigns.useSigns.containsKey(symbol)){
                formulaRPN += " ";
            }

            if(!temporaryStorage.empty()){
                if(symbol == '('){
                    temporaryStorage.push(symbol);
                    continue;
                }
                if(symbol == ')'){
                    while (temporaryStorage.peek() != '('){
                        formulaRPN += temporaryStorage.pop();
                    }
                    temporaryStorage.pop();
                    continue;
                }

                if(MathematicalSigns.getPriority(symbol) > MathematicalSigns.getPriority(temporaryStorage.peek())){
                    temporaryStorage.push(symbol);
                    continue;
                } else {
                    while (!temporaryStorage.empty()
                            && MathematicalSigns.getPriority(temporaryStorage.peek()) >= MathematicalSigns.getPriority(symbol)){
                        formulaRPN += temporaryStorage.pop();
                    }
                    temporaryStorage.push(symbol);
                    continue;
                }
            }
            temporaryStorage.push(symbol);
        }
        while (!temporaryStorage.empty()){
            formulaRPN += temporaryStorage.pop();
        }
        return formulaRPN ;
    }

}
