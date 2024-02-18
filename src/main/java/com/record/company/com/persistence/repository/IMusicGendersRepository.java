package com.record.company.com.persistence.repository;

import com.record.company.com.domain.entity.MusicGenres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMusicGendersRepository extends JpaRepository<MusicGenres,Integer> {
}
