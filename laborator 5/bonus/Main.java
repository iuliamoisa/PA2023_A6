package org.example;
import com.github.javafaker.Faker;
import org.example.commands.*;
import org.example.errors.DuplicateDocumentException;
import org.jgrapht.Graph;
import org.jgrapht.alg.color.GreedyColoring;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import java.util.stream.IntStream;
public class Main {
    public static void main(String[] args) throws Exception, DuplicateDocumentException {

        Catalog catalog = new Catalog("Iulia's catalog");
        Document book = new Document("1", "Harap Alb", "C:\\Users\\iulia\\Desktop\\PA_lab\\laborator5\\doc1.txt");
        book.addTag("Author", "Creanga");
        book.addTag("publishingDate", "1 august 1877");
        Document book2 = new Document("3", "Alta carte", "C:\\Users\\iulia\\Desktop\\PA_lab\\laborator5\\doc3.txt");
        book2.addTag("Author", "Eu");
        book2.addTag("publishingDate", "2 aprilie 2023");

        Document article = new Document("2", "On sleep","C:\\Users\\iulia\\Desktop\\PA_lab\\laborator5\\doc2.txt");
        article.addTag("Author", "Walker");
        article.addTag("Year", 2023);
        Document article2 = new Document("4", "Being a scientist","C:\\Users\\iulia\\Desktop\\PA_lab\\laborator5\\doc4.txt");
        article2.addTag("Author", "Walker");
        article2.addTag("Year", 2022);

        //CatalogUtil.save(catalog, "./catalog.json");
        //System.out.println(CatalogUtil.load("./catalog.json"));

        Command addCommand = new AddCommand(catalog, book, article, book2, article2);
        Command listCommand = new ListCommand(catalog);
        Command reportCommand = new ReportCommand(catalog, "src/main/resources/report.html");
        Command infoCommand = new InfoCommand(catalog);

        addCommand.execute();
        listCommand.execute();
        reportCommand.execute();

        infoCommand.execute();

        System.out.println();
        Faker faker = new Faker();
        var docs = IntStream.rangeClosed(0,500)
                .mapToObj(i -> new Document("0" + i, "Document"+i ))
                .toArray(Document[]::new);
        Catalog catalog2 = new Catalog("Dogs");
        for(Document doc : docs){
            doc.addTag("Dog", faker.dog().name());
            catalog2.add(doc);
        }
        var listOfDocuments = catalog2.getDocuments();
        Graph<String, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);
        for(Document doc : listOfDocuments)
            graph.addVertex(doc.getName());

        for(Document doc1 : listOfDocuments)
            for(Document doc2 : listOfDocuments)
                if(doc1.getName() != doc2.getName())
                    if(catalog.checkIfRelated(doc1, doc2) == 1)
                        graph.addEdge(doc1.getName(), doc2.getName());

        long runTime = System.currentTimeMillis();
        GreedyColoring<String, DefaultEdge> v = new GreedyColoring(graph);
        System.out.println(v.getColoring());
        System.out.println(System.currentTimeMillis()-runTime + "ms");
        System.out.println(listOfDocuments);
    }
}