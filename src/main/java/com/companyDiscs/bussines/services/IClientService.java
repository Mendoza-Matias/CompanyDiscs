package com.companyDiscs.bussines.services;

import com.companyDiscs.domain.dto.client.ClientDto;
import com.companyDiscs.domain.dto.client.CreateClientDto;

import java.util.List;

public interface IClientService {
    List<ClientDto> getAllClients();
    ClientDto createClient(CreateClientDto createClientDto);
    ClientDto modifyPassword(Long id,String password);
    boolean existClientWithEmail(String email);
    boolean thereIsEmptyFilm(CreateClientDto createClientDto);
}
