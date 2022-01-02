package entities;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Rules {

    private static List<Rule> rules = new ArrayList<Rule>() {{
        add(new Rule("a physical product", "generate a packing slip for shipping."));
        add(new Rule("a book", "create a duplicate packing slip for the royalty department."));
        add(new Rule("a membership", "activate that membership."));
        add(new Rule("an upgrade to a membership", "apply the upgrade."));
        add(new Rule("a membership or upgrade", "e-mail the owner and inform them of the activation/upgrade."));
        add(new Rule("the video “Learning to Ski”", "add a free “First Aid” video to the packing slip (the result of a court decision in 1997)."));
        add(new Rule("a physical product or a book", "generate a commission payment to the agent."));
    }};

    public static List<Rule> getRules() {
        return rules;
    }

    public static void addRule(Rule rule) {
        rules.add(rule);
    }

}
