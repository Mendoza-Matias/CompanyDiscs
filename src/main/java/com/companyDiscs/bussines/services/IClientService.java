package com.companyDiscs.bussines.services;

import com.companyDiscs.domain.dto.client.ClientAlbumDto;
import com.companyDiscs.domain.dto.client.ClientDto;
import com.companyDiscs.domain.dto.client.CreateClientDto;
import com.companyDiscs.domain.dto.user.CreateUserDto;

import java.util.List;

public interface IClientService {
    List<ClientDto> getAllClients();
    ClientAlbumDto getAlbumsOfAnClient(Long id);
    ClientDto createClient(CreateClientDto createClientDto);
    ClientDto modifyPassword(Long id,String password);
    boolean existClientWithEmail(String email);
    boolean thereIsEmptyFilm(CreateClientDto createClientDto);
}
