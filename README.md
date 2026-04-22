# SYSTEM-DESIGN
Practising
# 🚀 Singleton Pattern Logger

## 🧠 Problem
In a software park with multiple companies and facilities, all modules need to write logs to a **single file (`logger.txt`)**.

If each creates its own logger:
- ❌ Multiple file handles  
- ❌ Data inconsistency  
- ❌ Resource wastage  

---

## ✅ Solution
Implemented **Singleton Pattern (Bill Pugh)** to ensure:

> 🔥 **Only one Logger instance is used across the entire application**

---

## ⚙️ Key Idea

```java
public class Logger {

    private Logger() {}

    private static class Holder {
        private static final Logger INSTANCE = new Logger();
    }

    public static Logger getInstance() {
        return Holder.INSTANCE;
    }
}
```

---

# 🚀 2) Factory Pattern — Document Processing System

## 🧠 Problem
A system needs to process different document types — **PDF, Word, Excel** — each requiring different processing logic.

If the client handles creation directly:
- ❌ Tightly coupled to concrete classes
- ❌ Violates Open/Closed Principle
- ❌ Client must know every document type

---

## ✅ Solution
Implemented **Factory Pattern** with a Map-based registry to ensure:

> 🔥 **Client never knows which concrete class is instantiated — the factory decides based on file extension**

---

## ⚙️ How It Works

```text
User Input → DocumentFactory → Detect Extension → Create Object → process()
```

---

## 📌 Supported Extensions

| Extension | Type | Handler |
|-----------|------|---------|
| `.pdf` | PDF | `PdfDocument` |
| `.doc`, `.docx` | Word | `WordDocument` |
| `.xls`, `.xlsx`, `.csv` | Excel | `ExcelDocument` |

---

## ⚙️ Key Idea

```java
public class DocumentFactory {
    private static final Map<String, String> EXTENSION_MAP = Map.of(
        ".pdf", "PDF", ".doc", "WORD", ".docx", "WORD",
        ".xls", "EXCEL", ".xlsx", "EXCEL", ".csv", "EXCEL"
    );

    public static Document createDocument(String documentName) {
        String ext = getExtension(documentName);
        String type = EXTENSION_MAP.get(ext);
        return switch (type) {
            case "PDF"   -> new PdfDocument(documentName);
            case "WORD"  -> new WordDocument(documentName);
            case "EXCEL" -> new ExcelDocument(documentName);
            default -> throw new IllegalArgumentException("Unsupported");
        };
    }
}
```
