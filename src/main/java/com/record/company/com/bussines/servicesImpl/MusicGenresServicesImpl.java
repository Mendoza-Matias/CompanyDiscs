package com.record.company.com.bussines.servicesImpl;

import com.record.company.com.bussines.IMusicGenresServices;
import com.record.company.com.domain.dto.musicGenders.CreateMusicGenderDto;
import com.record.company.com.domain.dto.musicGenders.MusicGenderDto;
import com.record.company.com.domain.entity.MusicGenres;
import com.record.company.com.exception.MusicGenresException;
import com.record.company.com.persistence.repository.IAlbumRepository;
import com.record.company.com.persistence.repository.IMusicGendersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class MusicGenresServicesImpl implements IMusicGenresServices {

    @Autowired
    private IMusicGendersRepository musicGendersRepository;

    @Autowired
    private IAlbumRepository albumRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<MusicGenderDto> getAllMusicGenres() {
        return musicGendersRepository.findAll().stream().map(gender -> modelMapper.map(gender, MusicGenderDto.class)).collect(Collectors.toList());
    }

    @Override
    public MusicGenderDto getMusicGenresById(int id) {
        return modelMapper.map(musicGendersRepository.findById(id), MusicGenderDto.class);
    }

    @Override
    public MusicGenderDto createMusicGenres(CreateMusicGenderDto musicGenres) {
        return modelMapper.map(musicGendersRepository.save(MusicGenres.builder()
                .nameGenres(musicGenres.getNameGender()).build()), MusicGenderDto.class);
    }

    @Override
    public MusicGenderDto updateMusicGenres(int id, CreateMusicGenderDto genres) {

        Optional<MusicGenres> musicGenres = musicGendersRepository.findById(id);
        MusicGenres newMusicGenres = null;

        if(musicGenres.isPresent()){
            newMusicGenres = musicGenres.get();
            newMusicGenres.setNameGenres(genres.getNameGender());

            return modelMapper.map(musicGendersRepository.save(newMusicGenres), MusicGenderDto.class);
        }else{
            throw new MusicGenresException("Music genres not found");
        }

    }

    @Override
    public MusicGenderDto deleteMusicGenres(int id) {

        Optional<MusicGenres> musicGenderExist = musicGendersRepository.findById(id);
        if(musicGenderExist.isPresent()){
            MusicGenres musicGender = musicGenderExist.get();
            musicGendersRepository.deleteById(id);
            return modelMapper.map(musicGender, MusicGenderDto.class);
        }else{
            throw new MusicGenresException("Music genres not found");
        }

    }

}
