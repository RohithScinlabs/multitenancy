package com.multitenancy.multitenancy.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class EmployeeEntity {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;

    public EmployeeEntity(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public EmployeeEntity(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
