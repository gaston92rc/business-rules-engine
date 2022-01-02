import entities.Rule;
import entities.Rules;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class Main_Test {

    @Test
    public void new_rule_test() {
        List<Rule> rules = Rules.getRules();
        Rule newRule = Rule.builder().rule("New rule").action("New action").build();
        Rules.addRule(newRule);
        assertTrue(rules.stream().anyMatch(rule -> rule.equals(newRule)));
    }

    @Test
    public void exist_rule_test() {
        List<Rule> rules = Rules.getRules();
        String name = "An upgrade to a membership";
        String action = "Apply the upgrade.";
        boolean condition = rules
                .stream()
                .anyMatch(rule -> rule.getRule().equals(name) && rule.getAction().equals(action));

        assertTrue(condition);
    }
    
}
