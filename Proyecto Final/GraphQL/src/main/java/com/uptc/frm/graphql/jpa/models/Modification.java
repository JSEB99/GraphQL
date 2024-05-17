package com.uptc.frm.graphql.jpa.models;

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
    @Column(name = "COMPONENTE_ID",insertable = false,updatable = false)
    private long idComponent;
    @Column(name = "REPARACION_ID", insertable = false, updatable = false)
    private long idRepair;
    @ManyToOne
    @JoinColumn(name = "REPARACION_ID", nullable = false)
    private Repair repairId;
    @ManyToOne
    @JoinColumn(name = "COMPONENTE_ID",nullable = false)
    private Component componentID;

    public Modification() {
    }

    public long getId() {
        return id;
    }

    public Component getComponentID() {
        return componentID;
    }

    public void setComponentID(Component componentID) {
        this.componentID = componentID;
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

    public Repair getRepairId() {
        return repairId;
    }

    public void setRepairId(Repair repairId) {
        this.repairId = repairId;
    }

    public long getIdRepair() {
        return idRepair;
    }

    public void setIdRepair(long idRepair) {
        this.idRepair = idRepair;
    }

    @Override
    public String toString() {
        return "Modification{" +
                "id=" + id +
                ", description='" + description + '\'' +
               ", idComponent=" + idComponent +
               ", idRepair=" + idRepair +
                '}';
    }
}
