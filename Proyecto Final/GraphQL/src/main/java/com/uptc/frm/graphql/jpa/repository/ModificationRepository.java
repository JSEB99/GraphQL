package com.uptc.frm.graphql.jpa.repository;


import com.uptc.frm.graphql.jpa.models.Modification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModificationRepository extends JpaRepository<Modification,Integer> {
}
