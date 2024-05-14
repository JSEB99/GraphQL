package com.uptc.frm.jpasb.controller;

import com.uptc.frm.jpasb.jpa.models.ElectronicDevice;
import com.uptc.frm.jpasb.services.ElectronicDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/electronicDevice")
public class ElectronicDeviceController {

    @Autowired
    private ElectronicDeviceService electronicDeviceService;

    @GetMapping
    public List<ElectronicDevice> getElectronicDevices() {
        return electronicDeviceService.findAll();
    }
}
