package com.uptc.frm.graphql.jpa.repository;

import com.uptc.frm.graphql.jpa.models.Component;
import com.uptc.frm.graphql.jpa.models.Modification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComponentRepository extends JpaRepository<Component, Integer> {
    public List<Component> findComponentsByManufacturerId(Integer manufacturerId);
}
