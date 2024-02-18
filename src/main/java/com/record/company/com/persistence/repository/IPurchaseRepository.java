package com.record.company.com.persistence.repository;

import com.record.company.com.domain.dto.user.UserDto;
import com.record.company.com.domain.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPurchaseRepository extends JpaRepository <Purchase,Integer> {

    @Query("SELECT p FROM Purchase p WHERE p.user.id = :userId")
    List <Purchase> getPurchaseByUserId(int userId);

    @Query("SELECT p FROM Purchase p WHERE p.purchaseCode = :purchaseCode")
    Purchase getUserByPurchaseCode(String purchaseCode);
}
