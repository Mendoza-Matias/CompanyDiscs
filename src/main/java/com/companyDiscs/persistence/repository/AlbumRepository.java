package com.companyDiscs.persistence.repository;
import com.companyDiscs.domain.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Long> {

    //search by artist name
    Optional<Album> findByArtistName (String artist);
    //search by gender name
    Optional<Album> findByGenderName (String gender);
    Boolean existsByName(String name);
}
