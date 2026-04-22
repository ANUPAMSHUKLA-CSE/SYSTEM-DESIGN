package org.example;

public class PdfDocument implements Document {
    private final String documentName;

    public PdfDocument(String documentName) {
        this.documentName = documentName;
    }

    @Override
    public void process() {
        System.out.println("Processing PDF document..... " + documentName);
    }
}
