package org.example;

import org.example.errors.DuplicateDocumentException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Catalog implements Serializable {
    private String name;
    private List<Document> documents = new ArrayList<>();
    Catalog(){}
    public Catalog(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public void add(Document doc) throws DuplicateDocumentException {
        if (documents.contains(doc))
            throw new DuplicateDocumentException(doc.getId(), name);
        documents.add(doc);
    }
    public Document findById(String id) {
        return documents.stream()
                .filter(d -> d.getId().equals(id)).findFirst().orElse(null);
    }
    public int checkIfRelated(Document doc1, Document doc2){
        Map<String, Object> tag1 = doc1.getTags();
        Map<String, Object> tag2 = doc2.getTags();
        for(Map.Entry<String, Object> i : tag1.entrySet())
            if(tag2.containsKey(i.getKey()))
                if(i.getValue().equals(tag2.get(i.getKey())))
                    return 1;
        return 0;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", documents=" + documents +
                '}';
    }
}
