package org.example;

public class Main {
    public static void main(String[] args) throws Exception {

        Catalog catalog = new Catalog("My documents");
        Document book = new Document("1");
        book.setName("Carte");
        book.addTag("Author", "Creanga");
        book.addTag("publishingDate", "1 august 1877");
        Document article = new Document("2");
        article.setName("Article");
        article.addTag("Author", "Walker");
        article.addTag("Year", 2023);
        //catalog.add(book);
        //catalog.add(article);
        //System.out.println(catalog);
        //CatalogUtil.save(catalog, "./catalog.json");
        //System.out.println(CatalogUtil.load("./catalog.json"));

        Command addCommand = new AddCommand(catalog, book, article);
        Command listCommand = new ListCommand(catalog);

        addCommand.execute();
        listCommand.execute();
    }
}