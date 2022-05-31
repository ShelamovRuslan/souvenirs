import java.util.Scanner;

public class Console {


    public String in (String massage) {
       return scanner(massage);
    }

    private String scanner (String massage) {
        while (true) {
            System.out.println(massage);
            String command = new Scanner(System.in).nextLine();
            if (command.equals("") || command == null) {
                System.out.println("Вы ничего не ввели, попробуйте еще раз!");
            } else {
                return command;
            }
        }
    }
}
