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
    @Column(name = "APARATO_ID",insertable = false,updatable = false)
    private long idApparatus;
    @Column(name ="FECHA")
    private Date repairDate;
    @OneToMany(mappedBy = "repairId")
    private List<Modification> modifications;
    @ManyToOne
    @JoinColumn(name = "APARATO_ID",nullable = false)
    private ElectronicDevice electronicDevices;
    public Repair() {
    }

    public List<Modification> getModifications() {
        return modifications;
    }

    public void setModifications(List<Modification> modifications) {
        this.modifications = modifications;
    }

    public long getId() {
        return id;
    }

    public ElectronicDevice getElectronicDevices() {
        return electronicDevices;
    }

    public void setElectronicDevices(ElectronicDevice electronicDevices) {
        this.electronicDevices = electronicDevices;
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


    @Override
    public String toString() {
        return "Repair{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", repairDate=" + repairDate +
                ", idApparatus=" + idApparatus +
                '}';
    }
}
