package com.uptc.frm.graphql.jpa.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "APARATOS_ELECTRONICOS")
public class ElectronicDevice {

    @Id
    @Column(name = "APARATO_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deviceGen")
    @SequenceGenerator(name = "deviceGen", sequenceName = "APARATO_SEQ  ", allocationSize = 1)
    private int deviceId;
    @Column(name = "DESCRIPCION")
    private String description;
    @Column(name = "TIPO_ID", insertable = false, updatable = false)
    private int typeId;

    @ManyToOne
    @JoinColumn(name="TIPO_ID",nullable=false)
    @JsonIgnore
    private Type type;

    @OneToMany(mappedBy = "electronicDevice")
    @JsonIgnore
    private List<ComponentDevice> componentDevices;

    @OneToMany(mappedBy = "electronicDevices")
    @JsonIgnore
    private List<Repair> repairs;

    public ElectronicDevice() {}

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<ComponentDevice> getComponentDevices() {
        return componentDevices;
    }

    public void setComponentDevices(List<ComponentDevice> componentDevices) {
        this.componentDevices = componentDevices;
    }

    public List<Repair> getRepairs() {
        return repairs;
    }

    public void setRepairs(List<Repair> repairs) {
        this.repairs = repairs;
    }

    @Override
    public String toString() {
        return "ElectronicDevice{" +
                "deviceId=" + deviceId +
                ", description='" + description + '\'' +
                ", typeId=" + typeId +
                ", type=" + type +
                ", componentDevices=" + componentDevices +
                ", repairs=" + repairs +
                '}';
    }
}
