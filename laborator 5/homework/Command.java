package org.example;
public abstract class Command {
    protected Document item;
    protected Catalog catalog;
    public Command(Document item, Catalog catalog) {
        this.item = item;
        this.catalog = catalog;
    }
    public Command(){}
    public Command(Document item) {
        this.item = item;
    }
    public Command(Catalog catalog) {
        this.catalog = catalog;
    }

    public void setItem(Document item) {
        this.item = item;
    }
    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public Document getItem() {
        return item;
    }
    public Catalog getCatalog() {
        return catalog;
    }

    public abstract void execute() throws Exception;
}