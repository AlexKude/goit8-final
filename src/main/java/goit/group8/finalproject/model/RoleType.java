package goit.group8.finalproject.model;

import java.io.Serializable;

public enum RoleType implements Serializable {

    FREELANCER("FREELANCER"),
    CUSTOMER("CUSTOMER"),
    ADMIN("ADMIN");

    String roleType;

    private RoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getRoleType() {
        return roleType;
    }
}
