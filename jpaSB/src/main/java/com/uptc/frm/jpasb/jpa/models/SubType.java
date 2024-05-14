package com.uptc.frm.jpasb.jpa.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "SUBTIPOS")
public class SubType {

    @Id
    @Column(name = "SUBTIPO_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subTypeGen")
    @SequenceGenerator(name = "subTypeGen", sequenceName = "SUBTIPO_SEQ", allocationSize = 1)
    private int subTypeId;
    @Column(name = "DESCRIPCION")
    private String description;

    @OneToMany(mappedBy = "subType")
    private List<Type> types;

    public SubType() {}

    public int getSubTypeId() {
        return subTypeId;
    }

    public void setSubTypeId(int subTypeId) {
        this.subTypeId = subTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return "SubType{" +
                "subTypeId=" + subTypeId +
                ", description='" + description + '\'' +
                '}';
    }
}
