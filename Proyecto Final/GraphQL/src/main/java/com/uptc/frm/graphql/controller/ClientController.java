package com.uptc.frm.graphql.controller;

import com.uptc.frm.graphql.jpa.models.Client;
import com.uptc.frm.graphql.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;
    @QueryMapping(name = "findClientById")
    public Client findClientById(@Argument(name = "idClientC") Integer idClient){
        return clientService.findById(idClient);
    }
    @QueryMapping(name = "findAllClient")
    public List<Client> findAllClient(){
        return clientService.findAll();
    }
    @MutationMapping
    public Client createClient(@Argument Client inputClient){
        return clientService.createClient(inputClient);
    }
    @MutationMapping
    public Client updateClient(@Argument Client updateClient){
        return clientService.updateClient(updateClient);
    }
    @MutationMapping
    public String deleteClient(@Argument Integer deleteClient){
        Client client = clientService.findById(deleteClient);
        if (client != null) {
            clientService.deleteClient(deleteClient);
            return ("El cliente con id: " + deleteClient + " se elimino con exito");
        }else {
            return ("El cliente con id: " + deleteClient + " no existe");
        }
    }
}
