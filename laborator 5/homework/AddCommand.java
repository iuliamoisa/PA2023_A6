package org.example;

public class AddCommand extends Command{
    Document[] itemList;
    Catalog catalog;

    public AddCommand(Catalog catalog, Document... items){
        itemList = items;
        this.catalog = catalog;
    }

    public void execute() {
        for(Document item : itemList){
            catalog.getDocuments().add(item);
        }
    }
}
