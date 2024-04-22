package com.companyDiscs.persistence.repository;
import com.companyDiscs.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Boolean existsByEmail(String email);

    Optional<User> findByUserName(String name);
}
