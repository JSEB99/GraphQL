package com.uptc.frm.jpasb.jpa.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "COMPONENTES")
public class Component {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "compoGen")
    @SequenceGenerator(name = "compoGen",sequenceName = "COMPONENTE_SEQ",allocationSize = 1)
    @Column(name = "COMPONENTE_ID")
    private long componentId;

    @Column(name = "ESPECIFICACIONES")
    private String specs;

    @Column(name = "FABRICANTE_ID",insertable = false,updatable = false)
    private long manufacturerId;

    @ManyToOne
    @JoinColumn(name = "FABRICANTE_ID",nullable = false)
    private Manufacturer manufacturers;

    @OneToMany(mappedBy = "components")
    private List<ComponentDevice> componentsDevices;
    @OneToMany(mappedBy = "componentID")
    private List<Modification> modifications;
    public Component() {
    }

    public List<ComponentDevice> getComponentsDevices() {
        return componentsDevices;
    }

    public void setComponentsDevices(List<ComponentDevice> componentsDevices) {
        this.componentsDevices = componentsDevices;
    }

    public List<Modification> getModifications() {
        return modifications;
    }

    public void setModifications(List<Modification> modifications) {
        this.modifications = modifications;
    }

    public long getComponentId() {
        return componentId;
    }

    public void setComponentId(long componentId) {
        this.componentId = componentId;
    }

    public String getSpecs() {
        return specs;
    }

    public void setSpecs(String specs) {
        this.specs = specs;
    }

    public long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public Manufacturer getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(Manufacturer manufacturers) {
        this.manufacturers = manufacturers;
    }


    @Override
    public String toString() {
        return "Components{" +
                "componentId=" + componentId +
                ", specs='" + specs + '\'' +
                ", manufacturerId=" + manufacturerId +
                '}';
    }


}
