package org.example.commands;

import org.example.Catalog;
import org.example.CatalogUtil;

import java.io.IOException;

public class LoadCommand extends Command {
    private Catalog catalog;
    private String location;

    @Override
    public void execute() {
        try{
            Catalog loadedCatalog = CatalogUtil.load(location);
            catalog.setName(loadedCatalog.getName());
            catalog.setDocuments(loadedCatalog.getDocuments());
        }catch (IOException exception){
            System.err.println("Couldn't load catalog from " + location);
        }
    }
}
