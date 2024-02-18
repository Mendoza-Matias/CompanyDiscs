package com.record.company.com.presentation.controller;

import com.record.company.com.bussines.IPurchaseServices;
import com.record.company.com.domain.dto.purchase.PurchaseDto;
import com.record.company.com.domain.dto.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/purchase")
public class PurchaseController {

    @Autowired
    private IPurchaseServices purchaseServices;

    @GetMapping
    public ResponseEntity<List<PurchaseDto>> getAllPurchase(){
        return ResponseEntity.ok(purchaseServices.GetAllPrePurchase());
    }

    @PreAuthorize("hasRole('ROLE_USER') ")
    @GetMapping("{id}")
    public ResponseEntity<PurchaseDto> getPurchaseById(@PathVariable("id") int id){
        return ResponseEntity.ok(purchaseServices.getPurchaseById(id));
    }
    @PreAuthorize("hasRole('ROLE_USER') ")
    @GetMapping("/user")
    public ResponseEntity<UserDto> getUserByPurchaseCode(@RequestParam("code") String purchaseCode){
        return ResponseEntity.ok(purchaseServices.getUserByPurchaseCode(purchaseCode));
    }
    @PreAuthorize("hasRole('ROLE_USER') ")
    @PostMapping("{userId}/{albumId}")
    public ResponseEntity<PurchaseDto> createPurchase (@PathVariable("userId") int userId,@PathVariable("albumId") int albumId){
        return ResponseEntity.created(URI.create("/api/v1/recordCompany/purchase")).body(purchaseServices.createPurchase(userId,albumId));
    }

    @PreAuthorize("hasRole('ROLE_USER') ")
    @PutMapping("{id}/{albumId}")
    public ResponseEntity<PurchaseDto> updatePurchase(@PathVariable("id") int id,@PathVariable("albumId") int albumId){
        return ResponseEntity.ok(purchaseServices.updatePurchase(id,albumId));
    }

    @PreAuthorize("hasRole('ROLE_USER') ")
    @DeleteMapping("{id}")
    public ResponseEntity<PurchaseDto> deletePurchase(@PathVariable("id") int id){
        return ResponseEntity.ok(purchaseServices.deletePurchase(id));
    }
}
