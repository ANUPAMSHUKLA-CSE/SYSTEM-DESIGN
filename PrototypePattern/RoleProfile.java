package org.example;

import java.util.ArrayList;
import java.util.List;

// This is the PROTOTYPE — an object that can be cloned
public class RoleProfile implements Cloneable {
    private String roleName;
    private List<String> permissions;
    private List<String> regions;

    public RoleProfile(String roleName, List<String> permissions, List<String> regions) {
        this.roleName = roleName;
        this.permissions = new ArrayList<>(permissions);
        this.regions = new ArrayList<>(regions);
    }

    // PROTOTYPE PATTERN CORE: clone() creates a deep copy
    @Override
    public RoleProfile clone() {
        return new RoleProfile(this.roleName, this.permissions, this.regions);
    }

    public void addPermission(String permission) {
        permissions.add(permission);
    }

    public void addRegion(String region) {
        regions.add(region);
    }

    public String getRoleName() {
        return roleName;
    }

    @Override
    public String toString() {
        return "RoleProfile { role='" + roleName + "', permissions=" + permissions + ", regions=" + regions + " }";
    }
}
