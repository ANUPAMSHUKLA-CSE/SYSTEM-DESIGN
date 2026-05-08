package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// REGISTRY: stores predefined prototypes, returns clones (not originals)
public class RoleRegistry {
    private final Map<String, RoleProfile> prototypes = new HashMap<>();

    public RoleRegistry() {
        // Predefined role prototypes
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

    // Returns a CLONE, not the original — this is the Prototype Pattern in action
    public RoleProfile getRole(String roleName) {
        RoleProfile prototype = prototypes.get(roleName);
        if (prototype == null) {
            throw new IllegalArgumentException("No prototype found for role: " + roleName);
        }
        return prototype.clone();
    }
}
