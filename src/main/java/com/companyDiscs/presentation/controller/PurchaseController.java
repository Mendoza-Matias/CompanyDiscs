package com.companyDiscs.presentation.controller;

import com.companyDiscs.bussines.services.IPurchaseService;
import com.companyDiscs.domain.dto.purchase.PurchaseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/purchases")
public class PurchaseController {
    @Autowired
    private IPurchaseService purchaseService;
    @PostMapping("{clientId}/{albumId}")
    ResponseEntity<PurchaseDto> purchaseAlbum(@PathVariable(name = "clientId") Long clientId , @PathVariable(name = "albumId") Long albumId){
        return ResponseEntity.status(HttpStatus.OK).body(purchaseService.purchaseAlbum(clientId,albumId));
    }
}
