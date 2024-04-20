package com.companyDiscs.presentation.controller;

import com.companyDiscs.bussines.services.IClientService;
import com.companyDiscs.domain.dto.client.ClientAlbumDto;
import com.companyDiscs.domain.dto.client.ClientDto;
import com.companyDiscs.domain.dto.client.CreateClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clients")
public class ClientController {
    @Autowired
    private IClientService clientService;

    @GetMapping
    ResponseEntity<List<ClientDto>> getAllClients(){
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getAllClients());
    };
    @GetMapping("albumsOfAnClient/{id}")
    ResponseEntity<ClientAlbumDto> getAlbumsOfAnClient(@PathVariable(name = "id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getAlbumsOfAnClient(id));
    };

    @PostMapping("create")
    ResponseEntity<ClientDto> createClient(@RequestBody CreateClientDto createClientDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.createClient(createClientDto));
    }
    @PutMapping("password/{id}")
    ResponseEntity<ClientDto> modifyPassword(@PathVariable(name = "id") Long id , @RequestBody String password){
        return ResponseEntity.status(HttpStatus.OK).body(clientService.modifyPassword(id,password));
    }

}
