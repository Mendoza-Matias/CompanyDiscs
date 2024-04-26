package com.companyDiscs.bussines.services;

import com.companyDiscs.domain.dto.purchase.PurchaseDto;
import com.companyDiscs.domain.dto.purchase.PurchasedAlbumOfAClientDto;

public interface IPurchaseService {
    PurchaseDto purchaseAlbum(Long clientId , Long albumId);
    PurchasedAlbumOfAClientDto purchasedAlbumOfClient(Long clientId);

}
