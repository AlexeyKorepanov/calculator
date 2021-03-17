import java.util.Scanner;

public class Console {


    public static String outConsole(){
        Scanner scanner = new Scanner(System.in) ;
        String example = scanner.nextLine();
        scanner.close();
        return example ;
    }

    public static void start(){
        System.out.println("Введите пример!");
    }

    public static void finish(Double result) {
        System.out.print("Результат вычеслений : ");
        System.out.println(result);
    }
}
