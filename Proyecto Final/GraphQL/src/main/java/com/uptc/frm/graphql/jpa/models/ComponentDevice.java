package com.uptc.frm.graphql.jpa.models;

import jakarta.persistence.*;

@Entity
@Table(name = "COMPONENTES_APARATOS")
public class ComponentDevice {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "compoDeviceGen")
    @SequenceGenerator(name = "compoDeviceGen",sequenceName = "COMPONENTE_APARATO_SEQ",allocationSize = 1)
    @Column(name = "COMPONENTE_APARATO_ID")
    private long componentsDeviceId;

    @Column(name = "COMPONENTE_ID",insertable = false, updatable = false)
    private long componentId;

    @Column(name = "APARATO_ID", insertable = false, updatable = false)
    private long deviceId;

    @Column(name = "CANTIDAD")
    private long quantity;

    @ManyToOne
    @JoinColumn(name = "COMPONENTE_ID", nullable = false)
    private Component components;

    @ManyToOne
    @JoinColumn(name = "APARATO_ID", nullable = false)
    private ElectronicDevice electronicDevice;

    public ComponentDevice() {
    }

    public ElectronicDevice getElectronicDevice() {
        return electronicDevice;
    }

    public void setElectronicDevice(ElectronicDevice electronicDevice) {
        this.electronicDevice = electronicDevice;
    }

    public Component getComponents() {
        return components;
    }

    public void setComponents(Component components) {
        this.components = components;
    }

    public long getComponentsDeviceId() {
        return componentsDeviceId;
    }

    public void setComponentsDeviceId(long componentsDeviceId) {
        this.componentsDeviceId = componentsDeviceId;
    }

    public long getComponentId() {
        return componentId;
    }

    public void setComponentId(long componentId) {
        this.componentId = componentId;
    }

    public long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(long deviceId) {
        this.deviceId = deviceId;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ComponentsDevices{" +
                "componentsDeviceId=" + componentsDeviceId +
                ", componentId=" + componentId +
                ", deviceId=" + deviceId +
                ", quantity=" + quantity +
                '}';
    }
}
