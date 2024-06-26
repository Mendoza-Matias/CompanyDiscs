package com.companyDiscs.bussines.services.servicesImpl;

import com.companyDiscs.bussines.services.IClientService;
import com.companyDiscs.domain.dto.client.ClientDto;
import com.companyDiscs.domain.dto.client.CreateClientDto;
import com.companyDiscs.domain.entity.Client;
import com.companyDiscs.domain.enums.Rol;
import com.companyDiscs.exception.ClientException;
import com.companyDiscs.exception.NotFoundException;
import com.companyDiscs.persistence.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements IClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<ClientDto> getAllClients() {
        return clientRepository.findAll().stream().map(client -> modelMapper.map(client,ClientDto.class)).collect(Collectors.toList());
    }

    @Override
    public ClientDto createClient(CreateClientDto createClientDto) {

        if(thereIsEmptyFilm(createClientDto)){
            throw new ClientException("there is empty film");
        }

        if(existClientWithEmail(createClientDto.getEmail())){
            throw new ClientException("email exist");
        }

        Client client = modelMapper.map(createClientDto,Client.class);

        client.setRol(Rol.CLIENT);
        client.setPassword(passwordEncoder.encode(createClientDto.getPassword()));

        return modelMapper.map(clientRepository.save(client),ClientDto.class);
    }

    @Override
    public ClientDto modifyPassword(Long id, String password) {

        Client client = clientRepository.findById(id).orElseThrow(()-> new NotFoundException("client not found"));

        client.setPassword(passwordEncoder.encode(password));

        clientRepository.save(client);

        return modelMapper.map(client,ClientDto.class);
    }

    @Override
    public boolean existClientWithEmail(String email) {
        return clientRepository.existsByEmail(email);
    }

    @Override
    public boolean thereIsEmptyFilm(CreateClientDto createClientDto) {
        return createClientDto.getName() == null || createClientDto.getEmail() == null || createClientDto.getPassword() == null;
    }
}
