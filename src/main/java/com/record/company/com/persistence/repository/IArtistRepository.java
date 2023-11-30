package com.record.company.com.persistence.repository;

import com.record.company.com.domain.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IArtistRepository extends JpaRepository<Artist,Integer> {
}
