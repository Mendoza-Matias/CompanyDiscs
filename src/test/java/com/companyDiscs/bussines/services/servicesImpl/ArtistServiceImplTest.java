package com.companyDiscs.bussines.services.servicesImpl;

import com.companyDiscs.domain.dto.artist.ArtistDto;
import com.companyDiscs.domain.dto.artist.CreateArtistDto;
import com.companyDiscs.domain.dto.country.CountryDto;
import com.companyDiscs.domain.entity.Artist;
import com.companyDiscs.domain.entity.Country;
import com.companyDiscs.persistence.repository.ArtistRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ArtistServiceImplTest {
    @InjectMocks
    private ArtistServiceImpl artistServiceImpl;
    @Mock
    private ArtistRepository artistRepository;
    @Spy
    private ModelMapper modelMapper = new ModelMapper();

    private ArtistDto artistDto;
    private CreateArtistDto createArtistDto;

    private CreateArtistDto createArtistDtoTwo;
    private CountryDto countryDto;

    @BeforeEach
    void setUp(){
        artistDto = ArtistDto.builder()
                .id(1L)
                .name("rick")
                .build();

        countryDto = CountryDto.builder()
                .id(1L)
                .city("new york")
                .location("EE-UU")
                .build();

        createArtistDto = CreateArtistDto.builder()
                .name("rick")
                .country(countryDto)
                .build();
    }

    @Test
    void createArtist() {

        Artist artist = modelMapper.map(artistDto,Artist.class);
        artist.setCountry(modelMapper.map(countryDto,Country.class));

        Mockito.when(artistRepository.save(any(Artist.class))).thenReturn(artist);

        ArtistDto service = artistServiceImpl.CreateArtist(createArtistDto);

        assertAll(
                ()-> assertEquals("rick", service.getName()),
                ()-> assertEquals("new york",service.getCountry().getCity()),
                ()->assertEquals("EE-UU",service.getCountry().getLocation())
        );
    }

    @Test
    void updateArtist() {

       Artist artist = modelMapper.map(artistDto,Artist.class);
       artist.setCountry(modelMapper.map(countryDto,Country.class));

       CountryDto countryDto = CountryDto.builder()
               .city("lima")
               .location("peru")
               .build();

       CreateArtistDto createArtistDto = CreateArtistDto.
               builder()
               .name("jose")
               .country(countryDto)
               .build();

        Mockito.when(artistRepository.findById(1L)).thenReturn(Optional.of(artist));

        ArtistDto service = artistServiceImpl.updateArtist(1L,createArtistDto);

        assertEquals("jose",service.getName());
        assertEquals("lima",service.getCountry().getCity());
        assertEquals("peru",service.getCountry().getLocation());


    }
}