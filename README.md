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

---

# 🚀 4) Abstract Factory Pattern — Cloud Deployment SDK: Cloud Provider (GCP / AWS / Azure)

## 🧠 Problem
A Cloud Deployment SDK needs to provision infrastructure across **multiple cloud providers — AWS, Azure, GCP** — each requiring provider-specific implementations for **6 services**: Authentication, Compute, Storage, Networking, Deployment, and Monitoring.

If the client creates provider-specific objects directly:
- ❌ Tightly coupled to concrete classes (`new AWSCompute()`, `new AzureStorage()`, etc.)
- ❌ Risk of mixing services across providers (e.g., AWS Auth + Azure Storage) — **breaks compatibility**
- ❌ Adding a new provider requires changes across the entire client codebase
- ❌ Violates Open/Closed Principle — client must know every provider's class

---

## ✅ Solution
Implemented **Abstract Factory Pattern** to ensure:

> 🔥 **Client code is 100% provider-agnostic — a single factory interface creates an entire family of compatible cloud services, and switching providers is a one-line change**

---

## ⚙️ How It Works

```text
User Input ("AWS") → CloudServiceFactoryProvider → AWSFactory → creates AWSAuth, AWSCompute, AWSStorage, ...
User Input ("GCP") → CloudServiceFactoryProvider → GCPFactory → creates GCPAuth, GCPCompute, GCPStorage, ...
User Input ("Azure") → CloudServiceFactoryProvider → AzureFactory → creates AzureAuth, AzureCompute, AzureStorage, ...
```

---

## 📌 Supported Providers & Services

| Service | AWS | Azure | GCP |
|---------|-----|-------|-----|
| Authentication | IAM Roles / Access Keys | Azure Active Directory | Google Cloud IAM |
| Compute | EC2 / Lambda | Virtual Machines / Azure Functions | Compute Engine / Cloud Functions |
| Storage | Amazon S3 | Azure Blob Storage | Google Cloud Storage |
| Networking | VPC / ELB | Azure VNet | Google VPC |
| Deployment | CI-CD / ECS / EKS | Azure DevOps | Cloud Build / GKE |
| Monitoring | CloudWatch | Azure Monitor | Cloud Monitoring |

---

## ⚙️ Key Idea

**Abstract Factory Interface:**
```java
public interface CloudServiceFactory {
    Authentication createAuthentication();
    Compute createCompute();
    Storage createStorage();
    Networking createNetworking();
    Deployment createDeployment();
    Monitoring createMonitoring();
}
```

**Concrete Factory (e.g., AWS):**
```java
public class AWSFactory implements CloudServiceFactory {
    public Authentication createAuthentication() { return new AWSAuth(); }
    public Compute createCompute()               { return new AWSCompute(); }
    public Storage createStorage()               { return new AWSStorage(); }
    public Networking createNetworking()         { return new AWSNetworking(); }
    public Deployment createDeployment()         { return new AWSDeployment(); }
    public Monitoring createMonitoring()         { return new AWSMonitoring(); }
}
```

**Factory Provider (selects the right factory):**
```java
public class CloudServiceFactoryProvider {
    public static CloudServiceFactory getFactory(String provider) {
        switch (provider.toUpperCase()) {
            case "AZURE": return new AzureFactory();
            case "GCP":   return new GCPFactory();
            case "AWS":   return new AWSFactory();
            default:      return new AWSFactory();
        }
    }
}
```

**Usage (Client is fully provider-agnostic):**
```java
CloudServiceFactory factory = CloudServiceFactoryProvider.getFactory("AWS");

factory.createAuthentication().authenticate();
factory.createCompute().startCompute();
factory.createStorage().chooseStorage();
factory.createNetworking().chooseNetwork();
factory.createDeployment().doDeployment();
factory.createMonitoring().startMonitoring();
```

---

## 🛡️ Design Highlights

