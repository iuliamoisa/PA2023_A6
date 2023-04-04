package org.example.commands;

import org.example.Catalog;
import org.example.CatalogUtil;

import java.io.IOException;

public class SaveCommand extends Command {
    private Catalog catalog;
    private String location;
    @Override
    public void execute() {
        try{
            CatalogUtil.save(catalog, location);
        } catch (IOException exception){
            System.err.println(catalog.getName() + "couldn't be saved in the location specified: " + location);
        }
    }
}
