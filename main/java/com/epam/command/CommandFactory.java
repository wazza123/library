package com.epam.command;


import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private Map<String,Command> commands;

    public CommandFactory() {

        commands = new HashMap<String, Command>();
        commands.put("authorization",new LoginValidationCommand());
    }

    public Command getCommand(String command) {

        return commands.get(command);
    }
}
