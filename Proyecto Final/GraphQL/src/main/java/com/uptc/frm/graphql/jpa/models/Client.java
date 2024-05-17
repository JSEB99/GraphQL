package com.uptc.frm.graphql.jpa.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "CLIENTES")
public class Client {
    @Id
    @Column(name = "CLIENTE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientgen")
    @SequenceGenerator(name = "clientgen",sequenceName = "CLIENTE_SEQ",allocationSize = 1)
    private long id;
    @Column(name = "NOMBRE")
    private String name;
    @Column(name = "DOCUMENTO")
    private long document;
    @Column(name = "DIRECCION")
    private String address;
    @Column(name = "TELEFONO")
    private long phone;
    @Column(name = "CORREO")
    private String email;
    @OneToMany(mappedBy = "idClient")
    private List<Repair> repairs;
    public Client() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDocument() {
        return document;
    }

    public void setDocument(long document) {
        this.document = document;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Repair> getRepairs() {
        return repairs;
    }

    public void setRepairs(List<Repair> repairs) {
        this.repairs = repairs;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", document=" + document +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                '}';
    }
}
