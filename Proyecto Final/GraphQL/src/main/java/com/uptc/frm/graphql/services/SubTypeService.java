package com.uptc.frm.graphql.services;

import com.uptc.frm.graphql.jpa.models.SubType;
import com.uptc.frm.graphql.jpa.repository.SubTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubTypeService {

    @Autowired
    private SubTypeRepository subTypeRepository;

    public List<SubType> getAllSubTypes() {
        return subTypeRepository.findAll();
    }

    public SubType findSubTypeById(Integer id) {
        return subTypeRepository.findById(id).orElse(null);
    }

    public SubType saveSubType(SubType subType) {
        return subTypeRepository.save(subType);
    }

    public SubType updateSubType(SubType subType) {
        SubType oldSubType = findSubTypeById(subType.getSubTypeId());
        if (oldSubType != null) {
            if (subType.getDescription() != null){
                oldSubType.setDescription(subType.getDescription());
            }
            return subTypeRepository.save(oldSubType);
        }
        return subType;
    }
    public void deleteSubType(Integer id) {
        subTypeRepository.deleteById(id);
    }
}
