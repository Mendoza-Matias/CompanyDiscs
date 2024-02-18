package com.record.company.com.persistence.repository;

import com.record.company.com.domain.entity.AlbumImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlbumFileRepository extends JpaRepository<AlbumImage, Integer> {
}
