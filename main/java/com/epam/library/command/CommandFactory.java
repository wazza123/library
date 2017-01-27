package com.epam.library.command;


import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private Map<CommandType,Command> commands;
    private static CommandFactory commandFactory = new CommandFactory();

    private CommandFactory() {

        commands = new HashMap<CommandType, Command>();
        commands.put(CommandType.LOGOUT,new LogOutCommand());
        commands.put(CommandType.BOOK_LIST, new BookListCommand());
        commands.put(CommandType.BOOK_INFO, new BookInfoCommand());
        commands.put(CommandType.FIND_BOOK, new FindBookCommand());
        commands.put(CommandType.AUTHORIZATION, new AuthorizationCommand());
        commands.put(CommandType.REGISTRATION, new RegistrationCommand());
        commands.put(CommandType.DELETE_BOOK, new DeleteBookCommand());
        commands.put(CommandType.ADD_BOOK, new AddBookCommand());
        commands.put(CommandType.WRITER_INFO, new WriterInfoCommand());
        commands.put(CommandType.ADD_WRITER, new AddWriterCommand());
        commands.put(CommandType.FIND_WRITER, new FindWriterCommand());
        commands.put(CommandType.ADD_BOOK_AUTHOR, new AddBookAuthorCommand());
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


    public enum CommandType{AUTHORIZATION,LOGOUT,REGISTRATION,BOOK_LIST,BOOK_INFO,
        FIND_BOOK,DELETE_BOOK, ADD_BOOK, WRITER_INFO, ADD_WRITER, FIND_WRITER, ADD_BOOK_AUTHOR}
}
