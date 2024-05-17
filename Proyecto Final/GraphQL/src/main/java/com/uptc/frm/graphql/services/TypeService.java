package com.uptc.frm.graphql.services;

import com.uptc.frm.graphql.jpa.models.Type;
import com.uptc.frm.graphql.jpa.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TypeService {

    @Autowired
    private TypeRepository typeRepository;

    public Type findTypeById(int id) {
        Optional<Type> type = typeRepository.findById(id);
        return type.orElse(null);
    }


}
