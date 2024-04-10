package com.companyDiscs.persistence.repository;
import com.companyDiscs.domain.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {
}
