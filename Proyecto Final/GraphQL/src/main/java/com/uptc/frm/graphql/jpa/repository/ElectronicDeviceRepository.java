package com.uptc.frm.graphql.jpa.repository;

import com.uptc.frm.graphql.jpa.models.ElectronicDevice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ElectronicDeviceRepository extends JpaRepository<ElectronicDevice, Integer> {

    public List<ElectronicDevice> findByTypeId (Integer idType);

}
