package com.companyDiscs.presentation.controller;

import com.companyDiscs.bussines.services.IPurchaseService;
import com.companyDiscs.domain.dto.purchase.PurchaseDto;
import com.companyDiscs.domain.dto.purchase.PurchasedAlbumOfAClientDto;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/purchases")
public class PurchaseController {
    @Autowired
    private IPurchaseService purchaseService;

    @PermitAll
    @PostMapping("{clientId}/{albumId}")
    ResponseEntity<PurchaseDto> purchaseAlbum(@PathVariable(name = "clientId") Long clientId , @PathVariable(name = "albumId") Long albumId){
        return ResponseEntity.status(HttpStatus.OK).body(purchaseService.purchaseAlbum(clientId,albumId));
    }

    @PermitAll
    @GetMapping("getAlbumOfClient/{clientId}")
    ResponseEntity<PurchasedAlbumOfAClientDto>  purchasedAlbumOfClient(@PathVariable(name = "clientId") Long clientId){
        return ResponseEntity.status(HttpStatus.OK).body(purchaseService.purchasedAlbumOfClient(clientId));
    }
}
