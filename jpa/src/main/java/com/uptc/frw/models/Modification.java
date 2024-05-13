package com.uptc.frw.models;

import jakarta.persistence.*;

@Entity
@Table(name ="Modificaciones")
public class Modification {
    @Id
    @Column(name = "MODIFICACION_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "modifygen")
    @SequenceGenerator(name = "modifygen",sequenceName = "MODIFICACION_SEQ",allocationSize = 1)
    private long id;
    @Column(name = "DESCRIPCION")
    private String description;
    @Column(name = "COMPONENTE_ID")
    private long idComponent;

    public Modification() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getIdComponent() {
        return idComponent;
    }

    public void setIdComponent(long idComponent) {
        this.idComponent = idComponent;
    }

    @Override
    public String toString() {
        return "Modification{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", idComponent=" + idComponent +
                '}';
    }
}
