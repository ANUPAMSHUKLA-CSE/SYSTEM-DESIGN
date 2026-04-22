package org.example;

public class ExcelDocument  implements  Document {

    private final String documentName;
    public ExcelDocument(String documentName) {
        this.documentName = documentName;
    }
    @Override
    public void process() {
        System.out.println("Processing Excel document....."+documentName);
    }
}
