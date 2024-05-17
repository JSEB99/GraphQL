package com.uptc.frm.graphql.jpa.repository;
import com.uptc.frm.graphql.jpa.models.Repair;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepairRepository extends JpaRepository<Repair,Integer> {
    public List<Repair> findByNumberIdClient (Integer numberIdClient);
    public List<Repair> findByidApparatus (Integer idApparatus);
}
