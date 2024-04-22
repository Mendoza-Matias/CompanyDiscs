package com.companyDiscs.persistence.repository;
import com.companyDiscs.domain.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ArtistRepository extends JpaRepository<Artist,Long> {
    boolean existsByName(String name);
}
