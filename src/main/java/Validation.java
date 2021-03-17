import exceptions.DuplicateMathematicalSymbol;
import exceptions.EmptyString;
import exceptions.IncorrectFirstCharacter;
import exceptions.InvalidCharacter;


public class Validation {


    public static void checkingFormula (String example) throws IncorrectFirstCharacter,
            DuplicateMathematicalSymbol, InvalidCharacter, EmptyString {
        if (example.isEmpty()){
            throw new EmptyString("Нет данных для вычеслений");
        }
        for (int i = 0; i<example.length(); i++){

            if(Character.isDigit(example.charAt(i))) continue;

            if(!Character.isDigit(example.charAt(0)) && example.charAt(0) != '('){
               throw new IncorrectFirstCharacter("Пример должен начинаться с цифры");
            }
            if(!MathematicalSigns.useSigns.containsKey(example.charAt(i)))
                 throw new InvalidCharacter("Допускаются только цифры и математические знаки");

            if(i < example.length() - 1
                    && MathematicalSigns.useSigns.containsKey(example.charAt(i))
                    && MathematicalSigns.useSigns.containsKey(example.charAt(i+1))){
                if(MathematicalSigns.getPriority(example.charAt(i)) >= 1
                        && MathematicalSigns.getPriority(example.charAt(i+1)) >= 1){
                    throw new DuplicateMathematicalSymbol("Пропущенна цифра или лишний математический знак");
                }
            }
        }
    }
}