- **Family consistency** — A single factory guarantees all 6 services belong to the same provider, no cross-provider mixing
- **Open/Closed Principle** — Adding a new provider (e.g., Oracle Cloud) only requires a new factory + concrete classes, zero client changes
- **Provider-agnostic client** — Client depends only on interfaces (`Authentication`, `Compute`, `Storage`, etc.), never on concrete classes
- **Single point of selection** — `CloudServiceFactoryProvider` is the only place that knows about concrete factories
- **Separation of concerns** — Product interfaces (`product/`), concrete implementations (`aws/`, `azure/`, `gcp/`), factories (`factory/`), and client (`Main`) are cleanly separated

---

# 🚀 5) Prototype Pattern — Enterprise Role-Based Access Control (RBAC) Profiles

## 🧠 Problem
An enterprise system needs to create **role profiles** (Admin, Manager, Viewer) with predefined permissions and region access. Each team/user may need a **customized copy** of a base role.

If we create each role from scratch every time:
- ❌ Repeated expensive initialization logic
- ❌ Risk of inconsistency — different teams may define "Admin" differently
- ❌ No central source of truth for base role definitions
- ❌ Modifying a shared object affects all users of that role

---

## ✅ Solution
Implemented **Prototype Pattern** with a `RoleRegistry` that stores predefined prototypes and returns **deep clones** on request:

> 🔥 **Clone a predefined role prototype and customize the copy — the original prototype remains untouched**

---

## ⚙️ How It Works

```text
RoleRegistry (stores prototypes) → getRole("Admin") → clone() → Deep Copy → Customize (add permissions/regions)
                                                                    ↓
                                                        Original prototype stays unchanged
```

---

## 📌 Predefined Role Prototypes

| Role | Permissions | Regions |
|------|-------------|---------|
| Admin | `read`, `write`, `delete`, `manage-users` | `us-east-1`, `eu-west-1`, `ap-south-1` |
| Manager | `read`, `write` | `us-east-1`, `eu-west-1` |
| Viewer | `read` | `us-east-1` |

---

## ⚙️ Key Idea

**Prototype (Cloneable object):**
```java
public class RoleProfile implements Cloneable {
    private String roleName;
    private List<String> permissions;
    private List<String> regions;

    @Override
    public RoleProfile clone() {
        return new RoleProfile(this.roleName, this.permissions, this.regions);
    }

    public void addPermission(String permission) { permissions.add(permission); }
    public void addRegion(String region) { regions.add(region); }
}
```

**Registry (stores and clones prototypes):**
```java
public class RoleRegistry {
    private final Map<String, RoleProfile> prototypes = new HashMap<>();

    public RoleRegistry() {
        prototypes.put("Admin", new RoleProfile("Admin",
                List.of("read", "write", "delete", "manage-users"),
                List.of("us-east-1", "eu-west-1", "ap-south-1")));
        prototypes.put("Manager", new RoleProfile("Manager",
                List.of("read", "write"),
                List.of("us-east-1", "eu-west-1")));
        prototypes.put("Viewer", new RoleProfile("Viewer",
                List.of("read"),
                List.of("us-east-1")));
    }

    public RoleProfile getRole(String roleName) {
        RoleProfile prototype = prototypes.get(roleName);
        if (prototype == null) throw new IllegalArgumentException("No prototype found for role: " + roleName);
        return prototype.clone();
    }
}
```

**Usage:**
```java
RoleRegistry registry = new RoleRegistry();

RoleProfile admin = registry.getRole("Admin");
admin.addRegion("sa-east-1");
admin.addPermission("audit-logs");

RoleProfile freshAdmin = registry.getRole("Admin"); // no "sa-east-1" or "audit-logs"
```

---

## 🛡️ Design Highlights

