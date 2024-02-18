package com.record.company.com.bussines.servicesImpl;

import com.record.company.com.bussines.IAlbumServices;
import com.record.company.com.domain.dto.album.AlbumCreateDto;
import com.record.company.com.domain.dto.album.AlbumDto;
import com.record.company.com.domain.dto.album.AlbumInfoDto;
import com.record.company.com.domain.dto.album.AlbumTitleDto;
import com.record.company.com.domain.entity.Album;
import com.record.company.com.domain.entity.AlbumImage;
import com.record.company.com.domain.entity.Artist;
import com.record.company.com.domain.entity.MusicGenres;
import com.record.company.com.exception.AlbumException;
import com.record.company.com.exception.NotFoundException;
import com.record.company.com.persistence.repository.IAlbumFileRepository;
import com.record.company.com.persistence.repository.IAlbumRepository;
import com.record.company.com.persistence.repository.IArtistRepository;
import com.record.company.com.persistence.repository.IMusicGendersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlbumServicesImpl implements IAlbumServices {

    @Autowired
    private IAlbumRepository albumRepository;

    @Autowired
    private IArtistRepository artistRepository;

    @Autowired
    private IMusicGendersRepository musicGendersRepository;

    @Autowired
    private IAlbumFileRepository albumFileRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<AlbumDto> getAllAlbum() {
        return albumRepository.findAll().stream().map(album -> modelMapper.map(album,AlbumDto.class)).collect(Collectors.toList());
    }
    @Override
    public AlbumDto getAlbumById(int id) {
        Album albumExist = albumRepository.findById(id).orElseThrow(() -> new NotFoundException("Album not found"));
        return modelMapper.map(albumExist,AlbumDto.class);
    }
    @Override
    public List<AlbumTitleDto> getAllAlbumByNameArtist(String artist) {
        return albumRepository.getAllAlbumByNameArtist(artist).stream().map(album -> modelMapper.map(album,AlbumTitleDto.class)).collect(Collectors.toList());
    }
    @Override
    public List<AlbumInfoDto> getAllAlbumByMusicGenres(String musicGender) {
        return albumRepository.getAllAlbumByMusicGenres(musicGender).stream().map(albumInfoDto -> modelMapper.map(albumInfoDto,AlbumInfoDto.class)).collect(Collectors.toList());
    }
    @Override
    public AlbumDto creteAlbum(int artistId , int musicGenresId , int albumImageId ,AlbumCreateDto album) {

        Artist artist = artistRepository.findById(artistId).orElseThrow(()-> new NotFoundException("Id del artista no encontrado"));
        MusicGenres genres = musicGendersRepository.findById(musicGenresId).orElseThrow(()-> new NotFoundException("Id del genero musical no encontrado"));
        AlbumImage albumImage = albumFileRepository.findById(albumImageId).orElseThrow(()-> new NotFoundException("Album image not found"));

        return modelMapper.map(albumRepository.save(Album.builder()
                        .nameAlbum(album.getNameAlbum())
                        .numberSongs(album.getNumberSongs())
                        .yearPublication(album.getYearPublication())
                        .albumImage(albumImage)
                        .artist(artist)
                        .musicGenres(genres)
                .build()),AlbumDto.class);
    }
    @Override
    public AlbumDto updateAlbum (int id , int artistId , int musicGenderId , int albumFileId ,AlbumCreateDto albumData) {
        Optional <Album> album = albumRepository.findById(id);
        Artist artist = artistRepository.findById(artistId).orElseThrow(()-> new NotFoundException("Id del artista no encontrado"));
        MusicGenres genres = musicGendersRepository.findById(musicGenderId).orElseThrow(()-> new NotFoundException("Id del genero musical no encontrado"));
        AlbumImage albumImage = albumFileRepository.findById(albumFileId).orElseThrow(()-> new NotFoundException("Id de imagen no encontrada"));


        if(album.isPresent()){

            Album newAlbum = album.get();
            newAlbum.setNameAlbum(albumData.getNameAlbum());
            newAlbum.setNumberSongs(albumData.getNumberSongs());
            newAlbum.setYearPublication(albumData.getYearPublication());
            newAlbum.setArtist(artist);
            newAlbum.setMusicGenres(genres);
            newAlbum.setAlbumImage(albumImage);

            return modelMapper.map(albumRepository.save(newAlbum),AlbumDto.class);
        }else{
            throw new AlbumException("Album not found");
        }
    }
    @Override
    public AlbumDto deleteAlbum(int id) {

        Optional <Album> album = albumRepository.findById(id);
        if(album.isPresent()){
            Album albumDelete = album.get();
            albumRepository.deleteById(id);
            return modelMapper.map(albumDelete,AlbumDto.class);
        }else{
            throw new AlbumException("Album not found");
        }


    }

}
