import java.util.Stack;

public class Parsing {

    public static String getFormulaRPN (String enteredExample){
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
                    while (temporaryStorage.peek() != '('){
                        formulaRPN.append(temporaryStorage.pop());
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
        System.out.println(formulaRPN);
        return formulaRPN.toString();
    }

}
