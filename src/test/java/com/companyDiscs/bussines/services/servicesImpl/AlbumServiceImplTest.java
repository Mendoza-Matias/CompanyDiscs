package com.companyDiscs.bussines.services.servicesImpl;

import com.companyDiscs.domain.dto.album.AlbumDto;
import com.companyDiscs.domain.dto.album.CreateAlbumDto;
import com.companyDiscs.domain.dto.artist.ArtistDto;
import com.companyDiscs.domain.dto.country.CountryDto;
import com.companyDiscs.domain.dto.gender.GenderDto;
import com.companyDiscs.domain.entity.Album;
import com.companyDiscs.domain.entity.Artist;
import com.companyDiscs.domain.entity.Country;
import com.companyDiscs.persistence.repository.AlbumRepository;
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

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AlbumServiceImplTest {

    @InjectMocks
    private AlbumServiceImpl albumServiceImpl;

    @Mock
    private AlbumRepository albumRepository;

    @Mock
    private ArtistRepository artistRepository;

    @Spy
    private ModelMapper modelMapper = new ModelMapper();

    private AlbumDto albumDto;

    private ArtistDto artistDto;

    private CreateAlbumDto createAlbumDto;

    private GenderDto genderDto;

    @BeforeEach
    void setup(){
        genderDto = GenderDto.builder()
                .id(1L)
                .name("pop")
                .build();

        artistDto = ArtistDto.builder()
                .id(1L)
                .name("rick")
                .build();

        albumDto = AlbumDto.builder()
                .id(1L)
                .name("testing")
                .gender(genderDto)
                .artist(artistDto)
                .numberSongs(10)
                .publicationDate(LocalDate.of(2002, Month.DECEMBER, 19))
                .price(12.000)
                .imageUlr("image.jpg")
                .build();

        createAlbumDto = CreateAlbumDto.builder()
                .name("testing")
                .gender(genderDto)
                .numberSongs(10)
                .publicationDate(LocalDate.of(2002, Month.DECEMBER, 19))
                .price(12.000)
                .build();
    }

    @Test
    void getAlbumByNameArtist() {
        Album album = modelMapper.map(albumDto,Album.class);

        Mockito.when(albumRepository.findByArtistName("rick")).thenReturn(Optional.of(album));

        AlbumDto service = albumServiceImpl.getAlbumByNameArtist("rick");

        assertAll(
                ()-> assertEquals(1L,service.getId()),
                ()-> assertEquals("testing",service.getName()),
                ()-> assertEquals("pop",service.getGender().getName()),
                ()-> assertEquals("rick",service.getArtist().getName()),
                ()-> assertEquals(10,service.getNumberSongs()),
                ()-> assertEquals(LocalDate.of(2002,Month.DECEMBER,19),service.getPublicationDate()),
                ()-> assertEquals(12.000,service.getPrice())
                //()-> assertEquals("image.jpg",service.getImageUlr())
        );

    }

    @Test
    void getAlbumByGender() {
        Album album = modelMapper.map(albumDto,Album.class);

        Mockito.when(albumRepository.findByGenderName("pop")).thenReturn(Optional.of(album));

        AlbumDto service = albumServiceImpl.getAlbumByNameGender("pop");

        assertAll(
                ()-> assertEquals(1L,service.getId()),
                ()-> assertEquals("testing",service.getName()),
                ()-> assertEquals("pop",service.getGender().getName()),
                ()-> assertEquals("rick",service.getArtist().getName()),
                ()-> assertEquals(10,service.getNumberSongs()),
                ()-> assertEquals(LocalDate.of(2002,Month.DECEMBER,19),service.getPublicationDate()),
                ()-> assertEquals(12.000,service.getPrice())
                //()-> assertEquals("image.jpg",service.getImageUlr())
        );
    }

    @Test
    void createAlbum() {
        Album album = modelMapper.map(albumDto,Album.class);
        Artist artist = modelMapper.map(artistDto,Artist.class);

        album.setArtist(artist);

        Mockito.when(albumRepository.save(any(Album.class))).thenReturn(album);
        Mockito.when(artistRepository.findById(1L)).thenReturn(Optional.of(artist));

        AlbumDto service = albumServiceImpl.createAlbum(1L,createAlbumDto);

        assertAll(
                ()-> assertEquals(1L,service.getId()),
                ()-> assertEquals(1L,service.getArtist().getId()),
                ()-> assertEquals("testing",service.getName()),
                ()-> assertEquals("pop",service.getGender().getName()),
                ()-> assertEquals("rick",service.getArtist().getName()),
                ()-> assertEquals(10,service.getNumberSongs()),
                ()-> assertEquals(LocalDate.of(2002,Month.DECEMBER,19),service.getPublicationDate()),
                ()-> assertEquals(12.000,service.getPrice())
                //()-> assertEquals("image.jpg",service.getImageUlr())
        );
    }


    @Test
    void updateAlbum() {

        Album album = modelMapper.map(albumDto,Album.class);

        CreateAlbumDto createAlbumDto = CreateAlbumDto.builder()
                .name("updateAlbum")
                .gender(genderDto)
                .numberSongs(12)
                .publicationDate(LocalDate.of(2004, Month.DECEMBER, 24))
                .price(15000)
                .build();

        Mockito.when(albumRepository.findById(1L)).thenReturn(Optional.of(album));

        AlbumDto service = albumServiceImpl.updateAlbum(1L,createAlbumDto);

        assertAll(
                ()-> assertEquals(1L,service.getId()),
                ()-> assertEquals("updateAlbum",service.getName()),
                ()-> assertEquals("pop",service.getGender().getName()),
                ()-> assertEquals(12,service.getNumberSongs()),
                ()-> assertEquals(LocalDate.of(2004,Month.DECEMBER,24),service.getPublicationDate()),
                ()-> assertEquals(15000,service.getPrice())
                //()-> assertEquals("image.jpg",service.getImageUlr())
        );

    }

    @Test
    void updateArtistOfAlbum() {

        Artist artist = modelMapper.map(artistDto,Artist.class);
        artist.setName("joe");

        Album album = modelMapper.map(albumDto,Album.class);
        album.setArtist(artist);

        Mockito.when(albumRepository.findById(1L)).thenReturn(Optional.of(album));
        Mockito.when(artistRepository.findById(1L)).thenReturn(Optional.of(artist));

        AlbumDto service = albumServiceImpl.updateArtistOfAlbum(1L,1L);

        assertEquals(1L,service.getArtist().getId());
        assertEquals("joe",service.getArtist().getName());
        
    }
}