package com.record.company.com.persistence.repository;

import com.record.company.com.domain.entity.Album;
import com.record.company.com.domain.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IArtistRepository extends JpaRepository<Artist,Integer> {

    @Query("SELECT a FROM Artist a WHERE a.country = :country")
    List <Artist> getAllArtistByCountry(String country);
}
