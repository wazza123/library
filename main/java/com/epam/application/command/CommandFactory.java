package com.epam.application.command;


import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private Map<CommandType,Command> commands;
    private static CommandFactory commandFactory = new CommandFactory();

    private CommandFactory() {

        commands = new HashMap<CommandType, Command>();
        commands.put(CommandType.BOOK_LIST, new BookListCommand());
        commands.put(CommandType.BOOK_INFO, new BookInfoCommand());
    }

    public static CommandFactory getFactory() {

        return commandFactory;
    }

    public Command getCommand(CommandType command) {

        return commands.get(command);
    }

    public Command getCommand(String command) {

        return commands.get(CommandType.valueOf(command.toUpperCase()));
    }


    public enum CommandType{BOOK_LIST,BOOK_INFO}
}
