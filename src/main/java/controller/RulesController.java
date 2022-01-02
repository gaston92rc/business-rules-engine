package controller;

import entities.Rule;
import entities.Rules;
import helpers.ConsoleColorHelper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import static constants.Messages.*;
import static helpers.ConsoleColorHelper.*;

public class RulesController {
    private final static BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public void manageRules() {
        List<Rule> rules = Rules.getRules();
        int option = -1;

        while (option < 0 || option >= rules.size()) {
            try {

                System.out.println(SEPARATOR);
                ConsoleColorHelper.consoleColorized(CHOOSE_OPTION, GREEN_UNDERLINED);
                for (int i = 0; i < rules.size(); i++) {
                    System.out.println(i + "- " + rules.get(i).getRule());
                }
                ConsoleColorHelper.consoleColorized(rules.size() + "- Back", CYAN);
                System.out.println(SEPARATOR);
                System.out.print(OPTION);
                option = Integer.parseInt(READER.readLine());
                if (option == rules.size()) {
                    return;
                }

                String action = rules.get(option).getAction();
                ConsoleColorHelper.consoleColorized("ACTION: " + action, PURPLE_BOLD_BRIGHT);
            } catch (Exception e) {
                errorMessage();
            }
        }
    }


    public void addNewRule() {
        ConsoleColorHelper.consoleColorized("INSERT A NEW RULE", GREEN_UNDERLINED);
        try {
            String action = "";
            String ruleName = "";

            while (ruleName.isEmpty()) {

                System.out.print("Rule: ");
                ruleName = READER.readLine();
                if (ruleName.isEmpty()) {
                    ConsoleColorHelper.consoleColorized("You must enter a rule", RED_BOLD);
                }
            }

            while (action.isEmpty()) {
                System.out.print("Action: ");
                action = READER.readLine();
                if (action.isEmpty()) {
                    ConsoleColorHelper.consoleColorized("You must enter a action", RED_BOLD);
                }
            }

            Rule rule = Rule.builder().rule(ruleName).action(action).build();
            Rules.addRule(rule);
            ConsoleColorHelper.consoleColorized("---> Rule has been created! <---", GREEN_BRIGHT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void errorMessage() {
        ConsoleColorHelper.consoleColorized(INVALID_OPTION, RED_BOLD);
    }
}
