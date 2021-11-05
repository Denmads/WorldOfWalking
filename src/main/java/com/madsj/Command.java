package com.madsj;

import java.util.ArrayList;
import java.util.List;

public class Command {

    public static final String HELP = "help";
    public static final String LIST = "list";
    public static final String GOTO = "goto";
    public static final String INSPECT = "inspect";
    public static final String USE = "use";
    public static final String QUIT = "quit";

    private final String operation;
    private final List<String> arguments;
    private final String modifier;

    public Command(String operation) {
        this(operation, new ArrayList<>());
    }

    public Command(String operation, List<String> arguments) {
        this(operation, arguments, null);
    }

    public Command(String operation, List<String> arguments, String modifier) {
        this.operation = operation;
        this.arguments = arguments;
        this.modifier = modifier;
    }

    public String getOperation() {
        return operation;
    }

    public String getArgument(int i) {
        return arguments.get(i);
    }

    public int numberOfArguments() {
        return arguments.size();
    }

    public String getModifier() {
        return modifier;
    }
}
