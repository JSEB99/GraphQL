package com.uptc.frm.graphql.services;

import com.uptc.frm.graphql.jpa.models.ElectronicDevice;
import com.uptc.frm.graphql.jpa.models.Type;
import com.uptc.frm.graphql.jpa.repository.ElectronicDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectronicDeviceService {

    @Autowired
    private ElectronicDeviceRepository electronicDeviceRepository;

    @Autowired
    private TypeService typeService;

    public List<ElectronicDevice> findAll() {
        return electronicDeviceRepository.findAll();
    }

    public ElectronicDevice findById(int id) {
        return electronicDeviceRepository.findById(id).orElse(null);
    }

    public List<ElectronicDevice> findByTypeId (int idType) {
        return electronicDeviceRepository.findByTypeId(idType);
    }

    public ElectronicDevice createElectronicDevice(ElectronicDevice electronicDevice) {
        Type type = typeService.findTypeById(electronicDevice.getTypeId());
        electronicDevice.setType(type);
        return electronicDeviceRepository.save(electronicDevice);
    }

    public ElectronicDevice updateElectronicDevice(ElectronicDevice electronicDevice) {
        ElectronicDevice device = findById(electronicDevice.getDeviceId());
        if (device != null) {
            if (electronicDevice.getDescription() != null){
                device.setDescription(electronicDevice.getDescription());
            }
            if (device.getTypeId() != electronicDevice.getTypeId() && electronicDevice.getType() != null) {
                Type type = typeService.findTypeById(electronicDevice.getTypeId());
                device.setType(type);
            }
            return electronicDeviceRepository.save(device);
        }
        return electronicDevice;
    }

    public void deleteElectronicDevice(int id) {
        electronicDeviceRepository.deleteById(id);
    }
}
