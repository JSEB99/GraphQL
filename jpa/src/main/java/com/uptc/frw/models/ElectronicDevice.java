package com.uptc.frw.models;

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

    @ManyToOne
    @JoinColumn(name="TIPO_ID",nullable=false)
    private Type type;

    @OneToMany(mappedBy = "electronicDevice")
    private List<ComponentDevice> componentDevices;
    @OneToMany(mappedBy = "electronicDevices")
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
                '}';
    }
}
