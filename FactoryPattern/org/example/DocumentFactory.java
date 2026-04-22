package org.example;

import java.util.Map;

public class DocumentFactory {
    private static final Map<String, String> EXTENSION_MAP = Map.of(
        ".pdf", "PDF", ".doc", "WORD", ".docx", "WORD",
        ".xls", "EXCEL", ".xlsx", "EXCEL", ".csv", "EXCEL"
    );

    public static Document createDocument(String documentName) {
        String ext = getExtension(documentName);
        String type = EXTENSION_MAP.get(ext);
        if (type == null) throw new IllegalArgumentException("Unsupported document type: " + ext);

        return switch (type) {
            case "PDF" -> new PdfDocument(documentName);
            case "WORD" -> new WordDocument(documentName);
            case "EXCEL" -> new ExcelDocument(documentName);
            default -> throw new IllegalArgumentException("Unsupported type: " + type);
        };
    }

    private static String getExtension(String fileName) {
        int index = fileName.lastIndexOf(".");
        if (index == -1) throw new IllegalArgumentException("No file extension found: " + fileName);
        return fileName.substring(index).toLowerCase();
    }
}