- **Deep copy** — `clone()` creates a new `RoleProfile` with new `ArrayList` copies, so modifying a clone never affects the prototype
- **Central registry** — `RoleRegistry` is the single source of truth for all base role definitions
- **Customization without mutation** — Teams can add permissions/regions to their clone without impacting other users
- **Avoids repeated setup** — Complex role initialization happens once; subsequent uses are cheap clones
- **Separation of concerns** — `RoleProfile` (data + clone), `RoleRegistry` (prototype storage), `Main` (client usage) are cleanly separated

---

# 🚀 6) Adapter Pattern — Unified Media Player System

## 🧠 Problem
A media player application needs to support **multiple media formats — MP3, MP4, VLC** — each with its own incompatible playback interface (`playMp3()`, `playingMp4()`, `playVLC()`).

If the client calls each player's method directly:
- ❌ Tightly coupled to each player's unique API
- ❌ Adding a new format requires changes across the client code
- ❌ No uniform way to trigger playback — violates Interface Segregation Principle
- ❌ Client must know the internal details of each player

---

## ✅ Solution
Implemented **Adapter Pattern** to ensure:

> 🔥 **All media players are accessed through a single unified interface (`PlayButton.play()`) — the adapter translates the call to each player's native method**

---

## ⚙️ How It Works

```text
User Input ("mp3"/"mp4"/"vlc") → Create Adapter → PlayButton.play() → Delegates to native method
                                                                          ↓
                                                          MP3.playMp3() / MP4.playingMp4() / VLC.playVLC()
```

---

## 📌 Supported Media Types

| Type | Player Class | Native Method | Adapter |
|------|-------------|---------------|---------|
| `mp3` | `MP3` | `playMp3()` | `MP3Adapter` |
| `mp4` | `MP4` | `playingMp4()` | `MP4Adapter` |
| `vlc` | `VLC` | `playVLC()` | `VLCAdapter` |

---

## ⚙️ Key Idea

**Target Interface (unified API):**
```java
public interface PlayButton {
    void play();
}
```

**Adaptees (incompatible players):**
```java
public class MP3 {
    public void playMp3() { System.out.println("Playing MP3 audio: " + file + " [type=" + type + "]"); }
}

public class MP4 {
    public void playingMp4() { System.out.println("Playing MP4: " + file); }
}

public class VLC {
    public void playVLC() { System.out.println("Playing VLC video: " + file + " [quality=" + quality + "]"); }
}
```

**Adapters (bridge the gap):**
```java
public class MP3Adapter implements PlayButton {
    private MP3 mp3;
    public MP3Adapter(MP3 mp3) { this.mp3 = mp3; }

    @Override
    public void play() { mp3.playMp3(); }
}

public class MP4Adapter implements PlayButton {
    private MP4 mp4;
    public MP4Adapter(MP4 mp4) { this.mp4 = mp4; }

    @Override
    public void play() { mp4.playingMp4(); }
}

public class VLCAdapter implements PlayButton {
    private VLC vlc;
    public VLCAdapter(VLC vlc) { this.vlc = vlc; }

    @Override
    public void play() { vlc.playVLC(); }
}
```

**Usage (Client uses only the unified interface):**
```java
PlayButton player;

switch (type) {
    case "mp3": player = new MP3Adapter(new MP3(file, audioType)); break;
    case "mp4": player = new MP4Adapter(new MP4(file)); break;
    case "vlc": player = new VLCAdapter(new VLC(file, quality)); break;
}

player.play(); // Uniform call regardless of media type
```

---

## 🛡️ Design Highlights

- **Uniform interface** — Client only knows `PlayButton.play()`, never calls `playMp3()`, `playingMp4()`, or `playVLC()` directly
- **Open/Closed Principle** — Adding a new media format (e.g., FLAC) only requires a new player class + adapter, zero changes to existing code
- **Decoupled client** — `Main` depends on the `PlayButton` interface, not on concrete player implementations
- **Composition over inheritance** — Each adapter wraps (composes) the adaptee rather than extending it
- **Single Responsibility** — Each adapter has one job: translate `play()` to the native method of its wrapped player
