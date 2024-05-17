package com.uptc.frm.graphql.services;

import com.uptc.frm.graphql.jpa.models.Client;
import com.uptc.frm.graphql.jpa.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    public Client findById(Integer idClient){
        return clientRepository.findById(idClient).orElse(null);
    }
    public List<Client> findAll(){
        return  clientRepository.findAll();
    }
    public Client createClient(Client client){
        return clientRepository.save(client);
    }
    public Client updateClient(Client updateClient){
        Client client = findById((int)updateClient.getId());
        if (client != null){
            Long existingDocument = client.getDocument();
            Long newDocument = updateClient.getDocument();
            Long existingPhone = client.getPhone();
            Long newPhone = updateClient.getPhone();
            if (!newDocument.equals(existingDocument) && newDocument != 0){
                client.setDocument(updateClient.getDocument());
            }
            if (!newPhone.equals(existingPhone) && newPhone != 0){
                client.setPhone(updateClient.getPhone());
            }
            if (updateClient.getAddress()!=null){
                client.setAddress(updateClient.getAddress());
            }
            if (updateClient.getEmail()!=null){
                client.setEmail(updateClient.getEmail());
            }
            if (updateClient.getName()!=null){
                client.setName(updateClient.getName());
            }
            return clientRepository.save(client);
        }
        return null;
    }
    public void deleteClient(int id){clientRepository.deleteById(id);}


}
