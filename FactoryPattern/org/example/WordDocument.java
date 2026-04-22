package org.example;

public class WordDocument implements Document{
    private final String documentName;
    public WordDocument(String documentName) {
        this.documentName = documentName;
    }

    @Override
    public void process() {
        System.out.println("Processing Word document....."+documentName);
    }
}
