package entities;

import helpers.StringHelper;
import lombok.Builder;

@Builder
public class Rule {
    private String rule;
    private String action;

    public String getRule() {
        return StringHelper.capitalize(rule);
    }

    public String getAction() {
        return StringHelper.capitalize(action);
    }
}
