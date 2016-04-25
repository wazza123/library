package com.epam.application.command;


import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private Map<String,Command> commands;

    public CommandFactory() {

        commands = new HashMap<String, Command>(3);
        commands.put("authorization",new LoginValidationCommand());
        commands.put("logout",new LogOutCommand());
        commands.put("localization",new LocalizationCommand());
    }

    public Command getCommand(String command) {

        return commands.get(command);
    }
}
