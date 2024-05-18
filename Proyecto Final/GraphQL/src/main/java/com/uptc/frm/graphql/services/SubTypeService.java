package com.uptc.frm.graphql.services;

import com.uptc.frm.graphql.jpa.models.SubType;
import com.uptc.frm.graphql.jpa.models.Type;
import com.uptc.frm.graphql.jpa.repository.SubTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SubTypeService {

    @Autowired
    private SubTypeRepository subTypeRepository;

    @Autowired
    private TypeService typeService;

    public List<SubType> getAllSubTypes() {
        return subTypeRepository.findAll();
    }

    public SubType findSubTypeById(Integer id) {
        return subTypeRepository.findById(id).orElse(null);
    }

    public SubType saveSubType(SubType subType) {
        Type type = typeService.findTypeById(subType.getTypeId());
        if (type != null) {
            return subTypeRepository.save(subType);
        }
        return null;
    }

    public SubType updateSubType(SubType subType) {
        SubType oldSubType = findSubTypeById(subType.getSubTypeId());
        boolean hasChanges = false;
        if (oldSubType != null) {
            if (subType.getDescription() != null && !Objects.equals(subType.getDescription(), oldSubType.getDescription())) {
                oldSubType.setDescription(subType.getDescription());
                hasChanges = true;
            }
            if (subType.getTypeId() == 0 && !Objects.equals(subType.getTypeId(), oldSubType.getTypeId())) {
                Type type = typeService.findTypeById(oldSubType.getTypeId());
                if (type != null) {
                    oldSubType.setTypeId(subType.getTypeId());
                    hasChanges = true;
                }
            }
            if (hasChanges) {
                return subTypeRepository.save(oldSubType);
            }
        }
        return null;
    }

    public void deleteSubType(Integer id) {
        subTypeRepository.deleteById(id);
    }
}
