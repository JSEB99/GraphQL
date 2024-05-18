package com.uptc.frm.graphql.jpa.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TIPOS")
public class Type {

    @Id
    @Column(name = "TIPO_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "typeGen")
    @SequenceGenerator(name = "typeGen", sequenceName = "TIPO_SEQ ", allocationSize = 1)
    private int typeId;
    @Column(name = "DESCRIPCION")
    private String description;
    @Column(name = "CARACTERISTICAS")
    private String characteristics;

    @OneToMany(mappedBy = "type")
    private List<ElectronicDevice> electronicDevices;

    @OneToMany(mappedBy = "type")
    private List<SubType> subTypes;

    public Type() {}

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public List<ElectronicDevice> getElectronicDevices() {
        return electronicDevices;
    }

    public void setElectronicDevices(List<ElectronicDevice> electronicDevices) {
        this.electronicDevices = electronicDevices;
    }

    public List<SubType> getSubTypes() {
        return subTypes;
    }

    public void setSubTypes(List<SubType> subTypes) {
        this.subTypes = subTypes;
    }

    @Override
    public String toString() {
        return "Type{" +
                "typeId=" + typeId +
                ", description='" + description + '\'' +
                ", characteristics='" + characteristics + '\'' +
                '}';
    }
}
