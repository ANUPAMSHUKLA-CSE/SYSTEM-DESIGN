package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Enterprise RBAC Profiles (Prototype Pattern) ===\n");

        // Step 1: Registry holds predefined prototypes
        RoleRegistry registry = new RoleRegistry();

        // Step 2: Clone an Admin profile — it's a copy, not the original
        RoleProfile admin1 = registry.getRole("Admin");
        System.out.println("Admin1: " + admin1);

        // Step 3: Clone another Admin and customize it — original stays unchanged
        RoleProfile admin2 = registry.getRole("Admin");
        admin2.addRegion("sa-east-1");
        admin2.addPermission("audit-logs");
        System.out.println("Admin2 (customized): " + admin2);

        // Step 4: Verify original Admin prototype is untouched
        RoleProfile admin3 = registry.getRole("Admin");
        System.out.println("Admin3 (fresh clone): " + admin3);

        System.out.println();

        // Clone and customize other roles
        RoleProfile manager = registry.getRole("Manager");
        manager.addRegion("ap-south-1");
        System.out.println("Manager (customized): " + manager);

        RoleProfile viewer = registry.getRole("Viewer");
        System.out.println("Viewer: " + viewer);
    }
}
