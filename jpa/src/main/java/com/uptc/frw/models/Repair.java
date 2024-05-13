package com.uptc.frw.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "REPARACIONES")
public class Repair {
    @Id
    @Column(name = "REPARACION_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "repairgen")
    @SequenceGenerator(name = "repairgen",sequenceName = "REPARACION_SEQ", allocationSize = 1)
    private long id;
    @Column(name = "DESCRIPCION")
    private String description;

    @ManyToOne
    @JoinColumn(name = "CLIENTE_ID",nullable = false)
    private Client idClient;
    @Column(name = "APARATO_ID")
    private long idApparatus;
    @Column(name = "MODIFICACION_ID")
    private long idModification;
    @Column(name ="FECHA")
    private Date repairDate;
    public Repair() {
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

    public Date getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(Date repairDate) {
        this.repairDate = repairDate;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    public long getIdApparatus() {
        return idApparatus;
    }

    public void setIdApparatus(long idApparatus) {
        this.idApparatus = idApparatus;
    }

    public long getIdModification() {
        return idModification;
    }

    public void setIdModification(long idModification) {
        this.idModification = idModification;
    }

    @Override
    public String toString() {
        return "Repair{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", repairDate=" + repairDate +
                ", idClient=" + idClient +
                ", idApparatus=" + idApparatus +
                ", idModification=" + idModification +
                '}';
    }
}
