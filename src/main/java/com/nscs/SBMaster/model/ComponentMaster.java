package com.nscs.SBMaster.model;

import jakarta.persistence.*;

@Entity
@Table(name = "component_master")
public class ComponentMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String componentName;
    private String step;
    private boolean visible;

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    // Constructors
    public ComponentMaster() {
    }

    public ComponentMaster(String componentName, boolean visible) {
        this.componentName = componentName;
        this.visible = visible;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public String getComponentName() {
        return componentName;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
