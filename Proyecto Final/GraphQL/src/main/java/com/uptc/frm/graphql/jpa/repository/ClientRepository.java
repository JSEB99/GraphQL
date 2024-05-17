package com.uptc.frm.graphql.jpa.repository;

import com.uptc.frm.graphql.jpa.models.Client;
import com.uptc.frm.graphql.jpa.models.Repair;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ClientRepository extends JpaRepository<Client,Integer> {
    public List<Repair> findClientById(Integer numberIdClient);
}
