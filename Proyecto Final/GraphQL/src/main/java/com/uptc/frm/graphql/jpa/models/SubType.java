package com.uptc.frm.graphql.jpa.models;

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
    @Column(name = "TIPO_ID", insertable = false, updatable = false)
    private int typeId;

    @ManyToOne
    @JoinColumn(name="TIPO_ID",nullable=false)
    private Type type;

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

    @Override
    public String toString() {
        return "SubType{" +
                "subTypeId=" + subTypeId +
                ", description='" + description + '\'' +
                '}';
    }
}
