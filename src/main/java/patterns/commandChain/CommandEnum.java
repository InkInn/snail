package patterns.commandChain;

import java.util.ArrayList;
import java.util.List;

public enum CommandEnum {

    ls("patterns.commandChain.LSCommand"),

    df("patterns.commandChain.DFCommand");

    private String value = "";

    private CommandEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static List<String> getNames() {
        CommandEnum[] commandEnums = CommandEnum.values();
        List<String> names = new ArrayList<>();
        for (CommandEnum commandEnum : commandEnums) {
            names.add(commandEnum.name());
        }
        return names;
    }
}
