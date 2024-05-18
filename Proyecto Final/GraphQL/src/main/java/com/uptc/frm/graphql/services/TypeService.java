package com.uptc.frm.graphql.services;

import com.uptc.frm.graphql.jpa.models.SubType;
import com.uptc.frm.graphql.jpa.models.Type;
import com.uptc.frm.graphql.jpa.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TypeService {

    @Autowired
    private TypeRepository typeRepository;


    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }

    public Type findTypeById(int id) {
        return typeRepository.findById(id).orElse(null);
    }

    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    public Type updateType(Type type) {
        Type oldType = findTypeById(type.getTypeId());
        boolean hasChanges = false;
        if (oldType != null) {
            if (type.getDescription() != null && !Objects.equals(oldType.getDescription(), type.getDescription())) {
                oldType.setDescription(type.getDescription());
                hasChanges = true;
            }
            if (type.getCharacteristics() != null && !Objects.equals(oldType.getCharacteristics(), type.getCharacteristics())) {
                oldType.setCharacteristics(type.getCharacteristics());
                hasChanges = true;
            }
            if (hasChanges) {
                return typeRepository.save(oldType);
            }
        }
        return null;
    }

    public String deleteTypeById(Integer id) {
        Type type = findTypeById(id);
        if (type != null) {
            if (type.getSubTypes().isEmpty()) {
                if (type.getElectronicDevices().isEmpty()){
                    typeRepository.deleteById(id);
                    return ("El registro con id: " + id + " se elimino con exito");
                } else {
                    return ("El registro con id: " + id + " no se puede eliminar porque tiene aparatos electronicos asociados");
                }
            } else {
                return ("El registro con id: " + id + " no se puede eliminar porque tiene subtipos asociados");
            }
        } else {
            return ("El registro con id: " + id + " no existe");
        }
    }

}
