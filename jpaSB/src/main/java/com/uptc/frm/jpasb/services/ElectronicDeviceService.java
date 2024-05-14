package com.uptc.frm.jpasb.services;

import com.uptc.frm.jpasb.jpa.models.ElectronicDevice;
import com.uptc.frm.jpasb.jpa.repository.ElectronicDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectronicDeviceService {

    @Autowired
    private ElectronicDeviceRepository electronicDeviceRepository;

    public List<ElectronicDevice> findAll() {
        return electronicDeviceRepository.findAll();
    }
}
