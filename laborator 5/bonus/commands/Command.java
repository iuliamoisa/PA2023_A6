package org.example.commands;
public abstract class Command {
    private String name;
    private String path;
    Command(){}
    public Command(String name, String path){
        this.name = name;
        this.path = path;
    }

    public abstract void execute() throws Exception;
}