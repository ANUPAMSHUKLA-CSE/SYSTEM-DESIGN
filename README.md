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

---

# 🚀 3) Builder Pattern — TripForge Travel Package

## 🧠 Problem
A travel booking system needs to create `TravelPackage` objects with **3 mandatory fields** (destination, duration, basePrice) and **4 optional fields** (travel mode, meal plan, adventure activities, insurance).

If we use telescoping constructors:
- ❌ Constructor explosion — 2⁴ = 16 possible combinations
- ❌ Unreadable client code — `new TravelPackage("Goa", 3, 3500, null, "all", null, true)`
- ❌ Easy to mix up parameter order (especially multiple strings/ints)

---

## ✅ Solution
Implemented **Builder Pattern** with a static inner `TravelPackageBuilder` class to ensure:

> 🔥 **Immutable object creation with fluent, readable API — mandatory fields enforced via constructor, optional fields via chained setters**

---

## ⚙️ How It Works

```text
User Input → TravelPackageBuilder(mandatory) → .travelMode() → .mealPlan() → .build() → TravelPackage (immutable)
                                                         ↓
                                               CalculatePrice.calculate() → Itemized Total
```

---

## 📌 Configurable Options

| Option | Values | Price Impact |
|--------|--------|-------------|
| Travel Mode | `bus` / `train` / `plane` | +₹1200 / +₹900 / +₹10000 |
| Meal Plan | `breakfast` / `lunch` / `dinner` / `all` | +₹800 / ₹1200 / ₹1500 / ₹1500 × days |
| Adventure Activities | `Scuba Diving` / `Swimming` / `Camping` | +₹1000 / +₹2000 / +₹500 |
| Travel Insurance | `true` / `false` | +₹2000 |

---

## ⚙️ Key Idea

```java
public class TravelPackage {
    // All fields are private final → immutable
    private final String destination;
    private final int duration;
    private final int basePrice;
    private final String travelMode;       // optional
    private final String mealPlan;         // optional
    private final List<String> adventureActivities; // optional
    private final boolean isTravelInsuranceIncluded; // optional

    private TravelPackage(TravelPackageBuilder builder) { /* copy from builder */ }

    public static class TravelPackageBuilder {
        // Mandatory via constructor
        public TravelPackageBuilder(String destination, int duration, int basePrice) { }

        // Optional via fluent setters
        public TravelPackageBuilder travelMode(String mode) { return this; }
        public TravelPackageBuilder mealPlan(String plan) { return this; }
        public TravelPackageBuilder adventureActivities(List<String> activities) { return this; }
        public TravelPackageBuilder isTravelInsuranceIncluded(boolean ins) { return this; }

        public TravelPackage build() { return new TravelPackage(this); }
    }
}
```

**Usage:**
```java
TravelPackage pkg = new TravelPackage.TravelPackageBuilder("Goa", 3, 3500)
        .travelMode("bus")
        .mealPlan("all")
        .adventureActivities(Arrays.asList("Scuba Diving", "Camping"))
        .isTravelInsuranceIncluded(true)
        .build();
```

---

## 🛡️ Design Highlights

- **Immutability** — All fields are `private final`, object can't be modified after creation
- **Fluent API** — Each setter returns `this` for method chaining
- **Duplicate selection guard** — `HashSet` prevents user from setting the same option twice
- **Null-safe pricing** — `CalculatePrice` handles null optional fields gracefully
- **Separation of concerns** — `TravelPackage` (data), `CalculatePrice` (logic), `Main` (UI) are separate classes
