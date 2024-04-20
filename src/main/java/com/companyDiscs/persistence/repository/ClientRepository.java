package com.companyDiscs.persistence.repository;
import com.companyDiscs.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

    @Query(value = "SELECT albums.* FROM albums INNER JOIN rel_album_client ON albums.id " +
            "= rel_album_client.album_id WHERE rel_album_client.client_id = ?1",
            nativeQuery = true)
    Optional<Client> getAlbumsOfAnClient(Long id);

    Boolean exitsByEmail(String email);

}
