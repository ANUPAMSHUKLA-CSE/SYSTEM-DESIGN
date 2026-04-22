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
