package com.record.company.com.persistence.repository;

import com.record.company.com.domain.entity.MusicGender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMusicGenders extends JpaRepository<MusicGender,Integer> {
}
