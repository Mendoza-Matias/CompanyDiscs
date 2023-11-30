package com.record.company.com.persistence.repository;

import com.record.company.com.domain.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album,Integer> {
}
