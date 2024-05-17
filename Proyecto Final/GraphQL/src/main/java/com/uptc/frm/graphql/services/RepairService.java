package com.uptc.frm.graphql.services;

import com.uptc.frm.graphql.jpa.models.Client;
import com.uptc.frm.graphql.jpa.models.ElectronicDevice;
import com.uptc.frm.graphql.jpa.models.Repair;
import com.uptc.frm.graphql.jpa.models.Type;
import com.uptc.frm.graphql.jpa.repository.ClientRepository;
import com.uptc.frm.graphql.jpa.repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RepairService {
    @Autowired
    private RepairRepository repairRepository;
    @Autowired
    private ClientService clientService;
    @Autowired
    private ElectronicDeviceService electronicDeviceService;
    public Repair findById(Integer id){
        return repairRepository.findById(id).orElse(null);
    }
    public List<Repair> findAllRepair(){
        return repairRepository.findAll();
    }
    public Repair createRepair(Repair repair){
        Client client = clientService.findById(repair.getNumberIdClient());
        ElectronicDevice electronicDevice = electronicDeviceService.findById(repair.getIdApparatus());
        if (client != null && electronicDevice != null){
            repair.setIdClient(client);
            repair.setElectronicDevices(electronicDevice);
            repair.setRepairDate(new Date());
            return repairRepository.save(repair);
        }
        return null;
    }
    public Repair updateRepair(Repair updateRepair){
        Repair repair = findById((int)updateRepair.getId());
        if (repair != null && !updateRepair.equals(repair)){
            if((repair.getDescription()!= updateRepair.getDescription()) && updateRepair.getDescription() != null){
                repair.setDescription(updateRepair.getDescription());
            }
            if ((repair.getIdApparatus() != updateRepair.getIdApparatus()) && updateRepair.getIdApparatus() != null){
                ElectronicDevice electronicDevice = electronicDeviceService.findById(updateRepair.getIdApparatus());
                    if (electronicDevice != null) {
                        repair.setElectronicDevices(electronicDevice);
                    }
            }
            if((repair.getNumberIdClient() != updateRepair.getNumberIdClient())&& updateRepair.getNumberIdClient() != null){
                Client client = clientService.findById(updateRepair.getNumberIdClient());
                if (client != null) {
                    repair.setIdClient(client);
                }
            }
            return repairRepository.save(repair);
        }
        return null;
    }
    public void deleteRepair(int id){repairRepository.deleteById(id);}


}
