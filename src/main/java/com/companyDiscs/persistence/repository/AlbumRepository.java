package com.companyDiscs.persistence.repository;
import com.companyDiscs.domain.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Long> {
    Optional<Album> findByNameArtist(String artist);
    Optional<Album> findByNameGender(String gender);
    Boolean exitsByName(String name);
}
