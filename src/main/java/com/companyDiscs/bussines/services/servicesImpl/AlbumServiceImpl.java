package com.companyDiscs.bussines.services.servicesImpl;

import com.companyDiscs.bussines.services.IAlbumService;
import com.companyDiscs.domain.dto.album.AlbumDto;
import com.companyDiscs.domain.dto.album.CreateAlbumDto;
import com.companyDiscs.domain.dto.gender.GenderDto;
import com.companyDiscs.domain.entity.Album;
import com.companyDiscs.domain.entity.Artist;
import com.companyDiscs.domain.entity.Gender;
import com.companyDiscs.exception.AlbumException;
import com.companyDiscs.exception.NotFoundException;
import com.companyDiscs.persistence.repository.AlbumRepository;
import com.companyDiscs.persistence.repository.ArtistRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements IAlbumService {
    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<AlbumDto> getAllAlbums() {
        List<Album> albums = albumRepository.findAll();
        return albums.stream().map(alb -> modelMapper.map(alb,AlbumDto.class)).collect(Collectors.toList());
    }

    @Override
    public AlbumDto getAlbumById(Long id) {
        Album album = albumRepository.findById(id).orElseThrow(()-> new NotFoundException("album not found"));
        return modelMapper.map(album,AlbumDto.class);
    }

    @Override
    public AlbumDto getAlbumByNameArtist(String artist) {
        Album album = albumRepository.findByNameArtist(artist).orElseThrow(()-> new NotFoundException("album with " + artist + " not found"));
        return modelMapper.map(album,AlbumDto.class);
    }

    @Override
    public AlbumDto getAlbumByNameGender(String gender) {

        Album album = albumRepository.findByNameGender(gender).orElseThrow(()-> new NotFoundException("album with gender " + gender + " not found"));

        return modelMapper.map(album,AlbumDto.class);
    }

    @Override
    public AlbumDto createAlbum(Long artistId, CreateAlbumDto createAlbumDto) {

        if(existAlbumWithName(createAlbumDto.getName())){
            throw new AlbumException("album with " + createAlbumDto.getName() + "exist");
        }

        Artist artist = artistRepository.findById(artistId).orElseThrow(()-> new NotFoundException("artist not found"));

        Album album = modelMapper.map(createAlbumDto,Album.class);

        album.setArtist(artist);

        return modelMapper.map(albumRepository.save(album),AlbumDto.class);
    }

    @Override
    public AlbumDto uploadImageAlbum(Long id, MultipartFile file) {
        return null;
    }

    @Override
    public AlbumDto updateAlbum(Long id, CreateAlbumDto createAlbumDto) {

        Album album = albumRepository.findById(id).orElseThrow(()-> new NotFoundException("album not found"));

        album.setName(createAlbumDto.getName());
        album.setGender(modelMapper.map(createAlbumDto.getGender(), Gender.class));
        album.setNumberSongs(createAlbumDto.getNumberSongs());
        album.setPublicationDate(createAlbumDto.getPublicationDate());
        album.setPrice(createAlbumDto.getPrice());

        albumRepository.save(album);

        return modelMapper.map(album,AlbumDto.class);
    }

    @Override
    public AlbumDto updateArtistOfAlbum(Long id, Long artistId) {

        Album album = albumRepository.findById(id).orElseThrow(()-> new NotFoundException("album not found"));

        Artist artist = artistRepository.findById(artistId).orElseThrow(()-> new NotFoundException("artist not found"));

        album.setArtist(artist);

        albumRepository.save(album); /* save before mapping to avoid errors */

        return modelMapper.map(album,AlbumDto.class);
    }

    @Override
    public AlbumDto deleteAlbum(Long id) {

        Album album = albumRepository.findById(id).orElseThrow(()-> new NotFoundException("album not found"));

        albumRepository.deleteById(id);

        return modelMapper.map(album,AlbumDto.class);
    }

    @Override
    public boolean existAlbumWithName(String name) {
        return albumRepository.exitsByName(name);
    }
}
