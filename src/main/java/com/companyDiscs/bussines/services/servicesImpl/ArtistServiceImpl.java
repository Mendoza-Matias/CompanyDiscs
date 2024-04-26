package com.companyDiscs.bussines.services.servicesImpl;

import com.companyDiscs.bussines.services.IArtistService;
import com.companyDiscs.domain.dto.artist.ArtistDto;
import com.companyDiscs.domain.dto.artist.CreateArtistDto;
import com.companyDiscs.domain.dto.artist.UpdateArtistDto;
import com.companyDiscs.domain.dto.country.CountryDto;
import com.companyDiscs.domain.entity.Artist;
import com.companyDiscs.domain.entity.Country;
import com.companyDiscs.exception.ArtistException;
import com.companyDiscs.exception.NotFoundException;
import com.companyDiscs.persistence.repository.ArtistRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtistServiceImpl implements IArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ArtistDto> getAllArtist() {
        List<Artist> artists = artistRepository.findAll();
        return artists.stream().map(art -> modelMapper.map(art,ArtistDto.class)).collect(Collectors.toList());
    }

    @Override
    public ArtistDto getArtistById(Long id) {
        Artist artist = artistRepository.findById(id).orElseThrow(()-> new NotFoundException("artist not found"));
        return modelMapper.map(artist,ArtistDto.class);
    }

    @Override
    public ArtistDto CreateArtist(CreateArtistDto createArtistDto) {

        if(thereIsEmptyFilm(createArtistDto)){
            throw new ArtistException("there is empty film");
        }

        /* Creating artists to map countries and avoid errors. */
        Artist artist = Artist.builder()
                .name(createArtistDto.getName())
                .country(modelMapper.map(createArtistDto.getCountry(), Country.class))
                .build();

        return modelMapper.map(artistRepository.save(artist),ArtistDto.class);
    }

    @Override
    public ArtistDto updateArtist(Long id, UpdateArtistDto updateArtistDto){

        Artist artist = artistRepository.findById(id).orElseThrow(()-> new NotFoundException("artist not found"));

        //set new value of artist
        artist.setName(updateArtistDto.getName());
        
        artistRepository.save(artist);

        return modelMapper.map(artist,ArtistDto.class);
    }

    @Override
    public boolean existArtistWithName(String name) {
        return artistRepository.existsByName(name);
    }

    @Override
    public boolean thereIsEmptyFilm(CreateArtistDto createArtistDto) {
        //validation if there is an empty field
        return createArtistDto.getName() == null || createArtistDto.getCountry().getCity() == null || createArtistDto.getCountry().getLocation() == null;
    }
}
