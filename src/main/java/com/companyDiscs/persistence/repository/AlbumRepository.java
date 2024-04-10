package com.companyDiscs.persistence.repository;
import com.companyDiscs.domain.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AlbumRepository extends JpaRepository<Album,Long> {
    Album getAlbumByArtist(String artist);
    Album getAlbumByGender(String gender);
    Boolean exitsByName(String name);
    Boolean existByGender(String gender);
}
