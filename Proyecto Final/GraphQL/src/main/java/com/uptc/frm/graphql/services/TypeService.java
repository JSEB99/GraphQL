package com.uptc.frm.graphql.services;

import com.uptc.frm.graphql.jpa.models.SubType;
import com.uptc.frm.graphql.jpa.models.Type;
import com.uptc.frm.graphql.jpa.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private SubTypeService subTypeService;

    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }

    public Type findTypeById(int id) {
        return typeRepository.findById(id).orElse(null);
    }

    public Type saveType(Type type) {
        SubType subType = subTypeService.findSubTypeById(type.getSubtypeId());
        type.setSubType(subType);
        return typeRepository.save(type);
    }

    public Type updateType(Type type) {
        Type oldType = findTypeById(type.getTypeId());
        if (oldType != null) {
            if (type.getDescription() != null){
                oldType.setDescription(type.getDescription());
            }
            if (type.getCharacteristics() != null) {
                oldType.setCharacteristics(type.getCharacteristics());
            }
            if (type.getSubType() != null && oldType.getSubtypeId() != type.getSubtypeId()) {
                SubType subType = subTypeService.findSubTypeById(type.getSubtypeId());
                oldType.setSubType(subType);
            }
            return typeRepository.save(oldType);
        }
        return type;
    }

    public void deleteTypeById(int id) {
        typeRepository.deleteById(id);
    }








}
