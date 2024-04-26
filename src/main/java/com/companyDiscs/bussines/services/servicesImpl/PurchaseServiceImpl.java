package com.companyDiscs.bussines.services.servicesImpl;

import com.companyDiscs.bussines.services.IPurchaseService;
import com.companyDiscs.domain.dto.album.AlbumBasicInformationDto;
import com.companyDiscs.domain.dto.album.AlbumDto;
import com.companyDiscs.domain.dto.client.ClientDto;
import com.companyDiscs.domain.dto.purchase.PurchaseDto;
import com.companyDiscs.domain.dto.purchase.PurchasedAlbumOfAClientDto;
import com.companyDiscs.domain.entity.Album;
import com.companyDiscs.domain.entity.Client;
import com.companyDiscs.exception.NotFoundException;
import com.companyDiscs.persistence.repository.AlbumRepository;
import com.companyDiscs.persistence.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseServiceImpl implements IPurchaseService {
    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public PurchaseDto purchaseAlbum(Long clientId, Long albumId) {

        Client client = clientRepository.findById(clientId).orElseThrow(()-> new NotFoundException("client not found"));
        Album album = albumRepository.findById(albumId).orElseThrow(()-> new NotFoundException("album not found"));

        album.addClient(client);

        albumRepository.save(album);
        clientRepository.save(client);

        return PurchaseDto.builder()
                .clientDto(modelMapper.map(client, ClientDto.class))
                .albumDto(modelMapper.map(album, AlbumDto.class))
                .build();
    }

    @Override
    public PurchasedAlbumOfAClientDto purchasedAlbumOfClient(Long clientId) {

        Client client = clientRepository.findById(clientId).orElseThrow(()-> new NotFoundException("client not found"));
        List<AlbumBasicInformationDto> albums = client.getAlbums().stream().map(album -> modelMapper.map(album, AlbumBasicInformationDto.class)).toList();

        PurchasedAlbumOfAClientDto purchasedAlbumOfAClientDto = PurchasedAlbumOfAClientDto.
                builder()
                .name(client.getName())
                .albums(albums)
                .build();

        return purchasedAlbumOfAClientDto;
    }

}
