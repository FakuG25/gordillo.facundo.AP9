package com.mindhub.homebanking.controllers;



import com.mindhub.homebanking.dtos.ClientDTO;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RequestMapping("/api")
@RestController
public class ClientController {
    @Autowired

    private ClientRepository clientRepository;

@RequestMapping("/clients")
   public List<ClientDTO> getClients() {
    List<Client> allClients = clientRepository.findAll();

    List<ClientDTO> convertedList = allClients.stream().map(ClientDTO::new).collect(Collectors.toList());

    return convertedList;
}

    @RequestMapping("clients/{id}")
    public ClientDTO getClientById(@PathVariable Long id){
        Client client = clientRepository.findById(id).orElse(null);
   return new  ClientDTO(client);

    }

}