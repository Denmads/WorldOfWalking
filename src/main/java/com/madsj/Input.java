package com.madsj;

import com.madsj.exception.MalformedCommandException;
import com.madsj.exception.UnknownCommandException;
import com.madsj.exception.WrongNumberOfArgumentsException;

import java.util.*;

/**
 * Possible commands
 *
 * HELP
 * LIST <"Commands"/"Zones"/"Exits"/"Items">    //Items (in room)
 * GOTO <Zone/Room>
 * INSPECT <"Room"/"Zone"/Storage>
 * USE <Item>    //from backpack
 * USE <Item> ON <Object>    //from backpack
 * QUIT
 */

public class Input {
    private Input() {}

    private static final Scanner userInput = new Scanner(System.in);
    private static final String inputChar = ">";

    public static Command nextCommand() throws UnknownCommandException, WrongNumberOfArgumentsException, MalformedCommandException {
        System.out.print(inputChar + " ");
        String rawTxt = userInput.nextLine();
        String[] tokens = rawTxt.split(" ");
        return parseCommand(tokens);
    }

    private static Command parseCommand(String[] tokens) throws UnknownCommandException, WrongNumberOfArgumentsException, MalformedCommandException {
        String operator = tokens[0].toLowerCase();
        switch (operator) {
            case Command.LIST:
            case Command.GOTO:
            case Command.INSPECT:
                return parseDefault(operator, tokens);
            case Command.USE:
                return parseUse(operator, tokens);
            case Command.HELP:
            case Command.QUIT:
                return new Command(operator);
        }
        throw new UnknownCommandException(operator);
    }


    private static Command parseDefault(String operator, String[] tokens) throws MalformedCommandException {
        if (tokens.length <= 1) {
            throw new MalformedCommandException(operator, "Arguments", "None");
        }

        String[] arguments = Arrays.copyOfRange(tokens, 1, tokens.length);
        return new Command(operator, Arrays.asList(arguments));
    }

    private static Command parseUse(String operator, String[] tokens) throws WrongNumberOfArgumentsException, MalformedCommandException {
        List<String> arguments = null;
        String mod = null;
        if (tokens.length == 2) {
            arguments = Collections.singletonList(tokens[1]);
        }
        else if (tokens.length == 4) {
            if (!tokens[2].equalsIgnoreCase("on")) {
                throw new MalformedCommandException(operator, "on", tokens[2].toLowerCase());
            }
            arguments = Arrays.asList(tokens[1], tokens[3]);
            mod = "on";
        }
        else {
            throw new WrongNumberOfArgumentsException(operator, "2 or 4", ""+(tokens.length-1));
        }
        return new Command(operator, arguments, mod);
    }
}
