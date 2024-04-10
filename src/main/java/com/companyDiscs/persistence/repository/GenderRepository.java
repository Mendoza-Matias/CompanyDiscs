package com.companyDiscs.persistence.repository;
import com.companyDiscs.domain.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface GenderRepository extends JpaRepository<Gender,Long> {
    boolean exitsByName(String name);
}
