package com.uptc.frm.graphql.jpa.repository;

import com.uptc.frm.graphql.jpa.models.ComponentDevice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComponentDeviceRepository extends JpaRepository<ComponentDevice, Integer> {
    public List<ComponentDevice> findByComponentId(Integer componentId);
    public List<ComponentDevice> findByDeviceId(Integer deviceId);
}
