package com.companyDiscs.bussines.services.servicesImpl;

import com.companyDiscs.domain.dto.album.AlbumDto;
import com.companyDiscs.domain.dto.artist.ArtistDto;
import com.companyDiscs.domain.dto.client.ClientAlbumDto;
import com.companyDiscs.domain.dto.client.ClientDto;
import com.companyDiscs.domain.dto.client.CreateClientDto;
import com.companyDiscs.domain.dto.gender.GenderDto;
import com.companyDiscs.domain.entity.Album;
import com.companyDiscs.domain.entity.Client;
import com.companyDiscs.domain.enums.Rol;
import com.companyDiscs.persistence.repository.ClientRepository;
import lombok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ClientServiceImplTest {

    private ClientDto clientDto;

    private CreateClientDto createClientDto;

    private ClientAlbumDto clientAlbumDto;

    private ArtistDto artistDto;

    private GenderDto genderDto;

    @InjectMocks
    private ClientServiceImpl clientServiceImpl;

    @Mock
    private ClientRepository clientRepository;

    @Spy
    private ModelMapper modelMapper = new ModelMapper();

    @BeforeEach
    void setup(){

        genderDto = GenderDto.builder()
                .id(1L)
                .name("rock")
                .build();

        artistDto = ArtistDto.builder()
                .id(1L)
                .name("jack")
                .build();

        createClientDto = CreateClientDto.builder()
                .name("max")
                .email("max@gmail.com")
                .password("max1234")
                .rol(Rol.CLIENT)
                .build();

        clientDto = ClientDto
                .builder()
                .id(1L)
                .name("max")
                .rol(Rol.CLIENT)
                .build();

    }

    @Test
    void getAlbumsOfAnClient() {

        AlbumDto albumDto = AlbumDto.builder()
                .id(1L)
                .name("legend")
                .gender(genderDto)
                .artist(artistDto)
                .numberSongs(10)
                .price(1200.00)
                .imageUlr("image.png")
                .build();

        List <AlbumDto> albums = new ArrayList<>();
        albums.add(albumDto);

        Client client = modelMapper.map(clientDto,Client.class);
        client.setAlbums(albums.stream().map(albDto -> modelMapper.map(albDto,Album.class)).collect(Collectors.toList()));

        Mockito.when(clientRepository.getAlbumsOfAnClient(1L)).thenReturn(client);

        ClientAlbumDto service = clientServiceImpl.getAlbumsOfAnClient(1L);

        assertEquals(albums.size(),service.getAlbums().size());

    }

    @Test
    void createClient() {

        Client client = modelMapper.map(clientDto,Client.class);

        Mockito.when(clientRepository.save(any(Client.class))).thenReturn(client);

        ClientDto service = clientServiceImpl.createClient(createClientDto);

        assertAll(
                ()-> assertEquals(1L,service.getId()),
                ()-> assertEquals("max",service.getName()),
                ()-> assertEquals(Rol.CLIENT,service.getRol())
        );

    }

    @Test
    void modifyPassword() {

        Client client = Client.builder()
                .id(1L)
                .name("client")
                .email("client@gmail.com")
                .password("oldPassword")
                .rol(Rol.CLIENT)
                .build();

        Mockito.when(clientRepository.findById(1L)).thenReturn(Optional.of(client));

        clientServiceImpl.modifyPassword(1L,"newPassword");

        Optional<Client> updateClient = clientRepository.findById(1L);

        assertTrue(updateClient.isPresent());

        assertEquals("newPassword", updateClient.get().getPassword());

    }
}