package com.uptc.frm.graphql.services;

import com.uptc.frm.graphql.jpa.models.Component;
import com.uptc.frm.graphql.jpa.models.Modification;
import com.uptc.frm.graphql.jpa.models.Repair;
import com.uptc.frm.graphql.jpa.repository.ModificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModificationService {
    @Autowired
    private ModificationRepository modificationRepository;
    @Autowired
    private RepairService repairService;
    @Autowired
    private ComponentService componentService;
    public Modification findById(Integer id){
        return  modificationRepository.findById(id).orElse(null);
    }
    public List<Modification> findAll(){
        return modificationRepository.findAll();
    }
    public Modification createModification(Modification modification){
        Component component = componentService.findComponentById((int)modification.getIdComponent());
        Repair repair = repairService.findById((int)modification.getIdRepair());
        if (repair != null && component !=null){
            modification.setRepairId(repair);
            modification.setIdComponent(1);
            return modificationRepository.save(modification);
        }
        return null;
    }
    public Modification updateModification(Modification updateModification){
        Modification modification = findById((int)updateModification.getId());
        if(modification != null && !updateModification.equals(modification)){
            Long newRepair = updateModification.getIdRepair();
            Long newComponent =  updateModification.getIdComponent();
            if ((modification.getDescription() != updateModification.getDescription())&& updateModification.getDescription() != null){
                modification.setDescription(updateModification.getDescription());
            }if ((modification.getIdRepair() != updateModification.getIdRepair())&&newRepair!=null){
                Repair repair = repairService.findById((int)updateModification.getIdRepair());
                if (repair != null){
                    modification.setIdRepair(updateModification.getIdRepair());
                }
            }if ((modification.getIdComponent()!= updateModification.getIdComponent())&& newComponent!= null){
                Component componente = componentService.findComponentById((int)updateModification.getIdComponent());
                if (componente != null){
                    modification.setIdComponent(updateModification.getIdComponent());
                }
            }
            return modificationRepository.save(modification);
        }
        return null;
    }
    public void deleteModification(int id){modificationRepository.deleteById(id);}
    public List<Modification> findByidRepair (int numRepairId){
        return modificationRepository.findByidRepair(numRepairId);
    }
    public List<Modification> findByidComponent(int idComponent){
        return modificationRepository.findByidComponent(idComponent);
    }
}
