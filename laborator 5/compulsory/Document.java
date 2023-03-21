package org.example;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Document implements Serializable {
    private String id = new String();
    private String name = new String();
    private String location;
    private Map<String, Object> tags = new HashMap<>();
    Document(){}
    public Document(String id){
        this.id = id;
    }
    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setTags(Map<String, Object> tags) {
        this.tags = tags;
    }

    public Map<String, Object> getTags() {
        return tags;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", tags=" + tags +
                '}';
    }
}
