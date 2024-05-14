package com.uptc.frw.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "FABRICANTES")
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "manufacturerGen")
    @SequenceGenerator(name = "manufacturerGen",sequenceName = "FABRICANTE_SEQ",allocationSize = 1)
    @Column(name = "FABRICANTE_ID")
    private long manufacturerId;

    @Column(name = "RIF")
    private String rif;

    @Column(name = "DOMINIO_FISCAL")
    private String fiscalDomain;

    @OneToMany(mappedBy = "manufacturers")
    private List<Component> components;

    public Manufacturer() {

    }

    public long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getRif() {
        return rif;
    }

    public void setRif(String rif) {
        this.rif = rif;
    }

    public String getFiscalDomain() {
        return fiscalDomain;
    }

    public void setFiscalDomain(String fiscalDomain) {
        this.fiscalDomain = fiscalDomain;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "manufacturerId=" + manufacturerId +
                ", rif='" + rif + '\'' +
                ", fiscalDomain='" + fiscalDomain + '\'' +
                '}';
    }
}
