import controller.RulesController;
import helpers.ConsoleColorHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static constants.Messages.*;
import static helpers.ConsoleColorHelper.GREEN_UNDERLINED;
import static helpers.ConsoleColorHelper.RED;

public class Main {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        start();
    }

    private static void start() throws IOException {
        RulesController rules = new RulesController();
        boolean ok = true;
        while (ok) {
            showMenu();

            String option = reader.readLine();
            switch (option) {
                case "1":
                    rules.addNewRule();
                    break;
                case "2":
                    rules.manageRules();
                    break;
                case "3":
                    ok = false;
                    System.out.println("Bye!");
                    break;
                default:
                    rules.errorMessage();
                    break;
            }
        }
    }

    private static void showMenu() {
        System.out.println(SEPARATOR);
        ConsoleColorHelper.consoleColorized(CHOOSE_OPTION, GREEN_UNDERLINED);
        System.out.println("1- Add new Rule");
        System.out.println("2- Manage payment");
        ConsoleColorHelper.consoleColorized("3- Exit", RED);
        System.out.println(SEPARATOR);
        System.out.print(OPTION);
    }
}
