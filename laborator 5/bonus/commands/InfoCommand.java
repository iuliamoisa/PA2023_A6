package org.example.commands;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.txt.TXTParser;
import org.apache.tika.sax.BodyContentHandler;
import org.example.Catalog;
import org.example.Document;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class InfoCommand extends Command {
    private Catalog catalog;

    public InfoCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void execute() throws IOException, TikaException{
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        ParseContext parseContext = new ParseContext();
        FileInputStream inputStream = new FileInputStream(new File("C:\\Users\\iulia\\Desktop\\PA_lab\\laborator5\\catalog.json"));
        TXTParser parser = new TXTParser();
        for (Document doc : catalog.getDocuments()) {
            System.out.println("Extracting metadata from " + doc.getName());
            try {
                parser.parse(inputStream, handler, metadata, parseContext);
            } catch (SAXException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Content of: " + handler.toString());
            System.out.println("Metadata: ");
            for (String name : metadata.names()) {
                System.out.println(name + ":" + metadata.get(name));
            }
        }
    }
}
